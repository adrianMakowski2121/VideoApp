package application.model;

public class Video {
    private String title;
    private String director;
    private int rate;
    private int lenght;


    public Video(String title, String director, int rate, int lenght) {
        this.title = title;
        this.director = director;
        this.rate = rate;
        this.lenght = lenght;
    }

    @Override
    public String toString() {
        return "Video{" +
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", rate=" + rate +
                ", lenght=" + lenght +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }
}
