package AsteroidMiningTests;

import AsteroidMining.WaterIce;
import AsteroidMining.Asteroid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.image.BufferedImage;

class WaterIceTest {
    private WaterIce waterIce;
    private Asteroid mockedAsteroid;

    @BeforeEach
    void setUp() {
        waterIce = new WaterIce();
        mockedAsteroid = mock(Asteroid.class);  // Using Mockito to create a mock of the Asteroid class
    }

    @Test
    void testResourceType() {
        assertEquals("WaterIce", waterIce.getType(), "Resource type should be set to WaterIce");
    }

    @Test
    void testResourceId() {
        assertEquals(AsteroidMining.ID.WaterIce, waterIce.getId(), "Resource ID should be set to WaterIce");
    }

    @Test
    void testImageLoaded() {
        assertNotNull(waterIce.getImg(), "Image should be loaded for WaterIce resource");
        assertTrue(waterIce.getImg() instanceof BufferedImage, "Image should be an instance of BufferedImage");
    }

    @Test
    void testSublimeMethod() {
        // Test the sublime method to ensure it calls the removeResource method on the Asteroid
        waterIce.sublime(mockedAsteroid);

        // Verify that removeResource was called on the mocked Asteroid
        verify(mockedAsteroid).removeResource();
        // Additionally, you can test the output to ensure that the correct message is printed
        assertDoesNotThrow(() -> waterIce.sublime(mockedAsteroid),
                "Sublime method should not throw any exceptions");
    }
}
