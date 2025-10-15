package designpatterns.structural.bridge;

/**
 * Concrete implementor for Television device.
 */
public class Television implements Device {
    public void powerOn() {
        System.out.println("Television turned ON");
    }

    public void powerOff() {
        System.out.println("Television turned OFF");
    }

}