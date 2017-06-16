package model;

import controller.Controller;
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

    public final static int FIELD_POSITION = 200;
    public final static int PEREMESHALKA = 5;
    private Heroes heroes;
    private ArrayList<EnemyChar> listEnemy =new ArrayList<>();
    private ArrayList<GameObjects> listObjects=new ArrayList<>();
    private ArrayList<Walls> listWalls = new ArrayList<>();

    public void start(){
        chooseHero();
        for (int i = 50;i<1000;i=i+50) {
            listWalls.add(new Walls(i, 80));
        }

        for (int i = 50;i<1000;i=i+50) {
            listWalls.add(new Walls(i, 250));
            if (i==500)i=i+100;
        }
        for (int i = 250;i<800;i=i+50) {
            listWalls.add(new Walls(500, i));

        }

        listWalls.add(new Walls(700,400));
        listWalls.add(new Walls(700,450));
        listWalls.add(new Walls(750,400));
        listWalls.add(new Walls(750,450));

        listEnemy.add(new Ork(850,850));
        listEnemy.add(new Ork(850,170));

    }

    public void moveHero(Permeshalka p){
        heroes.move(p);
        for (GameObjects obj:listObjects){
            if (!obj.equals(heroes)) {
                switch (p) {
                    case UP:
                        if (obj.collision(heroes)||heroes.getY()<=0+heroes.getHight()/2) {
                            heroes.move(Permeshalka.DOWN);
                        }
                    case DOWN:
                        if (obj.collision(heroes)||heroes.getY()>=eventListener.getMaxY()-heroes.getHight()/2) {
                            heroes.move(Permeshalka.UP);
                        }
                    case RIGHT:
                        if (obj.collision(heroes)||heroes.getX()>=eventListener.getMaxX()-heroes.getWeight()/2) {
                            heroes.move(Permeshalka.LEFT);
                        }
                    case LEFT:
                        if (obj.collision(heroes)||heroes.getX()<=0+heroes.getWeight()/2) {
                            heroes.move(Permeshalka.RIGHT);
                        }
                }
            }
        }//kk
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
        listObjects.add(heroes);
    }


    public ArrayList<GameObjects> getListObjects() {
        if (listWalls.size()>0) {
            for (Walls w : listWalls) {
                if (!listObjects.contains(w)) {
                    listObjects.add(w);
                }
            }
        }
        if (listEnemy.size()>0) {
            for (EnemyChar w : listEnemy) {
                if (!listObjects.contains(w)) {
                    listObjects.add(w);
                }
            }
        }
        return listObjects;
    }


    public void setEventListener(EventListener eventListener) {
        this.eventListener  = eventListener;
    }

    public void heroAttack() {
        EnemyChar enemyChars=null;
        for (EnemyChar enemyChar:listEnemy){
            int dx = heroes.getX() - enemyChar.getX();
            int dy = heroes.getY() - enemyChar.getY();
            int sumRad = (heroes.getHight() / 2) + (enemyChar.getHight() / 2)+10;
            Double d = Math.sqrt((dx * dx) + (dy * dy));
            if (d<sumRad){
                heroes.attack(enemyChar);
                if (enemyChar.getHelths()<=0){
                    enemyChars=enemyChar;
                    break;
                }
                else enemyChar.attack(heroes);
            }
        }
        if (enemyChars!=null){
            listEnemy.remove(enemyChars);
            listObjects.remove(enemyChars);
        }
    }

    public void heroRest() {
        if (listEnemy.size()>0){
            heroes.setMesage("НЕ ВРЕМЯ ОТДЫХАТЬ, КРУГОМ ВРАГИ");
        }
        else heroes.setRest(true);
    }

    public Heroes getHeroes() {
        return heroes;
    }
}
