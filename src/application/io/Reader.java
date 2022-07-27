package application.io;

import application.model.Film;
import application.model.Pass;
import application.model.Serial;
import application.model.User;

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

    public User addUser() {
        consolePrinter.printLine("Podaj imie: ");
        String firstName = scanner.nextLine();
        consolePrinter.printLine("Podaj nazwisko: ");
        String lastName = scanner.nextLine();
        consolePrinter.printLine("Podaj wiek: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        consolePrinter.printLine("Podaj login: ");
        String login = scanner.nextLine();
        consolePrinter.printLine("Podaj haslo: ");
        String password = scanner.nextLine();
        return new User(firstName,lastName,age,login,password);
    }

    public Pass checkPass() {
        consolePrinter.printLine("Podaj login: ");
        String login = scanner.nextLine();
        consolePrinter.printLine("Podaj haslo: ");
        String password = scanner.nextLine();
        return new Pass(login, password);
    }

    public String getString() {
        return scanner.nextLine();
    }

    public void closeScanner() {
        scanner.close();
    }
}
