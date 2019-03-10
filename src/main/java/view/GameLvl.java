package view;

import controller.EventListener;
import model.Permeshalka;
import objects.GameObjects;
import personages.Heroes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


/**
 * Created by DiX on 14.06.2017.
 */
class GameLvl extends JPanel implements ActionListener {
    private final Timer timer = new Timer(200, this);
    private final View view;
    private EventListener eventListener;

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    class KeyHandler extends KeyAdapter{
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
                case (KeyEvent.VK_SPACE):
                    eventListener.heroAttack();
                   break;
                case (KeyEvent.VK_R):
                    eventListener.heroRest();
                    break;
                case (KeyEvent.VK_ENTER):
                    eventListener.heroRangeAttack();
                    timer.start();
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
        if (view.getListShell().size()==0)timer.stop();
        System.out.println("обновлено");
        g.setColor(Color.WHITE);
        g.fillRect(0,0,1000,1000);

        Heroes heroes = view.getHero();
        if (heroes!=null) {
            if (heroes.isRest()) {
                heroes.sleep(g);
            }
            else {
                ArrayList<GameObjects> set2 = view.getAllGameObjects();
                System.out.println(set2.size());
                for (GameObjects p : set2) {
                    p.show(g);
                }
            }
        }


    }
}
