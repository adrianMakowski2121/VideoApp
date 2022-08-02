package application.model;

import application.exceptions.BadLoginOrPasswordException;
import application.exceptions.NoSuchUserException;
import application.io.ConsolePrinter;

import java.util.Optional;

public class LoginSystem {

    private StorageUser storageUser;
    private ConsolePrinter consolePrinter;

    public LoginSystem(StorageUser storageUser, ConsolePrinter consolePrinter) {
        this.storageUser = storageUser;
        this.consolePrinter = consolePrinter;
    }

    public void betterAlgorit(Pass pass) {
        User user;

        user = storageUser.findUserBetter(pass.getLogin());
        if (user.getLogin().equals(pass.getLogin()) && user.getPassword().equals(pass.getPassword())) {
            consolePrinter.printLine("zalogowano" + " " + user.getLogin());
        } else {
            System.out.println("Zły login lub hasło");
        }
    }
}

