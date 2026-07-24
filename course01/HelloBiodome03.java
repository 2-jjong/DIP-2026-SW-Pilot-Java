package course01;

public class HelloBiodome03 {
    public static final double COEFFICIENT = 0.415;
    public static final double PI = 3.14;

    public static void main(String[] args) {
        if (args == null || args.length < 3) {
            System.out.println("입력된 값이 올바르지 않습니다. [온도][습도][산소농도] 순서 대로 숫자 값을 입력해주세요");
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
            System.out.println("입력된 값이 올바르지 않습니다. [온도][습도][산소농도] 순서 대로 숫자 값을 입력해주세요");
            return;
        }

        double h = calculateH(temperature, humidity, oxygen);
        System.out.println(String.format("생명지수 H = %.2f", h));
        System.out.println(String.format("생명지수 H = " + h));
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
