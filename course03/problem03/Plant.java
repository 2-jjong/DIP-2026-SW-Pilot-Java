package course03.problem03;

public class Plant extends Organism {
    private String bloomingSeason;
    private String fruitStatus;

    public Plant(String name, String species, String habitat, String bloomingSeason, String fruitStatus) {
        super(name, species, habitat);
        this.bloomingSeason = bloomingSeason;
        this.fruitStatus = fruitStatus;
    }

    public String getBloomingSeason() {
        return bloomingSeason;
    }

    public void setBloomingSeason(String bloomingSeason) {
        this.bloomingSeason = bloomingSeason;
    }

    public String getFruitStatus() {
        return fruitStatus;
    }

    public void setFruitStatus(String fruitStatus) {
        this.fruitStatus = fruitStatus;
    }

    @Override
    public void displayInfo() {
        System.out.println(getName() + ", " + getSpecies() + ", " + getHabitat() + ", " + bloomingSeason + ", " + fruitStatus);
    }
}
