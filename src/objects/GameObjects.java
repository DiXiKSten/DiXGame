package objects;

import java.awt.*;

/**
 * Created by DiX on 15.06.2017.
 */
public abstract class GameObjects {
    private int x,y,weight,hight;
    private Color color;

    public abstract void show(Graphics g);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHight() {
        return hight;
    }

    public void setHight(int hight) {
        this.hight = hight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean collision(GameObjects o) {
        int dx = o.getX() - this.getX();
        int dy = o.getY() - this.getY();
        int sumRad = (this.getHight() / 2) + (o.getHight() / 2);
        Double d = Math.sqrt((dx * dx) + (dy * dy));
        return d < sumRad;
    }

}
