package application.app;

import application.exceptions.NoSuchOptionException;
import application.io.ConsolePrinter;
import application.io.Reader;
import application.model.Film;
import application.model.Serial;
import application.model.Storage;

import java.util.InputMismatchException;

public class VideoControl {
    private final static int EXIT = 0;
    private final static int ADD_VIDEO = 1;
    private final static int ADD_SERIAL = 2;
    private final static int PRINT_SERIAL = 3;
    private final static int PRINT_FILM = 4;
    private final static int PRINT_ALL_LISTS = 5;

    private ConsolePrinter consolePrinter = new ConsolePrinter();
    private Reader reader = new Reader(consolePrinter);
    private Storage storage = new Storage();

    public void controlLoop() {
        Option option;

        do {
            printOptions();

            option = getOption();

            switch (option) {
                case EXIT:
                    consolePrinter.printLine("do zobaczenia innym razem");
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
                default:
                    consolePrinter.printLine("podales złą wartość");
                    break;
            }
        } while (option != Option.EXIT);
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
        } catch (InputMismatchException e ) {
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
