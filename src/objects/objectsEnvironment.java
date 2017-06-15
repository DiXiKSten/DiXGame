package objects;

import java.awt.*;

/**
 * Created by DiX on 15.06.2017.
 */
public interface objectsEnvironment {
    void destroy();
    boolean collision(GameObjects o);
}
