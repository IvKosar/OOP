package game;

import org.junit.Test;

import static org.junit.Assert.*;

public class HobbitTest {
    @Test
    public void testHobbit(){
        Hobbit h = new Hobbit();
        assertEquals(h.getHp(), 3);
        assertEquals(h.getPower(), 0);
        assertEquals(h.name, "Hobbit");
        assertEquals(h.isAlive(), true);
        h.setHp(0);
        assertEquals(h.isAlive(), false);
    }
    @Test
    public void testKick() {
        Hobbit h1 = new Hobbit();
        Hobbit h2 = new Hobbit();
        h1.kick(h2);
        assertEquals(h1.isAlive(), true);
        assertEquals(h2.isAlive(), true);
    }
}