package com.xbl.designPattern._06_adapterPattern.advancePlayer;

public class VlcPlayer implements AdvanceMediaPlayer{
    public void playMp4(String fileName) {

    }

    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }
}
