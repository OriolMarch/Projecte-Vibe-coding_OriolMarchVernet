import java.util.Random;
import java.util.Scanner;

public class Game {
    private Player player;
    private Enemy[] enemies;
    private int currentEnemyIndex;
    private boolean gameOver;
    private boolean victory;
    private Scanner scanner;
    private Random random;

    public Game() {
        scanner = new Scanner(System.in);
        random = new Random();
        currentEnemyIndex = 0;
        gameOver = false;
        victory = false;
        createPlayer();
        createEnemies();
    }

    public void startGame() {
        System.out.println("====================================");
        System.out.println("   BUG HUNTER: THE LAST COMMIT");
        System.out.println("====================================");
        System.out.println("Has de derrotar tots els bugs crítics del sistema.");
        System.out.println();

        while (!gameOver && currentEnemyIndex < enemies.length) {
            Enemy currentEnemy = enemies[currentEnemyIndex];

            System.out.println("------------------------------------");
            System.out.println("Nou enemic detectat: " + currentEnemy.getName());
            System.out.println("------------------------------------");

            Combat combat = new Combat(player, currentEnemy, scanner, random);
            boolean combatWon = combat.startCombat();

            if (combatWon) {
                currentEnemyIndex++;

                if (currentEnemyIndex < enemies.length) {
                    System.out.println();
                    System.out.println("Has superat el combat.");
                    System.out.println("Et prepares per al següent bug...");
                    System.out.println();
                }
            } else {
                gameOver = true;
                victory = false;
            }

            checkGameState();
        }

        showFinalResult();
        scanner.close();
    }

    private void createPlayer() {
        player = new Player("UriDev", 100, 100, 3, 18);
    }

    public void createEnemies() {
        enemies = new Enemy[3];
        enemies[0] = new Enemy("NullPointer Bug", 45, 10);
        enemies[1] = new Enemy("Infinite Loop Bug", 60, 12);
        enemies[2] = new Enemy("Critical Production Bug", 80, 15);
    }

    public void checkGameState() {
        if (!player.isAlive()) {
            gameOver = true;
            victory = false;
        }

        if (player.isAlive() && currentEnemyIndex >= enemies.length) {
            gameOver = true;
            victory = true;
        }
    }

    public void showFinalResult() {
        System.out.println();
        System.out.println("====================================");

        if (victory) {
            System.out.println("VICTÒRIA");
            System.out.println("Has eliminat tots els bugs del sistema.");
            System.out.println("El projecte s'ha pogut salvar.");
        } else {
            System.out.println("DERROTA");
            System.out.println("El sistema ha col·lapsat abans d'hora.");
        }

        System.out.println("====================================");
    }
}