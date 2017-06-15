package model;

import controller.EventListener;
import objects.GameObjects;
import objects.Walls;
import personages.*;

import java.util.ArrayList;

/**
 * Created by DiX on 13.06.2017.
 */
public class Model {
    private EventListener eventListener;

    public final static int FIELD_POSITION = 300;
    public final static int PEREMESHALKA = 5;
    private Heroes heroes;
    private ArrayList<Pers> listPers =new ArrayList<>();
    private ArrayList<GameObjects> listObjects=new ArrayList<>();
    private ArrayList<Walls> listWalls = new ArrayList<>();

    public void start(){
        chooseHero();
        listWalls.add(new Walls(100,100));
        listWalls.add(new Walls(500,500));
        listWalls.add(new Walls(500,550));
        listWalls.add(new Walls(500,600));
    }

    public void moveHero(Permeshalka p){
        heroes.move(p);
        for (Walls obj:listWalls){
            switch (p){
                case UP: if (obj.collision(heroes)){
                    heroes.move(Permeshalka.DOWN);
                }
                case DOWN: if (obj.collision(heroes)){
                    heroes.move(Permeshalka.UP);
                }
                case RIGHT: if (obj.collision(heroes)){
                    heroes.move(Permeshalka.LEFT);
                }
                case LEFT: if (obj.collision(heroes)){
                    heroes.move(Permeshalka.RIGHT);
                }
            }
        }
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
        listPers.add(heroes);
    }

    public ArrayList<Pers> getListPers() {
        return listPers;
    }

    public ArrayList<GameObjects> getListObjects() {
        if (listWalls.size()>0) {
            for (Walls w : listWalls) {
                if (!listObjects.contains(w)) {
                    listObjects.add(w);
                }
            }
        }
        return listObjects;
    }

    public void setListPers(ArrayList<Pers> listPers) {
        this.listPers = listPers;
    }

    public ArrayList<Pers> getAllPers() {
        return getListPers();
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener  = eventListener;
    }
}
