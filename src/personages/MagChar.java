package personages;

import model.Model;

import java.awt.*;

/**
 * Created by DiX on 13.06.2017.
 */
public class MagChar extends Heroes {

    public MagChar(String name, boolean pol) {
        setName(name);
        setPol(pol);
        setLvl(1);
        setHelths(stackHP);
        setAttackPower((int) (stackAP*0.8));
        setSpellPower(stackSP);
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
        graphics.setColor(Color.cyan);
        graphics.fillOval(getX()-(getWeight()/2),getY()-(getHight()/2),getHight(),getWeight());
        graphics.setColor(Color.BLACK);
        graphics.drawString(getName(),getX()-28,getY()+07);
    }
}
