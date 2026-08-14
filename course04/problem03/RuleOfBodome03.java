package course04.problem03;

public class RuleOfBodome03 {
    public static void main(String[] args) {
        // 스마트 전자기기와 일반 기기 생성
        GeneralDevice doorOpener = new GeneralDevice("도어 오프너");
        SmartDevice autoMirror = new SmartDevice("자동 거울", "기분을 인식해 옷을 추천하는 기능");

        System.out.println();

        // 컨트롤러 생성 및 기기 연결
        DeviceController controller = new DeviceController();
        controller.connectDevice(doorOpener);
        controller.connectDevice(autoMirror);

        System.out.println();

        // 컨트롤러를 이용해 스마트 전자기기 전원을 켬
        controller.powerOnDevice(autoMirror);

        // 컨트롤러를 이용해 스마트 고급 기능을 활성화 시킴
        controller.activateSmartFeature(autoMirror);

        System.out.println();

        // 일반 전자기기의 전원을 켬
        controller.powerOnDevice(doorOpener);

        System.out.println();

        // 컨트롤러를 이용해 모든 전자기기 전원을 끔
        controller.powerOffAllDevices();

        System.out.println();

        // 에너지 절약 모드
        controller.setAllEnergySavingMode(true);
    }
}
