package AsteroidMiningTests;

import AsteroidMining.Game;
import AsteroidMining.Menu;
import AsteroidMining.Resources.STATE;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {

    private Menu menu;
    private Game game;
    private Graphics graphics;

    @BeforeEach
    public void setup() {
        game = mock(Game.class);
        menu = new Menu(game);
        graphics = mock(Graphics.class);
    }

    @Test
    public void testImageLoad() {
        assertNotNull(menu.back, "Background image should be loaded");
        assertNotNull(menu.logo, "Logo image should be loaded");
        assertNotNull(menu.play, "Play button image should be loaded");
        assertNotNull(menu.exit, "Exit button image should be loaded");
    }

    @Test
    public void testMousePressedChangesGameState() {
        game.gameState = STATE.Menu;
        game.paused = false;

        MouseEvent e = new MouseEvent(new Component(){}, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(), 0, 410, 360, 1, false);
        menu.mousePressed(e);

        assertEquals(STATE.Game, game.gameState, "Game state should change to Game when Play is clicked");
    }

}
