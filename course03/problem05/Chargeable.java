package course03.problem05;

public interface Chargeable {
    int getChargeLevel();

    void setChargeLevel(int level);

    String getArtifactName();

    default void charge(int amount) {
        System.out.println(getArtifactName() + "에 " + amount + "만큼 에너지를 충전합니다.");
        setChargeLevel(getChargeLevel() + amount);
    }

    static void showChargingTips() {
        System.out.println("\n에너지를 효율적으로 충전하려면 마법사의 기분이 좋아야합니다.");
    }
}
