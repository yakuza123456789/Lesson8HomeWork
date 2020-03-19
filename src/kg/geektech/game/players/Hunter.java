package kg.geektech.game.players;

public class Hunter extends Hero {

    public Hunter(int health, int damage) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_ADN_REVERT);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        boss.setHealth(boss.getHealth() - ((getDamage() * 20) / 100));
    }
}
