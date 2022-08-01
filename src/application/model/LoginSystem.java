package application.model;

import application.io.ConsolePrinter;

public class LoginSystem {

    private StorageUser storageUser;
    private ConsolePrinter consolePrinter;

    public LoginSystem(StorageUser storageUser, ConsolePrinter consolePrinter) {
        this.storageUser = storageUser;
        this.consolePrinter = consolePrinter;
    }

    public void betterAlgorit(Pass pass) {
        User user = storageUser.findUserBetter(pass.getLogin());

       if (user.getLogin().equals(pass.getLogin()) ) {
           System.out.println("zalogowano " + user.getFirsName());
        }
    }
}
