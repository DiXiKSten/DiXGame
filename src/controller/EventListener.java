package controller;

import model.Permeshalka;

/**
 * Created by DiX on 14.06.2017.
 */
public interface EventListener {
    void move(Permeshalka p);
    String[] getChoose();

    void stop();

    void heroAttack();

    int getMaxY();

    int getMaxX();

    void heroRest();

    void gameOver();

    void startGame();

    void heroRangeAttack();

    void upd();
}
