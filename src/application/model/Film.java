package application.model;

public class Film extends Video{
    private String relaseDate;

    public Film(String title, String director, int rate, String relaseDate) {
        super(title, director, rate);
        this.relaseDate = relaseDate;
    }

    public String getRelaseDate() {
        return relaseDate;
    }

    public void setRelaseDate(String relaseDate) {
        this.relaseDate = relaseDate;
    }

    @Override
    public String toString() {
        return "Film " + super.toString() + " " + "relaseDate: " + relaseDate + "}";
    }
}
