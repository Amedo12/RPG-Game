package RPGGame.main;

import RPGGame.objects.Key;

import java.awt.*;
import java.awt.image.BufferedImage;


public class UI {
    GamePanel gamePanel;
    Font font, biggerFont;
    BufferedImage keyImage;
    private boolean messageOn=false,gameOver=false;
    String message="";
    int messageCounter=0 ;
    double timecount=0;
    int x;
    int y;
    String text;
    int textLength;


    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public UI(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        biggerFont=new Font("Bold", Font.PLAIN, 80);
        font = new Font("Arial", Font.PLAIN, 40);
        try {
            Key key=new Key();
            keyImage = key.getImage();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
     public void showMessage(String message) {
        messageOn=true;
        this.message=message;
     }

    public void paint(Graphics2D g2) {
        if (!gameOver) {
            g2.setFont(font);
            g2.setColor(Color.white);
            g2.drawImage(keyImage, gamePanel.getTilesize() / 2, gamePanel.getTilesize() / 2, gamePanel.getTilesize(), gamePanel.getTilesize(), null);
            g2.drawString("X" + gamePanel.player.getKeyCounter(), 74, 65);

            if (messageOn) {
                g2.setFont(g2.getFont().deriveFont(30F));

                g2.drawString(message, gamePanel.getTilesize() / 2, gamePanel.getTilesize() * 5);

                messageCounter++;
                if (messageCounter > 120) {
                    messageCounter = 0;
                    messageOn = false;
                }
            }
            if (gamePanel.getGameState()==gamePanel.getPauseState()) {

                text="PAUSED";
                g2.setFont(biggerFont);
                g2.setColor(Color.white);
                textLength=(int) g2.getFontMetrics().getStringBounds(text,g2).getWidth();
                x= gamePanel.getScreenWidth()/2-textLength/2;
                y=gamePanel.getScreenHeight()/2;
                g2.drawString(text, x, y);


            }



else {
                timecount += (double) 1 / 60;


                g2.setFont(g2.getFont().deriveFont(15F));

                g2.drawString("SEC:" + String.format("%.2f", timecount), gamePanel.getTilesize() * 14, gamePanel.getTilesize() / 3);

            }
        }
        else {


            text="You found the treasure!!!";
            g2.setFont(font);
            g2.setColor(Color.white);
            textLength=(int) g2.getFontMetrics().getStringBounds(text,g2).getWidth();
            x= gamePanel.getScreenWidth()/2-textLength/2;
            y=gamePanel.getScreenHeight()/2-gamePanel.getTilesize()*3;
            g2.drawString(text, x, y);

             text="Congratulations!";
            g2.setFont(biggerFont);
            g2.setColor(Color.yellow);
            textLength=(int) g2.getFontMetrics().getStringBounds(text,g2).getWidth();
            x= gamePanel.getScreenWidth()/2-textLength/2;
            y=gamePanel.getScreenHeight()/2+gamePanel.getTilesize()*2;
            g2.drawString(text, x, y);


            text="You finished IN "+String.format("%.2f", timecount) + " seconds.";
            g2.setFont(font);
            g2.setColor(Color.PINK);
            textLength=(int) g2.getFontMetrics().getStringBounds(text,g2).getWidth();
            x= gamePanel.getScreenWidth()/2-textLength/2;
            y=gamePanel.getScreenHeight()/2+gamePanel.getTilesize()*4;
            g2.drawString(text, x, y);
            gamePanel.thread=null;



        }
    }

}
