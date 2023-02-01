package com.qinglan.designPattern._06_adapterPattern.oldPlayer;

import com.qinglan.designPattern._06_adapterPattern.advancePlayer.AdvanceMediaPlayer;
import com.qinglan.designPattern._06_adapterPattern.advancePlayer.Mp4Player;
import com.qinglan.designPattern._06_adapterPattern.advancePlayer.VlcPlayer;

public class MediaAdapter implements MediaPlayer{
    AdvanceMediaPlayer advanceMediaPlayer ;


    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")){
            advanceMediaPlayer.playVlc(fileName);
        }else if (audioType.equalsIgnoreCase("mp4")){
            advanceMediaPlayer.playMp4(fileName);
        }
    }

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")){
            this.advanceMediaPlayer = new VlcPlayer();
        }else if (audioType.equalsIgnoreCase("mp4")){
            this.advanceMediaPlayer = new Mp4Player();
        }
    }
}
