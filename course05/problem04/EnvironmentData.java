package course05.problem04;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EnvironmentData {
    private String dateTime;
    private double temperature;
    private double humidity;
    private double oxygen;
    private String location;

    public EnvironmentData(double temperature, double humidity, double oxygen, String location) {
        this.dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        this.temperature = temperature;
        this.humidity = humidity;
        this.oxygen = oxygen;
        this.location = location;
    }

    public EnvironmentData(String dateTime, double temperature, double humidity, double oxygen, String location) {
        this.dateTime = dateTime;
        this.temperature = temperature;
        this.humidity = humidity;
        this.oxygen = oxygen;
        this.location = location;
    }

    public String getDateTime() {
        return dateTime;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getOxygen() {
        return oxygen;
    }

    public String getLocation() {
        return location;
    }

    public String toCsvFormat() {
        return String.format("%s,%.1f,%.1f,%.1f,%s", dateTime, temperature, humidity, oxygen, location);
    }

    public String toOxygenSummary() {
        return String.format("%s - %.1f - %s", dateTime, oxygen, location);
    }
}
