package designpatterns.behavioral.observer;

/**
 * Concrete Observer - Mobile display receiving score updates
 */
public class MobileDisplay implements ScoreObserver {
    private String user;

    public MobileDisplay(String user) {
        this.user = user;
    }

    @Override
    public void update(String score) {
        System.out.println("Mobile (" + user + "): Score Update - " + score);
    }
}