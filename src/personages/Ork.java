package personages;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DiX on 15.06.2017.
 */
public class Ork extends EnemyChar {

    public Ork(int x, int y) {
        setX(x);
        setY(y);
        setLvl(1);
        setHelths(stackHPMonster);
        setAttackPower(stackAP/2);
        setName(this.getClass().getSimpleName());
        setWeight(70);
        setHight(70);
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
    public void show(Graphics graphics) {
        ImageIcon icon1 = new ImageIcon("images/orcModel.png");
        Image im = icon1.getImage();
        graphics.drawImage(im,getX()-getWeight()/2,getY()-getHight()/2,null);
        graphics.setColor(Color.RED);
        graphics.drawString(getName(),getX(),getY()-getHight()/2);
    }
}
