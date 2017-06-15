package controller;

import model.Model;
import model.Permeshalka;
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

    public ArrayList<Pers> getPers(){
        return model.getAllPers();
    }

    public String[] getChoose(){
        String[] s = view.chooseHero();
        if (s[1].equals(""))s[1]="New Player";
        return s;
    }

    @Override
    public void move(Permeshalka p) {
        model.moveHero(p);
        view.update();
    }
}
