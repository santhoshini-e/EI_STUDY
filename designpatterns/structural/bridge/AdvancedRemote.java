package designpatterns.structural.bridge;

/**
 * Concrete abstraction for advanced remote control with extra features.
 */
public class AdvancedRemote extends BasicRemote {

    public AdvancedRemote(Device device) {
        super(device);
    }

    public void mute() {
        try {
            device.setVolume(0);
            System.out.println("Device muted");
        } catch (Exception e) {
            System.out.println("Operation failed: " + e.getMessage());
        }
    }

    public void setSpecificVolume(int volume) {
        try {
            device.setVolume(volume);
        } catch (Exception e) {
            System.out.println("Operation failed: " + e.getMessage());
        }
    }

    @Override
    public void displayStatus() {
        super.displayStatus();
        if (device.isPoweredOn()) {
            System.out.println("Remote Type: Advanced");
        }
    }
}