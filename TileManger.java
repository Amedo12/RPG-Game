package RPGGame.Tiles;

import RPGGame.main.GamePanel;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;



public class TileManger {
    private Tile[] tile;
   private int[][] mapTilenum;
    GamePanel gamePanel;
    BufferedImage images;

    public Tile[] getTile() {
        return tile;
    }

    public void setTile(Tile[] tile) {
        this.tile = tile;
    }

    public int[][] getMapTilenum() {
        return mapTilenum;
    }

    public void setMapTilenum(int[][] mapTilenum) {
        this.mapTilenum = mapTilenum;
    }

    public TileManger(GamePanel gamePanel) {
    this.gamePanel=gamePanel;
    tile = new Tile[10];

    mapTilenum = new int[gamePanel.getMaxWorldCol()][gamePanel.getMaxWorldRow()];
    getTileImage();
    loadMap("/mapData/50X50.txt");
}

public void loadMap(String filePath)
{
  try  {
        InputStream is = getClass().getResourceAsStream(filePath);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        int col = 0, row = 0;
        while (col < gamePanel.getMaxWorldCol() && row < gamePanel.getMaxWorldRow()) {

            String line = br.readLine();

            while (col < gamePanel.getMaxWorldCol()) {

                String[] numbers = line.split(" ");

                int num = Integer.parseInt(numbers[col]);

                mapTilenum[col][row] = num;
                col++;

            }
            col = 0;
            row++;
        }
        br.close();
    }
  catch (IOException e) {
      e.printStackTrace();
  }

}


public void getTileImage()
{
try {
    images = ImageIO.read(getClass().getResourceAsStream("/Tiles/grass.png"));
    tile[0]=new Tile();
    tile[0].setImage(images);
    images = ImageIO.read(getClass().getResourceAsStream("/Tiles/water.png"));
    tile[1]=new Tile();
    tile[1].setImage(images);
    tile[1].setCollision(true);
    images = ImageIO.read(getClass().getResourceAsStream("/Tiles/wall.png"));
    tile[2]=new Tile();
    tile[2].setImage(images);
    tile[2].setCollision(true);
    images = ImageIO.read(getClass().getResourceAsStream("/Tiles/tree1.png"));
    tile[3]=new Tile();
    tile[3].setImage(images);
    tile[3].setCollision(true);
    images = ImageIO.read(getClass().getResourceAsStream("/Tiles/Sand4.png"));
    tile[4]=new Tile();
    tile[4].setImage(images);

}

catch (Exception e) {
    e.printStackTrace();
}


}
public void draw(Graphics2D g2d) {
    int worldCol=0,worldRow=0;
    while(worldCol< gamePanel.getMaxWorldCol()   &&  worldRow< gamePanel.getMaxWorldRow()){
        int mapT=mapTilenum[worldCol][worldRow];

        int worldX=worldCol* gamePanel.getTilesize();
        int worldY=worldRow* gamePanel.getTilesize();
        int screenX=worldX-gamePanel.player.getWorldX()+gamePanel.player.screenX;
        int screenY=worldY-gamePanel.player.getWorldY()+gamePanel.player.screenY;

if(worldX + gamePanel.getTilesize() > gamePanel.player.getWorldX() - gamePanel.player.screenX &&
   worldX - gamePanel.getTilesize() < gamePanel.player.getWorldX() + gamePanel.player.screenX &&
   worldY + gamePanel.getTilesize() > gamePanel.player.getWorldY() - gamePanel.player.screenY &&
   worldY - gamePanel.getTilesize() < gamePanel.player.getWorldY() + gamePanel.player.screenY)
    g2d.drawImage(tile[mapT].getImage(), screenX, screenY,gamePanel.getTilesize() ,gamePanel.getTilesize(),null);

worldCol++;


   if(worldCol==gamePanel.getMaxWorldCol()) {
       worldCol=0;
       worldRow++;
            }

        }

    }

}
