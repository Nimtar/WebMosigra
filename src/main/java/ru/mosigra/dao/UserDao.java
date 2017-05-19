package ru.mosigra.dao;

import org.hibernate.TypeMismatchException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Repository;
import ru.mosigra.entity.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.regex.Pattern;

@Repository
public class UserDao implements Dao {

    private EntityManagerFactory managerFactory;
    private EntityManager entityManager;
    private CriteriaBuilder criteriaBuilder;
    private CriteriaQuery<UserEntity> query;
    private Root<UserEntity> fromUser;

    //region Utils
    private boolean isPhoneNumberNotValid (String number) {
        return !isPhoneNumberValid(number);
    }

    private boolean isPhoneNumberValid (String number) {
        return number == null || Pattern.compile("^\\+[0-9]{1,15}")
            .matcher(number)
            .matches();
    }

    private void closeManagerAndFactory () {
        entityManager.close();
        managerFactory.close();
    }
    //endregion

    //region Read operations
    public List<UserEntity> getAll () {
        prepareReading();
        try {
            return entityManager.createQuery(query.select(fromUser))
                .getResultList();
        } catch (NoResultException e) {
            return null;
        } finally {
            closeManagerAndFactory();
        }
    }

    private void prepareReading () {
        managerFactory = Persistence.createEntityManagerFactory("ru.mosigra");
        entityManager = managerFactory.createEntityManager();
        criteriaBuilder = entityManager.getCriteriaBuilder();
        query = criteriaBuilder.createQuery(UserEntity.class);
        fromUser = query.from(UserEntity.class);
    }

    public List<UserEntity> getByFullName (String dueName) {
        prepareReading();
        try {
            Expression<String> fullName = fromUser.get("fullName");
            Predicate nameLikeDue = criteriaBuilder.like(fullName, dueName);
            return entityManager.createQuery(
                query.select(fromUser).where(nameLikeDue)).getResultList();
        } catch (NoResultException e) {
            return null;
        } finally {
            closeManagerAndFactory();
        }
    }

    public List<UserEntity> getByPhoneNumber (String dueNumber) {
        prepareReading();
        try {
            if (isPhoneNumberNotValid(dueNumber)) {
                return null;
            }
            Expression<String> phoneNumber = fromUser.get("phoneNumber");
            Predicate numberLikeDue =
                criteriaBuilder.like(phoneNumber, dueNumber);
            return entityManager.createQuery(
                query.select(fromUser).where(numberLikeDue)).getResultList();
        } catch (NoResultException e) {
            return null;
        } finally {
            closeManagerAndFactory();
        }
    }

    private boolean isTypeMismatch (InvalidDataAccessApiUsageException e) {
        return e.getRootCause() != null && TypeMismatchException.class.equals(
            e.getRootCause().getClass());
    }

    public UserEntity getByUsername (String dueName) {
        prepareReading();
        try {
            Expression<String> username = fromUser.get("username");
            Predicate nameLikeDue = criteriaBuilder.like(username, dueName);
            return entityManager.createQuery(
                query.select(fromUser).where(nameLikeDue)).getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            closeManagerAndFactory();
        }
    }

    public UserEntity getById (int id) {
        return getById((short)id);
    }

    public UserEntity getById (short requestedId) {
        prepareReading();
        try {
            return entityManager.find(UserEntity.class, requestedId);
        } catch (NoResultException e) {
            return null;
        } finally {
            closeManagerAndFactory();
        }
    }
    //endregion

    //region Create operations
    public UserDao create (String username, String fullName,
        String passwordHash) throws IllegalArgumentException {
        return create(username, fullName, passwordHash, null);
    }

    public UserDao create (String username, String fullName,
        String passwordHash, String phoneNumber)
        throws IllegalArgumentException {
        return create(new UserEntity().setUsername(username)
            .setFullName(fullName)
            .setPasswordHash(passwordHash)
            .setPhoneNumber(phoneNumber));
    }

    public UserDao create (UserEntity user) throws IllegalArgumentException {
        if (user == null || isPhoneNumberNotValid(user.getPhoneNumber())) {
            throw new IllegalArgumentException(
                "User phone number is invalid" + " ");
        }
        prepareCreating();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
        } finally {
            closeManagerAndFactory();
        }
        return this;
    }

    private void prepareCreating () {
        managerFactory = Persistence.createEntityManagerFactory("ru.mosigra");
        entityManager = managerFactory.createEntityManager();
    }
    //endregion

    //region Update operations
    public UserDao updateUsername (String old, String fresh) {
        prepareReading();
        try {
            Expression<String> username = fromUser.get("username");
            Predicate nameLikeOld = criteriaBuilder.like(username, old);
            entityManager.createQuery(query.select(fromUser).where(nameLikeOld))
                .getSingleResult()
                .setUsername(fresh);
            entityManager.getTransaction().begin();
            entityManager.getTransaction().commit();
            return this;
        } catch (NoResultException e) {
            return null;
        } finally {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            closeManagerAndFactory();
        }
    }

    public UserDao update (UserEntity old, UserEntity fresh) {
        prepareReading();
        try {
            entityManager.find(UserEntity.class, old.getId())
                .setPhoneNumber(fresh.getPhoneNumber())
                .setFullName(fresh.getFullName())
                .setPasswordHash(fresh.getPasswordHash())
                .setUsername(fresh.getUsername());
            entityManager.getTransaction().begin();
            entityManager.getTransaction().commit();
            return this;
        } catch (NoResultException e) {
            return null;
        } finally {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            closeManagerAndFactory();
        }
    }
    //endregion

    //region Delete operations
    public UserDao delete (UserEntity user) {
        prepareReading();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.find(UserEntity.class, user.getId()));
            entityManager.getTransaction().commit();
        } catch (NoResultException e) {
            return null;
        } finally {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            closeManagerAndFactory();
        }
        return this;
    }
    //endregion
}
