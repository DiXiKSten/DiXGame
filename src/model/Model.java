package model;

import controller.Controller;
import object.ArcherChar;
import object.MagChar;
import object.Pers;
import object.WarriorChar;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by DiX on 13.06.2017.
 */
public class Model {
    Controller controller;

    public final static int FIELD_POSITION = 300;
    Set<Pers> set = new HashSet<>();

    public Model(Controller controller) {
        this.controller = controller;
    }

    public void start(){
        chooseHero();
    }

    public void chooseHero(){
        String[] s = controller.getChoose();
        switch (s[0]){
            case "var":
                set.add(new WarriorChar(s[1],true));
                break;
            case "mag":
                set.add(new MagChar(s[1],true));
                break;
            case "luk":
                set.add(new ArcherChar(s[1],true));
                break;
        }
    }

    public Set<Pers> getAllPers() {
        return set;
    }
}
