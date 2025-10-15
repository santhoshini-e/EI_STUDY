package designpatterns.structural.bridge;

/**
 * Demonstration class for the Bridge pattern in remote control system.
 */
public class RemoteControlDemo {

    public static void main(String[] args) {
        Device tv = new Television();
        RemoteControl remote = new BasicRemote(tv);
        remote.togglePower();

        Device radio = new Radio();
        remote = new BasicRemote(radio);
        remote.togglePower();
        remote.togglePower();

    }
}