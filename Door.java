package RPGGame.objects;

import javax.imageio.ImageIO;

public class Door extends SuperObject {
    public Door() throws Exception
    {

        setObjectName("Door");

        setImage(ImageIO.read(getClass().getResourceAsStream("/objects/door.png")));

        setCollision(true);
    }
}
