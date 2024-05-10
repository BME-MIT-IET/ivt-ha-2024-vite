package AsteroidMiningTests;

// Imports the necessary classes and methods from the JUnit framework and other packages.
import AsteroidMining.Carbon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.image.BufferedImage;

// Defines a test class named CarbonTest within the AsteroidMiningTests package.
class CarbonTest {
    // Private member to hold the instance of Carbon used in the test methods.
    private Carbon carbon;

    // This method is annotated with @BeforeEach, indicating it runs before each test method.
    // It sets up the environment for tests by initializing a new instance of Carbon.
    @BeforeEach
    void setUp() {
        carbon = new Carbon();
    }

    // A test method to verify that the type property of the Carbon instance is correctly set.
    // It asserts that the getType method should return "Carbon", indicating the resource type.
    @Test
    void testResourceType() {
        assertEquals("Carbon", carbon.getType(), "Resource type should be Carbon");
    }

    // A test method to check if the ID of the Carbon instance is set correctly.
    // It asserts that the getId method should return the enum value ID.Carbon, confirming the resource identifier.
    @Test
    void testResourceId() {
        assertEquals(AsteroidMining.ID.Carbon, carbon.getId(), "Resource ID should be set to Carbon");
    }

    // A test method to ensure that an image file is correctly loaded into the Carbon instance.
    // It checks that the getImg method does not return null and that the returned object is an instance of BufferedImage.
    @Test
    void testImageLoaded() {
        assertNotNull(carbon.getImg(), "Image should be loaded for Carbon resource");
        assertTrue(carbon.getImg() instanceof BufferedImage, "Image should be an instance of BufferedImage");
    }
}
