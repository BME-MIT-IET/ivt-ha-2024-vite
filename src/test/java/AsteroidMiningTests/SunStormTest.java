package AsteroidMiningTests;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import AsteroidMining.SunStorm;
import AsteroidMining.Asteroid;
import AsteroidMining.Visitor;
import AsteroidMining.Robot;
import AsteroidMining.ID;

/**
 * Tests for the SunStorm class in the AsteroidMining game.
 * This class focuses on verifying the interactions between the SunStorm and other objects,
 * specifically how it impacts settlers and robots during collisions.
 */
class SunStormTest {
    private SunStorm sunStorm;
    private Asteroid asteroid;
    private Visitor settler;
    private Robot robot;

    /**
     * Sets up the testing environment before each test.
     * This method prepares mocked objects and defines their behavior to simulate the game's logic.
     */
    @BeforeEach
    void setUp() {
        // Initialize the SunStorm object with predefined coordinates and duration.
        sunStorm = new SunStorm(100, 100, 10);

        // Mock the Asteroid and its visitors (Settler and Robot) to simulate their interactions.
        asteroid = mock(Asteroid.class);
        settler = mock(Visitor.class);
        robot = mock(Robot.class); // Directly mock Robot to use its specific methods without casting.

        // Define how the mocked methods should behave when invoked.
        when(settler.getId()).thenReturn(ID.Settler);
        when(robot.getId()).thenReturn(ID.Robot);
        when(asteroid.getVisitors()).thenReturn(Arrays.asList(settler, robot));
    }

    /**
     * Test the interaction of a SunStorm with a Settler.
     * Ensures that if the settler is not hidden, they will "die" as a result of the storm.
     */
    @Test
    void testCollisionWithSettler() {
        // Setup the settler to be visible (not hidden).
        when(settler.isHidden()).thenReturn(false);

        // Execute the collision logic.
        sunStorm.collisionWith(asteroid);

        // Verify that the settler's die method is called, indicating they were killed by the storm.
        verify(settler).die();
    }

    /**
     * Test the interaction of a SunStorm with a Robot.
     * Verifies that a robot takes damage during a storm, and if its health drops to zero, it dies.
     */
    @Test
    void testCollisionWithRobot() {
        // Setup the robot to be visible and its health to zero to simulate critical damage.
        when(robot.isHidden()).thenReturn(false);
        when(robot.getHealth()).thenReturn(0);

        // Execute the collision logic.
        sunStorm.collisionWith(asteroid);

        // Verify that the robot takes damage and then dies due to zero health.
        verify(robot).getDamage(5);
        verify(robot).die();
    }
}
