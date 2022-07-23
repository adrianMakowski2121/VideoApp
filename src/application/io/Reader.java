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
        consolePrinter.printLine("Podaj tytuł: ");
        String title = scanner.nextLine();
        consolePrinter.printLine("Podaj reżysera: ");
        String director = scanner.nextLine();
        consolePrinter.printLine("Podaj ocenę filmu: ");
        int rate = getNumber();
        consolePrinter.printLine("Podaj datę wydania: ");
        String relaseDate = scanner.nextLine();

        return new Film(title, director, rate, relaseDate);
    }

    public Serial addSerial() {
        consolePrinter.printLine("Podaj tytuł: ");
        String title = scanner.nextLine();
        consolePrinter.printLine("Podaj reżysera: ");
        String director = scanner.nextLine();
        consolePrinter.printLine("Podaj ocenę serialu: ");
        int rate = getNumber();
        consolePrinter.printLine("Podaj liczbę sezonów: ");
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

    public String getString() {
        return scanner.nextLine();
    }

    public void closeScanner() {
        scanner.close();
    }
}
