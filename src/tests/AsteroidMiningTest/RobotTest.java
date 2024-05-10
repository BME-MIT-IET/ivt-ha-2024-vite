package AsteroidMiningTests;

import AsteroidMining.Asteroid;
import AsteroidMining.Carbon;
import AsteroidMining.Robot;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class RobotTest {

    private Robot r;
    private Asteroid a1, a2;

    @BeforeEach
    void init() {
        r = new Robot();
        a1 = new Asteroid(1, 1, new Carbon(), 2);
        a2 = new Asteroid(1, 1, new Carbon(), 0);
        a2.addNeighbour(a1);
        a1.addNeighbour(a2);
    }

    @Test
    public void testHideSuccess(){
        r.setPlace(a2);
        a2.removeResource();
        Assertions.assertTrue(a2.isHollow());
        r.hide();
        Assertions.assertTrue(r.isHidden());
    }

    @Test
    public void testHideNoSuccess(){
        r.setPlace(a1);
        Assertions.assertFalse(a1.isHollow());
        r.hide();
        Assertions.assertFalse(r.isHidden());
    }

    @Test
    public void testDrill() {
        r.setPlace(a1);
        Assertions.assertTrue(r.drill());
    }


    @Test
    public void testDrillWithNoAsteroid() {
        Assertions.assertFalse(r.drill());
    }
}