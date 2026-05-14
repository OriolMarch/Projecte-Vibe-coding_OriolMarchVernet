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
    private JLabel subtitleLabel;
    private JLabel stageLabel;
    private JLabel roundLabel;

    private JLabel playerNameLabel;
    private JLabel playerFaceLabel;
    private JLabel playerHealLabel;
    private JProgressBar playerHealthBar;

    private JLabel enemyNameLabel;
    private JLabel enemyFaceLabel;
    private JProgressBar enemyHealthBar;

    private JTextArea logArea;

    private JButton attackButton;
    private JButton defendButton;
    private JButton healButton;
    private JButton riskyButton;
    private JButton restartButton;

    public GameGUI() {
        random = new Random();

        setTitle("Bug Hunter - Kawaii Anime Edition");
        setSize(980, 680);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        createInterface();
        startNewGame();

        setVisible(true);
    }

    private void createInterface() {
        JPanel background = new GradientPanel();
        background.setLayout(new BorderLayout(15, 15));
        background.setBorder(new EmptyBorder(18, 18, 18, 18));
        setContentPane(background);

        JPanel headerPanel = createHeaderPanel();
        background.add(headerPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 15, 15));
        centerPanel.setOpaque(false);

        JPanel statusPanel = createStatusPanel();
        JPanel logPanel = createLogPanel();

        centerPanel.add(statusPanel);
        centerPanel.add(logPanel);

        background.add(centerPanel, BorderLayout.CENTER);

        JPanel actionsPanel = createActionsPanel();
        background.add(actionsPanel, BorderLayout.SOUTH);
    }

    private JPanel createHeaderPanel() {
        RoundedPanel panel = new RoundedPanel(new Color(255, 245, 252), 30);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(18, 20, 18, 20));

        titleLabel = new JLabel("♡ BUG HUNTER: KAWAII COMMIT ♡", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setForeground(new Color(110, 70, 120));

        subtitleLabel = new JLabel("Derrota a todos los bugs del sistema con poder anime ✨", SwingConstants.CENTER);
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitleLabel.setForeground(new Color(120, 90, 130));

        stageLabel = new JLabel("Stage 1", SwingConstants.CENTER);
        stageLabel.setFont(new Font("Arial", Font.BOLD, 16));
        stageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        stageLabel.setForeground(new Color(180, 90, 140));

        roundLabel = new JLabel("Round 1", SwingConstants.CENTER);
        roundLabel.setFont(new Font("Arial", Font.BOLD, 16));
        roundLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        roundLabel.setForeground(new Color(180, 90, 140));

        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(8));
        panel.add(subtitleLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(stageLabel);
        panel.add(Box.createVerticalStrut(4));
        panel.add(roundLabel);

        return panel;
    }

    private JPanel createStatusPanel() {
        RoundedPanel panel = new RoundedPanel(new Color(255, 248, 252), 30);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(18, 18, 18, 18));

        JLabel statusTitle = new JLabel("✿ Character Status ✿");
        statusTitle.setFont(new Font("Arial", Font.BOLD, 22));
        statusTitle.setForeground(new Color(130, 70, 140));
        statusTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(statusTitle);
        panel.add(Box.createVerticalStrut(20));

        RoundedPanel playerCard = new RoundedPanel(new Color(255, 232, 244), 25);
        playerCard.setLayout(new BoxLayout(playerCard, BoxLayout.Y_AXIS));
        playerCard.setBorder(new EmptyBorder(16, 16, 16, 16));

        playerNameLabel = new JLabel("Jugador");
        playerNameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        playerNameLabel.setForeground(new Color(100, 60, 120));
        playerNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        playerFaceLabel = new JLabel("(＾▽＾) ♡");
        playerFaceLabel.setFont(new Font("Arial", Font.BOLD, 28));
        playerFaceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        playerHealthBar = new JProgressBar();
        playerHealthBar.setStringPainted(true);
        playerHealthBar.setFont(new Font("Arial", Font.BOLD, 14));
        playerHealthBar.setForeground(new Color(255, 128, 170));
        playerHealthBar.setBackground(new Color(255, 245, 250));

        playerHealLabel = new JLabel("Curaciones: 3");
        playerHealLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        playerHealLabel.setForeground(new Color(110, 70, 120));
        playerHealLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        playerCard.add(playerNameLabel);
        playerCard.add(Box.createVerticalStrut(10));
        playerCard.add(playerFaceLabel);
        playerCard.add(Box.createVerticalStrut(12));
        playerCard.add(playerHealthBar);
        playerCard.add(Box.createVerticalStrut(10));
        playerCard.add(playerHealLabel);

        RoundedPanel enemyCard = new RoundedPanel(new Color(237, 231, 255), 25);
        enemyCard.setLayout(new BoxLayout(enemyCard, BoxLayout.Y_AXIS));
        enemyCard.setBorder(new EmptyBorder(16, 16, 16, 16));

        enemyNameLabel = new JLabel("Enemigo");
        enemyNameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        enemyNameLabel.setForeground(new Color(80, 60, 130));
        enemyNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        enemyFaceLabel = new JLabel("(▼皿▼#)");
        enemyFaceLabel.setFont(new Font("Arial", Font.BOLD, 28));
        enemyFaceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        enemyHealthBar = new JProgressBar();
        enemyHealthBar.setStringPainted(true);
        enemyHealthBar.setFont(new Font("Arial", Font.BOLD, 14));
        enemyHealthBar.setForeground(new Color(170, 140, 255));
        enemyHealthBar.setBackground(new Color(247, 245, 255));

        enemyCard.add(enemyNameLabel);
        enemyCard.add(Box.createVerticalStrut(10));
        enemyCard.add(enemyFaceLabel);
        enemyCard.add(Box.createVerticalStrut(12));
        enemyCard.add(enemyHealthBar);

        panel.add(playerCard);
        panel.add(Box.createVerticalStrut(18));
        panel.add(enemyCard);

        return panel;
    }

    private JPanel createLogPanel() {
        RoundedPanel panel = new RoundedPanel(new Color(255, 248, 252), 30);
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBorder(new EmptyBorder(18, 18, 18, 18));

        JLabel logTitle = new JLabel("★ Battle Log ★");
        logTitle.setFont(new Font("Arial", Font.BOLD, 22));
        logTitle.setForeground(new Color(130, 70, 140));

        logArea = new JTextArea();
        logArea.setEditable(false);
        logArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
        logArea.setLineWrap(true);
        logArea.setWrapStyleWord(true);
        logArea.setBackground(new Color(255, 240, 248));
        logArea.setForeground(new Color(90, 60, 100));
        logArea.setMargin(new Insets(12, 12, 12, 12));

        JScrollPane scrollPane = new JScrollPane(logArea);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(230, 190, 220), 2));

        panel.add(logTitle, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createActionsPanel() {
        RoundedPanel panel = new RoundedPanel(new Color(255, 245, 252), 30);
        panel.setLayout(new GridLayout(1, 5, 12, 12));
        panel.setBorder(new EmptyBorder(14, 14, 14, 14));

        attackButton = new KawaiiButton("⚔ Atacar", new Color(255, 182, 193));
        defendButton = new KawaiiButton("🛡 Defender", new Color(190, 220, 255));
        healButton = new KawaiiButton("❤ Curar", new Color(255, 210, 230));
        riskyButton = new KawaiiButton("✨ Skill", new Color(215, 190, 255));
        restartButton = new KawaiiButton("↺ Reiniciar", new Color(255, 230, 180));

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
        addLog("🌸 Welcome, magical developer!");
        addLog("💻 Tu misión es derrotar todos los bugs del sistema.");
        addLog("👾 Enemigo detectado: " + enemies[currentEnemyIndex].getName());

        enableActionButtons(true);
        updateInterface();
    }

    private void playerAction(int option) {
        Enemy currentEnemy = enemies[currentEnemyIndex];

        addLog(" ");
        addLog("──────── ROUND " + round + " ────────");

        if (option == 1) {
            int damage = player.attack(random);
            currentEnemy.takeDamage(damage);
            addLog("⚔ " + player.getName() + " ataca y hace " + damage + " de daño.");
        } else if (option == 2) {
            player.defend();
            addLog("🛡 " + player.getName() + " se protege. El próximo golpe recibido se reducirá.");
        } else if (option == 3) {
            int healthBefore = player.getHealth();
            int healed = player.heal();
            int realHealed = player.getHealth() - healthBefore;

            if (healed > 0) {
                addLog("❤ " + player.getName() + " recupera " + realHealed + " puntos de vida.");
            } else {
                addLog("⚠ No quedan curaciones disponibles.");
            }
        } else if (option == 4) {
            int chance = random.nextInt(100);

            if (chance < 50) {
                int damage = 30 + random.nextInt(11);
                currentEnemy.takeDamage(damage);
                addLog("✨ Depuración arriesgada completada con éxito. Has hecho " + damage + " de daño.");
            } else {
                addLog("💥 La skill especial ha fallado.");
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

        addLog("👾 " + enemy.getName() + " contraataca y hace " + realDamage + " de daño.");
    }

    private void checkCombatState() {
        Enemy currentEnemy = enemies[currentEnemyIndex];

        if (!player.isAlive()) {
            endGame(false);
            return;
        }

        if (!currentEnemy.isAlive()) {
            addLog("🎀 Has derrotado a " + currentEnemy.getName() + ".");

            currentEnemyIndex++;

            if (currentEnemyIndex >= enemies.length) {
                endGame(true);
            } else {
                round = 1;
                addLog("🌟 Nuevo enemigo detectado: " + enemies[currentEnemyIndex].getName());
            }
        } else {
            round++;
        }
    }

    private void endGame(boolean victory) {
        enableActionButtons(false);

        if (victory) {
            addLog(" ");
            addLog("🏆 VICTORIA TOTAL");
            addLog("✨ Has eliminado todos los bugs del sistema.");
            addLog("💖 El proyecto ha sido salvado.");
            JOptionPane.showMessageDialog(
                    this,
                    "🏆 VICTORIA\nHas eliminado todos los bugs del sistema.\nEl proyecto ha sido salvado.",
                    "Resultado final",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            addLog(" ");
            addLog("💀 DERROTA");
            addLog("💥 El sistema ha colapsado antes de tiempo.");
            JOptionPane.showMessageDialog(
                    this,
                    "💀 DERROTA\nEl sistema ha colapsado.",
                    "Resultado final",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    private void updateInterface() {
        stageLabel.setText("Stage " + (currentEnemyIndex + 1));
        roundLabel.setText("Round " + round);

        playerNameLabel.setText("🌸 " + player.getName());
        playerHealLabel.setText("Curaciones restantes: " + player.getHealUses());

        playerHealthBar.setMaximum(player.getMaxHealth());
        playerHealthBar.setValue(player.getHealth());
        playerHealthBar.setString(player.getHealth() + " / " + player.getMaxHealth());

        if (player.getHealth() > 60) {
            playerFaceLabel.setText("(＾▽＾) ♡");
        } else if (player.getHealth() > 25) {
            playerFaceLabel.setText("(•̀ᴗ•́)و");
        } else {
            playerFaceLabel.setText("(╥﹏╥)");
        }

        if (currentEnemyIndex < enemies.length) {
            Enemy currentEnemy = enemies[currentEnemyIndex];
            enemyNameLabel.setText("👾 " + currentEnemy.getName());

            enemyHealthBar.setMaximum(enemyMaxHealths[currentEnemyIndex]);
            enemyHealthBar.setValue(currentEnemy.getHealth());
            enemyHealthBar.setString(currentEnemy.getHealth() + " / " + enemyMaxHealths[currentEnemyIndex]);

            int enemyHealth = currentEnemy.getHealth();
            int enemyMaxHealth = enemyMaxHealths[currentEnemyIndex];

            if (enemyHealth > enemyMaxHealth / 2) {
                enemyFaceLabel.setText("(▼皿▼#)");
            } else if (enemyHealth > 15) {
                enemyFaceLabel.setText("(ง'̀-'́)ง");
            } else {
                enemyFaceLabel.setText("(x_x)");
            }
        } else {
            enemyNameLabel.setText("👾 Enemigo derrotado");
            enemyHealthBar.setValue(0);
            enemyHealthBar.setString("0 / 0");
            enemyFaceLabel.setText("(×﹏×)");
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

    class GradientPanel extends JPanel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;
            GradientPaint gp = new GradientPaint(
                    0, 0, new Color(255, 230, 245),
                    getWidth(), getHeight(), new Color(230, 235, 255)
            );
            g2.setPaint(gp);
            g2.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    class RoundedPanel extends JPanel {
        private Color backgroundColor;
        private int cornerRadius;

        public RoundedPanel(Color bgColor, int radius) {
            backgroundColor = bgColor;
            cornerRadius = radius;
            setOpaque(false);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setColor(backgroundColor);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
        }
    }

    class KawaiiButton extends JButton {
        private Color color;

        public KawaiiButton(String text, Color color) {
            super(text);
            this.color = color;

            setFocusPainted(false);
            setFont(new Font("Arial", Font.BOLD, 14));
            setForeground(new Color(90, 60, 100));
            setContentAreaFilled(false);
            setBorderPainted(false);
            setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            if (getModel().isPressed()) {
                g2.setColor(color.darker());
            } else if (getModel().isRollover()) {
                g2.setColor(color.brighter());
            } else {
                g2.setColor(color);
            }

            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);

            FontMetrics fm = g2.getFontMetrics();
            Rectangle stringBounds = fm.getStringBounds(getText(), g2).getBounds();

            int textX = (getWidth() - stringBounds.width) / 2;
            int textY = (getHeight() - stringBounds.height) / 2 + fm.getAscent();

            g2.setColor(new Color(90, 60, 100));
            g2.setFont(getFont());
            g2.drawString(getText(), textX, textY);

            g2.dispose();
        }
    }
}