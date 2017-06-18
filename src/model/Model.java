package model;

import controller.Controller;
import controller.EventListener;
import javazoom.jl.decoder.JavaLayerException;
import objects.GameObjects;
import objects.HeroShell;
import objects.Walls;
import personages.*;
import view.Sound;

import java.io.FileNotFoundException;
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
    private ArrayList<HeroShell> listShell = new ArrayList<>();

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
        listEnemy.add(new Ork(250,170));

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
        ArrayList<HeroShell> shell = new ArrayList<>();
        if (listShell.size()>0) {
            for (HeroShell w : listShell) {
                if (w.isDestr()){
                    listObjects.remove(w);
                    Heroes heroes = (Heroes) w.getGetterAttack();
                    heroes.attack(w.getSetterAttack());
                    System.out.println("удалил стрелу");
                    shell.add(w);
                    if (w.getSetterAttack().getHelths()<=0) {
                        listEnemy.remove(w.getSetterAttack());
                        listObjects.remove(w.getSetterAttack());
                    }
                }
            }
        }
        listShell.removeAll(shell);
        if (listShell.size()==0)eventListener.stop();
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
        if (heroes.getHelths()<=0){
            gameOver();
        }
    }

    public void heroRangeAttack() {
        EnemyChar enemyChars=null;
        for (EnemyChar enemyChar:listEnemy){
            int dx = heroes.getX() - enemyChar.getX();
            int dy = heroes.getY() - enemyChar.getY();
            int sumRad = (heroes.getHight() / 2) + (enemyChar.getHight() / 2)+200;
            Double d = Math.sqrt((dx * dx) + (dy * dy));
            if (d<sumRad){
                HeroShell shell = (HeroShell) heroes.rangeAkkack(heroes,enemyChar);
                if (shell==null)break;
                listShell.add(shell);
                listObjects.add(shell);
                if (enemyChar.getHelths()<=0){
                    enemyChars=enemyChar;
                    break;
                }
            }
        }
        if (enemyChars!=null){
            listEnemy.remove(enemyChars);
            listObjects.remove(enemyChars);
        }
    }

    public void heroRest() {
        class RestSound extends Thread{
            @Override
            public void run() {
                try {
                    Sound sound = new Sound("sound/koster.wav");
                    sound.play();
                    System.out.println("все ок");

                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (JavaLayerException e1) {
                    e1.printStackTrace();
                }
            }
        }
        if (listEnemy.size()>0){
            heroes.setMesage("НЕ ВРЕМЯ ОТДЫХАТЬ, КРУГОМ ВРАГИ");
        }
        else {
            heroes.setRest(true);
            RestSound restSound = new RestSound();
            restSound.start();
        }
    }

    public ArrayList<HeroShell> getListShell() {
        return listShell;
    }

    public Heroes getHeroes() {
        return heroes;
    }

    public void gameOver(){
        eventListener.gameOver();
    }

    public void restartGame(){
        heroes=null;
        listEnemy=new ArrayList<>();
        listObjects=new ArrayList<>();
        listWalls = new ArrayList<>();
        start();
    }


}
