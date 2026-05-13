import java.util.Random;

public class Player {
    private String name;
    private int health;
    private int maxHealth;
    private int healUses;
    private boolean defending;
    private int baseAttack;

    public Player(String name, int health, int maxHealth, int healUses, int baseAttack) {
        this.name = name;
        this.health = health;
        this.maxHealth = maxHealth;
        this.healUses = healUses;
        this.defending = false;
        this.baseAttack = baseAttack;
    }

    public int attack(Random random) {
        int extraDamage = random.nextInt(5);
        return baseAttack + extraDamage;
    }

    public void defend() {
        defending = true;
    }

    public int heal() {
        if (healUses <= 0) {
            return 0;
        }

        int healAmount = 20;
        health = health + healAmount;

        if (health > maxHealth) {
            health = maxHealth;
        }

        healUses--;
        return healAmount;
    }

    public void takeDamage(int damage) {
        if (defending) {
            damage = damage / 2;
            defending = false;
        }

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

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealUses() {
        return healUses;
    }

    public boolean isDefending() {
        return defending;
    }
}