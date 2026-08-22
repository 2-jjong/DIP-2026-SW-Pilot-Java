package course05.problem03;

import java.io.FileNotFoundException;
import java.io.IOException;

public class BiodomeForever03 {
    public static void main(String[] args) {
        String folderPath = (args != null && args.length > 0) ? args[0] : "course05/problem03";

        try {
            ResearchLogExtractor extractor = new ResearchLogExtractor(folderPath);
            extractor.extractAndSaveSummary();
        } catch (FileNotFoundException e) {
            System.out.println("예외 발생: " + e.getMessage());
        } catch (NoDataAvailableException e) {
            System.out.println("예외 발생: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("입출력 오류 발생: " + e.getMessage());
        }
    }
}
