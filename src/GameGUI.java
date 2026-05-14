import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Random;

public class GameGUI extends JFrame {
    private Player player;
    private Enemy[] enemies;
    private int[] enemyMaxHealths;
    private int currentEnemyIndex;
    private int round;

    private Random random;

    private JLabel titleLabel;
    private JLabel roundLabel;
    private JLabel playerLabel;
    private JLabel enemyLabel;
    private JLabel healLabel;

    private JProgressBar playerHealthBar;
    private JProgressBar enemyHealthBar;

    private JTextArea logArea;

    private JButton attackButton;
    private JButton defendButton;
    private JButton healButton;
    private JButton riskyButton;
    private JButton restartButton;

    public GameGUI() {
        random = new Random();

        setTitle("Bug Hunter: The Last Commit");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createInterface();
        startNewGame();

        setVisible(true);
    }

    private void createInterface() {
        setLayout(new BorderLayout(10, 10));

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        add(mainPanel);

        titleLabel = new JLabel("BUG HUNTER: THE LAST COMMIT", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 15, 15));
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        JPanel statusPanel = createStatusPanel();
        centerPanel.add(statusPanel);

        JPanel logPanel = createLogPanel();
        centerPanel.add(logPanel);

        JPanel buttonPanel = createButtonPanel();
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    private JPanel createStatusPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        roundLabel = new JLabel();
        roundLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(roundLabel);

        panel.add(Box.createVerticalStrut(20));

        playerLabel = new JLabel();
        playerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(playerLabel);

        playerHealthBar = new JProgressBar();
        playerHealthBar.setStringPainted(true);
        panel.add(playerHealthBar);

        panel.add(Box.createVerticalStrut(10));

        healLabel = new JLabel();
        panel.add(healLabel);

        panel.add(Box.createVerticalStrut(30));

        enemyLabel = new JLabel();
        enemyLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(enemyLabel);

        enemyHealthBar = new JProgressBar();
        enemyHealthBar.setStringPainted(true);
        panel.add(enemyHealthBar);

