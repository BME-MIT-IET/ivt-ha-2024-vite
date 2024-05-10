package AsteroidMiningTests;

import AsteroidMining.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SpaceShipTest {

    SpaceShip spaceShip;
    @BeforeEach
    void setUp() {
        spaceShip = new SpaceShip();
        spaceShip.addResource(new Uranium());
    }


    @Test
    void addResourceTest(){
        Carbon carbon = new Carbon();
        spaceShip.addResource(carbon);
        Assertions.assertEquals(carbon, spaceShip.getResource(carbon.getId()));
    }

    @Test
    void countResourceTest(){
        Carbon carbon = new Carbon();
        spaceShip.addResource(carbon);
        Assertions.assertEquals(1, spaceShip.countResource(carbon.getId()));
    }

    @Test
    void checkCapacityTest(){
        Carbon carbon = new Carbon();
        spaceShip.addResource(carbon);
        Assertions.assertTrue(spaceShip.checkCapacity());
    }
}
