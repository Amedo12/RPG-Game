package RPGGame.main;

import RPGGame.Entity.Entity;

public class CollisionChecker {

    GamePanel gamePanel;
    public CollisionChecker(GamePanel gamePanel) {
        this.gamePanel=gamePanel;
    }

    public void checkTile(Entity entity) {

int entityLeftWorldX=entity.getWorldX()+entity.getSolidArea().x;
int entityRightWorldX=entity.getWorldX()+entity.getSolidArea().x+entity.getSolidArea().width;
int entityTopWorldY=entity.getWorldY()+entity.getSolidArea().y;
int entityBottomWorldY=entity.getWorldY()+entity.getSolidArea().y+entity.getSolidArea().height;

int entityLeftCol=entityLeftWorldX/gamePanel.getTilesize();
int entityRightCol=entityRightWorldX/gamePanel.getTilesize();
int entityTopRow=entityTopWorldY/gamePanel.getTilesize();
int entityBottomRow=entityBottomWorldY/gamePanel.getTilesize();

int tile1,tile2;

switch (entity.getDirection())
{
    case "up":
        entityTopRow=(entityTopWorldY-entity.getSpeed())/gamePanel.getTilesize();

        tile1=gamePanel.tileManger.getMapTilenum()[entityLeftCol][entityTopRow];
        tile2=gamePanel.tileManger.getMapTilenum()[entityRightCol][entityTopRow];

        if(gamePanel.tileManger.getTile() [tile1].isCollision()==true || gamePanel.tileManger.getTile() [tile2].isCollision()==true )
            entity.setCollisionON(true);

        break;
        case "down":
            entityBottomRow=(entityBottomWorldY+entity.getSpeed())/gamePanel.getTilesize();
            tile1=gamePanel.tileManger.getMapTilenum()[entityLeftCol][entityBottomRow];
            tile2=gamePanel.tileManger.getMapTilenum()[entityRightCol][entityBottomRow];
            if (gamePanel.tileManger.getTile()[tile1].isCollision()==true || gamePanel.tileManger.getTile()[tile2].isCollision()==true )
                entity.setCollisionON(true);
            break;
            case "left":
                entityLeftCol=(entityLeftWorldX-entity.getSpeed())/gamePanel.getTilesize();
                tile1=gamePanel.tileManger.getMapTilenum()[entityLeftCol][entityBottomRow];
                tile2=gamePanel.tileManger.getMapTilenum()[entityLeftCol][entityTopRow];
                if (gamePanel.tileManger.getTile()[tile1].isCollision()==true || gamePanel.tileManger.getTile()[tile2].isCollision()==true )
                    entity.setCollisionON(true);
                break;
                case "right":
                    entityRightCol=(entityRightWorldX+entity.getSpeed())/gamePanel.getTilesize();
                    tile1=gamePanel.tileManger.getMapTilenum()[entityRightCol][entityBottomRow];
                    tile2=gamePanel.tileManger.getMapTilenum()[entityRightCol][entityTopRow];
                    if (gamePanel.tileManger.getTile()[tile1].isCollision()==true || gamePanel.tileManger.getTile()[tile2].isCollision()==true )
                        entity.setCollisionON(true);
                    break;
}

    }

    public int checkObject(Entity entity, boolean player) {
int index=999;

for(int i=0;i<gamePanel.superObject.length;i++) {
    if(gamePanel.superObject[i] != null) {
        entity.getSolidArea().x = entity.getWorldX() + entity.getSolidArea().x;
        entity.getSolidArea().y = entity.getWorldY() + entity.getSolidArea().y;

        gamePanel.superObject[i].getSolidArea().x = gamePanel.superObject[i].getWorldX() + gamePanel.superObject[i].getSolidArea().x;
        gamePanel.superObject[i].getSolidArea().y = gamePanel.superObject[i].getWorldY() + gamePanel.superObject[i].getSolidArea().y;


        switch (entity.getDirection()) {

            case "up":
                entity.getSolidArea().y -= entity.getSpeed();
                if(entity.getSolidArea().intersects(gamePanel.superObject[i].getSolidArea())){
                    if (gamePanel.superObject[i].isCollision()==true)
                        entity.setCollisionON(true);

                    if(player==true)
                        index=i;
                }


                break;
                case "down":
                    entity.getSolidArea().y += entity.getSpeed();
                    if(entity.getSolidArea().intersects(gamePanel.superObject[i].getSolidArea())){
                        if (gamePanel.superObject[i].isCollision()==true)
                            entity.setCollisionON(true);

                    if(player==true)
                        index=i;
                    }
                    break;
            case "left":
                entity.getSolidArea().x -= entity.getSpeed();
                if(entity.getSolidArea().intersects(gamePanel.superObject[i].getSolidArea())){
                    if (gamePanel.superObject[i].isCollision()==true)
                        entity.setCollisionON(true);

                if(player==true)
                    index=i;
                }
                break;
                case "right":
                    entity.getSolidArea().x += entity.getSpeed();
                    if(entity.getSolidArea().intersects(gamePanel.superObject[i].getSolidArea())){
                        if (gamePanel.superObject[i].isCollision()==true)
                            entity.setCollisionON(true);

                    if(player==true)
                        index=i;
                    }
                    break;

        }
        entity.getSolidArea().x = entity.getSolidAreaDefaultX();
        entity.getSolidArea().y = entity.getSolidAreaDefaultY();

        gamePanel.superObject[i].getSolidArea().x = entity.getSolidAreaDefaultX();
        gamePanel.superObject[i].getSolidArea().y = entity.getSolidAreaDefaultY();
    }

}

return index;



    }





}
