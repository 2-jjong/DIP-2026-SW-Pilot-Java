package course04.problem03;

public abstract class Device {
    private String name;
    private static final String BRAND = "DOMETech";
    private boolean poweredOn;

    public Device(String name) {
        this.name = name;
        this.poweredOn = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getBrand() {
        return BRAND;
    }

    public boolean isPoweredOn() {
        return poweredOn;
    }

    public void setPoweredOn(boolean poweredOn) {
        this.poweredOn = poweredOn;
    }

    public void powerOn() {
        this.poweredOn = true;
        System.out.println(name + " 전원을 켰습니다.");
    }

    public void powerOff() {
        this.poweredOn = false;
    }

    public void displayInfo() {
        System.out.println("기기명: " + name + ", 브랜드: " + BRAND);
    }
}
