package course05.problem01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ResearchLogManager {
    private List<ResearchLog> logs;

    public ResearchLogManager() {
        this.logs = new ArrayList<>();
    }

    public ResearchLog readAndDisplayLog(String inputFileName) {
        if (inputFileName == null || inputFileName.trim().isEmpty()) {
            System.out.println("→ 존재하지 않는 파일입니다. 파일 이름을 다시 확인해주세요.");
            return null;
        }

        String fileName = inputFileName.trim();
        if (!fileName.endsWith(".txt")) {
            fileName += ".txt";
        }

        File targetFile = findFile(fileName);

        if (targetFile == null || !targetFile.exists()) {
            System.out.println("→ 존재하지 않는 파일입니다. 파일 이름을 다시 확인해주세요.");
            return null;
        }

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(targetFile);
            byte[] buffer = new byte[(int) targetFile.length()];
            int bytesRead = fis.read(buffer);

            String content = "";
            if (bytesRead > 0) {
                content = new String(buffer, 0, bytesRead, StandardCharsets.UTF_8).trim();
            }

            System.out.println("→ " + content);
            ResearchLog log = new ResearchLog(fileName, content);
            logs.add(log);
            return log;
        } catch (FileNotFoundException e) {
            System.out.println("→ 존재하지 않는 파일입니다. 파일 이름을 다시 확인해주세요.");
        } catch (IOException e) {
            System.out.println("→ 파일 읽기 중 오류가 발생했습니다: " + e.getMessage());
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    System.out.println("→ 파일 스트림 닫기 오류: " + e.getMessage());
                }
            }
        }
        return null;
    }

    private File findFile(String fileName) {
        File f1 = new File("course05/problem01/" + fileName);
        if (f1.exists())
            return f1;

        File f2 = new File("course05/" + fileName);
        if (f2.exists())
            return f2;

        File f3 = new File("course05/5-1-" + fileName);
        if (f3.exists())
            return f3;

        File f4 = new File(fileName);
        if (f4.exists())
            return f4;

        return null;
    }

    public List<ResearchLog> searchByDate(String dateQuery) {
        List<ResearchLog> results = new ArrayList<>();
        for (ResearchLog log : logs) {
            if (log.getLogDate().contains(dateQuery) || log.getFileName().contains(dateQuery)) {
                results.add(log);
            }
        }
        return results;
    }
}
