package objects;

import java.awt.*;

/**
 * Created by DiX on 15.06.2017.
 */
public class Walls extends GameObjects implements objectsEnvironment {

    public Walls(int x, int y) {
        setX(x);
        setY(y);
        setHight(40);
        setWeight(40);
        setColor(Color.BLACK);
    }

    @Override
    public void show(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getX()-(getWeight()/2),getY()-(getHight()/2),getWeight(),getHight());
    }

    @Override
    public void destroy() {

    }

    @Override
    public void collision(Object o) {

    }
}
