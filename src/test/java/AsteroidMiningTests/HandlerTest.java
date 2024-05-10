package AsteroidMiningTests;

import AsteroidMining.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HandlerTest {
    SunStorm obj1 = new SunStorm(1,1,1);
    SunStorm obj2 = new SunStorm(1,1,1);

    @Test
    void testAddObject() {
        Handler h = new Handler();

        h.addObject(obj1);
        Assertions.assertEquals(h.objects.contains(obj1),true);
        Assertions.assertEquals(h.objects.getFirst().getId(),obj1.getId());
    }

    @Test
    void testRemoveObject() {
        Handler h = new Handler();

        h.addObject(obj1);
        h.addObject(obj2);

        Assertions.assertEquals(h.objects.contains(obj1),true);
        h.removeObject(obj1);

        Assertions.assertEquals(h.objects.contains(obj1),false);
    }

    @Test
    void testCheckAsteroids() {
        ID resourceId = ID.Inventory;
        Resource resource = new Resource(resourceId);
        RadioActiveAsteroid obj3 = new RadioActiveAsteroid(1,1,resource,0);

        Handler h = new Handler();

        h.addObject(obj1);
        h.addObject(obj3);
        h.checkAsteroids();

        Assertions.assertEquals(h.objects.contains(obj3),true);
    }
}