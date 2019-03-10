package objects;

import personages.Pers;
import view.Sound;

import java.awt.*;

/**
 * Created by DiX on 18.06.2017.
 */
public class Spell extends HeroShell {

    private class MoveSpell extends Thread {
        @Override
        public void run() {
            while (count < 22) {
                try {
                    Thread.sleep(200);
                    changPosition();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            setDestr(true);
        }
    }

    private class SoundSpell extends Thread {
        @Override
        public void run() {
            try {
                Sound sound = new Sound("sound/fb.wav");
                sound.play();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    public Spell(Pers pers, Pers pers2) {
        setWeight(20);
        setHight(20);
        setGetterAttack(pers);
        setSetterAttack(pers2);
        setX(pers.getX() + 20);
        setY(pers.getY());
        count = 0;
        MoveSpell moveArrow = new MoveSpell();
        setDestr(false);
        moveArrow.start();
        SoundSpell soundSpell = new SoundSpell();
        soundSpell.start();
    }

    @Override
    public void show(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(getX() - getWeight() / 2, getY() - getHight() / 2, getHight(), getWeight());
    }
}