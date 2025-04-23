package RPGGame.Entity;

import RPGGame.main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class NPC_Old extends Entity {
    GamePanel gamePanel;
    public NPC_Old(GamePanel gamePanel) {
        super(gamePanel);

        setDirection("down");
        setSpeed(2);
        getImage();

    }




    public void getImage()
    {
       try {
            BufferedImage up= ImageIO.read(getClass().getResourceAsStream("/NPC/back.png"));
            BufferedImage down= ImageIO.read(getClass().getResourceAsStream("/NPC/front.png"));

            setDown1(down);
            setUp1(up);

       } catch (IOException e) {
           throw new RuntimeException(e);
       }
    }
    int actionLock=0;
public void setAction() {
    actionLock++;
         if(actionLock==120) {
             Random random = new Random();
             int action = random.nextInt(51);
        if (action <= 25)
            setDirection("down");

        else
            setDirection("up");

        actionLock=0;
    }


    }



}
