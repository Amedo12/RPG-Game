package RPGGame.main;

import RPGGame.Entity.Entity;
import RPGGame.Entity.Player;
import RPGGame.Tiles.TileManger;
import RPGGame.objects.SuperObject;

import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel implements Runnable {
    private static final int FPS = 60 ;
    final private int ogTilesize=16;
    final private int scale=3;

    final private int  tilesize=ogTilesize*scale;
    final private int  maxScreenCol=16;
    final private int maxScreenRow=12;
    final private int screenWidth= maxScreenCol*tilesize;
    final private int screenHeight= maxScreenRow*tilesize;

     final private int maxWorldCol=50;
     final private int maxWorldRow=50;
      private int gameState;
     final private int playState=1;
     final private int pauseState=2;

    public int getPlayState() {
        return playState;
    }

    public int getPauseState() {
        return pauseState;
    }

    public int getGameState() {
        return gameState;
    }

    public void setGameState(int gameState) {
        this.gameState = gameState;
    }

    public int getMaxWorldCol() {
        return maxWorldCol;
    }

    public int getMaxWorldRow() {
        return maxWorldRow;
    }

    public int getMaxScreenRow() {
        return maxScreenRow;
    }

    public int getMaxScreenCol() {
        return maxScreenCol;
    }

    public int getTilesize() {
        return tilesize;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }


    TileManger tileManger=new TileManger(this);
    KeyHandler keyH=new KeyHandler(this);
    public Sound music = new Sound();
    public Sound soundEffect = new Sound();


    Thread thread;

public UI ui=new UI(this);
    public CollisionChecker cChecker=new CollisionChecker(this);
    public Player player=new Player(keyH,this);
    public SuperObject superObject[] = new SuperObject[10];
    public AssetSetter assetSetter =new AssetSetter(this);
    public Entity[] npc = new Entity[10];




    public GamePanel()  {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addKeyListener(keyH);
    }
    public void setupGame() throws Exception {
        assetSetter.setObject();
        assetSetter.npcSetter();
        playMusic(0);
        gameState=playState;
    }

public void startThread() {
        thread = new Thread(this);
        thread.start();
}
    @Override
    public void run() {
        double drawInterval = 1000000000.0 / FPS;
        double nextInterval = System.nanoTime()+drawInterval;


    while (thread!=null) {

        update();

        repaint();

        double remainder = nextInterval - System.nanoTime();
        remainder /= 1000000;
        if (remainder<0) {
            remainder=0;
        }
        try {
            Thread.sleep((long) remainder);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        nextInterval+=drawInterval;
    }
    }

    public void update() {
        if (gameState==playState)
        {player.update();
            npc[0].update();
        }
        else if (gameState==pauseState) {}

    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        tileManger.draw(g2d);

        for (SuperObject object : superObject) {
            if (object != null) {
                object.draw(g2d, this);
            }

        }
        for (int i = 0; i < npc.length; i++) {
            if(npc[i] != null)
            {
                npc[i].draw(g2d);
            }
        }

        player.draw(g2d);
       ui.paint(g2d);
        g2d.dispose();

    }
    public void playMusic(int i) {
        music.setFile(i);
        music.play();
        music.loop();

    }
    public void stopMusic() {
        music.stop();
    }
    public void playSoundEffect(int i) {
        soundEffect.setFile(i);
        soundEffect.play();
    }

}
