package application.app;

import application.io.Reader;
import application.model.Film;
import application.model.Storage;

public class VideoControl {
    private final static int EXIT = 0;
    private final static int ADD_VIDEO = 1;
    private final static int ADD_SERIAL = 2;
    private final static int PRINT_SERIAL = 3;
    private final static int PRINT_FILM = 4;

    Reader reader = new Reader();
    Storage storage = new Storage();

    public void controlLoop() {

        int option;

        do {
            printOptions();
             option = reader.getNumber();
            switch (option) {
                case EXIT:
                    System.out.println("do zobaczenia innym razem");
                    break;
                case ADD_VIDEO:
                    addVideo();
                    break;
                case ADD_SERIAL:
                    System.out.println("tej opcji jeszcze nie ma");
                    break;
                case PRINT_SERIAL:
                    System.out.println("tej opcji jeszcze nie ma.");
                    break;
                case PRINT_FILM:
                    storage.printList();
                    break;
                default:
                    System.out.println("podales złą wartość");
                    break;
            }
        } while (option != EXIT);

    }

    public void printOptions() {
        System.out.println(" ");
        System.out.println("wybierz jedną z opcji");
        System.out.println(EXIT + " -wyjscie z programu");
        System.out.println(ADD_VIDEO + " -dodaj film");
        System.out.println(ADD_SERIAL + " -dodaj serial");
        System.out.println(PRINT_SERIAL + " -wyswietl wszystkie seriale");
        System.out.println(PRINT_FILM + " -wyswietl wszystkie filmy");
    }

    private void addVideo() {
        Film film = reader.addVideo();
        storage.addVideo(film);
    }
}
