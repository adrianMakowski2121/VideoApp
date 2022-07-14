package application.model;

public class Serial extends Video{
    private int seasons;

    public Serial(String title, String director, int rate, int seasons) {
        super(title, director, rate);
        this.seasons = seasons;
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    @Override
    public String toString() {
        return "Serial " + super.toString() + " " +  ",sezony "+seasons + "}";
    }
}
