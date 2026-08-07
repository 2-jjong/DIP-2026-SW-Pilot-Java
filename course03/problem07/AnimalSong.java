package course03.problem07;

public class AnimalSong extends Song {
    private String targetAnimal;

    public AnimalSong(String title, String duration, String artist, String targetAnimal) {
        super(title, duration, artist);
        this.targetAnimal = targetAnimal;
    }

    public String getTargetAnimal() {
        return targetAnimal;
    }

    public void setTargetAnimal(String targetAnimal) {
        this.targetAnimal = targetAnimal;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", " + targetAnimal;
    }
}
