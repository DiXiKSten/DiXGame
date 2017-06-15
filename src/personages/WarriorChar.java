package personages;

import model.Model;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DiX on 13.06.2017.
 */
public class WarriorChar extends Heroes {
//hjghjtghdfgdgf
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
        ImageIcon icon1 = new ImageIcon("images/varModel.png");
        Image im = icon1.getImage();
        graphics.drawImage(im,getX()-getWeight()/2,getY()-getHight()/2,null);
        graphics.setColor(Color.RED);
        graphics.drawString(getName(),getX()-getWeight()/3,getY()-getHight()/2);
    }
}
