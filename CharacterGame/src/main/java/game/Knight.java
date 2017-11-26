package game;

import java.util.Random;

public class Knight extends Character {
    public Knight(){
        super(2, 12, 2, 21);
        this.name = "Knight";
    }

    @Override
    void kick(Character c) {
        int strength = new Random().nextInt(this.power);
        c.hp -= strength;
    }
}
