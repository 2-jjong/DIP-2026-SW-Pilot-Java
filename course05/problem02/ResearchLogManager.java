package course05.problem02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
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

        FileInputStream fis = null;
        try {
            File targetFile = findFile(fileName);

            if (targetFile == null || !targetFile.exists()) {
                throw new FileNotFoundException(fileName + " (No such file or directory)");
            }

            fis = new FileInputStream(targetFile);
            byte[] buffer = new byte[(int) targetFile.length()];
            int bytesRead = fis.read(buffer);

            String content = "";
            if (bytesRead > 0) {
                content = new String(buffer, 0, bytesRead, StandardCharsets.UTF_8).trim();
            }

            if (content.isEmpty()) {
                throw new EmptyFileException("파일 내용이 비어있습니다.");
            }

            ResearchLog log = new ResearchLog(fileName, content);
            log.displayLog();
            logs.add(log);
            return log;

        } catch (FileNotFoundException e) {
            System.out.println("→ " + e.toString() + " 존재하지 않는 파일입니다. 파일 이름을 다시 확인해주세요.");
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.println("→ " + e.toString() + " 파일 이름에서 날짜를 확인할 수 없습니다.");
            e.printStackTrace();
        } catch (EmptyFileException e) {
            System.out.println("→ " + e.toString());
            e.printStackTrace();
        } catch (SecurityException e) {
            System.out.println("→ " + e.toString() + " 보안 문제로 파일에 접근할 수 없습니다.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("→ " + e.toString() + " 파일 읽기 실패.");
            e.printStackTrace();
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
        File f1 = new File("course05/problem02/" + fileName);
        if (f1.exists()) return f1;

        File f2 = new File("course05/" + fileName);
        if (f2.exists()) return f2;

        File f3 = new File("course05/5-1-" + fileName);
        if (f3.exists()) return f3;

        File f4 = new File(fileName);
        if (f4.exists()) return f4;

        return null;
    }

    public List<ResearchLog> getLogs() {
        return logs;
    }
}