        return panel;
    }

    private JPanel createLogPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel logTitle = new JLabel("Registre del combat");
        logTitle.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(logTitle, BorderLayout.NORTH);

        logArea = new JTextArea();
        logArea.setEditable(false);
        logArea.setLineWrap(true);
        logArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(logArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 5, 10, 10));

        attackButton = new JButton("Atacar");
        defendButton = new JButton("Defensar");
        healButton = new JButton("Curar");
        riskyButton = new JButton("Depuració arriscada");
        restartButton = new JButton("Reiniciar");

        attackButton.addActionListener(e -> playerAction(1));
        defendButton.addActionListener(e -> playerAction(2));
        healButton.addActionListener(e -> playerAction(3));
        riskyButton.addActionListener(e -> playerAction(4));
        restartButton.addActionListener(e -> startNewGame());

        panel.add(attackButton);
        panel.add(defendButton);
        panel.add(healButton);
        panel.add(riskyButton);
        panel.add(restartButton);

        return panel;
    }

    private void startNewGame() {
        player = new Player("UriDev", 100, 100, 3, 18);

        enemies = new Enemy[3];
        enemies[0] = new Enemy("NullPointer Bug", 45, 10);
        enemies[1] = new Enemy("Infinite Loop Bug", 60, 12);
        enemies[2] = new Enemy("Critical Production Bug", 80, 15);

        enemyMaxHealths = new int[3];
        enemyMaxHealths[0] = 45;
        enemyMaxHealths[1] = 60;
        enemyMaxHealths[2] = 80;

        currentEnemyIndex = 0;
        round = 1;

        logArea.setText("");
        addLog("Comença la partida.");
        addLog("Has de derrotar tots els bugs crítics del sistema.");
        addLog("Nou enemic detectat: " + enemies[currentEnemyIndex].getName());

        enableActionButtons(true);
        updateInterface();
    }

    private void playerAction(int option) {
        Enemy currentEnemy = enemies[currentEnemyIndex];

        addLog("");
        addLog("Ronda " + round);

        if (option == 1) {
            int damage = player.attack(random);
            currentEnemy.takeDamage(damage);
            addLog(player.getName() + " ataca i fa " + damage + " de dany.");
        } else if (option == 2) {
            player.defend();
            addLog(player.getName() + " es defensa. El següent atac rebut es reduirà.");
        } else if (option == 3) {
            int healthBefore = player.getHealth();
            int healed = player.heal();
            int realHealed = player.getHealth() - healthBefore;

            if (healed > 0) {
                addLog(player.getName() + " recupera " + realHealed + " punts de vida.");
            } else {
                addLog("No queden usos de curació.");
            }
        } else if (option == 4) {
            int chance = random.nextInt(100);

            if (chance < 50) {
                int damage = 30 + random.nextInt(11);
                currentEnemy.takeDamage(damage);
                addLog("Depuració arriscada amb èxit. Has fet " + damage + " de dany.");
            } else {
                addLog("La depuració arriscada ha fallat.");
            }
        }

        if (currentEnemy.isAlive()) {
            enemyTurn(currentEnemy);
        }

        checkCombatState();
        updateInterface();
    }

    private void enemyTurn(Enemy enemy) {
        int healthBefore = player.getHealth();

        int damage = enemy.attack(random);
        player.takeDamage(damage);

        int realDamage = healthBefore - player.getHealth();

        addLog(enemy.getName() + " ataca i fa " + realDamage + " de dany.");
    }

    private void checkCombatState() {
        Enemy currentEnemy = enemies[currentEnemyIndex];

        if (!player.isAlive()) {
            endGame(false);
            return;
        }

        if (!currentEnemy.isAlive()) {
            addLog("Has derrotat " + currentEnemy.getName() + ".");

            currentEnemyIndex++;

            if (currentEnemyIndex >= enemies.length) {
                endGame(true);
            } else {
                round = 1;
                addLog("");
                addLog("Nou enemic detectat: " + enemies[currentEnemyIndex].getName());
            }
        } else {
            round++;
        }
    }

    private void endGame(boolean victory) {
        enableActionButtons(false);

        if (victory) {
            addLog("");
            addLog("VICTÒRIA");
            addLog("Has eliminat tots els bugs del sistema.");
            addLog("El projecte s'ha pogut salvar.");
            JOptionPane.showMessageDialog(this, "VICTÒRIA\nHas eliminat tots els bugs del sistema.");
        } else {
            addLog("");
            addLog("DERROTA");
            addLog("El sistema ha col·lapsat abans d'hora.");
            JOptionPane.showMessageDialog(this, "DERROTA\nEl sistema ha col·lapsat.");
        }
    }

    private void updateInterface() {
        roundLabel.setText("Ronda: " + round);

        playerLabel.setText("Jugador: " + player.getName());
        playerHealthBar.setMaximum(player.getMaxHealth());
        playerHealthBar.setValue(player.getHealth());
        playerHealthBar.setString(player.getHealth() + " / " + player.getMaxHealth());

        healLabel.setText("Curacions restants: " + player.getHealUses());

        if (currentEnemyIndex < enemies.length) {
            Enemy currentEnemy = enemies[currentEnemyIndex];

            enemyLabel.setText("Enemic: " + currentEnemy.getName());
            enemyHealthBar.setMaximum(enemyMaxHealths[currentEnemyIndex]);
            enemyHealthBar.setValue(currentEnemy.getHealth());
            enemyHealthBar.setString(currentEnemy.getHealth() + " / " + enemyMaxHealths[currentEnemyIndex]);
        } else {
            enemyLabel.setText("Enemic: eliminat");
            enemyHealthBar.setValue(0);
            enemyHealthBar.setString("0");
        }
    }

    private void enableActionButtons(boolean enabled) {
        attackButton.setEnabled(enabled);
        defendButton.setEnabled(enabled);
        healButton.setEnabled(enabled);
        riskyButton.setEnabled(enabled);
    }

    private void addLog(String text) {
        logArea.append(text + "\n");
        logArea.setCaretPosition(logArea.getDocument().getLength());
    }
}