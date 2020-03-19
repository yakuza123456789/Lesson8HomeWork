package kg.geektech.game.players;

import java.util.Random;

public class Magic extends Hero {

    public Magic(int health, int damage) {
        super(health, damage, SuperAbility.BOOST);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        Random rand = new Random();
        int r = rand.nextInt(4);
        for (int i = 0; i < heroes.length; i++) {
           heroes[i].setDamage(heroes[i].getDamage() + r);
        }
    }
}
