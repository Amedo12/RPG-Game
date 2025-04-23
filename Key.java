package RPGGame.objects;

import javax.imageio.ImageIO;

public class Key extends SuperObject {
    public Key() throws Exception {
        setObjectName("Key");

        setImage(ImageIO.read(getClass().getResourceAsStream("/objects/Key.png")));
    }
}