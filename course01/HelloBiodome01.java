package course01;

public class HelloBiodome01 {
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println("이름을 1글자 이상 입력해주세요.");
            return;
        }

        String name = String.join(" ", args);

        if (name.isEmpty()) {
            System.out.println("이름을 1글자 이상 입력해주세요.");
            return;
        }

        String formattedName = String.format("%.10s", name);

        System.out.println("안녕하세요, \"" + formattedName + "\"님!");
    }
}
