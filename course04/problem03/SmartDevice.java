package course04.problem03;

public class SmartDevice extends Device implements SmartCallable, EnergySavable {
    private String smartFeature;
    private boolean energySavingMode;

    public SmartDevice(String name, String smartFeature) {
        super(name);
        this.smartFeature = smartFeature;
        this.energySavingMode = false;
        System.out.println("스마트 기기가 생성되었습니다 : " + name + " , " + getBrand() + ", " + smartFeature);
    }

    public String getSmartFeature() {
        return smartFeature;
    }

    public void setSmartFeature(String smartFeature) {
        this.smartFeature = smartFeature;
    }

    @Override
    public void activateSmartFeature() {
        if (!isPoweredOn()) {
            System.out.println("[예외] 꺼져있는 스마트 기기(" + getName() + ")의 고급 기능을 활성화할 수 없습니다.");
            return;
        }

        if (smartFeature == null || smartFeature.trim().isEmpty()) {
            System.out.println("[예외] 스마트 기기(" + getName() + ")의 고급 기능이 입력되지 않았습니다.");
            return;
        }

        System.out.println(getName() + " 고급 기능을 활성화 시켰습니다.");
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
