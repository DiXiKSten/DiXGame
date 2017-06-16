package personages;

import objects.GameObjects;

import java.awt.*;

/**
 * Created by DiX on 13.06.2017.
 */
public abstract class Pers extends GameObjects{
    private String mesage = "";
    private String name;
    private boolean pol;
    private int lvl;
    private int helths;
    private int maxHelth;
    private int attackPower;
    private int spellPower;
    public final static int stackHP = 20;
    public final static int stackHPMonster = 40;
    public final static int stackAP = 10;
    public final static int stackSP = 10;

    public abstract void show(Graphics graphics);

    public int getMaxHelth() {
        return maxHelth;
    }

    public void setMaxHelth(int maxHelth) {
        this.maxHelth = maxHelth;
    }

    public int getSpellPower() {
        return spellPower;
    }
    public void setSpellPower(int spellPower) {
        this.spellPower = spellPower;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPol() {
        return pol;
    }

    public void setPol(boolean pol) {
        this.pol = pol;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getHelths() {
        return helths;
    }

    public void setHelths(int helths) {
        this.helths = helths;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public String getMesage() {
        return mesage;
    }

    public void setMesage(String mesage) {
        this.mesage = mesage;
    }
}
