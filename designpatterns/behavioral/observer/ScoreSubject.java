package designpatterns.behavioral.observer;

/**
 * Subject interface for managing score observers
 */
public interface ScoreSubject {
    void addObserver(ScoreObserver observer);
    void notifyObservers();
}