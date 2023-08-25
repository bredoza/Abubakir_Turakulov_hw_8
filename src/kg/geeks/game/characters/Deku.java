package kg.geeks.game.characters;

import kg.geeks.game.general.Game;

public class Deku extends Hero {
    private double powerBoostFactor = 1.0;

    public Deku(String name, int health, int damage) {
        super(name, health, damage, Ability.ONE_FOR_ALL);
    }

    @Override
    public void applyAbility(Boss boss, Hero[] heroes) {
        double boostChance = 0.5;

        if (Game.random.nextDouble() < boostChance) {
            int boostType = Game.random.nextInt(4);
            int boostPower = 0;

            switch (boostType) {
                case 0:
                    powerBoostFactor *= 1.2;
                    boostPower = 20;
                    break;
                case 1:
                    powerBoostFactor *= 1.5;
                    boostPower = 50;
                    break;
                case 2:
                    powerBoostFactor *= 2.0;
                    boostPower = 100;
                    break;
                default:
                    break;
            }
            int maxHealthLoss = 25;
            int healthLoss = (int) (maxHealthLoss * powerBoostFactor);

            setHealth(getHealth() - healthLoss);
            setDamage(getDamage() + boostType);
            System.out.println(getName() + " used " + boostPower + "% and lost " + healthLoss + " health");
        }
    }

    @Override
    public int getDamage() {
        return (int) (super.getDamage() * powerBoostFactor);
    }
}
