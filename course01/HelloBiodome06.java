package course01;

public class HelloBiodome06 {
    public static void main(String[] args) {
        if (args == null || args.length < 2) {
            System.out.println("두 개의 유전자 코드를 입력해주세요.");
            return;
        }

        String dna1 = args[0];
        String dna2 = args[1];

        if (isEquals(dna1, dna2)) {
            System.out.println("동일한 유전자 코드입니다.");
        } else if (isContains(dna1, dna2)) {
            System.out.println("부분적으로 포함됩니다.");
        } else {
            System.out.println("일치하지 않습니다.");
        }
    }

    public static boolean isEquals(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int i = 0;
        while (i < s1.length()) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }

            i++;
        }

        return true;
    }

    public static boolean isContains(String pattern, String target) {
        if (pattern.length() > target.length()) {
            return false;
        }

        int i = 0;
        while (i <= target.length() - pattern.length()) {
            int j = 0;
            boolean match = true;

            while (j < pattern.length()) {
                if (target.charAt(i + j) != pattern.charAt(j)) {
                    match = false;
                    break;
                }

                j++;
            }

            if (match) {
                return true;
            }

            i++;
        }

        return false;
    }
}
