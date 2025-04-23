package RPGGame.Entity;

import RPGGame.main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    GamePanel gamePanel;
    private int worldX,worldY,speed;

    private BufferedImage up2,up1,down2,down1,right1,right2,left1,left2,up3,right3,down3,left3;

    private String direction;

    private int spriteCounter , spriteNum;

    private Rectangle solidArea=new Rectangle(4,8,28,28);

    private boolean collisionON=false;

    private int solidAreaDefaultX=0, solidAreaDefaultY=0;

    public  Entity(GamePanel gamePanel)
    {
        this.gamePanel=gamePanel;
    }
    public void setAction(){
    }

    public void update()
        {
        setAction();
        collisionON=false;
        gamePanel.cChecker.checkTile(this);
            if (collisionON == false) {

                    switch (direction) {
                        case "up":
                            worldY-=speed;
                            break;
                        case "down":
                            worldY+=speed;
                            break;
                        case "left":
                            worldX-=speed;
                            break;
                        case "right":
                            worldX+=speed;
                            break;
                    }
            }
        }
    public void draw(Graphics2D g2d ) {


        int screenX=worldX-gamePanel.player.getWorldX()+gamePanel.player.screenX;
        int screenY=worldY-gamePanel.player.getWorldY()+gamePanel.player.screenY;

        if(worldX + gamePanel.getTilesize() > gamePanel.player.getWorldX() - gamePanel.player.screenX &&
                worldX - gamePanel.getTilesize() < gamePanel.player.getWorldX() + gamePanel.player.screenX &&
                worldY + gamePanel.getTilesize() > gamePanel.player.getWorldY() - gamePanel.player.screenY &&
                worldY - gamePanel.getTilesize() < gamePanel.player.getWorldY() + gamePanel.player.screenY)
        { BufferedImage image = switch (getDirection()) {

                case "up" -> getUp1() ;
                case "down" -> getDown1() ;
                default -> null;
            };
            g2d.drawImage(image, screenX, screenY,gamePanel.getTilesize() ,gamePanel.getTilesize(),null);}

    }

    public int getSolidAreaDefaultX() {
        return solidAreaDefaultX;
    }

    public void setSolidAreaDefaultX(int solidAreaDefaultX) {
        this.solidAreaDefaultX = solidAreaDefaultX;
    }

    public int getSolidAreaDefaultY() {
        return solidAreaDefaultY;
    }

    public void setSolidAreaDefaultY(int solidAreaDefaultY) {
        this.solidAreaDefaultY = solidAreaDefaultY;
    }

    public boolean isCollisionON() {return collisionON;}


    public void setCollisionON(boolean collisionON) {this.collisionON = collisionON;}


    public Rectangle getSolidArea() {return solidArea;}


    public void setSolidArea(Rectangle solidArea) {this.solidArea = solidArea;}


    public int getWorldX() {return worldX;}


    public void setWorldX(int worldX) {
        this.worldX = worldX;
    }


    public int getWorldY() {
        return worldY;
    }


    public void setWorldY(int worldY) {
        this.worldY = worldY;
    }


    public int getSpeed() {
        return speed;
    }


    public void setSpeed(int speed) {
        this.speed = speed;
    }


    public BufferedImage getUp2() {
        return up2;
    }


    public void setUp2(BufferedImage up2) {
        this.up2 = up2;
    }


    public BufferedImage getUp1() {
        return up1;
    }


    public void setUp1(BufferedImage up1) {
        this.up1 = up1;
    }


    public BufferedImage getDown2() {
        return down2;
    }


    public void setDown2(BufferedImage down2) {
        this.down2 = down2;
    }


    public BufferedImage getDown1() {
        return down1;
    }


    public void setDown1(BufferedImage down1) {
        this.down1 = down1;
    }


    public BufferedImage getRight1() {
        return right1;
    }


    public void setRight1(BufferedImage right1) {
        this.right1 = right1;
    }


    public BufferedImage getRight2() {
        return right2;
    }


    public void setRight2(BufferedImage right2) {
        this.right2 = right2;
    }


    public BufferedImage getLeft1() {
        return left1;
    }


    public void setLeft1(BufferedImage left1) {
        this.left1 = left1;
    }


    public BufferedImage getLeft2() {
        return left2;
    }


    public void setLeft2(BufferedImage left2) {
        this.left2 = left2;
    }


    public BufferedImage getUp3() {
        return up3;
    }


    public void setUp3(BufferedImage up3) {this.up3 = up3;}

    public BufferedImage getRight3() {
        return right3;
    }


    public void setRight3(BufferedImage right3) {
        this.right3 = right3;
    }


    public BufferedImage getDown3() {
        return down3;
    }


    public void setDown3(BufferedImage down3) {
        this.down3 = down3;
    }


    public BufferedImage getLeft3() {
        return left3;
    }


    public void setLeft3(BufferedImage left3) {this.left3 = left3;}


    public String getDirection() {
        return direction;
    }


    public void setDirection(String direction) {
        this.direction = direction;
    }


    public int getSpriteCounter() {
        return spriteCounter;
    }


    public void setSpriteCounter(int spriteCounter) {
        this.spriteCounter = spriteCounter;
    }


    public int getSpriteNum() {
        return spriteNum;
    }


    public void setSpriteNum(int spriteNum) {
        this.spriteNum = spriteNum;
    }

}