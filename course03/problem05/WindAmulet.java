package course03.problem05;

public class WindAmulet extends AncientArtifact implements WeatherController {
    public WindAmulet(String name) {
        super(name);
    }

    @Override
    public void describe() {
        System.out.println("\"바람의 부적으로 주변 공기의 흐름을 이용해 날씨를 조절합니다.\"");
    }

    @Override
    public void controlWeather() {
        describe();
    }
}
