package game;

public class Hobbit extends Character {
    public Hobbit() {
        setHp(3);
        setPower(0);
        this.name = "Hobbit";
    }

    private void toCry(){
    System.out.println("Crying");
    }

    @Override
    void kick(Character c) {
        toCry();
    }
}
