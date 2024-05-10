package AsteroidMiningTests;

import AsteroidMining.Iron;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.image.BufferedImage;

class IronTest {
    private Iron iron;

    @BeforeEach
    void setUp() {
        // Initialize the Iron instance before each test
        iron = new Iron();
    }

    @Test
    void testResourceType() {
        // Test if the type is correctly initialized as "Iron"
        assertEquals("Iron", iron.getType(), "Resource type should be correctly set to Iron");
    }

    @Test
    void testResourceId() {
        // Test if the ID is correctly set to Iron
        assertEquals(AsteroidMining.ID.Iron, iron.getId(), "Resource ID should be set to Iron");
    }

    @Test
    void testImageLoaded() {
        // Test to ensure the image file is correctly loaded into the Iron instance
        assertNotNull(iron.getImg(), "Image should be loaded for Iron resource");
        assertTrue(iron.getImg() instanceof BufferedImage, "Image should be an instance of BufferedImage");
    }
}
