package course05.problem03;

public class ResearchLog {
    private String fileName;
    private String content;
    private String plantName;
    private String address;

    public ResearchLog(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
        parsePlantNameAndAddress(content);
    }

    private void parsePlantNameAndAddress(String text) {
        if (text == null || text.trim().isEmpty()) {
            return;
        }

        int nameIdx = text.indexOf("Name.");
        if (nameIdx != -1) {
            int start = nameIdx + 5;
            while (start < text.length() && (text.charAt(start) == ' ' || text.charAt(start) == '\t')) {
                start++;
            }

            int endNL = text.indexOf("\n", start);
            int endCR = text.indexOf("\r", start);
            int endADR = text.indexOf("ADR.", start);

            int end = text.length();
            if (endNL != -1 && endNL < end)
                end = endNL;
            if (endCR != -1 && endCR < end)
                end = endCR;
            if (endADR != -1 && endADR < end)
                end = endADR;

            String extractedName = text.substring(start, end).trim();
            if (!extractedName.isEmpty()) {
                this.plantName = extractedName;
            }
        }

        int adrIdx = text.indexOf("ADR.");
        if (adrIdx != -1) {
            int start = adrIdx + 4;
            while (start < text.length() && (text.charAt(start) == ' ' || text.charAt(start) == '\t')) {
                start++;
            }

            int endNL = text.indexOf("\n", start);
            int endCR = text.indexOf("\r", start);

            int end = text.length();
            if (endNL != -1 && endNL < end)
                end = endNL;
            if (endCR != -1 && endCR < end)
                end = endCR;

            String extractedAddr = text.substring(start, end).trim();
            if (!extractedAddr.isEmpty()) {
                this.address = extractedAddr;
            }
        }
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

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void displayLog() {
        if (content != null) {
            System.out.println(content);
        }
    }
}
