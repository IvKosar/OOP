package game;

public class GameManager {
    Character c1 = CharacterFactory.createCharacter();
    Character c2 = CharacterFactory.createCharacter();
    public static int fight(Character c1, Character c2) {
        if (c1.name == c2.name){
            if (c1.name == "Hobbit" && c2.name == "Hobbit"){
                System.out.println("Hobbits can't fight each other");
                return 1;
            }
            c1.name += "_one";
            c2.name += "_two";
        }
        System.out.println("First fighter: " + c1.name);
        System.out.println("First fighter: " + c2.name);
        while (c1.isAlive() && c2.isAlive()) {
            System.out.format("%s power and hp: %d, %d\n", c1.name, c1.power, c1.hp);
            System.out.format("%s power and hp: %d, %d\n", c2.name, c2.power, c2.hp);

            c1.kick(c2);
            System.out.format("%s power and hp: %d, %d\n", c2.name, c2.power, c2.hp);
            if (!c2.isAlive()) {
                System.out.format("%s is dead\n", c2.name);
            }
            if (c2.isAlive()) {
                c2.kick(c1);
                System.out.format("%s power and hp: %d, %d\n", c1.name, c1.power, c1.hp);
                if (!c1.isAlive()) {
                    System.out.format("%s is dead\n", c1.name);
                }
            }
        }
        if (c1.isAlive()) {
            System.out.format("%s won", c1.name);
        } else {
            System.out.format("%s won", c2.name);
        } return 1;
    }
}
