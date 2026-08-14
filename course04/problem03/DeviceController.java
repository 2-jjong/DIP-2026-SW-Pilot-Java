package course04.problem03;

import java.util.ArrayList;
import java.util.List;

public class DeviceController {
    private List<Device> connectedDevices;

    public DeviceController() {
        this.connectedDevices = new ArrayList<>();
    }

    public void connectDevice(Device device) {
        connectedDevices.add(device);
        System.out.println("컨트롤러에 기기가 등록되었습니다 : " + device.getName());
    }

    public void powerOnDevice(Device device) {
        device.powerOn();
    }

    public void powerOffDevice(Device device) {
        device.powerOff();
        System.out.println(device.getName() + " 전원을 껐습니다.");
    }

    public void activateSmartFeature(Device device) {
        if (device instanceof SmartCallable) {
            ((SmartCallable) device).activateSmartFeature();
        } else {
            System.out.println("[예외] 스마트 기능이 없는 일반 기기입니다: " + device.getName());
        }
    }

    public void powerOffAllDevices() {
        if (connectedDevices.isEmpty()) {
            return;
        }

        List<String> names = new ArrayList<>();
        for (int i = connectedDevices.size() - 1; i >= 0; i--) {
            names.add(connectedDevices.get(i).getName());
        }

        System.out.println("모든 기기 전원을 종료합니다 : " + String.join(", ", names));

        for (Device device : connectedDevices) {
            device.setPoweredOn(false);
        }
    }

    public void setEnergySavingMode(Device device, boolean enable) {
        if (device instanceof EnergySavable) {
            ((EnergySavable) device).setEnergySavingMode(enable);
        }
    }

    public void setAllEnergySavingMode(boolean enable) {
        String statusText = enable ? "활성화" : "비활성화";
        System.out.println("--- 모든 기기의 에너지 절약 모드를 " + statusText + "합니다 ---");
        for (Device device : connectedDevices) {
            setEnergySavingMode(device, enable);
        }
    }
}
