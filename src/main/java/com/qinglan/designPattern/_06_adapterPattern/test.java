package com.qinglan.designPattern._06_adapterPattern;

import com.qinglan.designPattern._06_adapterPattern.oldPlayer.AudioPlayer;

public class test {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}
