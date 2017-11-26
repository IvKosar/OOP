package game;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class KnightTest {
    @Test
    public void testKnight() {
        Knight k = new Knight();
        assertThat(k.getHp()).isBetween(12, 21);
        assertThat(k.getPower()).isBetween(2, 12);
        assertEquals(k.name, "Knight");
    }
    @Test
    public void kick() throws Exception {
        Knight k1 = new Knight();
        Knight k2 = new Knight();
        int hp2 = k2.getHp();
        k1.kick(k2);
        assertTrue(k2.getHp() < hp2);
    }
}