package course01;

public class HelloBiodome02 {
    public static void main(String[] args) {
        if (args == null || args.length < 3) {
            System.out.println("error: 세 종류의 에너지 생산량을 입력해주세요.");
            return;
        }

        int solar;
        int wind;
        int geothermal;

        try {
            solar = Integer.parseInt(args[0]);
            wind = Integer.parseInt(args[1]);
            geothermal = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.out.println("error: 숫자가 아닌 값이 입력되었습니다.");
            return;
        }

        if (solar < 0 || solar > 30000 || wind < 0 || wind > 30000 || geothermal < 0 || geothermal > 30000) {
            System.out.println("error: 에너지 생산량은 0 이상 30,000 이하이어야 합니다.");
            return;
        }

        int totalEnergy = solar + wind + geothermal;

        System.out.println("총 에너지 사용량은 " + totalEnergy + "입니다.");

        double solarRatio = totalEnergy == 0 ? 0.0 : (double) solar / totalEnergy * 100;
        double windRatio = totalEnergy == 0 ? 0.0 : (double) wind / totalEnergy * 100;
        double geothermalRatio = totalEnergy == 0 ? 0.0 : (double) geothermal / totalEnergy * 100;

        System.out.println(String.format("태양광 %.2f%%, 풍력 %.2f%%, 지열 %.2f%%", solarRatio, windRatio, geothermalRatio));
    }
}
