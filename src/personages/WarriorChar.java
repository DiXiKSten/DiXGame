package personages;

import model.Model;

import java.awt.*;

/**
 * Created by DiX on 13.06.2017.
 */
public class WarriorChar extends Heroes {

    public WarriorChar(String name, boolean pol) {
        setName(name);
        setPol(pol);
        setLvl(1);
        setHelths(stackHP * 2);
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
        graphics.fillOval(getX() - (heroRadius/2), getY() - (heroRadius/2), heroRadius, heroRadius);
        graphics.setColor(Color.BLACK);
        graphics.drawString(getName(), getX() - 28, getY() + 07);
    }
}
