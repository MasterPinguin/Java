import java.io.*;
import javax.sound.sampled.*;

public class AudioPlayer {
   public static void main(String[] args) {
      try {
         File file = new File("suoni/salto.wav");
         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
         Clip clip = AudioSystem.getClip();
         clip.open(stream);
         System.out.println("Clip opened successfully");
          
         FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
         gainControl.setValue(-6.0206f); // Imposta il volume al 50%
         
         clip.start();
         System.out.println("Clip started successfully");
         Thread.sleep(2000); // Aspetta 2 secondi
         clip.stop();
         System.out.println("Clip stopped successfully");
      } catch (UnsupportedAudioFileException e) {
         System.out.println("Unsupported audio file format: " + e.getMessage());
      } catch (IOException e) {
         System.out.println("Error reading audio file: " + e.getMessage());
      } catch (LineUnavailableException e) {
         System.out.println("Line unavailable: " + e.getMessage());
      } catch (InterruptedException e) {
         System.out.println("Thread interrupted: " + e.getMessage());
      }
   }
}
