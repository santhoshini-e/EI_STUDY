package designpatterns.structural.bridge;

/**
 * Concrete implementor for Television device.
 */
public class Television implements Device {
    private boolean poweredOn;
    private int volume;
    private int channel;

    public Television() {
        this.poweredOn = false;
        this.volume = 50;
        this.channel = 1;
    }

    @Override
    public void powerOn() {
        if (poweredOn) {
            throw new IllegalStateException("Television is already powered on");
        }
        poweredOn = true;
        System.out.println("Television powered ON");
    }

    @Override
    public void powerOff() {
        if (!poweredOn) {
            throw new IllegalStateException("Television is already powered off");
        }
        poweredOn = false;
        System.out.println("Television powered OFF");
    }

    @Override
    public void setVolume(int volume) {
        if (!poweredOn) {
            throw new IllegalStateException("Cannot adjust volume when television is off");
        }
        if (volume < 0 || volume > 100) {
            throw new IllegalArgumentException("Volume must be between 0 and 100");
        }
        this.volume = volume;
        System.out.println("Television volume set to: " + volume);
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