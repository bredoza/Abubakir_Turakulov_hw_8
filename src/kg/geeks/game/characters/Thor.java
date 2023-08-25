package kg.geeks.game.characters;

import kg.geeks.game.general.Game;

public class Thor extends Hero {

    public Thor(String name, int health, int damage) {
        super(name, health, damage, Ability.STUN);
    }

    @Override
    public void applyAbility(Boss boss, Hero[] heroes) {
        if (Game.random.nextBoolean()) {
            boss.setStunnedRounds(1);
        }
    }
}
