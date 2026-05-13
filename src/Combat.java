import java.util.Random;
import java.util.Scanner;

public class Combat {
    private Player player;
    private Enemy enemy;
    private int round;
    private boolean combatEnded;
    private Scanner scanner;
    private Random random;

    public Combat(Player player, Enemy enemy, Scanner scanner, Random random) {
        this.player = player;
        this.enemy = enemy;
        this.scanner = scanner;
        this.random = random;
        this.round = 1;
        this.combatEnded = false;
    }

    public boolean startCombat() {
        while (!combatEnded) {
            System.out.println();
            System.out.println("========== RONDA " + round + " ==========");
            showStatus();

            int option = readOption();
            playerTurn(option);

            if (enemy.isAlive()) {
                enemyTurn();
            }

            if (isCombatFinished()) {
                combatEnded = true;
            } else {
                round++;
            }
        }

        if (player.isAlive()) {
            System.out.println("Has derrotat " + enemy.getName() + ".");
            return true;
        } else {
            System.out.println(player.getName() + " ha caigut en combat.");
            return false;
        }
    }

    public void playerTurn(int option) {
        if (option == 1) {
            int damage = player.attack(random);
            enemy.takeDamage(damage);
            System.out.println(player.getName() + " ataca i fa " + damage + " de dany.");
        } else if (option == 2) {
            player.defend();
            System.out.println(player.getName() + " es defensa. El següent atac rebut es reduirà.");
        } else if (option == 3) {
            int healed = player.heal();

            if (healed > 0) {
                System.out.println(player.getName() + " recupera " + healed + " punts de vida.");
            } else {
                System.out.println("No queden usos de curació.");
            }
        } else if (option == 4) {
            int chance = random.nextInt(100);

            if (chance < 50) {
                int damage = 30 + random.nextInt(11);
                enemy.takeDamage(damage);
                System.out.println("Depuració arriscada amb èxit. Has fet " + damage + " de dany.");
            } else {
                System.out.println("La depuració arriscada ha fallat.");
            }
        }
    }

    public void enemyTurn() {
        int damage = enemy.attack(random);
        player.takeDamage(damage);
        System.out.println(enemy.getName() + " ataca i fa " + damage + " de dany.");
    }

    public void showStatus() {
        System.out.println("Jugador: " + player.getName());
        System.out.println("Vida jugador: " + player.getHealth() + "/" + player.getMaxHealth());
        System.out.println("Curacions restants: " + player.getHealUses());
        System.out.println("Enemic: " + enemy.getName());
        System.out.println("Vida enemic: " + enemy.getHealth());
        System.out.println();
        System.out.println("Accions disponibles:");
        System.out.println("1. Atacar");
        System.out.println("2. Defensar-se");
        System.out.println("3. Curar-se");
        System.out.println("4. Depuració arriscada");
    }

    private int readOption() {
        int option = 0;
        boolean validOption = false;

        while (!validOption) {
            System.out.print("Escull una opció: ");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();

                if (option >= 1 && option <= 4) {
                    validOption = true;
                } else {
                    System.out.println("Opció no vàlida. Introdueix un número entre 1 i 4.");
                }
            } else {
                System.out.println("Entrada no vàlida. Introdueix un número.");
                scanner.next();
            }
        }

        return option;
    }

    public boolean isCombatFinished() {
        if (!player.isAlive()) {
            return true;
        }

        if (!enemy.isAlive()) {
            return true;
        }

        return false;
    }
}