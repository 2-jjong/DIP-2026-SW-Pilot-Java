package course03.problem07;

public class Song {
    private String title;
    private String duration;
    private String artist;

    public Song(String title, String duration, String artist) {
        this.title = title;
        this.duration = duration;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getInfo() {
        return title + ", " + duration + ", " + artist;
    }

    @Override
    public String toString() {
        return getInfo();
    }
}
