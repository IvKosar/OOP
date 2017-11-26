package game;

import org.junit.Test;

import static org.junit.Assert.*;

public class ElfTest {
    @Test
    public void testElf(){
        Elf e = new Elf();
        assertEquals(e.getHp(), 10);
        assertEquals(e.getPower(), 10);
        assertEquals(e.name, "Elf");
    }

    @Test
    public void kick() throws Exception {
        Elf e1 = new Elf();
        Elf e2 = new Elf();
        e1.kick(e2);
        assertEquals(e2.getHp(), 9);
        e2.setPower(9);
        e1.kick(e2);
        assertEquals(e2.getHp(), 0);
        assertEquals(e2.isAlive(), false);
    }

}