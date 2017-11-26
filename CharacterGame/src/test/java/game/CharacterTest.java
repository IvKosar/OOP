package game;

import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterTest {
    @Test
    public void isAlive() throws Exception {
        Character c = CharacterFactory.createCharacter();
        assertTrue(c.isAlive());
        c.setHp(0);
        assertFalse(c.isAlive());
    }
}