package course03.problem05;

public class BiodomeFamily05 {
    public static void main(String[] args) {
        // 마법사 및 유물 객체 생성
        Sorcerer sorcerer = new Sorcerer("아리엘");
        SolarStone solarStone = new SolarStone("태양의 돌");
        WindAmulet windAmulet = new WindAmulet("바람의 부적");
        WaterMirror waterMirror = new WaterMirror("물의 거울");

        System.out.println();

        // 마법사가 유물 소유
        sorcerer.addArtifact(solarStone);
        sorcerer.addArtifact(windAmulet);
        sorcerer.addArtifact(waterMirror);

        System.out.println();

        // 유물 능력 확인 및 사용
        sorcerer.checkArtifactAbility(solarStone);
        System.out.println();

        sorcerer.useEnergyGenerator(waterMirror);

        System.out.println();

        // Chargeable 인터페이스 충전 기능
        solarStone.charge(50);
        waterMirror.charge(30);
        solarStone.charge(10);

        System.out.println();

        System.out.println(solarStone.getName() + "에 총 " + solarStone.getChargeLevel() + "만큼의 에너지가 충전되었습니다.");
        System.out.println(waterMirror.getName() + "에 총 " + waterMirror.getChargeLevel() + "만큼의 에너지가 충전되었습니다.");

        Chargeable.showChargingTips();
    }
}
