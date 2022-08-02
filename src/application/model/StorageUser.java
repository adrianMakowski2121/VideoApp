package application.model;

import application.exceptions.ListIsEmptyException;
import application.exceptions.NoSuchOptionException;
import application.exceptions.NoSuchUserException;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

public class StorageUser {
    List<User> userList = new ArrayList<>();

    public void userAdd(User user) {
        userList.add(user);
    }

    public List<User> getUserList() {
        return userList;
    }

    public User getAllUsers() {
        for (User user : userList) {
            return user;
        }
        return null;
    }

    public boolean isListEmpty() {
        if (userList.isEmpty()) {
            throw new ListIsEmptyException("lista jest pusta");
        } else {
            return false;
        }
    }

    public User findUserBetter(String login) {
        for (User user : userList) {
            if (login.equals(user.getLogin())) {
                return user;
            } else {
                throw new NoSuchUserException("Nie ma takiego użytkownika");
            }
        }
        return null;
    }
}
