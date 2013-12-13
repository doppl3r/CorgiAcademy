package audio;
import java.io.*;
import javax.sound.sampled.*;

public enum AudioHandler {
    ERROR("sounds/error.wav"),
    WIN("sounds/win.wav"),
    GOAL("sounds/goal.wav"),
    SELECT("sounds/select.wav");

   public static enum Volume {
      MUTE, LOW, MEDIUM, HIGH
   }
   public static Volume volume = Volume.LOW;
   public Clip clip;
   AudioHandler(String soundFileName) {
      try {
    	  // Set up an audio input stream piped from the sound file.
          AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
         		 this.getClass().getClassLoader().getResource(soundFileName));
          //AudioFormat format = audioInputStream.getFormat();
          DataLine.Info info = new DataLine.Info(Clip.class, audioInputStream.getFormat());
          clip = (Clip) AudioSystem.getLine(info);
          clip.open(audioInputStream); }
      catch (UnsupportedAudioFileException e) { e.printStackTrace(); }
      catch (IOException e) { e.printStackTrace(); }
      catch (LineUnavailableException e) { e.printStackTrace(); }
   }
   public void play() {
       if (volume != Volume.MUTE) {
           //clip.setFramePosition(0); // rewind to the beginning
           if (!clip.isRunning()){
               stop(); //only play the sound if it is finished
           }
           clip.start();     // Start playing
       }
   }
   public void stop(){
	   clip.stop();
	   clip.setFramePosition(0);
   }
   public static void init() { values(); }  // calls the constructor for all the elements
}