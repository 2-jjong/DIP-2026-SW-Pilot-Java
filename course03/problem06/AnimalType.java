package course03.problem06;

public enum AnimalType {
    MONKEY("원숭이"),
    TIGER("호랑이"),
    DEER("사슴"),
    ELEPHANT("코끼리"),
    RHINO("코뿔소");

    private final String name;

    AnimalType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
