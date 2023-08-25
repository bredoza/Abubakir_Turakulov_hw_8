package kg.geeks.game.characters;

public class Berserk extends Hero {
    private int damageReserve;

    public Berserk(String name, int health, int damage) {
        super(name, health, damage, Ability.BLOCK_DAMAGE_AND_REVERT);
    }

    @Override
    public void applyAbility(Boss boss, Hero[] heroes) {
        boss.setHealth(boss.getHealth() - damageReserve);
        System.out.println(this.getName() + " give " + damageReserve + " damage to the boss");
    }

    public void setBlockedDamage(int blockedDamage) {
        this.damageReserve = blockedDamage;
    }
}
