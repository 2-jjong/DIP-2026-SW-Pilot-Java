package course03.problem05;

public class WaterMirror extends AncientArtifact implements EnergyGenerator, WeatherController, Chargeable {
    private int chargeLevel = 0;

    public WaterMirror(String name) {
        super(name);
    }

    @Override
    public void describe() {
        System.out.println("\"수증기를 모아 에너지를 생성하고, 날씨를 조절합니다.\"");
    }

    @Override
    public void generateEnergy() {
        System.out.println("\"물의 거울을 이용해 수증기로 에너지를 생성했습니다!\"");
    }

    @Override
    public void controlWeather() {
        System.out.println("\"물의 거울로 수증기를 모아 비를 내립니다!\"");
    }

    @Override
    public int getChargeLevel() {
        return chargeLevel;
    }

    @Override
    public void setChargeLevel(int level) {
        this.chargeLevel = level;
    }

    @Override
    public String getArtifactName() {
        return getName();
    }
}
