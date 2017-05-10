package ru.mosigra.service;

import ru.mosigra.model.Account;

import java.util.List;

public interface AccountService {

    void addAccount(Account account);
    void updateAccount(Account account);
    void deleteAccount(Account account);
    List<Account> getAccounts();
    Account getAccount(String username);
}
