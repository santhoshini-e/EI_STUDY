package designpatterns.structural.bridge;

/**
 * Concrete abstraction for basic remote control.
 */
public class BasicRemote extends RemoteControl {

    public BasicRemote(Device device) {
        super(device);
    }

    @Override
    public void togglePower() {
        try {
            if (device.isPoweredOn()) {
                device.powerOff();
            } else {
                device.powerOn();
            }
        } catch (IllegalStateException e) {
            System.out.println("Operation failed: " + e.getMessage());
        }
    }

    @Override
    public void volumeUp() {
        try {
            int currentVolume = device.getCurrentVolume();
            device.setVolume(currentVolume + 5);
        } catch (Exception e) {
            System.out.println("Operation failed: " + e.getMessage());
        }
    }

    @Override
    public void volumeDown() {
        try {
            int currentVolume = device.getCurrentVolume();
            device.setVolume(currentVolume - 5);
        } catch (Exception e) {
            System.out.println("Operation failed: " + e.getMessage());
        }
    }

    @Override
    public void displayStatus() {
        String status = device.isPoweredOn() ? "ON" : "OFF";
        System.out.println("Device Status: " + status);
        if (device.isPoweredOn()) {
            System.out.println("Volume: " + device.getCurrentVolume());
        }
    }
}