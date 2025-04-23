package RPGGame.main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {

    Clip clip;
    URL soundURL[] =new URL[30];


   public Sound() {
        soundURL[0]= getClass().getResource("/sound/MainS.wav");
        soundURL[1]= getClass().getResource("/sound/getkey.wav");
        soundURL[2]= getClass().getResource("/sound/Power.wav");
        soundURL[3]= getClass().getResource("/sound/door.wav");
        }

        public void setFile(int i){
       try {
           AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL[i]) ;
           clip = AudioSystem.getClip();
           clip.open(audioInputStream);
       }
       catch (Exception e) {
           e.printStackTrace();
       }
        }
public void play(){
       clip.start();

}
public void stop(){
       clip.stop();
}
public void loop()
{
    clip.loop(Clip.LOOP_CONTINUOUSLY);
}

}
