package kg.geeks.game.characters;

import kg.geeks.game.general.Game;

public class Warrior extends Hero {
    public Warrior(String name, int health, int damage) {
        super(name, health, damage, Ability.CRITICAL_DAMAGE);
    }

    @Override
    public void applyAbility(Boss boss, Hero[] heroes) {
        int multiple = Game.random.nextInt(8) + 2;
        boss.setHealth(boss.getHealth() - multiple * this.getDamage());
        System.out.println(this.getName() + " critical damage " + multiple * this.getDamage());
    }
}
