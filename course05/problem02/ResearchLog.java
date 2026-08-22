package course05.problem02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ResearchLog {
    private String fileName;
    private String content;
    private String formattedDate;

    public ResearchLog(String fileName, String content) throws ParseException {
        this.fileName = fileName;
        this.content = content;
        this.formattedDate = parseDateFromFileName(fileName);
    }

    private String parseDateFromFileName(String fileName) throws ParseException {
        if (fileName == null) {
            throw new ParseException("Unparseable date: \"null\"", 0);
        }

        String cleanName = fileName;
        if (cleanName.contains("-")) {
            cleanName = cleanName.substring(cleanName.lastIndexOf("-") + 1);
        }

        String datePart = cleanName;
        if (cleanName.contains("_")) {
            datePart = cleanName.substring(0, cleanName.indexOf("_"));
        } else if (cleanName.contains(".")) {
            datePart = cleanName.substring(0, cleanName.indexOf("."));
        }

        if (datePart.length() != 12 || !datePart.matches("\\d{12}")) {
            throw new ParseException("Unparseable date: \"" + datePart + "\"", 0);
        }

        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyyMMddHHmm");
        inputFormat.setLenient(false);
        Date date = inputFormat.parse(datePart);

        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return outputFormat.format(date);
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

    public String getFormattedDate() {
        return formattedDate;
    }

    public void setFormattedDate(String formattedDate) {
        this.formattedDate = formattedDate;
    }

    public void displayLog() {
        System.out.println("→ " + formattedDate + " " + content);
    }
}
