package application.io;

import application.model.Video;

import java.util.Scanner;

public class Reader {
    private Scanner scanner = new Scanner(System.in);

    public Video addVideo() {
        System.out.println("Podaj tytuł: ");
        String title = scanner.nextLine();
        System.out.println("Podaj reżysera: ");
        String director = scanner.nextLine();
        System.out.println("Podaj ocenę ocenę filmu: ");
        int rate = scanner.nextInt();
        scanner.nextLine();


        return new Video(title, director,rate);

    }


    public void closeScanner() {
        scanner.close();
    }
}
