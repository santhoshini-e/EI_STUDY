package designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Subject - Live score that broadcasts updates
 */
public class LiveScore implements ScoreSubject {
    private List<ScoreObserver> observers = new ArrayList<>();
    private String score;

    @Override
    public void addObserver(ScoreObserver observer) {
        observers.add(observer);
        System.out.println("SUCCESS : Observer added successfully.");
    }

    @Override
    public void notifyObservers() {
        if (observers.isEmpty()) {
            System.out.println("INFO : No Observers exist.");
        }
        for (ScoreObserver observer : observers) {
            observer.update(score);
        }
    }

    public void setScore(String newScore) {
        this.score = newScore;
        notifyObservers();
    }
}