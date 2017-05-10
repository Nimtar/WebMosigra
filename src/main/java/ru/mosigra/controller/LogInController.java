package ru.mosigra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mosigra.model.LogInForm;
import ru.mosigra.service.AccountListService;
import ru.mosigra.utils.RedirectLinks;

@RestController
public class LogInController {

    private static final String WRONG_PASSWORD = "Incorrect password";
    private static final String WRONG_USERNAME = "Incorrect username";


    @Autowired
    private AccountListService accountListService;

    /**
     * Uses username and password passed through log in form to log a user in
     * @param logInForm log in form with filled username and password fields
     * @return {@link RedirectLinks#REDIRECT_LOGGED_IN_HOME} redirect link if the user is successfully logged in,
     * {@link LogInController#WRONG_PASSWORD} message if the password is incorrect,
     * {@link LogInController#WRONG_USERNAME} message if there is no accounts with such username
     */
    @RequestMapping(value = "/login")
    public String logIn(@ModelAttribute("login_form") LogInForm logInForm) {
        String username = logInForm.getUsername();
        if (accountListService.getAccount(username) != null) {
            if (logInForm.getPassword().equals(accountListService.getAccount(username).getPassword())) {
                return RedirectLinks.REDIRECT_LOGGED_IN_HOME;
            } else {
                return WRONG_PASSWORD;
            }
        }
        return WRONG_USERNAME;
    }
}
