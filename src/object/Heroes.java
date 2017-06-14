package object;

import model.Model;
import model.Permeshalka;

/**
 * Created by DiX on 14.06.2017.
 */
public abstract class Heroes extends Pers implements HeroInt{
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
