package RPGGame.Entity;

import RPGGame.main.GamePanel;
import RPGGame.main.KeyHandler;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
    public final int screenX, screenY;
    private int keyCounter=0;
        KeyHandler KeyH;
        GamePanel gamePanel;


    public int getKeyCounter() {
        return keyCounter;
    }

    public void setKeyCounter(int keyCounter) {
        this.keyCounter = keyCounter;
    }

    public Player(KeyHandler KeyH, GamePanel gamePanel) {
        super(gamePanel);
            this.KeyH=KeyH;
            this.gamePanel=gamePanel;

            screenX=gamePanel.getScreenWidth()/2-(gamePanel.getTilesize()/2);
            screenY=gamePanel.getScreenHeight()/2-(gamePanel.getTilesize()/2);

            setSolidArea(new Rectangle(4,8,28,28));

            setSolidAreaDefaultX(getSolidArea().x);
            setSolidAreaDefaultY(getSolidArea().y);

            defaultValues();
            getImage();



        }

   public void defaultValues()
   {
       int worldX= gamePanel.getTilesize()*23,worldY= gamePanel.getTilesize()*21, speed=4,spriteCounter=0,spriteNum=1;
       String direction = "down";
       setWorldX(worldX);
       setWorldY(worldY);
       setSpeed(speed);
       setDirection(direction);
       setSpriteNum(spriteNum);
       setSpriteCounter(spriteCounter);

   }

   public void getImage()
   {
       try {
          BufferedImage up1= ImageIO.read(getClass().getResourceAsStream("/player/up1.png"));
          BufferedImage up2= ImageIO.read(getClass().getResourceAsStream("/player/up2.png"));
          BufferedImage down1= ImageIO.read(getClass().getResourceAsStream("/player/down1.png"));
          BufferedImage down2= ImageIO.read(getClass().getResourceAsStream("/player/down2.png"));
          BufferedImage left1= ImageIO.read(getClass().getResourceAsStream("/player/left1.png"));
          BufferedImage left2= ImageIO.read(getClass().getResourceAsStream("/player/left2.png"));
          BufferedImage right1= ImageIO.read(getClass().getResourceAsStream("/player/right1.png"));
          BufferedImage right2= ImageIO.read(getClass().getResourceAsStream("/player/right2.png"));
          BufferedImage up3= ImageIO.read(getClass().getResourceAsStream("/player/up3.png"));
          BufferedImage right3= ImageIO.read(getClass().getResourceAsStream("/player/right3.png"));
          BufferedImage down3= ImageIO.read(getClass().getResourceAsStream("/player/down3.png"));
          BufferedImage left3= ImageIO.read(getClass().getResourceAsStream("/player/left3.png"));
          setDown1(down1);
          setDown2(down2);
          setDown3(down3);
          setLeft1(left1);
          setLeft2(left2);
          setLeft3(left3);
          setRight1(right1);
          setRight2(right2);
          setRight3(right3);
          setUp1(up3);
          setUp2(up1);
          setUp3(up2);



       } catch (IOException e) {
           throw new RuntimeException(e);
       }
   }

   public void  update() {


       if (KeyH.isUpPressed()) {


           setDirection("up");


       }
       if (KeyH.isDownPressed()) {


           setDirection("down");

       }
       if (KeyH.isLeftPressed()) {


           setDirection("left");

       }
       if (KeyH.isRightPressed()) {


           setDirection("right");

       }

       setCollisionON(false);
       gamePanel.cChecker.checkTile(this);
       int obj_index = gamePanel.cChecker.checkObject(this, true);
       pickUpObj(obj_index);

       if (isCollisionON() == false) {
           if(KeyH.isUpPressed() == true || KeyH.isDownPressed() == true || KeyH.isLeftPressed() == true || KeyH.isRightPressed() == true) {
           switch (getDirection()) {
               case "up":
                   setWorldY(getWorldY() - getSpeed());
                   break;
               case "down":
                   setWorldY(getWorldY() + getSpeed());
                   break;
               case "left":
                   setWorldX(getWorldX() - getSpeed());
                   break;
               case "right":
                   setWorldX(getWorldX() + getSpeed());
                   break;
           }
       }
   }


    setSpriteCounter(getSpriteCounter() + 1);

    if (getSpriteCounter() > 10) {

        if (getSpriteNum() == 1)
            setSpriteNum(2);

        else if (getSpriteNum() == 2)
            setSpriteNum(3);

        else
            setSpriteNum(1);

        setSpriteCounter(0);
    }



   }

   public void pickUpObj(int i) {
            if(i!=999) {

                if (gamePanel.superObject[i].getObjectName().equals("Key")) {
                    gamePanel.ui.showMessage("you picked up a key");
                    gamePanel.playSoundEffect(1);
                    gamePanel.superObject[i] = null;
                    keyCounter++;
                }

                else if (gamePanel.superObject[i].getObjectName().equals("Door")) {
                    if (keyCounter > 0) {
                        gamePanel.ui.showMessage("Door opened.");
                        gamePanel.playSoundEffect(3);
                        keyCounter--;
                        gamePanel.superObject[i] = null;

                    }
                    else gamePanel.ui.showMessage("You need a key to do this.");


                }
                else if (gamePanel.superObject[i].getObjectName().equals("Berry")) {

                    gamePanel.playSoundEffect(2);
                    gamePanel.superObject[i] = null;
                    setSpeed(getSpeed() + 2);
                    gamePanel.ui.showMessage("Speed X2");

                }
                else if (gamePanel.superObject[i].getObjectName().equals("Chest")) {
                    gamePanel.ui.setGameOver(true);
                    gamePanel.stopMusic();

                }
            }
   }

   public void draw(Graphics2D g2d) {

       BufferedImage image = switch (getDirection()) {

           case "up" -> getSpriteNum() ==1?getUp1() : getSpriteNum()==2 ? getUp3(): getUp2()  ;
           case "down" -> getSpriteNum() ==1?getDown1(): getSpriteNum()==2? getDown3(): getDown2()  ;
           case "left" -> getSpriteNum() ==1?getLeft1(): getSpriteNum()==2? getLeft3(): getLeft2()  ;
           case "right" -> getSpriteNum() ==1?getRight1(): getSpriteNum()==2? getRight3(): getRight2() ;
           default -> null;
       };
       g2d.drawImage(image,screenX,screenY,gamePanel.getTilesize(),gamePanel.getTilesize(),null);


   }

}
