package AsteroidMiningTests;

import AsteroidMining.ID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IDTest {

    @Test
    void testEnumValues() {
        // This test verifies that all expected values are present in the ID enum.
        ID[] values = ID.values();
        Assertions.assertEquals(11, values.length, "There should be eleven ID types");

        // Verifies that each expected ID type is present
        Assertions.assertTrue(contains(values, ID.Settler), "Enum should contain Settler");
        Assertions.assertTrue(contains(values, ID.Robot), "Enum should contain Robot");
        Assertions.assertTrue(contains(values, ID.Asteroid), "Enum should contain Asteroid");
        Assertions.assertTrue(contains(values, ID.RadioActiveAsteroid), "Enum should contain RadioActiveAsteroid");
        Assertions.assertTrue(contains(values, ID.TeleportationGate), "Enum should contain TeleportationGate");
        Assertions.assertTrue(contains(values, ID.SunStorm), "Enum should contain SunStorm");
        Assertions.assertTrue(contains(values, ID.Iron), "Enum should contain Iron");
        Assertions.assertTrue(contains(values, ID.Carbon), "Enum should contain Carbon");
        Assertions.assertTrue(contains(values, ID.Uranium), "Enum should contain Uranium");
        Assertions.assertTrue(contains(values, ID.WaterIce), "Enum should contain WaterIce");
        Assertions.assertTrue(contains(values, ID.Inventory), "Enum should contain Inventory");
    }

    // Helper method to determine if an array contains a specific value
    private boolean contains(ID[] array, ID value) {
        for (ID id : array) {
            if (id == value) {
                return true;
            }
        }
        return false;
    }
}
