package kg.geeks.game.characters;

import kg.geeks.game.general.Game;

public class Boss extends GameEntity {
    private Ability defence;
    private int stunnedRounds = 0;

    public void stunnedBoss() {
        if (stunnedRounds > 0) {
            stunnedRounds--;
            if (stunnedRounds == 0) {
                setDefence(null);
            }
        }
    }

    public void setStunnedRounds(int stunnedRounds) {
        this.stunnedRounds = stunnedRounds;
    }

    public Boss(String name, int health, int damage) {
        super(name, health, damage);
    }

    public void setDefence(Ability defence) {
        this.defence = defence;
    }

    public Ability getDefence() {
        return defence;
    }

    public void chooseDefence() {
        Ability[] values = Ability.values();
        int index = Game.random.nextInt(values.length);
        this.defence = values[index];
    }

    public void attack(Hero[] heroes) {
        if (stunnedRounds == 0) {
            for (Hero hero : heroes) {
                if (hero.getHealth() > 0) {
                    if (hero instanceof Berserk && hero.getAbility() != this.defence) {
                        int blocked;
                        if (Game.random.nextBoolean()) {
                            blocked = this.getDamage() / 2;
                        } else {
                            blocked = this.getDamage() / 5;
                        }
                        ((Berserk) hero).setBlockedDamage(blocked);
                        hero.setHealth(hero.getHealth() - (this.getDamage() - blocked));
                    } else {
                        hero.setHealth(hero.getHealth() - this.getDamage());
                    }
                }
            }
        } else {
            System.out.println("Boss stunned and skip next round");
            stunnedBoss();
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Defense: " + this.defence + "\n";
    }
}
