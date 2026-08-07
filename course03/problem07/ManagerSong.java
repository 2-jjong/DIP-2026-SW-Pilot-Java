package course03.problem07;

public class ManagerSong extends Song {
    private String genre;

    public ManagerSong(String title, String duration, String artist, String genre) {
        super(title, duration, artist);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", " + genre;
    }
}
