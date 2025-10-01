package designpatterns.structural.bridge;

/**
 * Implementor interface for the Bridge pattern.
 * Defines the operations that all devices must implement.
 */
public interface Device {
    void powerOn();

    void powerOff();

    void setVolume(int volume);

    boolean isPoweredOn();

    int getCurrentVolume();
}