package game;

import java.util.Random;

public class CharacterFactory {
    public CharacterFactory(){}
    static Character createCharacter(){
        int code = new Random().nextInt(4);
        Character ch;
        switch (code){
            case 0:
                ch = new Hobbit();
                break;
            case 1:
                ch = new Elf();
                break;
            case 2:
                ch = new King();
                break;
            default:
                ch = new Knight();
                break;
        } return ch;
    }
}
