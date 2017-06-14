package view;

import object.Pers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.EventListener;
import java.util.Set;

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
                // тут назначим управление
            }
        }
    }

    public GameLvl(View view){
        this.view = view;
        this.addKeyListener(new KeyHandler());
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0,0,view.getWidth(),view.getHeight());
        Set<Pers> set = view.getAllPers();
        for (Pers p:set){
            p.show(g);
        }
    }
}
