import java.util.Random;

public class Enemy {
    private String name;
    private int health;
    private int attackDamage;

    public Enemy(String name, int health, int attackDamage) {
        this.name = name;
        this.health = health;
        this.attackDamage = attackDamage;
    }

    public int attack(Random random) {
        int extraDamage = random.nextInt(4);
        return attackDamage + extraDamage;
    }

    public void takeDamage(int damage) {
        health = health - damage;

        if (health < 0) {
            health = 0;
        }
    }

    public boolean isAlive() {
        return health > 0;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
}