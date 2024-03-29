package application.app;

import application.exceptions.*;
import application.io.ConsolePrinter;
import application.io.Reader;
import application.io.file.FileManager;
import application.io.file.FileManagerBuilder;
import application.model.*;

import java.util.InputMismatchException;

public class VideoControl {

    private ConsolePrinter consolePrinter = new ConsolePrinter();
    private Reader reader = new Reader(consolePrinter);
    private Storage storage;
    private FileManager fileManager;
    private StorageUser storageUser = new StorageUser();
    private LoginSystem loginSystem = new LoginSystem(storageUser, consolePrinter);

    public VideoControl() {
        fileManager = new FileManagerBuilder(reader, consolePrinter).build();
        try {
            storage = fileManager.importData();
            consolePrinter.printLine("Zainportowano dane z pliku");
        } catch (DataImportException e) {
            consolePrinter.printLine(e.getMessage());
            consolePrinter.printLine("zaanicjowano nową baze danych ");
            storage = new Storage();
        }
    }

    public void controlLoop() {
        Option option;

        do {
            printOptions();

            option = getOption();

            switch (option) {
                case EXIT:
                    exit();
                    break;
                case ADD_VIDEO:
                    addVideo();
                    break;
                case ADD_SERIAL:
                    addSerial();
                    break;
                case PRINT_SERIAL:
                    printSerials();
                    break;
                case PRINT_FILM:
                    printFilms();
                    break;
                case PRINT_ALL_LISTS:
                    printAllLists();
                    break;
                case LOGGING:
                    loginAlg();
                    break;
                case ADD_NEW_USER:
                    addNewUser();
                    break;
                case PRINT_ALL_USERS:
                    printAllUsers();
                    break;
                case TEST:
                    consolePrinter.printLine("podaj login");
                    loginAlg();
                    break;
                case FIND_USER:
                    findUserInBase();
                    break;
                default:
                    consolePrinter.printLine("podales złą wartość");
                    break;
            }
        } while (option != Option.EXIT);
    }

    private void loginAlg() {
        try {
            storageUser.isListEmpty();
            Pass pass = reader.checkPass();
            loginSystem.betterAlgorit(pass);


        } catch (ListIsEmptyException e) {
            consolePrinter.printLine("Nie możesz się zalogować, ponieważ nie dodałeś użytkownika");
        }
    }

    public void findUserInBase() {
        try {
            if (storageUser.isListEmpty()) {
                consolePrinter.printLine("lista jest pusta");
            } else {
                consolePrinter.printLine("wpisz login użytkownika, którego szukasz");
                String login = reader.getString();
                System.out.println(storageUser.findUserBetter(login));
            }
        } catch (ListIsEmptyException | NoSuchUserException e) {
            consolePrinter.printLine(e.getMessage());
        }
    }

    private void printAllUsers() {
        consolePrinter.printLine(storageUser.getUserList().toString());
    }

    private void addNewUser() {
        storageUser.userAdd(reader.addUser());
        consolePrinter.printLine("Dodano nowego użytkownika");
    }

    private void exit() {
        try {
            fileManager.exportData(storage);
            consolePrinter.printLine("Export danych do pliku zakończony powodzeniem");
        } catch (DataExportException e) {
            consolePrinter.printLine(e.getMessage());
        }
        consolePrinter.printLine("zakończenie programu, do zobaczenia");
        reader.closeScanner();
    }

    private void printOptions() {
        consolePrinter.printLine("Wybierz opcję: ");

        for (Option option : Option.values()) {
            consolePrinter.printLine(option.toString());
        }
    }

    private void printFilms() {
        consolePrinter.printFilms(storage.getFilms());
    }

    private void printSerials() {
        consolePrinter.printSerials(storage.getSerials());
    }

    private Option getOption() {
        boolean optionIsOk = false;
        Option option1 = null;

        while (!optionIsOk) {
            try {
                option1 = Option.createInt(reader.getNumber());
                optionIsOk = true;
            } catch (NoSuchOptionException e) {
                consolePrinter.printLine(e.getMessage());
            } catch (InputMismatchException e) {
                consolePrinter.printLine("nie mozesz wprowadzac liczb, podaj liczbę ponownie: ");
            }
        }
        return option1;
    }

    public void printAllLists() {
        printFilms();
        printSerials();
    }

    private void addSerial() {
        try {
            Serial serial = reader.addSerial();
            storage.addSerial(serial);
        } catch (InputMismatchException e) {
            consolePrinter.printLine("nie udało się dodać i utworzyć serialu: ");
        }
    }

    private void addVideo() {
        try {
            Film film = reader.addVideo();
            storage.addFilm(film);
        } catch (InputMismatchException e) {
            consolePrinter.printLine("nie udało się dodać i utworzyć filmu: ");
        }
    }
}
