package designpatterns.structural.bridge;

/**
 * Concrete abstraction for basic remote control.
 */
public class BasicRemote extends RemoteControl {
    private boolean isPoweredOn = false;

    public BasicRemote(Device device) {
        super(device);
    }

    @Override
    public void togglePower() {
        if (isPoweredOn) {
            device.powerOff();
        } else device.powerOn();
        isPoweredOn = !isPoweredOn;
    }
}