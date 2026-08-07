package course03.problem05;

import java.util.ArrayList;
import java.util.List;

public class Sorcerer {
    private String name;
    private List<AncientArtifact> artifactList;

    public Sorcerer(String name) {
        this.name = name;
        this.artifactList = new ArrayList<>();
        System.out.println("마법사 '" + name + "'이 생성되었습니다.");
    }

    public void addArtifact(AncientArtifact artifact) {
        artifactList.add(artifact);
        System.out.println("마법사 '" + name + "'이 " + artifact.getName() + "을 소유하게 되었습니다.");
    }

    public void checkArtifactAbility(AncientArtifact artifact) {
        System.out.println("마법사 '" + name + "'이 " + artifact.getName() + "의 능력을 확인합니다.\n");
        artifact.describe();
    }

    public void useEnergyGenerator(EnergyGenerator energyGenerator) {
        if (energyGenerator instanceof AncientArtifact) {
            AncientArtifact artifact = (AncientArtifact) energyGenerator;
            System.out.println("마법사 '" + name + "'이 " + artifact.getName() + "의 에너지 생성 능력을 사용합니다.");
        }
        energyGenerator.generateEnergy();
    }

    public void useWeatherController(WeatherController weatherController) {
        if (weatherController instanceof AncientArtifact) {
            AncientArtifact artifact = (AncientArtifact) weatherController;
            System.out.println("마법사 '" + name + "'이 " + artifact.getName() + "의 날씨 조절 능력을 사용합니다.");
        }
        weatherController.controlWeather();
    }
}
