package personages;

import objects.GameObjects;

/**
 * Created by DiX on 13.06.2017.
 */
public interface PersInt {
    void attack(Pers gameObjects);
    GameObjects rangeAkkack(Pers p1, Pers p2);
    void defence();
    void die();
}
