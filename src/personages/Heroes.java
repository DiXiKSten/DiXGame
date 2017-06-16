package personages;

import model.Model;
import model.Permeshalka;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DiX on 14.06.2017.
 */
public abstract class Heroes extends Pers implements HeroInt{

    private boolean rest;

    public boolean isRest() {
        return rest;
    }

    public void setRest(boolean rest) {
        this.rest = rest;
    }

    @Override
    public void attack(Pers gameObjects) {
        gameObjects.setHelths(gameObjects.getHelths()-this.getAttackPower());
    }

    @Override
    public void sleep(Graphics g) {
        setHelths(getMaxHelth());
        setRest(false);
        ImageIcon icon1 = new ImageIcon("images/otdih.png");
        Image im = icon1.getImage();
        g.drawImage(im,1,1,null);
    }

    @Override
    public int getWeight() {
        return 50;
    }

    @Override
    public int getHight() {
        return 50;
    }

    @Override
    public void move(Permeshalka p) {
        switch (p) {
            case RIGHT:
                setX(getX() + Model.PEREMESHALKA);
                break;
            case LEFT:
                setX(getX() - Model.PEREMESHALKA);
                break;
            case DOWN: setY(getY()+Model.PEREMESHALKA);
                break;
            case UP:setY(getY()-Model.PEREMESHALKA);
                break;
        }
    }
}
