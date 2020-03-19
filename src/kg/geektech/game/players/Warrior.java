package kg.geektech.game.players;


import java.util.Random;

public class Warrior extends Hero {

    public Warrior(int health, int damage) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        Random randi = new Random();
        int war = randi.nextInt(2) + 2;
        setDamage(getDamage() * war);

    }
}
