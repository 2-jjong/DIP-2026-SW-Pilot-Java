package course03.problem05;

public class SolarStone extends AncientArtifact implements EnergyGenerator, Chargeable {
    private int chargeLevel = 0;

    public SolarStone(String name) {
        super(name);
    }

    @Override
    public void describe() {
        System.out.println("\"태양의 돌로 에너지 생성 중! 빛을 받은 시간에 따라 에너지의 양이 달라집니다.\"");
    }

    @Override
    public void generateEnergy() {
        describe();
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
