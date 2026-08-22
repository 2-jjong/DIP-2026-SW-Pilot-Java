package course05.problem02;

public class BiodomeForever02 {
    public static void main(String[] args) {
        ResearchLogManager manager = new ResearchLogManager();

        if (args != null && args.length > 0) {
            for (String arg : args) {
                System.out.println(arg);
                System.out.println();
                manager.readAndDisplayLog(arg);
                System.out.println();
            }
            return;
        }
    }
}
