package game;

public class Elf extends Character{
    public Elf() {
        setHp(10);
        setPower(10);
        this.name = "Elf";
    }

    @Override
    void kick(Character c) {
        if (c.power < this.power) {
            c.hp = 0;
        } else {
            c.hp -= 1;
        }
    }
}
