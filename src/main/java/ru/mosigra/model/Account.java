package ru.mosigra.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable {

    private long id;
    private String username;
    private String password;
    private String fullName;
    private String mobileNumber;
    private ArrayList<String> canPlayGames;
    private ArrayList<String> wantToLearnGames;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public ArrayList<String> getCanPlayGames() {
        return canPlayGames;
    }

    public void setCanPlayGames(ArrayList<String> canPlayGames) {
        this.canPlayGames = canPlayGames;
    }

    public ArrayList<String> getWantToLearnGames() {
        return wantToLearnGames;
    }

    public void setWantToLearnGames(ArrayList<String> wantToLearnGames) {
        this.wantToLearnGames = wantToLearnGames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        return username != null ? username.equals(account.username) : account.username == null;
    }

    @Override
    public int hashCode() {
        return username != null ? username.hashCode() : 0;
    }
}
