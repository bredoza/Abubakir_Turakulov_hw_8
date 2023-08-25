package kg.geeks.game.characters;

public class Cleric extends Hero {
    private final int healPoints;

    public Cleric(String name, int health, int damage, int healPoints) {
        super(name, health, damage, Ability.HEAL);
        this.healPoints = healPoints;
    }

    @Override
    public void applyAbility(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && this != hero) {
                hero.setHealth(hero.getHealth() + this.healPoints);
            }
        }
        System.out.println(this.getName() + " heal group for " + this.healPoints);
    }
}
