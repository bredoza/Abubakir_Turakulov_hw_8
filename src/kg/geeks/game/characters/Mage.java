package kg.geeks.game.characters;

import kg.geeks.game.general.Game;

public class Mage extends Hero {
    public Mage(String name, int health, int damage) {
        super(name, health, damage, Ability.BOOST_DAMAGE);
    }

    @Override
    public void applyAbility(Boss boss, Hero[] heroes) {
        int boost = Game.random.nextInt(10);

        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && !(hero instanceof Witcher)) {
                hero.setDamage(hero.getDamage() + boost);
            }
        }
        System.out.println(this.getName() + " boost group damage by " + boost);
    }
}
