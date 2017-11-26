package game;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class KingTest {
    @Test
    public void testKing() {
        King k = new King();
        assertThat(k.getHp()).isBetween(5, 15);
        assertThat(k.getPower()).isBetween(5, 15);
        assertEquals(k.name, "King");
    }
    @Test
    public void kick() throws Exception {
        King k1 = new King();
        King k2 = new King();
        int hp2 = k2.getHp();
        k1.kick(k2);
        assertTrue(k2.getHp() < hp2);
    }
}