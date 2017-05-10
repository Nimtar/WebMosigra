package ru.mosigra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.mosigra.model.Account;
import ru.mosigra.service.AccountListService;
import ru.mosigra.utils.RedirectLinks;

@RestController
public class RegistrationController {

    private static final String ACCOUNT_IS_NOT_VALIDATED = "There already is an account with such username.";

    @Autowired
    private AccountListService accountListService;

    /**
     * Registers an <tt>account</tt> with the user's data passed through the registration form
     * @param account account to be registered
     * @return {@link RedirectLinks#REDIRECT_LOGGED_IN_HOME} redirect link if the account is registered successfully,
     * {@link RegistrationController#ACCOUNT_IS_NOT_VALIDATED} message if account is not registered
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerAccount(@ModelAttribute("account") Account account) {
            if (validateAccountExistence(account)) {
            accountListService.addAccount(account);
            return RedirectLinks.REDIRECT_LOGGED_IN_HOME;
        }
        return ACCOUNT_IS_NOT_VALIDATED;
    }


    /**
     * Returns <tt>true</tt>, if account list contains no account name as username
     * of this <tt>account</tt>
     * @param account account whose presence in account list is to be tested
     * @return <tt>true</tt> if account list contain no account with usith usernername of this <tt>account</tt>
     */
    private boolean validateAccountExistence(Account account) {
        return !accountListService.getAccounts().contains(account);
    }
}
