package kg.geektech.game.players;

public abstract class GameEntity {
    private int health;
    private int damage;

    public GameEntity(int health, int damage){
        this.damage = damage;
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
