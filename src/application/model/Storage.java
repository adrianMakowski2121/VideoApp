package application.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Storage implements Serializable {
    List<Film> films = new ArrayList<>();
    List<Serial> serials = new ArrayList<>();

    public void addSerial(Serial serial) {
        serials.add(serial);
    }

    public void addFilm(Film film) {
        films.add(film);
    }

    public List<Film> getFilms() {
        return films;
    }

    public List<Serial> getSerials() {
        return serials;
    }
}
