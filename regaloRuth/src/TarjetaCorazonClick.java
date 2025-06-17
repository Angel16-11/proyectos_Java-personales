//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;

public class TarjetaCorazonClick extends JPanel implements ActionListener, MouseListener {
    BufferedImage fondo;
    Timer timer;
    Random rand = new Random();
    float scale = 1.0f;
    boolean growing = true;
    float alpha = 0.6f;

    Hoja[] hojas;
    PuntoCorazon[] puntos;

    int heartCenterX = 250;
    int heartCenterY = 80; // Posición más arriba

    public TarjetaCorazonClick() {
        try {
            fondo = ImageIO.read(new File("fondo.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        hojas = new Hoja[15];
        for (int i = 0; i < hojas.length; i++) {
            hojas[i] = new Hoja(rand.nextInt(800), rand.nextInt(600));
        }

        puntos = new PuntoCorazon[200];
        for (int i = 0; i < puntos.length; i++) {
            double t = Math.PI * 2 * rand.nextDouble();
            double x = 16 * Math.pow(Math.sin(t), 3);
            double y = 13 * Math.cos(t) - 5 * Math.cos(2 * t) - 2 * Math.cos(3 * t) - Math.cos(4 * t);
            puntos[i] = new PuntoCorazon(x, y);
        }

        this.addMouseListener(this);
        timer = new Timer(30, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        drawHeartParticles(g);

        for (Hoja hoja : hojas) {
            hoja.update(getWidth(), getHeight());
            hoja.draw(g);
        }
    }

    public void drawHeartParticles(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Color color = new Color(255, (int)(105 + 50 * Math.sin(scale * 3)), 180);
        g2d.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), (int)(alpha * 255)));

        for (PuntoCorazon p : puntos) {
            int x = (int)(heartCenterX + p.x * scale);
            int y = (int)(heartCenterY - p.y * scale);
            g2d.fillOval(x, y, 4, 4);
        }
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
        if (growing) {
            scale += 0.01;
            alpha += 0.01;
            if (scale >= 1.4f) growing = false;
        } else {
            scale -= 0.01;
            alpha -= 0.01;
            if (scale <= 1.0f) growing = true;
        }

        alpha = Math.min(1.0f, Math.max(0.4f, alpha));
    }

    public void mouseClicked(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        double distance = Math.sqrt(Math.pow(mx - heartCenterX, 2) + Math.pow(my - heartCenterY, 2));
        if (distance < 80 * scale) { // más sensible para el corazón más grande
            JOptionPane.showMessageDialog(this, "¡Felices 18, Ruth! 🎉", "Mensaje Especial", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    class PuntoCorazon {
        double x, y;
        PuntoCorazon(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    class Hoja {
        int x, y, speed;

        Hoja(int x, int y) {
            this.x = x;
            this.y = y;
            this.speed = 1 + rand.nextInt(2);
        }

        void update(int width, int height) {
            y += speed;
            x += Math.sin(y * 0.05);
            if (y > height) {
                y = -20;
                x = rand.nextInt(width);
            }
        }

        void draw(Graphics g) {
            g.setColor(new Color(85, 107, 47));
            g.fillOval(x, y, 40, 20);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Serif", Font.BOLD, 12));
            g.drawString("Te quiero", x + 5, y + 14);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Feliz Cumpleaños Ruth Ariana!");
        TarjetaCorazonClick panel = new TarjetaCorazonClick();
        frame.add(panel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}




