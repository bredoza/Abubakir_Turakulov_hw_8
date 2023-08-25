package kg.geeks.game.characters;

public class Goku extends Hero {
    private int kiCharge = 0;
    private static final int KI_PER_ROUND = 20;
    private static final int KI_FULL = 100;
    private boolean usedKamehameha = false;

    public Goku(String name, int health, int damage) {
        super(name, health, damage, Ability.KAMEHAMEHA);
    }

    @Override
    public void applyAbility(Boss boss, Hero[] heroes) {
        kiCharge += KI_PER_ROUND;
        if (kiCharge >= KI_FULL) {
            usedKamehameha = true;
            kamehameha(boss);
        }
    }

    private void kamehameha(Boss boss) {
        int kamehamehaDamage = getDamage() * 10;
        boss.setHealth(boss.getHealth() - kamehamehaDamage);
        kiCharge = 0;
    }

    public boolean hasUsedKamehameha() {
        return usedKamehameha;
    }

    public void resetKamehameha() {
        usedKamehameha = false;
    }

    public int getKiCharge() {
        return kiCharge;
    }
}
