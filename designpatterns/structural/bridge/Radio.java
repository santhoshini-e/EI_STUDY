package designpatterns.structural.bridge;

/**
 * Concrete implementor for Radio device.
 */
public class Radio implements Device {
    @Override
    public void powerOn() {
        System.out.println("Radio turned ON.");
    }

    @Override
    public void powerOff() {
        System.out.println("Radio turned OFF.");
    }
}