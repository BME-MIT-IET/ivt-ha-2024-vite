package AsteroidMiningTests;
import AsteroidMining.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PlaceTest {

    Place place;

    @BeforeEach
    void setUp() {
        place = (Place) new Asteroid(0, 0, null, 10);
    }

    @Test
    void getNeighbourTest() {
        Asteroid a1  = new Asteroid(1, 1, new Uranium(), 2);
        place.addNeighbour(a1);
        Assertions.assertEquals(a1, place.getNeighbour());
    }

    @Test
    void getVisitorTest(){
        Settler s = new Settler(1, 1, new Handler());
        place.addVisitor(s);
        Assertions.assertEquals(s, place.getVisitors().get(0));
    }

    @Test
    void removeVisitorTest(){
        Settler s = new Settler(1, 1, new Handler());
        place.addVisitor(s);
        place.removeVisitor(s);
        Assertions.assertEquals(0, place.getVisitors().size());
    }
}
