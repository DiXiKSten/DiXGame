package objects;

import personages.Pers;

/**
 * Created by DiX on 18.06.2017.
 */
public abstract class HeroShell extends GameObjects {
    int count;

    private Pers gAttack;
    private Pers sAttack;
    private boolean destr;

    public boolean isDestr() {
        return destr;
    }

    void changPosition(){
        int dx = (getSetterAttack().getX()-getGetterAttack().getX())/20;
        int dy = (getSetterAttack().getY()-getGetterAttack().getY())/20;
        count++;
        setX(getX()+dx);
        setY(getY()+dy);
    }

    void setDestr(boolean destr) {
        this.destr = destr;
    }

    public Pers getGetterAttack() {
        return gAttack;
    }

    void setGetterAttack(Pers getterAttack) {
        this.gAttack = getterAttack;
    }

    public Pers getSetterAttack() {
        return sAttack;
    }

    void setSetterAttack(Pers setterAttack) {
        this.sAttack = setterAttack;
    }

}
