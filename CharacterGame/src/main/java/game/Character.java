package game;

import java.util.Random;

public abstract class Character {
    protected int power;
    protected int hp;
    public String name;

    public Character(){}

    protected Character(int minPower, int maxPower, int minHp, int maxHp){
        power = new Random().nextInt(maxPower - minPower + 1) + minPower;
        hp = new Random().nextInt(maxHp - minHp + 1) + minHp;

    }

    abstract void kick(Character c);

    public boolean isAlive() {
        return hp > 0;
    }

    public int getHp() {
        return hp;
    }
    public void setHp(int hp){
        this.hp = hp;
    }
    public int getPower(){
        return power;
    }
    public void setPower(int power){
        this.power = power;
    }
}
