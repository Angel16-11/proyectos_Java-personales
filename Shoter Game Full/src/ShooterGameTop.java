import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;
import java.io.*;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;

public class ShooterGameTop extends JPanel implements ActionListener, KeyListener {
    // Juego
    private javax.swing.Timer timer;
    private Player player;
    private List<Bullet> bullets;
    private List<Enemy> enemies;
    private List<EnemyBullet> enemyBullets;
    private List<BossEnemy> bosses;
    private List<PowerUp> powerUps;
    private List<Explosion> explosions;
    private boolean inGame = false, paused = false, gameOver = false, inMenu = true;
    private int score = 0, bossCounter = 0, difficulty = 1, level = 1, combo = 0, maxCombo = 0, bombs = 1;
    private long lastPowerUpTime = 0, lastShotTime = 0;
    private final Random random = new Random();
    private final Font scoreFont = new Font("Consolas", Font.BOLD, 18);
    private final Font bigFont = new Font("Arial", Font.BOLD, 42);
    private final Font pauseFont = new Font("Arial", Font.BOLD, 32);
    // Sprites (puedes poner tus imágenes en assets/)
    private BufferedImage playerImg, enemyImg, bossImg, explosionImg, powerUpImg;
    private Clip musicClip, shootClip, explosionClip, powerUpClip;
    // Ranking
    private final List<Integer> highScores = new ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Shooter 2D PRO - Ángel David");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            ShooterGameTop panel = new ShooterGameTop();
            frame.setContentPane(panel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    public ShooterGameTop() {
        setPreferredSize(new Dimension(720, 480));
        setFocusable(true);
        addKeyListener(this);
        loadAssets();
        loadRanking();
        initGame();
    }

    private void loadAssets() {
        try {
            playerImg = ImageIO.read(new File("assets/player.png"));
            enemyImg = ImageIO.read(new File("assets/enemy.png"));
            bossImg = ImageIO.read(new File("assets/boss.png"));
            explosionImg = ImageIO.read(new File("assets/explosion.png"));
            powerUpImg = ImageIO.read(new File("assets/powerup.png"));
        } catch (Exception ex) {
            // Si no hay imágenes, ignora (usa gráficos simples)
            playerImg = null; enemyImg = null; bossImg = null; explosionImg = null; powerUpImg = null;
        }
        try {
            musicClip = AudioSystem.getClip();
            musicClip.open(AudioSystem.getAudioInputStream(new File("assets/music.wav")));
            shootClip = AudioSystem.getClip();
            shootClip.open(AudioSystem.getAudioInputStream(new File("assets/shoot.wav")));
            explosionClip = AudioSystem.getClip();
            explosionClip.open(AudioSystem.getAudioInputStream(new File("assets/explosion.wav")));
            powerUpClip = AudioSystem.getClip();
            powerUpClip.open(AudioSystem.getAudioInputStream(new File("assets/powerup.wav")));
        } catch (Exception ex) {
            musicClip = null; shootClip = null; explosionClip = null; powerUpClip = null;
        }
    }

    private void playSound(Clip clip) {
        if (clip != null) {
            if (clip.isRunning()) clip.stop();
            clip.setFramePosition(0);
            clip.start();
        }
    }

    private void playMusic() {
        if (musicClip != null) {
            musicClip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    private void stopMusic() {
        if (musicClip != null) musicClip.stop();
    }

    private void saveRanking() {
        try (PrintWriter pw = new PrintWriter("assets/ranking.txt")) {
            for (int s : highScores) pw.println(s);
        } catch (Exception ex) {
            // Ignorar si no existen archivos
        }
    }

    private void loadRanking() {
        highScores.clear();
        try (BufferedReader br = new BufferedReader(new FileReader("assets/ranking.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                highScores.add(Integer.parseInt(line));
            }
        } catch (Exception ex) {
            // If no file exists, initial scores are empty
        }
    }

    private void initGame() {
        player = new Player(340, 380, 5, 1);
        bullets = new ArrayList<>();
        enemies = new ArrayList<>();
        enemyBullets = new ArrayList<>();
        bosses = new ArrayList<>();
        powerUps = new ArrayList<>();
        explosions = new ArrayList<>();
        score = 0; bossCounter = 0; level = 1; difficulty = 1; combo = 0; maxCombo = 0; bombs = 1;
        gameOver = false; inGame = true; paused = false; inMenu = false;
        lastPowerUpTime = System.currentTimeMillis();
        playMusic();
        if (timer != null) timer.stop();
        timer = new javax.swing.Timer(16, this); // 60fps
        timer.start();

        new javax.swing.Timer(1400, ev -> {
            if (inGame && !paused) {
                for (int i = 0; i < difficulty; i++) enemies.add(new Enemy());
                bossCounter++;
                if (bossCounter >= 10+level*2) {
                    bosses.add(new BossEnemy());
                    bossCounter = 0;
                }
            }
        }).start();

        new javax.swing.Timer(12000, ev -> {
            if (inGame && !paused && System.currentTimeMillis() - lastPowerUpTime > 11000) {
                powerUps.add(new PowerUp());
                lastPowerUpTime = System.currentTimeMillis();
            }
        }).start();
    }

    private void endGame() {
        inGame = false;
        gameOver = true;
        stopMusic();
        highScores.add(score);
        highScores.sort(Collections.reverseOrder());
        while (highScores.size() > 5) highScores.remove(highScores.size()-1);
        saveRanking();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Fondo parallax (estrellas)
        g.setColor(new Color(20, 20, 30));
        g.fillRect(0, 0, getWidth(), getHeight());
        for (int i = 0; i < 120; i++) {
            int sx = random.nextInt(getWidth());
            int sy = random.nextInt(getHeight());
            g.setColor(new Color(220, 220, 255, 60));
            g.fillRect(sx, sy, 1, 1);
        }
        // HUD
        g.setColor(Color.WHITE);
        g.setFont(scoreFont);
        g.drawString("Vidas: " + player.getLives(), 30, 30);
        g.drawString("Puntaje: " + score, 540, 30);
        g.drawString("Nivel: " + level, 320, 30);
        g.drawString("Bombas: " + bombs, 320, 54);
        g.drawString("Combo: " + combo, 30, 54);

        if (inMenu) {
            g.setColor(Color.CYAN);
            g.setFont(bigFont);
            g.drawString("SHOOTER 2D PRO", 180, 120);
            g.setFont(scoreFont);
            g.drawString("Presiona ENTER para Jugar", 240, 200);
            g.drawString("Mejor puntaje: " + (highScores.isEmpty() ? 0 : highScores.get(0)), 250, 250);
            g.drawString("Ranking:", 310, 290);
            for (int i = 0; i < highScores.size(); i++)
                g.drawString((i+1)+". " + highScores.get(i), 310, 320+i*20);
            return;
        }
        if (paused) {
            g.setColor(Color.ORANGE);
            g.setFont(pauseFont);
            g.drawString("PAUSA", 290, 220);
            g.setFont(scoreFont);
            g.setColor(Color.WHITE);
            g.drawString("Presiona [P] para reanudar", 230, 270);
            return;
        }
        if (gameOver) {
            g.setColor(Color.RED);
            g.setFont(bigFont);
            g.drawString("¡GAME OVER!", 200, 180);
            g.setFont(scoreFont);
            g.setColor(Color.WHITE);
            g.drawString("Tu puntaje: " + score, 280, 220);
            g.drawString("Combo Máx: " + maxCombo, 280, 244);
            g.drawString("Presiona [R] para reiniciar, ESC para salir", 170, 270);
            g.drawString("Ranking:", 310, 300);
            for (int i = 0; i < highScores.size(); i++)
                g.drawString((i+1)+". " + highScores.get(i), 310, 330+i*20);
            return;
        }
        // Sprites y entidades
        if (playerImg != null)
            g.drawImage(playerImg, player.getX(), player.getY(), player.getW(), player.getH(), this);
        else {
            g.setColor(Color.CYAN);
            g.fillRoundRect(player.getX(), player.getY(), player.getW(), player.getH(), 10, 10);
        }
        g.setColor(Color.YELLOW);
        for (Bullet b : bullets) g.fillRect(b.getX(), b.getY(), b.getW(), b.getH());
        g.setColor(Color.PINK);
        for (EnemyBullet eb : enemyBullets) g.fillRect(eb.getX(), eb.getY(), eb.getW(), eb.getH());
        for (Enemy e : enemies) {
            if (enemyImg != null)
                g.drawImage(enemyImg, e.getX(), e.getY(), e.getW(), e.getH(), this);
            else {
                g.setColor(Color.RED);
                g.fillRoundRect(e.getX(), e.getY(), e.getW(), e.getH(), 8, 8);
            }
        }
        for (BossEnemy b : bosses) {
            g.setColor(Color.WHITE);
            g.drawRect(b.getX()-2, b.getY()-12, b.getW()+4, 8);
            g.setColor(Color.GREEN);
            int vidaBarra = (int)((b.getLives()/(float)b.getMaxLives())*b.getW());
            g.fillRect(b.getX(), b.getY()-10, vidaBarra, 5);
            if (bossImg != null)
                g.drawImage(bossImg, b.getX(), b.getY(), b.getW(), b.getH(), this);
            else {
                g.setColor(new Color(120, 70, 250));
                g.fillRoundRect(b.getX(), b.getY(), b.getW(), b.getH(), 14, 14);
            }
        }
        for (PowerUp pu : powerUps) {
            if (powerUpImg != null)
                g.drawImage(powerUpImg, pu.getX(), pu.getY(), pu.getW(), pu.getH(), this);
            else {
                if (pu.type == PowerUp.LIFE) g.setColor(Color.GREEN);
                else if (pu.type == PowerUp.BOMB) g.setColor(Color.ORANGE);
                else g.setColor(Color.MAGENTA);
                g.fillOval(pu.getX(), pu.getY(), pu.getW(), pu.getH());
            }
        }
        for (Explosion ex : explosions) {
            if (explosionImg != null)
                g.drawImage(explosionImg, ex.x, ex.y, ex.w, ex.h, this);
            else {
                g.setColor(Color.WHITE);
                g.drawOval(ex.x, ex.y, ex.w, ex.h);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!inGame || paused) return;
        // Dificultad y nivel
        if (score > level * 200) { level++; difficulty++; bombs++; }
        player.update();
        bullets.forEach(Bullet::update);
        enemyBullets.forEach(EnemyBullet::update);
        enemies.forEach(Enemy::update);
        bosses.forEach(BossEnemy::update);
        powerUps.forEach(PowerUp::update);
        explosions.forEach(Explosion::update);
        bullets.removeIf(b -> b.getY() < 0);
        enemyBullets.removeIf(b -> b.getY() > getHeight());
        enemies.removeIf(e1 -> e1.getY() > getHeight());
        bosses.removeIf(b1 -> b1.getY() > getHeight());
        powerUps.removeIf(pu -> pu.getY() > getHeight());
        explosions.removeIf(Explosion::isAlive);
        // Disparo enemigo
        for (Enemy enemy : enemies)
            if (random.nextInt(110) < difficulty * 2)
                enemyBullets.add(new EnemyBullet(enemy.getX() + 15, enemy.getY() + 30));
        for (BossEnemy b : bosses)
            if (random.nextInt(60) < difficulty * 2)
                enemyBullets.add(new EnemyBullet(b.getX()+b.getW()/2-5, b.getY()+b.getH()));
        checkCollisions();
        repaint();
    }

    private void checkCollisions() {
        List<Bullet> bulletsToRemove = new ArrayList<>();
        List<Enemy> enemiesToRemove = new ArrayList<>();
        List<BossEnemy> bossesToRemove = new ArrayList<>();
        List<EnemyBullet> enemyBulletsToRemove = new ArrayList<>();
        List<PowerUp> powerUpsToRemove = new ArrayList<>();
        // Balas del jugador con enemigos
        for (Bullet b : bullets) {
            for (Enemy e : enemies) {
                if (b.getBounds().intersects(e.getBounds())) {
                    bulletsToRemove.add(b); enemiesToRemove.add(e);
                    score += 10*level; combo++; maxCombo = Math.max(combo,maxCombo);
                    playSound(explosionClip); explosions.add(new Explosion(e.getX(),e.getY(),40,40));
                    break;
                }
            }
        }
        // Balas del jugador con jefes
        for (Bullet b : bullets) {
            for (BossEnemy boss : bosses) {
                if (b.getBounds().intersects(boss.getBounds())) {
                    boss.takeDamage(); bulletsToRemove.add(b);
                    if (boss.getLives() <= 0) {
                        bossesToRemove.add(boss); score += 250*level;
                        playSound(explosionClip); explosions.add(new Explosion(boss.getX(),boss.getY(),60,60));
                        combo+=10; maxCombo=Math.max(combo,maxCombo);
                    }
                    break;
                }
            }
        }
        // Balas enemigas con jugador
        for (EnemyBullet eb : enemyBullets)
            if (eb.getBounds().intersects(player.getBounds())) {
                player.loseLife(); enemyBulletsToRemove.add(eb); combo=0;
                playSound(explosionClip); explosions.add(new Explosion(player.getX(),player.getY(),40,40));
            }
        // Enemigos o jefes chocan con jugador
        for (Enemy e : enemies)
            if (e.getBounds().intersects(player.getBounds()) || (e.getY() + e.getH() >= player.getY())) {
                player.loseLife(); enemiesToRemove.add(e); combo=0;
                playSound(explosionClip); explosions.add(new Explosion(e.getX(),e.getY(),40,40));
                break;
            }
        for (BossEnemy boss : bosses)
            if (boss.getBounds().intersects(player.getBounds())||(boss.getY()+boss.getH()>=player.getY())) {
                player.loseLife(); bossesToRemove.add(boss); combo=0;
                playSound(explosionClip); explosions.add(new Explosion(boss.getX(),boss.getY(),60,60));
                break;
            }
        // Jugador recoge powerups
        for (PowerUp pu : powerUps)
            if (pu.getBounds().intersects(player.getBounds())) {
                if (pu.type == PowerUp.LIFE) player.gainLife();
                if (pu.type == PowerUp.BOMB) bombs++;
                if (pu.type == PowerUp.SHIELD) player.enableShield();
                playSound(powerUpClip); powerUpsToRemove.add(pu);
            }
        bullets.removeAll(bulletsToRemove);
        enemies.removeAll(enemiesToRemove);
        bosses.removeAll(bossesToRemove);
        enemyBullets.removeAll(enemyBulletsToRemove);
        powerUps.removeAll(powerUpsToRemove);
        if (player.getLives() <= 0) endGame();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (inMenu) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) { inMenu=false; initGame(); }
            return;
        }
        if (gameOver) {
            if (e.getKeyCode() == KeyEvent.VK_R) { initGame(); }
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) { System.exit(0); }
            return;
        }
        if (!inGame) return;
        if (e.getKeyCode() == KeyEvent.VK_P) { paused = !paused; repaint(); return; }
        if (e.getKeyCode() == KeyEvent.VK_R) { initGame(); return; }
        if (paused) return;
        if (e.getKeyCode() == KeyEvent.VK_LEFT) player.moveLeft();
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) player.moveRight();
        else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            // Disparo rápido con retardo
            if (System.currentTimeMillis() - lastShotTime > 120) {
                bullets.add(new Bullet(player.getX() + player.getW()/2 - 3, player.getY()-5, player.weapon));
                playSound(shootClip); lastShotTime = System.currentTimeMillis();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_B && bombs > 0) {
            // Bomba: elimina todos los enemigos y balas en pantalla
            playSound(explosionClip);
            score += 30*enemies.size() + 100*bosses.size();
            enemies.clear(); bosses.clear(); enemyBullets.clear();
            bombs--;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    // --------- CLASES INTERNAS ---------

    private class Player {
        private int x, y, w = 40, h = 40, speed = 13, lives, maxLives = 9, shield = 0, weapon = 1;
        public Player(int x, int y, int lives, int weapon) { this.x = x; this.y = y; this.lives = lives; this.weapon = weapon; }
        public void update() { if (shield > 0) shield--; }
        public void moveLeft() { x = Math.max(0, x - speed); }
        public void moveRight() { x = Math.min(720-w, x + speed); }
        public void loseLife() { if (shield==0) lives--; }
        public void gainLife() { if (lives < maxLives) lives++; }
        public void enableShield() { shield = 180; }
        public int getLives() { return lives; }
        public int getX() { return x; }
        public int getY() { return y; }
        public int getW() { return w; }
        public int getH() { return h; }
        public Rectangle getBounds() { return new Rectangle(x, y, w, h); }
    }

    private class Bullet {
        private int x, y, w=8, h=18, speed = 13, type;
        public Bullet(int x, int y, int type) { this.x = x; this.y = y; this.type = type; }
        public void update() { y -= speed; }
        public int getX() { return x; }
        public int getY() { return y; }
        public int getW() { return w; }
        public int getH() { return h; }
        public Rectangle getBounds() { return new Rectangle(x, y, w, h); }
    }

    private class Enemy {
        private int x, y, w=30, h=30, speed = 2 + difficulty;
        public Enemy() { this.x = random.nextInt(720-w); this.y = 0; }
        public void update() { y += speed; }
        public int getX() { return x; }
        public int getY() { return y; }
        public int getW() { return w; }
        public int getH() { return h; }
        public Rectangle getBounds() { return new Rectangle(x, y, w, h); }
    }

    private class BossEnemy {
        private int x, y, w=70, h=70, speed = 1 + difficulty/2, lives, maxLives;
        public BossEnemy() {
            this.x = random.nextInt(720-w); this.y = 0;
            this.lives = 15 + level * 2; this.maxLives = lives;
        }
        public void update() { y += speed; }
        public void takeDamage() { lives--; }
        public int getLives() { return lives; }
        public int getMaxLives() { return maxLives; }
        public int getX() { return x; }
        public int getY() { return y; }
        public int getW() { return w; }
        public int getH() { return h; }
        public Rectangle getBounds() { return new Rectangle(x, y, w, h); }
    }

    private class EnemyBullet {
        private int x, y, w=10, h=18, speed = 8;
        public EnemyBullet(int x, int y) { this.x = x; this.y = y; }
        public void update() { y += speed; }
        public int getX() { return x; }
        public int getY() { return y; }
        public int getW() { return w; }
        public int getH() { return h; }
        public Rectangle getBounds() { return new Rectangle(x, y, w, h); }
    }

    private class PowerUp {
        int x, y, w=28, h=28, speed=3, type;
        static final int LIFE = 1, BOMB = 2, SHIELD = 3;
        public PowerUp() {
            this.x = random.nextInt(720-w); this.y = 0;
            int r = random.nextInt(3);
            this.type = (r==0 ? LIFE : (r==1 ? BOMB : SHIELD));
        }
        public void update() { y += speed; }
        public int getX() { return x; }
        public int getY() { return y; }
        public int getW() { return w; }
        public int getH() { return h; }
        public Rectangle getBounds() { return new Rectangle(x, y, w, h); }
    }

    private class Explosion {
        int x, y, w, h, life = 18;
        public Explosion(int x, int y, int w, int h) { this.x = x; this.y = y; this.w = w; this.h = h; }
        public void update() { life--; }
        public boolean isAlive() { return life > 0; }
    }
}

