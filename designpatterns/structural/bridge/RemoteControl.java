package designpatterns.structural.bridge;

/**
 * Abstraction class for the Bridge pattern.
 * Defines the interface for remote controls.
 */
public abstract class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        if (device == null) {
            throw new IllegalArgumentException("Device cannot be null");
        }
        this.device = device;
    }

    public abstract void togglePower();
    public abstract void volumeUp();
    public abstract void volumeDown();
    public abstract void displayStatus();
}