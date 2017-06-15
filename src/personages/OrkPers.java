package personages;

import java.awt.*;

/**
 * Created by DiX on 15.06.2017.
 */
public class OrkPers extends EnemyChar {

    public OrkPers(int x, int y) {
        setX(x);
        setY(y);
        setLvl(1);
        setHelths(stackHPMonster);
        setAttackPower(stackAP/2);
        setName(this.getClass().getName());
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

    }
}
