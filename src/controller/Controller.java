package controller;

import model.Model;
import model.Permeshalka;
import objects.GameObjects;
import personages.Heroes;
import personages.Pers;
import view.View;

import java.util.ArrayList;


/**
 * Created by DiX on 13.06.2017.
 */
public class Controller implements EventListener{

    private Model model;
    private View view;

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

    public String[] getChoose(){
        String[] s = view.chooseHero();
        if (s[1].equals(""))s[1]="New Player";
        return s;

    }

    @Override
    public void heroAttack() {
        model.heroAttack();
        view.update();
    }

    @Override
    public void move(Permeshalka p) {
        model.moveHero(p);
        view.update();
    }
    public int getMaxX(){
        return view.getWidth();
    }

    @Override
    public void heroRest() {
        model.heroRest();
        view.update();
    }

    @Override
    public void gameOver() {
        view.gameOver();
    }

    @Override
    public void startGame() {
        model.restartGame();
        view.update();
    }

    public int getMaxY(){
        return view.getHeight();
    }

}
