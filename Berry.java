package RPGGame.objects;

import javax.imageio.ImageIO;

public class Berry extends SuperObject {
    public Berry() throws Exception
    {

        setObjectName("Berry");

        setImage(ImageIO.read(getClass().getResourceAsStream("/objects/berry.png")));

        setCollision(true);
    }
}
