package RPGGame.objects;

import RPGGame.main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {

    private BufferedImage image;
    private String objectName;
    private boolean collision;
    private int worldX, worldY;
    private Rectangle solidArea = new Rectangle(0,0,48,48);
    int solidAreaDefaultX=0, solidAreaDefaultY=0;

    public Rectangle getSolidArea() {
        return solidArea;
    }

    public void setSolidArea(Rectangle solidArea) {
        this.solidArea = solidArea;
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

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public boolean isCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public int getWorldX() {
        return worldX;
    }

    public void setWorldX(int worldX) {
        this.worldX = worldX;
    }

    public int getWorldY() {
        return worldY;
    }

    public void setWorldY(int worldY) {
        this.worldY = worldY;
    }


    public void draw(Graphics2D g2d , GamePanel gamePanel) {


        int screenX=worldX-gamePanel.player.getWorldX()+gamePanel.player.screenX;
        int screenY=worldY-gamePanel.player.getWorldY()+gamePanel.player.screenY;

        if(worldX + gamePanel.getTilesize() > gamePanel.player.getWorldX() - gamePanel.player.screenX &&
                worldX - gamePanel.getTilesize() < gamePanel.player.getWorldX() + gamePanel.player.screenX &&
                worldY + gamePanel.getTilesize() > gamePanel.player.getWorldY() - gamePanel.player.screenY &&
                worldY - gamePanel.getTilesize() < gamePanel.player.getWorldY() + gamePanel.player.screenY)

            g2d.drawImage(image, screenX, screenY,gamePanel.getTilesize() ,gamePanel.getTilesize(),null);


    }
}
