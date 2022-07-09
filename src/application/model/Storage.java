package application.model;


public class Storage {
    public static final int MAX_VIDEO = 10;
    int actualNumberOfVideo = 0;

    Film[] listOfFilm = new Film[MAX_VIDEO];

    public void addVideo(Film film) {
        if (actualNumberOfVideo < MAX_VIDEO) {
            listOfFilm[actualNumberOfVideo] = film;
            actualNumberOfVideo++;
        } else {
            System.out.println("za malo miejsca");
        }

    }

    public void printList() {
        for (int i = 0; i < actualNumberOfVideo; i++) {
            System.out.println(listOfFilm[i]);
        }

    }

}
