package view;


import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Sound {

    private FileInputStream fileInputStream;
    private Player player;
    public Sound(String s) throws FileNotFoundException, JavaLayerException {
        fileInputStream=new FileInputStream(s);
        player = new Player(fileInputStream);
    }

    public void play() throws JavaLayerException {
        player.play();
    }

}