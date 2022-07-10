package application.model;


public class Storage {
    public static final int MAX_VIDEO = 10;
    int actualNumberOfVideo = 0;

    public static final int MAX_SERIAL = 10;
    int actualNumberOfSerial = 0;

    Film[] listOfFilm = new Film[MAX_VIDEO];
    Serial[] listOfSerial = new Serial[MAX_VIDEO];

    public void addFilm(Film film) {
        if (actualNumberOfVideo < MAX_VIDEO) {
            listOfFilm[actualNumberOfVideo] = film;
            actualNumberOfVideo++;
        } else {
            System.out.println("za malo miejsca");
        }
    }

    public void addSerial(Serial serial) {
        if (actualNumberOfSerial < MAX_SERIAL) {
            listOfSerial[actualNumberOfSerial] = serial;
            actualNumberOfSerial++;
        } else {
            System.out.println("za malo miejsca");
        }
    }

    public void printFilms() {
        for (int i = 0; i < actualNumberOfVideo; i++) {
            System.out.println(listOfFilm[i]);
        }
    }

    public void printSerials() {
        for (int i = 0; i < actualNumberOfSerial; i++) {
            System.out.println(listOfSerial[i]);
        }
    }

}
