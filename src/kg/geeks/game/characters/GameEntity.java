package kg.geeks.game.characters;

public abstract class GameEntity {
    private final String name;
    private int health;
    private int damage;

    public GameEntity(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Math.max(health, 0);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "Name:    " + this.name + "\n" + "Health:  " + this.health + "\n" + "Damage:  " + this.damage + "\n";
    }
}
