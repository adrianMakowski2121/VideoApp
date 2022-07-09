package application.io;

import application.model.Film;

import java.util.Scanner;

public class Reader {
    private Scanner scanner = new Scanner(System.in);

    public Film addVideo() {
        System.out.println("Podaj tytuł: ");
        String title = scanner.nextLine();
        System.out.println("Podaj reżysera: ");
        String director = scanner.nextLine();
        System.out.println("Podaj ocenę ocenę filmu: ");
        int rate = getNumber();

        return new Film(title, director, rate);
    }

    public int getNumber() {
        int i = scanner.nextInt();
        scanner.nextLine();
        return i;
    }

    public void closeScanner() {
        scanner.close();
    }
}
