package course01;

public class HelloBiodome04 {
    public static final double COEFFICIENT = 0.415;
    public static final double PI = 3.14;

    public static void main(String[] args) {
        if (args == null || args.length < 3) {
            System.out.println("입력된 값이 올바르지 않습니다. [온도][습도][산소농도] 순서대로 숫자 값을 입력해주세요");
            return;
        }

        double temperature;
        double humidity;
        double oxygen;

        try {
            temperature = Double.parseDouble(args[0]);
            humidity = Double.parseDouble(args[1]);
            oxygen = Double.parseDouble(args[2]);
        } catch (NumberFormatException e) {
            System.out.println("입력된 값이 올바르지 않습니다. [온도][습도][산소농도] 순서대로 숫자 값을 입력해주세요");
            return;
        }

        boolean tempCheck = isTemperatureStable(temperature);
        boolean humCheck = isHumidityStable(humidity);
        boolean oxyCheck = isOxygenStable(oxygen);

        if (tempCheck && humCheck && oxyCheck) {
            double h = calculateH(temperature, humidity, oxygen);
            System.out.println(String.format("생명의 나무는 안정적인 상태입니다. 건강지수는 %.2f입니다.", h));
        } else if (!tempCheck) {
            System.out.println("온도값이 정상 범위를 벗어났습니다. 확인이 필요합니다.");
        } else if (!humCheck) {
            System.out.println("습도값이 정상 범위를 벗어났습니다. 확인이 필요합니다.");
        } else if (!oxyCheck) {
            System.out.println("산소 농도값이 정상 범위를 벗어났습니다. 확인이 필요합니다.");
        }
    }

    // 온도 안정 범위 검사
    public static boolean isTemperatureStable(double temp) {
        return temp >= 10.0 && temp < 27.5;
    }

    // 습도 안정 범위 검사
    public static boolean isHumidityStable(double humidity) {
        return humidity > 40.0 && humidity <= 60.0;
    }

    // 산소 농도 안정 범위 검사
    public static boolean isOxygenStable(double oxygen) {
        return oxygen >= 19.5 && oxygen <= 23.5;
    }

    // 습도값을 인자로 입력 받아 루트 계산 결과를 반환하는 메소드
    public static double calculateSqrt(double humidity) {
        if (humidity <= 0)
            return 0;

        return babylonianSqrt(humidity, humidity);
    }

    // 바빌로니아 법을 이용한 제곱근 계산 메소드
    private static double babylonianSqrt(double n, double x) {
        double nextX = (x + n / x) / 2.0;

        double diff = nextX - x;

        if ((diff < 0 ? -diff : diff) < 0.0000001)
            return nextX;

        return babylonianSqrt(n, nextX);
    }

    // √습도와 온도를 입력받아 절대값을 계산하고 결과를 반환하는 메소드
    public static double calculateAbsDiff(double sqrtHumidity, double temperature) {
        double diff = sqrtHumidity - temperature;
        return diff < 0 ? -diff : diff;
    }

    // 건강지수 H를 계산하는 메소드
    public static double calculateH(double temperature, double humidity, double oxygen) {
        double sqrtHumidity = calculateSqrt(humidity);
        double absDiff = calculateAbsDiff(sqrtHumidity, temperature);
        return COEFFICIENT * absDiff + (oxygen / (PI * PI));
    }
}
