package designpatterns.structural.bridge;

/**
 * Concrete implementor for Radio device.
 */
public class Radio implements Device {
    private boolean poweredOn;
    private int volume;

    public Radio() {
        this.poweredOn = false;
        this.volume = 30;
    }

    @Override
    public void powerOn() {
        if (poweredOn) {
            throw new IllegalStateException("Radio is already powered on");
        }
        poweredOn = true;
        System.out.println("Radio powered ON");
    }

    @Override
    public void powerOff() {
        if (!poweredOn) {
            throw new IllegalStateException("Radio is already powered off");
        }
        poweredOn = false;
        System.out.println("Radio powered OFF");
    }

    @Override
    public void setVolume(int volume) {
        if (!poweredOn) {
            throw new IllegalStateException("Cannot adjust volume when radio is off");
        }
        if (volume < 0 || volume > 100) {
            throw new IllegalArgumentException("Volume must be between 0 and 100");
        }
        this.volume = volume;
        System.out.println("Radio volume set to: " + volume);
    }

    @Override
    public boolean isPoweredOn() {
        return poweredOn;
    }

    @Override
    public int getCurrentVolume() {
        return volume;
    }
}