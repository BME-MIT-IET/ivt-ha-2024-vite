package AsteroidMiningTests;

import AsteroidMining.Direction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DirectionTest {

    @Test
    void testEnumValues() {
        // This test verifies that all expected values are present in the Direction enum.
        Direction[] values = Direction.values();
        Assertions.assertEquals(4, values.length, "There should be four directions");

        // Verifies that each expected direction is present
        Assertions.assertTrue(contains(values, Direction.UP), "Should contain UP");
        Assertions.assertTrue(contains(values, Direction.DOWN), "Should contain DOWN");
        Assertions.assertTrue(contains(values, Direction.RIGHT), "Should contain RIGHT");
        Assertions.assertTrue(contains(values, Direction.LEFT), "Should contain LEFT");
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
