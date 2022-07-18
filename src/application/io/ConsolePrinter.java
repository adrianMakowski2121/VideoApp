package application.io;

import application.model.Film;
import application.model.Serial;

import java.util.List;

public class ConsolePrinter {

    public void printSerials(List<Serial> serials) {
        if (serials.isEmpty()) {
            printLine("nie ma seriali");
        }
        for (Serial serial : serials) {
            System.out.println(serial);
        }
    }

    public void printFilms(List<Film> films) {
        if (films.isEmpty()) {
            printLine("nie ma filmow");
        }
        for (Film film : films) {
            System.out.println(film);
        }
    }

    public void printLine(String string) {
        System.out.println(string);
    }
}
