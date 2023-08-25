package kg.geeks.game.characters;

import kg.geeks.game.general.Game;

public class Samurai extends Hero {
    public Samurai(String name, int health, int damage) {
        super(name, health, damage, Ability.NINJA_ATTACK);
    }

    @Override
    public void applyAbility(Boss boss, Hero[] heroes) {
        int abilityType = Game.random.nextInt(2);

        if (abilityType == 0) {
            int virusDamage = Game.random.nextInt(getDamage()) + 1;
            boss.setHealth(boss.getHealth() - virusDamage);
            System.out.println(getName() + " virus dagger damage " + virusDamage);
        } else {
            int vaccineHeal = Game.random.nextInt(getDamage()) + 1;
            boss.setHealth(boss.getHealth() + vaccineHeal);
            System.out.println(getName() + " vaccine dagger heal " + vaccineHeal);
        }
    }
}
