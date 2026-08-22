package course05.problem04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EnvironmentManager {
    private String filePath;

    public EnvironmentManager() {
        this.filePath = "course05/problem04/environment_data.txt";
    }

    public EnvironmentManager(String filePath) {
        this.filePath = filePath;
    }

    public void saveEnvironmentData(EnvironmentData data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(data.toCsvFormat());
            bw.newLine();
            System.out.println();
            File file = new File(filePath);
            System.out.println("데이터가 " + file.getName() + "에 저장되었습니다.");
        } catch (IOException e) {
            System.out.println("파일 저장 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    public void displayAllData() {
        File file = new File(filePath);
        if (!file.exists() || file.length() == 0) {
            System.out.println();
            System.out.println("저장된 환경 데이터가 없습니다.");
            return;
        }

        System.out.println();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("파일 읽기 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    public void displayOxygenData() {
        File file = new File(filePath);
        if (!file.exists() || file.length() == 0) {
            System.out.println();
            System.out.println("저장된 환경 데이터가 없습니다.");
            return;
        }

        System.out.println();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    String dateTime = parts[0];
                    String oxygen = parts[3];
                    String location = (parts.length >= 5) ? parts[4] : "";
                    System.out.println(dateTime + " - " + oxygen + " - " + location);
                }
            }
        } catch (IOException e) {
            System.out.println("파일 읽기 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}
