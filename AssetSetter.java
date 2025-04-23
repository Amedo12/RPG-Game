package RPGGame.main;

import RPGGame.Entity.NPC_Old;
import RPGGame.objects.Chest;
import RPGGame.objects.Door;
import RPGGame.objects.Key;
import RPGGame.objects.Berry;

public class AssetSetter {

    GamePanel gamePanel;

    public AssetSetter(GamePanel gamePanel) {
        this.gamePanel=gamePanel;
    }


public void setObject() throws Exception {
        gamePanel.superObject[0] = new Berry();
       gamePanel.superObject[0].setWorldX(23 * gamePanel.getTilesize());
        gamePanel.superObject[0].setWorldY(15 * gamePanel.getTilesize());

//        gamePanel.superObject[1] = new Key();
//        gamePanel.superObject[1].setWorldX(23 * gamePanel.getTilesize());
//        gamePanel.superObject[1].setWorldY(40 * gamePanel.getTilesize());

//            gamePanel.superObject[2] = new Door();
//            gamePanel.superObject[2].setWorldX(40 * gamePanel.getTilesize());
//            gamePanel.superObject[2].setWorldY(32 * gamePanel.getTilesize());
        gamePanel.superObject[1] = new Key();
        gamePanel.superObject[1].setWorldX(40 * gamePanel.getTilesize());
        gamePanel.superObject[1].setWorldY(31 * gamePanel.getTilesize());

        gamePanel.superObject[2] = new Chest();
        gamePanel.superObject[2].setWorldX(6 * gamePanel.getTilesize());
        gamePanel.superObject[2].setWorldY(31 * gamePanel.getTilesize());


        gamePanel.superObject[3] = new Door();
        gamePanel.superObject[3].setWorldX(6 * gamePanel.getTilesize());
        gamePanel.superObject[3].setWorldY(33 * gamePanel.getTilesize());

        gamePanel.superObject[4] = new Door();
        gamePanel.superObject[4].setWorldX(6 * gamePanel.getTilesize());
        gamePanel.superObject[4].setWorldY(35 * gamePanel.getTilesize());

        gamePanel.superObject[5] = new Key();
        gamePanel.superObject[5].setWorldX(6 * gamePanel.getTilesize());
        gamePanel.superObject[5].setWorldY(28 * gamePanel.getTilesize());


//        gamePanel.superObject[6] = new Berry();
//        gamePanel.superObject[6].setWorldX( 45* gamePanel.getTilesize());
//        gamePanel.superObject[6].setWorldY(20 * gamePanel.getTilesize());

}
public void npcSetter()
{
    gamePanel.npc[0]=new NPC_Old(gamePanel);
    gamePanel.npc[0].setWorldX(35*gamePanel.getTilesize());
    gamePanel.npc[0].setWorldY(28*gamePanel.getTilesize());

}

}
