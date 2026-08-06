package course03.problem02;

public class Organism {
    private String name;
    private String species;
    private String habitat;
    private String characteristic;
    private String lifeSpan;

    public Organism(String name, String species, String habitat) {
        this(name, species, habitat, null, null);
    }

    public Organism(String name, String species, String habitat, String characteristic, String lifeSpan) {
        this.name = name;
        this.species = species;
        this.habitat = habitat;
        this.characteristic = characteristic;
        this.lifeSpan = lifeSpan;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
        System.out.println("[LifeNest] " + name + "의 서식지가 변경되었습니다.");
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
        System.out.println("[LifeNest] " + name + "의 특징이 변경되었습니다.");
    }

    public String getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(String lifeSpan) {
        this.lifeSpan = lifeSpan;
        System.out.println("[LifeNest] " + name + "의 수명이 변경되었습니다.");
    }

    public void displayInfo() {
        if (characteristic != null && lifeSpan != null) {
            System.out.println(name + ", " + species + ", " + habitat + ", " + characteristic + ", " + lifeSpan);
        } else {
            System.out.println(name + ", " + species + ", " + habitat);
        }
    }
}
