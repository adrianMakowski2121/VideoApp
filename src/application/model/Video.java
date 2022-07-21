package application.model;

public abstract class Video {

    private String title;
    private String director;
    private int rate;

    public Video(String title, String director, int rate) {
        this.title = title;
        this.director = director;
        this.rate = rate;
    }

    @Override
    public String toString() {
        return
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", rate=" + rate;
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
}
