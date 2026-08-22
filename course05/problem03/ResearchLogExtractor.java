package course05.problem03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ResearchLogExtractor {
    private String folderPath;
    private List<ResearchLog> logs;

    public ResearchLogExtractor(String folderPath) throws FileNotFoundException, NoDataAvailableException, IOException {
        this.folderPath = folderPath;
        this.logs = new ArrayList<>();
        loadLogsFromFolder();
    }

    private void loadLogsFromFolder() throws FileNotFoundException, NoDataAvailableException, IOException {
        File dir = new File(folderPath);
        if (!dir.exists() || !dir.isDirectory()) {
            throw new FileNotFoundException("폴더 경로가 잘못되었습니다: " + folderPath);
        }

        File[] files = dir.listFiles((d, name) -> name.endsWith(".txt") && !name.contains("_Lumino_ADR.txt"));

        if (files == null || files.length == 0) {
            System.out.println("분석할 파일이 없습니다");
            throw new NoDataAvailableException("분석할 파일이 없습니다");
        }

        for (File file : files) {
            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] buffer = new byte[(int) file.length()];
                int bytesRead = fis.read(buffer);

                String content = "";
                if (bytesRead > 0) {
                    content = new String(buffer, 0, bytesRead, StandardCharsets.UTF_8).trim();
                }

                ResearchLog log = new ResearchLog(file.getName(), content);
                logs.add(log);
            }
        }
    }

    public File extractAndSaveSummary() throws IOException {
        List<String> validEntries = new ArrayList<>();
        Set<String> seenEntries = new HashSet<>();

        for (ResearchLog log : logs) {
            String name = log.getPlantName();
            String addr = log.getAddress();

            if (name == null || addr == null) {
                System.out.println(log.getFileName() + ": 식물명 또는 주소 정보가 누락되었습니다.");
                continue;
            }

            String entry = name + " - " + addr;

            if (seenEntries.contains(entry)) {
                continue;
            }

            seenEntries.add(entry);
            validEntries.add(entry);
        }

        if (validEntries.isEmpty()) {
            System.out.println("추출할 유효한 식물 데이터가 없습니다.");
            return null;
        }

        String baseTime = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
        String outputFileName = baseTime + "_Lumino_ADR.txt";
        File outputFile = new File(folderPath, outputFileName);

        if (outputFile.exists()) {
            String secondsTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            outputFileName = secondsTime + "_Lumino_ADR.txt";
            outputFile = new File(folderPath, outputFileName);
        }

        StringBuilder sb = new StringBuilder();
        for (String entry : validEntries) {
            sb.append(entry).append("\n");
        }

        try (FileOutputStream fos = new FileOutputStream(outputFile)) {
            fos.write(sb.toString().getBytes(StandardCharsets.UTF_8));
        }

        System.out.println("요약 파일이 성공적으로 생성되었습니다: " + outputFile.getName());
        System.out.println();
        System.out.print(sb.toString());

        return outputFile;
    }

    public List<ResearchLog> getLogs() {
        return logs;
    }
}
