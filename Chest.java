package RPGGame.objects;

import javax.imageio.ImageIO;

public class Chest extends SuperObject {
    public Chest() throws Exception
    {

        setObjectName("Chest");

        setImage(ImageIO.read(getClass().getResourceAsStream("/objects/chest.png")));

        setCollision(true);
    }
}
