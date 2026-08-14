package course04.problem03;

public class GeneralDevice extends Device implements EnergySavable {
    private boolean energySavingMode;

    public GeneralDevice(String name) {
        super(name);
        this.energySavingMode = false;
        System.out.println("일반 기기가 생성되었습니다 : " + name + ", " + getBrand());
    }

    @Override
    public void setEnergySavingMode(boolean enable) {
        this.energySavingMode = enable;
        String statusText = enable ? "활성화" : "비활성화";
        System.out.println(getName() + " 에너지 절약 모드가 " + statusText + " 되었습니다.");
    }

    @Override
    public boolean isEnergySavingMode() {
        return energySavingMode;
    }
}
