package controller;

import model.Model;
import model.Permeshalka;
import objects.GameObjects;
import objects.HeroShell;
import personages.Heroes;
import view.View;

import java.util.ArrayList;


/**
 * Created by DiX on 13.06.2017.
 */
public class Controller implements EventListener{

    private boolean stop =false;

    private final Model model;
    private final View view;

    public Controller() {
        view = new View(this);
        model = new Model();
        view.init();
        model.setEventListener(this);
        view.setEventListener(this);
        model.start();
        view.update();
    }


    public ArrayList<GameObjects> getGameObjects(){
        return model.getListObjects();
    }

    public Heroes getHero(){
        return model.getHeroes();
    }

    public ArrayList<HeroShell> getListShell(){
        return model.getListShell();
    }

    public String[] getChoose(){
        String[] s = view.chooseHero();
        if (s[1].equals(""))s[1]="New Player";
        return s;

    }

    public void stop() {
        stop=true;
    }

    public void heroAttack() {
        model.heroAttack();
        view.update();
    }

    public void heroRangeAttack() {
        model.heroRangeAttack();
        view.update();
    }

    public boolean isStop() {
        return stop;
    }

    public void upd() {
        view.update();
    }

    public void move(Permeshalka p) {
        model.moveHero(p);
        view.update();
    }
    public int getMaxX(){
        return view.getWidth();
    }

    public void heroRest() {
        model.heroRest();
        view.update();
    }

    public void gameOver() {
        view.gameOver();
    }

    public void startGame() {
        model.restartGame();
        view.update();
    }

    public int getMaxY(){
        return view.getHeight();
    }
}
