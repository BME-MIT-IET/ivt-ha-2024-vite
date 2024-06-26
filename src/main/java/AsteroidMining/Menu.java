package AsteroidMining;

import AsteroidMining.Resources.STATE;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Menu extends MouseAdapter{

    private Game game;

    public BufferedImage back = null;
    public BufferedImage logo = null;
    public BufferedImage play;
    public BufferedImage exit;

    public Menu(Game game) {
        this.game = game;

        try {
            back= ImageIO.read(new File("Assets/space.png"));
            logo= ImageIO.read(new File("Assets/logo.png"));
            play= ImageIO.read(new File("Assets/play.png"));
            exit= ImageIO.read(new File("Assets/exit.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        if(game.gameState== STATE.End || game.gameState==STATE.Menu && !game.paused) {
            if(mouseOver(mouseX, mouseY, 400, 350, 200, 80)) {
                game.gameState = STATE.Game;

            }
            if(mouseOver(mouseX, mouseY, 400, 450, 200, 80)) {
                System.exit(1);
                //game.gameState = STATE.Game;
            }

        }

    }


    private boolean mouseOver(int mouseX, int mouseY, int x, int y, int width, int height) {
        if(mouseX > x && mouseX < x+width) {
            if(mouseY > y && mouseY < y+height){
                return true;
            }else return false;
        }else return false;
    }

    public void render(Graphics g) {
        g.drawImage(back, 0, 0, game.WIDTH, game.HEIGHT, null);
        g.drawImage(logo, 150, 50, 700, 200, null);

        Font font2 = new Font("arial", 1, 30);


        if(game.gameState==STATE.End) {

        }
        g.setColor(Color.white);
        g.setFont(font2);

        g.drawImage(play, 400, 350, 200, 80, null);
        g.drawImage(exit,400, 450, 200, 80, null);

    }
}
