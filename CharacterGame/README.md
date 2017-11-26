Heroes game

Character: int power, int hp, void kick(Character c), boolean isAlive()
Hobbit: power = 0, hp = 3, kick(toCry()l) Elf: power = 10, hp= 10, kick(kill everobody which weaker than him, otherwise decrease power of the other character by 1)
King: power 5-15, hp 5-15, kick(decrease number of hp of the enemy by random number which will be in range of his power)
Knight: power 2-12, hp 2-21, kick(like King)
CharacterFactory: Character createCharacter() - returns random instance of any existing character.
GameManager: void fight(Character c1, Character c2) - to provide fight between to characters and explaing via command line what happens during the fight, till both of the characters are alive.
