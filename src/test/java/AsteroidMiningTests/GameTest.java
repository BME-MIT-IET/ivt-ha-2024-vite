package AsteroidMiningTests;

import AsteroidMining.Game;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {

    private Game game;

    @BeforeEach
    public void setup() {
        game = new Game();
    }

    @Test
    public void testInitialization() {
        assertNotNull(game.menu, "Menu should not be null");
        assertNotNull(game.handler, "Handler should not be null");
        assertNotNull(game.nResources, "Resources map should not be null");
        assertFalse(game.nResources.isEmpty(), "Resources map should be initialized with items");
    }
}
