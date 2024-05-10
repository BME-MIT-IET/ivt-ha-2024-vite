package AsteroidMiningTests;

import AsteroidMining.RadioActiveAsteroid;
import AsteroidMining.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class RadioActiveAsteroidTest {
    private RadioActiveAsteroid asteroid;
    private Resource mockResource;

    @BeforeEach
    void setUp() {
        // Mock the Resource to avoid dealing with its internals
        mockResource = Mockito.mock(Resource.class);
        asteroid = new RadioActiveAsteroid(0, 0, mockResource, 10);
    }

    @Test
    void testConstructor() {
        assertNotNull(asteroid, "Asteroid should be instantiated");
    }

    @Test
    void testExplosionImpactOnEnvironment() {
        RadioActiveAsteroid neighbor = new RadioActiveAsteroid(1, 1, mockResource, 5);
        asteroid.explode();
    }

    @Test
    void testExplosionDoesNotOccurUnderCertainConditions() {
        // Set up conditions under which explosion should not occur
        // Example: when depth is not zero
        RadioActiveAsteroid deepAsteroid = new RadioActiveAsteroid(0, 0, mockResource, 20);
        deepAsteroid.explode();

        // Verify no interaction or state change happens with resource or asteroid when depth is not zero
        verifyNoInteractions(mockResource);
    }
}
