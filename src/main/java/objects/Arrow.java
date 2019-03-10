package objects;

import personages.Pers;
import view.Sound;

import java.awt.*;

/**
 * Created by DiX on 18.06.2017.
 */
public class Arrow extends HeroShell {

    private class MoveArrow extends Thread{
        @Override
        public void run() {
            while (count<22){
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
    private class SoundArrow extends Thread{
        @Override
        public void run() {
            try {
                Sound sound = new Sound("sound/strela.wav");
                sound.play();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }


    public Arrow(Pers pers, Pers pers2) {
        setWeight(15);
        setHight(15);
        setGetterAttack(pers);
        setSetterAttack(pers2);
        setX(pers.getX()+20);
        setY(pers.getY());
        count=0;
        MoveArrow moveArrow = new MoveArrow();
        setDestr(false);
        moveArrow.start();
        SoundArrow soundArrow = new SoundArrow();
        soundArrow.start();

    }

    @Override
    public void show(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(getX()-getWeight()/2,getY()-getHight()/2,getWeight(),3);
    }
}
