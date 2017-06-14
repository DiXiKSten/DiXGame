package model;

import controller.Controller;
import controller.EventListener;
import object.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by DiX on 13.06.2017.
 */
public class Model {
    private EventListener eventListener;

    public final static int FIELD_POSITION = 300;
    public final static int PEREMESHALKA = 5;
    private Heroes heroes;
    private ArrayList<Pers> list=new ArrayList<>();

    public void start(){
        chooseHero();
        list.add(heroes);
    }

    public void moveHero(Permeshalka p){
        heroes.move(p);
    }

    public void chooseHero(){

        String[] s = eventListener.getChoose();
        switch (s[0]){
            case "var":
                heroes=new WarriorChar(s[1],true);
                break;
            case "mag":
                heroes=new MagChar(s[1],true);
                break;
            case "luk":
                heroes=new ArcherChar(s[1],true);
                break;
        }
        list.add(heroes);
    }

    public Heroes getHeroes() {
        return heroes;
    }

    public ArrayList<Pers> getList() {
        return list;
    }

    public void setList(ArrayList<Pers> list) {
        this.list = list;
    }

    public ArrayList<Pers> getAllPers() {
        return getList();
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener  = eventListener;
    }
}
