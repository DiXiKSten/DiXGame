package controller;

import model.Permeshalka;

/**
 * Created by DiX on 14.06.2017.
 */
public interface EventListener {
    void move(Permeshalka p);
    String[] getChoose();

    void heroAttack();

    int getMaxY();

    int getMaxX();

    void heroRest();
}
