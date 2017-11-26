package game;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameManagerTest {
    @Test
    public void fight() throws Exception {
        Hobbit h1 = new Hobbit();
        Hobbit h2 = new Hobbit();
        new GameManager().fight(h1, h1);
        assertTrue(h1.isAlive());
        assertTrue(h2.isAlive());

        Character c1 = CharacterFactory.createCharacter();
        Character c2 = CharacterFactory.createCharacter();
        if (!(c1.name == "Hobbit" && c2.name == "Hobbit")){
            assertFalse(c1.isAlive() && c2.isAlive());
        }
    }

}