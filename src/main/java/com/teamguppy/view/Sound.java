package com.teamguppy.view;


import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;


public class Sound {

  public void playBackgroundMusic() {
    URL musicLocation = Sound.class.getClassLoader().getResource("audio/main_background.wav");

    try {
      AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicLocation);
      Clip clip = AudioSystem.getClip();
      clip.open(audioInput);

      // Set volume
      FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
      gainControl.setValue(-10.0f);

      clip.loop(Clip.LOOP_CONTINUOUSLY);
      clip.start();

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void playTurtleTalk0() {
    URL musicLocation = Sound.class.getClassLoader().getResource("audio/turtle_talk_0.wav");

    try {
      AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicLocation);
      Clip clip = AudioSystem.getClip();
      clip.open(audioInput);
      clip.start();

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void playTurtleTalk1() {
    URL musicLocation = Sound.class.getClassLoader().getResource("audio/turtle_talk_1.wav");

    try {
      AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicLocation);
      Clip clip = AudioSystem.getClip();
      clip.open(audioInput);
      clip.start();

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void playTurtleTalk2() {
    URL musicLocation = Sound.class.getClassLoader().getResource("audio/turtle_talk_2.wav");

    try {
      AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicLocation);
      Clip clip = AudioSystem.getClip();
      clip.open(audioInput);
      clip.start();

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void playGoblinShark() {
    URL musicLocation = Sound.class.getClassLoader().getResource("audio/goblin_shark.wav");

    try {
      AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicLocation);
      Clip clip = AudioSystem.getClip();
      clip.open(audioInput);
      clip.start();

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void playJellyfish() {
    URL musicLocation = Sound.class.getClassLoader().getResource("audio/jellyfish.wav");

    try {
      AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicLocation);
      Clip clip = AudioSystem.getClip();
      clip.open(audioInput);
      clip.start();

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void playGuppy() {
    URL musicLocation = Sound.class.getClassLoader().getResource("audio/guppy.wav");

    try {
      AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicLocation);
      Clip clip = AudioSystem.getClip();
      clip.open(audioInput);
      clip.start();

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void playGetItem() {
    URL musicLocation = Sound.class.getClassLoader().getResource("audio/get_item.wav");

    try {
      AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicLocation);
      Clip clip = AudioSystem.getClip();
      clip.open(audioInput);
      clip.start();

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void playUseItem() {
    URL musicLocation = Sound.class.getClassLoader().getResource("audio/use_item.wav");

    try {
      AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicLocation);
      Clip clip = AudioSystem.getClip();
      clip.open(audioInput);
      clip.start();

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
