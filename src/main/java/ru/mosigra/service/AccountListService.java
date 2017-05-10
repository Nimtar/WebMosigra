package ru.mosigra.service;

import org.springframework.stereotype.Component;
import ru.mosigra.model.Account;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountListService implements AccountService {

    private static ArrayList<Account> accounts = new ArrayList<>();

    @Override
    public synchronized void addAccount(Account account) {
        accounts.add(account);
    }

    @Override
    public synchronized void updateAccount(Account account) {

    }

    @Override
    public synchronized void deleteAccount(Account account) {
        accounts.remove(account);
    }

    @Override
    public List<Account> getAccounts() {
        return accounts;
    }

    @Override
    public Account getAccount(String username) {
        for (Account account : accounts) {
            if (username.equals(account.getUsername())) {
                return account;
            }
        }
        return null;
    }
}
