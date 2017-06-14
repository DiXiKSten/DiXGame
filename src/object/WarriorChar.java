package object;

import model.Model;

import java.awt.*;

/**
 * Created by DiX on 13.06.2017.
 */
public class WarriorChar extends Pers implements HeroInt {

    public WarriorChar(String name, boolean pol) {
        setName(name);
        setPol(pol);
        setLvl(1);
        setHelths(stackHP*2);
        setAttackPower(stackAP);
        setSpellPower(0);
        setX(Model.FIELD_POSITION);
        setY(Model.FIELD_POSITION);
    }

    @Override
    public void attack() {

    }

    @Override
    public void defence() {

    }

    @Override
    public void die() {

    }

    @Override
    public void move() {

    }

    @Override
    public void speak() {

    }

    @Override
    public void eat() {

    }

    @Override
    public void sleep() {

    }

    @Override
    public void lvlUp() {

    }

    @Override
    public void show(Graphics graphics) {
        graphics.setColor(Color.PINK);
        graphics.fillOval(getX()-40,getY()-40,80,80);
        graphics.setColor(Color.BLACK);
        graphics.drawString(getName(),getX()-28,getY()+07);
    }
}
