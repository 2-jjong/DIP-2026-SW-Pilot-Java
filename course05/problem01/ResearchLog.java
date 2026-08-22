package course05.problem01;

public class ResearchLog {
    private String fileName;
    private String content;
    private String logDate;

    public ResearchLog(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
        this.logDate = extractDateFromFileName(fileName);
    }

    private String extractDateFromFileName(String fileName) {
        if (fileName == null)
            return "알 수 없음";

        String cleanName = fileName;
        if (cleanName.contains("-")) {
            cleanName = cleanName.substring(cleanName.lastIndexOf("-") + 1);
        }

        if (cleanName.length() >= 12 && cleanName.substring(0, 12).matches("\\d{12}")) {
            String digits = cleanName.substring(0, 12);
            String year = digits.substring(0, 4);
            String month = digits.substring(4, 6);
            String day = digits.substring(6, 8);
            String hour = digits.substring(8, 10);
            String minute = digits.substring(10, 12);
            return year + "년 " + month + "월 " + day + "일 " + hour + "시 " + minute + "분";
        }
        return "작성일자 정보 없음";
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLogDate() {
        return logDate;
    }

    public void setLogDate(String logDate) {
        this.logDate = logDate;
    }

    public void displayLog() {
        if (content != null) {
            System.out.println("→ " + content);
        }
    }
}
