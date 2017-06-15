package view;

import controller.EventListener;
import model.Permeshalka;
import objects.GameObjects;
import personages.Pers;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


/**
 * Created by DiX on 14.06.2017.
 */
public class GameLvl extends JPanel {
    private View view;
    private EventListener eventListener;

    public class KeyHandler extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case (KeyEvent.VK_LEFT):
                    eventListener.move(Permeshalka.LEFT);
                    break;
                case (KeyEvent.VK_RIGHT):
                    eventListener.move(Permeshalka.RIGHT);
                    break;
                case (KeyEvent.VK_UP):
                    eventListener.move(Permeshalka.UP);
                    break;
                case (KeyEvent.VK_DOWN):
                    eventListener.move(Permeshalka.DOWN);
                    break;
            }
        }
    }

    public void setEventListener(EventListener eventListener){
        this.eventListener=eventListener;
    }

    public GameLvl(View view){
        this.view=view;
        this.addKeyListener(new KeyHandler());
        this.setFocusable(true);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(0,0,1000,1000);

        ArrayList<GameObjects> set2 = view.getAllGameObjects();

        for (GameObjects p:set2){
            p.show(g);
        }
        System.out.println("обновлено");
    }
}
