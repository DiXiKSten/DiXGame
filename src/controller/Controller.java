package controller;

import model.Model;
import object.Pers;
import view.View;

import java.util.EventListener;
import java.util.Set;

/**
 * Created by DiX on 13.06.2017.
 */
public class Controller implements EventListener{

    private Model model;
    private View view;

    public Controller() {
        view = new View(this);
        model = new Model(this);
        model.start();
        view.init();
        view.setEventListener(this);;
    }

    public Set<Pers> getPers(){
        return model.getAllPers();
    }
    public String[] getChoose(){
        String[] s = view.chooseHero();
        if (s[1].equals(""))s[1]="New Player";
        return s;
    }
}
