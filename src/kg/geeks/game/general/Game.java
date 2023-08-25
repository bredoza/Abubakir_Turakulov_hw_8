package kg.geeks.game.general;

import kg.geeks.game.characters.*;

import java.util.Random;

public class Game {
    public static Random random = new Random();
    private static int roundNumber;

    public static void startGame() {
        Boss boss = new Boss("Ragnar", 3000, 50);
        Warrior artur = new Warrior("Artur", 200, 10);
        Mage merlin = new Mage("Merlin", 100, 20);
        Berserk guts = new Berserk("Guts", 120, 10);
        Cleric gabriel = new Cleric("Gabriel", 100, 5, 10);
        Cleric angelina = new Cleric("Angelina", 80, 5, 5);
        Witcher geralt = new Witcher("Geralt", 200, 0);
        Thor odinSon = new Thor("Thor", 150, 15);
        Deku midoriya = new Deku("Midoriya", 100, 5);
        Samurai kenshin = new Samurai("Kenshin", 120, 15);
        Goku goku = new Goku("Goku", 200, 10);

        Hero[] heroes = {artur, merlin, guts, gabriel, angelina, geralt, odinSon, midoriya, kenshin, goku};

        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static void showStatistics(Boss boss, Hero[] heroes) {
        System.out.println("⸻⸻⸻⸻⸻⸻「 ROUND " + roundNumber + " 」⸻⸻⸻⸻⸻⸻\n");
        System.out.println(boss);
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence();
        showStatistics(boss, heroes);
        boss.attack(heroes);
        for (Hero value : heroes) {
            if (value.getHealth() > 0 && boss.getHealth() > 0 && boss.getDefence() != value.getAbility()) {
                value.attack(boss);
                value.applyAbility(boss, heroes);
            }
        }
        for (Hero hero : heroes) {
            if (hero instanceof Goku) {
                if (((Goku) hero).hasUsedKamehameha()) {
                    System.out.println(hero.getName() + " use kamehameha and deal " + (hero.getDamage() * 10) + " damage");
                    ((Goku) hero).resetKamehameha();
                }
                System.out.println(hero.getName() + " has " + ((Goku) hero).getKiCharge() + "% Ki");
            }
        }
        System.out.println(" ");
    }

    private static boolean isGameOver(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("⸻⸻⸻⸻ Win ⸻⸻⸻⸻");
            return true;
        }
        boolean allHeroesDead = true;
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("⸻⸻⸻⸻ Lose ⸻⸻⸻⸻");
        }
        return allHeroesDead;
    }
}
