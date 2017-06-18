package objects;

import personages.EnemyChar;
import personages.Pers;

import java.awt.*;

/**
 * Created by DiX on 18.06.2017.
 */
public abstract class HeroShell extends GameObjects{
    int count;

    private Pers gAttack;
    private Pers sAttack;
    private boolean destr;

    public boolean isDestr() {
        return destr;
    }

    protected void changPosition(){
        int dx = (getSetterAttack().getX()-getGetterAttack().getX())/10;
        int dy = (getSetterAttack().getY()-getGetterAttack().getY())/10;
        count++;
        setX(getX()+dx);
        setY(getY()+dy);
    }

    public void setDestr(boolean destr) {
        this.destr = destr;
    }

    public Pers getGetterAttack() {
        return gAttack;
    }

    public void setGetterAttack(Pers getterAttack) {
        this.gAttack = getterAttack;
    }

    public Pers getSetterAttack() {
        return sAttack;
    }

    public void setSetterAttack(Pers setterAttack) {
        this.sAttack = setterAttack;
    }

}
