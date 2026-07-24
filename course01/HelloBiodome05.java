package course01;

public class HelloBiodome05 {
    public static void main(String[] args) {
        int[] gh = findGH();
        int g = gh[0];
        int h = gh[1];

        System.out.println("찾아낸 변수 값: g = " + g + ", h = " + h);

        int result = calculateEquation(g, h);

        System.out.println("세 번째 수식 계산 결과: " + result);
    }

    // 4 bit 범위 내에서 두 수식을 모두 만족하는 g와 h를 찾는 메서드
    public static int[] findGH() {
        for (int g = 0; g < 16; g++) {
            for (int h = 0; h < 16; h++) {
                if (((g & 1 >> g << 2 | h + g ^ h) == 1) && ((g % 2 << h >> g | 1 & 0 ^ 0) == 2)) {
                    return new int[] { g, h };
                }
            }
        }

        return new int[] { 0, 0 };
    }

    // 세 번째 수식 계산 결과 반환 메서드
    public static int calculateEquation(int g, int h) {
        int result = (h * h + g) * (h << h) + (g << g);
        return result;
    }
}
