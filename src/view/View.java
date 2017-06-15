package view;

import controller.Controller;
import controller.EventListener;
import objects.GameObjects;
import personages.Pers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by DiX on 13.06.2017.
 */
public class View extends JFrame {

    private GameLvl gameLvl;
    private Controller controller;
    String clas="";
    String nam="";

    public View(Controller controller){
        this.controller=controller;
    }

    public void update(){
        gameLvl.repaint();
    }

    public Controller getController() {
        return controller;
    }

    public void init() {
        gameLvl = new GameLvl(this);
        add(gameLvl);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setLocationRelativeTo(null);
        setTitle("Супер игрушка");
        setVisible(true);
    }
    public int getWidth(){
        return 1000;
    }
    public int getHeight(){
        return 1000;
    }

    public String[] chooseHero(){

        JFrame frame = new JFrame("Выбор героя");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(900, 300);
        frame.setLocationRelativeTo(null);

        frame.setLayout(new BorderLayout());

        JTextField textField = new JTextField("");
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
        String[] st = {clas,nam};
        return st;
    }

    public ArrayList<GameObjects> getAllGameObjects(){
        return controller.getGameObjects();
    }

    public void setEventListener(EventListener eventListener){
        gameLvl.setEventListener(eventListener);
    }

}
