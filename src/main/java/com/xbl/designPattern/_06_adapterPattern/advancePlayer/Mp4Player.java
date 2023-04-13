package com.xbl.designPattern._06_adapterPattern.advancePlayer;

public class Mp4Player implements AdvanceMediaPlayer{
    public void playMp4(String fileName) {
        System.out.println("Playing Mp4 file. Name: "+ fileName);
    }

    public void playVlc(String fileName) {

    }
}
