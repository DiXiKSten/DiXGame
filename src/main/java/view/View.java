package view;

import controller.Controller;
import controller.EventListener;
import objects.GameObjects;
import objects.HeroShell;
import personages.Heroes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by DiX on 13.06.2017.
 */
public class View extends JFrame {

    private static GameLvl gameLvl;
    private final Controller controller;
    private String clas="";
    private String nam="";

    public View(Controller controller){
        this.controller=controller;
    }

    public void update(){
        gameLvl.repaint();
        System.out.println("sdsdsd");
    }

    public Controller getController() {
        return controller;
    }

    public void init() {
        gameLvl = new GameLvl(this);
        add(gameLvl);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900, 900);
        setLocationRelativeTo(null);
        setTitle("Супер игрушка");
        setVisible(true);
    }
    public int getWidth(){
        return 900;
    }
    public int getHeight(){
        return 900;
    }

    public String[] chooseHero(){

        JFrame frame = new JFrame("Выбор героя");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(900, 300);
        frame.setLocationRelativeTo(null);

        frame.setLayout(new BorderLayout());

        final JTextField textField = new JTextField("");
        textField.setMinimumSize(new Dimension(100,60));
        frame.add(textField,BorderLayout.SOUTH);

        JLabel label = new JLabel("                                                                                                                 " +
                "Введитие ваше имя и выберите класс");
        label.setMinimumSize(new Dimension(100,60));
        frame.add(label,BorderLayout.NORTH);

        JButton buttonWar = new JButton(" Воин ");
        buttonWar.setBackground(Color.PINK);
        buttonWar.setFont(new Font("Verdana", Font.BOLD, 30));
        ImageIcon icon1 = new ImageIcon("images/var.png");
        buttonWar.setIcon(icon1);
        buttonWar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clas="var";
                nam = textField.getText();
            }
        });
        JButton buttonMag = new JButton(" Маг ");
        buttonMag.setBackground(Color.cyan);
        buttonMag.setFont(new Font("Verdana", Font.BOLD, 30));
        ImageIcon icon2 = new ImageIcon("images/mag.png");
        buttonMag.setIcon(icon2);
        buttonMag.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clas="mag";
                nam = textField.getText();
            }
        });
        JButton buttonArch = new JButton("Лучник");
        buttonArch.setBackground(Color.green);
        buttonArch.setFont(new Font("Verdana", Font.BOLD, 30));
        ImageIcon icon3 = new ImageIcon("images/luk.png");
        buttonArch.setIcon(icon3);
        buttonArch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clas="luk";
                nam = textField.getText();
            }
        });
        frame.add(buttonWar,BorderLayout.LINE_START);
        frame.add(buttonMag,BorderLayout.CENTER);
        frame.add(buttonArch,BorderLayout.LINE_END);
        frame.setVisible(true);
        while (clas.equals("")){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        frame.setVisible(false);
        return new String[]{clas,nam};
    }

    public ArrayList<GameObjects> getAllGameObjects(){
        return controller.getGameObjects();
    }

    public void setEventListener(EventListener eventListener){
        gameLvl.setEventListener(eventListener);
    }

    public Heroes getHero(){
        return controller.getHero();
    }

    public ArrayList<HeroShell> getListShell(){
        return controller.getListShell();
    }

    public void gameOver() {
        final JFrame frameDead = new JFrame();
        frameDead.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameDead.setSize(1000, 1000);
        frameDead.setLocationRelativeTo(null);
        frameDead.setTitle("Конец игры");
        frameDead.setBackground(Color.BLACK);
        frameDead.setLayout(new BorderLayout());

        JLabel labelDead = new JLabel("           " +
                "Как так то КАРЛ, ты умер....");
        labelDead.setBackground(Color.BLACK);
        labelDead.setFont(new Font("Verdana", Font.BOLD, 40));
        frameDead.add(labelDead,BorderLayout.NORTH);

        JLabel labelDead2 = new JLabel();
        labelDead2.setBackground(Color.BLACK);
        ImageIcon icon1 = new ImageIcon("images/dead.png");
        labelDead2.setIcon(icon1);
        labelDead2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frameDead.setVisible(false);
                controller.startGame();

            }

            @Override
            public void mousePressed(MouseEvent e) {
                frameDead.setVisible(false);
                controller.startGame();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                frameDead.setVisible(false);
                controller.startGame();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        frameDead.add(labelDead2,BorderLayout.CENTER);

        JLabel labelDeadFake = new JLabel("                                                                                                                      " +
                "");
        frameDead.add(labelDeadFake,BorderLayout.LINE_START);

        JLabel labelDead3 = new JLabel("    Тыкай на ЧЕРЕП и начинай по новой!!");
        labelDead3.setBackground(Color.WHITE);
        labelDead3.setFont(new Font("Verdana", Font.BOLD, 40));
        frameDead.add(labelDead3,BorderLayout.SOUTH);

        frameDead.setVisible(true);


    }

}
