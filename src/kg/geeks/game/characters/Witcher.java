package kg.geeks.game.characters;

public class Witcher extends Hero {
    public Witcher(String name, int health, int damage) {
        super(name, health, damage, Ability.REVIVE);
    }

    @Override
    public void applyAbility(Boss boss, Hero[] heroes) {
        Hero firstDeadHero = findFirstDeadHero(heroes);
        if (firstDeadHero != null) {
            firstDeadHero.setHealth(this.getHealth());
            this.setHealth(0);
            System.out.println(this.getName() + " revive " + firstDeadHero.getName());
        }
    }

    private Hero findFirstDeadHero(Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getHealth() <= 0) {
                return hero;
            }
        }
        return null;
    }
}
