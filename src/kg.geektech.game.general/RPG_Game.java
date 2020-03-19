package kg.geektech.game.general;

import kg.geektech.game.players.*;

public class RPG_Game {

    public static void startGame() {
        Boss boss = new Boss(450, 50);
        Magic magic = new Magic(170, 20);
        Warrior warrior = new Warrior(180, 10);
        Medic medic = new Medic(160, 10, 15);
        Hunter hunter = new Hunter(150, 25);
        Medic youngMedic = new Medic(180, 15, 5);
        Hero[] heroes = {magic, warrior, medic, hunter, youngMedic};

        printStatic(boss, heroes);

        while (!isfinish(boss, heroes)) {
            round(boss, heroes);
        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        heroesHit(boss, heroes);
        bossHit(boss, heroes);
        printStatic(boss, heroes);
        heroesApplyAnilities(boss, heroes);

    }

    private static boolean isfinish(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes WON");
            return true;
        }
        boolean allHeroesDeath = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDeath = false;
                break;
            }
        }
        if (allHeroesDeath) {
            System.out.println("Boss WON");
        }
        return allHeroesDeath;
    }

    private static void heroesHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && !(heroes[i] instanceof Medic) && boss.getHealth() > 0) {
                if (boss.getHealth() - heroes[i].getDamage() < 0){
                    boss.setHealth(0);
                } else
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }
        }
    }

    private static void heroesApplyAnilities(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
                heroes[i].applySuperAbility(boss, heroes);
            }
        }
    }

    private static void bossHit(Boss boss, Hero[] heroes) {
        if (boss.getHealth() > 0) {
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth() > 0) {
                    if (heroes[i].getHealth() - boss.getDamage() < 0) {
                        heroes[i].setHealth(0);
                    } else {
                        heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
                    }
                }
            }
        }
    }

    private static void printStatic(Boss boss, Hero[] heroes) {
        System.out.println("_______________");
        System.out.println("Boss Health " + boss.getHealth());
        System.out.println("_______________");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName() + " Hero health " + heroes[i].getHealth());
        }
        System.out.println("______________");


    }

}
