package application.io;

import application.model.Film;
import application.model.Serial;

import java.util.Scanner;

public class Reader {
    private ConsolePrinter consolePrinter;
    private Scanner scanner = new Scanner(System.in);

    public Reader(ConsolePrinter consolePrinter) {
        this.consolePrinter = consolePrinter;
    }

    public Film addVideo() {
        System.out.println("Podaj tytuł: ");
        String title = scanner.nextLine();
        System.out.println("Podaj reżysera: ");
        String director = scanner.nextLine();
        System.out.println("Podaj ocenę ocenę filmu: ");
        int rate = getNumber();
        System.out.println("Podaj datę wydania");
        String relaseDate = scanner.nextLine();

        return new Film(title, director, rate, relaseDate);
    }

    public Serial addSerial() {
        System.out.println("Podaj tytuł: ");
        String title = scanner.nextLine();
        System.out.println("Podaj reżysera: ");
        String director = scanner.nextLine();
        System.out.println("Podaj ocenę ocenę serialu: ");
        int rate = getNumber();
        System.out.println("Podaj liczbę sezonów");
        int seasons = scanner.nextInt();
        scanner.nextLine();

        return new Serial(title, director, rate, seasons);
    }

    public int getNumber() {
        try {
            return scanner.nextInt();
        } finally {
            scanner.nextLine();
        }
    }

    public void closeScanner() {
        scanner.close();
    }
}
