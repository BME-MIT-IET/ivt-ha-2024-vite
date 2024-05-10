package AsteroidMiningTests;

import AsteroidMining.Asteroid;
import AsteroidMining.Carbon;
import AsteroidMining.Robot;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

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

    @Test
    public void testGetDamage(){
        int health = r.getHealth();
        r.getDamage(2);
        Assertions.assertEquals(health-2, r.getHealth());
    }
    @Test
    public void testRobotHealthDecrease() {
        r.getDamage(5);
        Assertions.assertEquals(-5, r.getHealth(), "Health should decrease by the amount of damage received");
    }

    @Test
    public void testRobotDeath() {
        r.getDamage(100);
        Assertions.assertTrue(r.getHealth() <= 0, "Robot should be dead or inactive when health is zero or negative");
    }

    @Test
    public void testTickNoActionWhenDead() {
        r.getDamage(100);
        Robot spyRobot = Mockito.spy(r);
        spyRobot.tick();
        Mockito.verify(spyRobot, Mockito.never()).travel();
        Mockito.verify(spyRobot, Mockito.never()).drill();
    }
}