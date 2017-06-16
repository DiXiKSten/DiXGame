package personages;

import model.Permeshalka;

import java.awt.*;

/**
 * Created by DiX on 13.06.2017.
 */
public interface HeroInt extends PersInt {
    void move(Permeshalka p);
    void speak();
    void eat();
    void sleep(Graphics g);
    void lvlUp();

}
