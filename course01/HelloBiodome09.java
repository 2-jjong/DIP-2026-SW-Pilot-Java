package course01;

public class HelloBiodome09 {
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println("잘못된 입력입니다. 3~100 사이의 숫자를 입력하세요.");
            return;
        }

        int height;
        try {
            height = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다. 3~100 사이의 숫자를 입력하세요.");
            return;
        }

        if (height < 3 || height > 100) {
            System.out.println("잘못된 입력입니다. 3~100 사이의 숫자를 입력하세요.");
            return;
        }

        String centerChar = null;
        if (args.length >= 2) {
            centerChar = args[1];
        }

        for (int i = 1; i <= height; i++) {
            for (int space = 0; space < height - i; space++) {
                System.out.print(" ");
            }

            if (centerChar == null) {
                for (int star = 0; star < 2 * i - 1; star++) {
                    System.out.print("*");
                }
            } else {
                for (int star = 0; star < i - 1; star++) {
                    System.out.print("*");
                }
                System.out.print(centerChar);
                for (int star = 0; star < i - 1; star++) {
                    System.out.print("*");
                }
            }

            System.out.println();
        }

        for (int space = 0; space < height - 1; space++) {
            System.out.print(" ");
        }
        System.out.println("|");
    }
}
