package com.jianglijiuju.model;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Music {
    public void music() throws FileNotFoundException, JavaLayerException {
        String str=System.getProperty("user.dir")+"/music/music.mp3";
        BufferedInputStream buffer=new BufferedInputStream(new FileInputStream(str));

        Player player=new Player(buffer);
        player.play();
    }
}
