package game;

import java.util.Random;

public class King extends Character{
    public King() {
        super(5, 15, 5, 15);
        this.name = "King";
    }

    @Override
    void kick(Character c) {
        int strength = new Random().nextInt(this.power);
        c.hp -= strength;
    }
}
