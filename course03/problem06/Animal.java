package course03.problem06;

public class Animal {
    private String name;
    private AnimalType type;
    private int age;

    public Animal(String name, AnimalType type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnimalType getType() {
        return type;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void displayInfo() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return name + "(" + type.getName() + ", " + age + "살)";
    }
}
