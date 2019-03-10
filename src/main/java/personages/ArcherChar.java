package personages;

import model.Model;
import objects.Arrow;
import objects.HeroShell;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DiX on 13.06.2017.
 */
public class ArcherChar extends Heroes {

    public ArcherChar(String name, boolean pol) {
        setName(name);
        setPol(pol);
        setLvl(1);
        setHelths((int) (stackHP*1.4));
        setMaxHelth(getHelths());
        setRest(false);
        setAttackPower((int) (stackAP*1.2));
        setSpellPower(0);
        setX(Model.FIELD_POSITION/2);
        setY(Model.FIELD_POSITION);
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
    public void lvlUp() {

    }

    @Override
    public HeroShell rangeAkkack(Pers p1, Pers p2) {
        return new Arrow(p1,p2);
    }

    @Override
    public void show(Graphics graphics) {
        ImageIcon icon1 = new ImageIcon("images/lukModel.png");
        Image im = icon1.getImage();
        graphics.drawImage(im,getX()-getWeight()/2,getY()-getHight()/2,null);
        graphics.setColor(Color.RED);
        graphics.drawString(getName(),getX()-getWeight()/3,getY()-getHight()/2);
        graphics.drawString(String.valueOf(getHelths()),getX(),getY()-getHight()/2-15);
        if (!getMesage().equals("")) {
            graphics.setColor(Color.BLUE);
            graphics.drawRoundRect(getX() - getWeight() * 2-5,getY() - getHight() - 30,230,30,200,20);
            graphics.drawString(getMesage(), getX() - getWeight() * 2, getY() - getHight() / 2 - 35);
            setMesage("");
        }
    }
}
