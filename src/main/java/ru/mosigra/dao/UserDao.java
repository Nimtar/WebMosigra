package ru.mosigra.dao;

import org.springframework.stereotype.Repository;
import ru.mosigra.entity.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.regex.Pattern;

@Repository
public class UserDao implements Dao {
	private final CriteriaBuilder criteriaBuilder;
	private final CriteriaQuery<UserEntity> query;
	private final Root<UserEntity> fromUser;

	@PersistenceContext(unitName = "ru.mosigra")
	private EntityManager entityManager;

	UserDao () {
		criteriaBuilder = entityManager.getCriteriaBuilder();
		query = criteriaBuilder.createQuery(UserEntity.class);
		fromUser = query.from(UserEntity.class);
	}

	public List<UserEntity> getAll () {
		return entityManager.createQuery(query.select(fromUser))
			.getResultList();
	}

	public List<UserEntity> getByFullName (String dueName) {
		Expression<String> fullName = fromUser.get("full_name");
		Predicate nameLikeDue = criteriaBuilder.like(fullName, dueName);
		return entityManager.createQuery(
			query.select(fromUser).where(nameLikeDue)).getResultList();
	}

	public List<UserEntity> getByPhoneNumber (String dueNumber) {
		if (isPhoneNumberNotValid(dueNumber)) {
			return null;
		}

		Expression<String> phoneNumber = fromUser.get("phone_number");
		Predicate numberLikeDue = criteriaBuilder.like(phoneNumber, dueNumber);
		return entityManager.createQuery(
			query.select(fromUser).where(numberLikeDue)).getResultList();
	}

	private boolean isPhoneNumberNotValid (String number) {
		return !isPhoneNumberValid(number);
	}

	private boolean isPhoneNumberValid (String number) {
		return number != null && Pattern.compile("^\\+[0-9]{1,15}")
			.matcher(number)
			.matches();
	}

	public UserEntity getByUsername (String dueName) {
		Expression<String> username = fromUser.get("username");
		Predicate nameLikeDue = criteriaBuilder.like(username, dueName);
		return entityManager.createQuery(
			query.select(fromUser).where(nameLikeDue)).getSingleResult();
	}

	public UserEntity getById (int requestedId) {
		return entityManager.find(UserEntity.class, requestedId);
	}
}
