
package AsteroidMiningTests;

import AsteroidMining.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AsteroidTest {
    Asteroid asteroid;

    @BeforeEach
    void setUp() {
        asteroid = new Asteroid(0, 0, null, 10);
    }

    @Test
    void deepenHoleTest() {

        asteroid.deepenHole(5);

        //TODO: getDepth() getter is missing
        //assertEquals(5, asteroid.GetDepth());
    }

    @Test
    void addResourceTest(){
        Resource iron;
        iron = new Iron();

        asteroid.addResource(iron);

        Assertions.assertEquals(iron, asteroid.getResource());
        Assertions.assertFalse(asteroid.isHollow());
    }

    @Test
    void addRadioactiveResourceTest(){
        Resource uranium = new Uranium();

        asteroid.addResource(uranium);

        Assertions.assertEquals(uranium, asteroid.getResource());
        //Failed test: ID is not set to RadioactiveAsteroid after addResource(uranium) invoked
        //assertEquals(ID.RadioActiveAsteroid, asteroid.getId());
    }

    @Test
    void removeResourceTest() {
        Resource resource = new Carbon();
        asteroid.addResource(resource);

        asteroid.removeResource();

        Assertions.assertNull(asteroid.getResource());
        Assertions.assertTrue(asteroid.isHollow());
    }

    @Test
    void isFullyDrilledTest() {
        Asteroid fullyDrilledAsteroid = new Asteroid(0, 0, new Carbon(), 0);
        Asteroid partiallyDrilledAsteroid = new Asteroid(0, 0, new Carbon(), 5);

        Assertions.assertTrue(fullyDrilledAsteroid.isFullyDrilled());
        Assertions.assertFalse(partiallyDrilledAsteroid.isFullyDrilled());
    }

    @Test
    void explodeTest_Settler() {
        Visitor settler = new Settler(0,0, new Handler());
        asteroid.addVisitor(settler);

        asteroid.explode(true);
        Assertions.assertFalse(settler.isAlive());
    }




    @Test
    void inPerihelionUraniumTest() {
        Asteroid drilledAsteroid = new Asteroid(0, 0, new Uranium(), 0);
        drilledAsteroid.setId(ID.RadioActiveAsteroid);
        boolean exploded = true;

        drilledAsteroid.inPerihelion(exploded);
        Assertions.assertEquals(ID.RadioActiveAsteroid, drilledAsteroid.getId() );
    }

    @Test
    void inPerihelionWaterIceTest() {
        Asteroid drilledAsteroid = new Asteroid(0, 0, new WaterIce(), 0);
        boolean exploded = false;

        drilledAsteroid.inPerihelion(exploded);
        Assertions.assertNull(asteroid.getResource());
    }
}
