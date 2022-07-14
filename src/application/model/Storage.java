package application.model;


import java.util.ArrayList;
import java.util.List;

public class Storage {
    List<Film> films = new ArrayList<>();
    List<Serial> serials = new ArrayList<>();

    public void addSerial(Serial serial) {
        serials.add(serial);
    }

    public void addFilm(Film film) {
        films.add(film);
    }

    public void printSerials() {
        for (Serial serial : serials) {
            System.out.println(serial);
        }
    }

    public void printFilms() {
        for (Film film : films) {
            System.out.println(film);
        }
    }
}
