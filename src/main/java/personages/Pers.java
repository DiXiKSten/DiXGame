package personages;

import objects.GameObjects;

import java.awt.*;

/**
 * Created by DiX on 13.06.2017.
 */
public abstract class Pers extends GameObjects {
    private String mesage = "";
    private String name;
    private boolean pol;
    private int lvl;
    private int helths;
    private int maxHelth;
    private int attackPower;
    private int spellPower;
    final static int stackHP = 20;
    final static int stackHPMonster = 40;
    final static int stackAP = 10;
    final static int stackSP = 10;

    public abstract void show(Graphics graphics);

    int getMaxHelth() {
        return maxHelth;
    }

    void setMaxHelth(int maxHelth) {
        this.maxHelth = maxHelth;
    }

    public int getSpellPower() {
        return spellPower;
    }
    void setSpellPower(int spellPower) {
        this.spellPower = spellPower;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public boolean isPol() {
        return pol;
    }

    void setPol(boolean pol) {
        this.pol = pol;
    }

    public int getLvl() {
        return lvl;
    }

    void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getHelths() {
        return helths;
    }

    void setHelths(int helths) {
        this.helths = helths;
    }

    int getAttackPower() {
        return attackPower;
    }

    void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    String getMesage() {
        return mesage;
    }

    public void setMesage(String mesage) {
        this.mesage = mesage;
    }
}
