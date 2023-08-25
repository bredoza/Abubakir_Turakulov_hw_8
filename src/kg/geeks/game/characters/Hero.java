package kg.geeks.game.characters;

public abstract class Hero extends GameEntity implements HavingAbility {
    private final Ability ability;

    public Hero(String name, int health, int damage, Ability ability) {
        super(name, health, damage);
        this.ability = ability;
    }

    public Ability getAbility() {
        return ability;
    }

    public void attack(Boss boss) {
        boss.setHealth(boss.getHealth() - this.getDamage());
    }
}
