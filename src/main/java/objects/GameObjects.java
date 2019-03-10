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

    protected void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    protected void setY(int y) {
        this.y = y;
    }

    protected int getWeight() {
        return weight;
    }

    protected void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHight() {
        return hight;
    }

    protected void setHight(int hight) {
        this.hight = hight;
    }

    Color getColor() {
        return color;
    }

    void setColor(Color color) {
        this.color = color;
    }

    public boolean collision(GameObjects o) {
        int dx = o.getX() - this.getX();
        int dy = o.getY() - this.getY();
        int sumRad = (this.getHight() / 2) + (o.getHight() / 2);
        double d = Math.sqrt((dx * dx) + (dy * dy));
        return d < sumRad;
    }

}
