package personages;

import model.Permeshalka;

/**
 * Created by DiX on 13.06.2017.
 */
public interface HeroInt extends PersInt {
    void move(Permeshalka p);
    void speak();
    void eat();
    void sleep();
    void lvlUp();

}
