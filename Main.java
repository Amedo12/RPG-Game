package RPGGame.main;
import javax.swing.*;

public class Main {
public static void main(String[] args) throws Exception {
    JFrame frame = new JFrame();

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setTitle("RPG Game");
GamePanel panel = new GamePanel();
frame.add(panel);
        frame.pack();

    frame.setLocationRelativeTo(null);
    frame.setVisible(true);


    panel.setupGame();
    panel.startThread();


}
}
