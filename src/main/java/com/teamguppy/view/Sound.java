package com.teamguppy.view;


import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Sound {

  public void playSound() {
    URL musicLocation = Sound.class.getClassLoader().getResource("audio/main_background.wav");

    try {
      AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicLocation);
      Clip clip = AudioSystem.getClip();
      clip.open(audioInput);
      clip.loop(Clip.LOOP_CONTINUOUSLY);
      clip.start();

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
