package application.model;

import application.io.ConsolePrinter;

import java.util.List;

public class LoginSystem {

    private StorageUser storageUser;
    private ConsolePrinter consolePrinter;
    Pass pass;

    public LoginSystem(StorageUser storageUser, ConsolePrinter consolePrinter) {
        this.storageUser = storageUser;
        this.consolePrinter = consolePrinter;
    }

    //delete
    public void logginToSystem(Pass pass) {
        User allUsers = storageUser.getAllUsers();
        if(allUsers.getLogin().equals(pass.getLogin()) && allUsers.getPassword().equals(pass.getPassword())) {
            System.out.println("zalogowano " + allUsers.getFirsName());
        }
    }

    public void betterAlgorit(Pass pass) {
        User user = storageUser.findUserBetter(pass.getLogin());

       if (user.getLogin().equals(pass.getLogin())) {
           System.out.println("zalogowano " + user.getFirsName());
        }

    }
}
