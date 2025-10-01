package designpatterns.behavioral.observer;

/**
 * Observer interface for receiving score updates
 */
public interface ScoreObserver {
    void update(String score);
}