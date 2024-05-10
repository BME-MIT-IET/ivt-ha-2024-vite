package AsteroidMiningTests;

import AsteroidMining.Direction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    @Test
    void testEnumValues() {
        // This test verifies that all expected values are present in the Direction enum.
        Direction[] values = Direction.values();
        assertEquals(4, values.length, "There should be four directions");

        // Verifies that each expected direction is present
        assertTrue(contains(values, Direction.UP), "Should contain UP");
        assertTrue(contains(values, Direction.DOWN), "Should contain DOWN");
        assertTrue(contains(values, Direction.RIGHT), "Should contain RIGHT");
        assertTrue(contains(values, Direction.LEFT), "Should contain LEFT");
    }

    // Helper method to determine if an array contains a specific value
    private boolean contains(Direction[] array, Direction value) {
        for (Direction dir : array) {
            if (dir == value) {
                return true;
            }
        }
        return false;
    }
}
