package RPGGame.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    GamePanel gamePanel;
    private boolean upPressed,downPressed,leftPressed,rightPressed;

    public boolean isUpPressed() {
        return upPressed;
    }

    public void setUpPressed(boolean upPressed) {
        this.upPressed = upPressed;
    }

    public boolean isDownPressed() {
        return downPressed;
    }

    public void setDownPressed(boolean downPressed) {
        this.downPressed = downPressed;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public void setLeftPressed(boolean leftPressed) {
        this.leftPressed = leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public void setRightPressed(boolean rightPressed) {
        this.rightPressed = rightPressed;
    }


    public KeyHandler(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        char code2= e.getKeyChar();
        code2= Character.toUpperCase(code2);
       int code = e.getKeyCode();
        if( code == KeyEvent.VK_UP)
            setUpPressed(true);
         if( code == KeyEvent.VK_DOWN)
            setDownPressed(true);
         if( code == KeyEvent.VK_LEFT)
             setLeftPressed(true);
         if( code == KeyEvent.VK_RIGHT)
             setRightPressed(true);
        if (code == KeyEvent.VK_ESCAPE ) {
            if(gamePanel.getGameState()==gamePanel.getPlayState()) {
                gamePanel.setGameState(gamePanel.getPauseState());
            }
            else
                gamePanel.setGameState(gamePanel.getPlayState());

        }





        switch(code2) {
            case 'W': setUpPressed(true); break;
            case 'S': setDownPressed(true); break;
            case 'A': setLeftPressed(true); break;
            case 'D': setRightPressed(true); break;

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        char code2= e.getKeyChar();
        code2= Character.toUpperCase(code2);

        if( code == KeyEvent.VK_UP)
            setUpPressed(false);

        if( code == KeyEvent.VK_DOWN)
            setDownPressed(false);

        if( code == KeyEvent.VK_LEFT)
            setLeftPressed(false);

        if( code == KeyEvent.VK_RIGHT)
            setRightPressed(false);



        switch(code2) {
            case 'W': setUpPressed(false); break;
            case 'S': setDownPressed(false); break;
            case 'A': setLeftPressed(false); break;
            case 'D': setRightPressed(false); break;

        }

    }

    }

