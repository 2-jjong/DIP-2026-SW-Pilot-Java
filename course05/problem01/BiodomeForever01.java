package course05.problem01;

public class BiodomeForever01 {
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
