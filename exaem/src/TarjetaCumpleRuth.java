//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class TarjetaCumpleRuth extends JPanel implements ActionListener {

    private javax.swing.Timer timer;
    private double t = 0;
    private ArrayList<Point> puntosCorazon = new ArrayList<>();
    private BufferedImage fondo, arbol;
    private java.util.List<Hoja> hojas = new ArrayList<>();
    private Random rand = new Random();
    private long ultimoTiempoHoja = System.currentTimeMillis();

    public TarjetaCumpleRuth() {
        setBackground(Color.BLACK);
        timer = new javax.swing.Timer(30, this);
        timer.start();

        try {
            fondo = ImageIO.read(new File("tarjeta_ruth_final.png"));
            arbol = ImageIO.read(new File("arbol_derecha.png"));
        } catch (IOException e) {
            System.out.println("Error cargando imágenes: " + e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Fondo imagen (centrada)
        if (fondo != null) {
            int imgWidth = 700;
            int imgHeight = 680;
            int imgX = (getWidth() - imgWidth) / 2;
            int imgY = 200;
            g.drawImage(fondo, imgX, imgY, imgWidth, imgHeight, null);
        }

        // Árbol a la derecha
        if (arbol != null) {
            g.drawImage(arbol, 740, 210, 130, 370, null);
        }

        // Corazón animado arriba
        g2d.setColor(Color.RED);
        for (Point p : puntosCorazon) {
            g2d.fillOval(p.x, p.y, 2, 2);
        }

        if (t <= Math.PI * 2) {
            double x = 16 * Math.pow(Math.sin(t), 3);
            double y = 13 * Math.cos(t) - 5 * Math.cos(2 * t)
                    - 2 * Math.cos(3 * t) - Math.cos(4 * t);
            int esc = 10;
            int px = getWidth() / 2 + (int)(x * esc);
            int py = 120 + (int)(-y * esc);
            puntosCorazon.add(new Point(px, py));
        }

        // Dibujar hojas con texto
        g2d.setFont(new Font("SansSerif", Font.BOLD, 12));
        for (Hoja h : hojas) {
            g2d.setColor(new Color(139, 69, 19)); // hoja marrón
            g2d.fillOval(h.x, h.y, 20, 20);
            g2d.setColor(Color.WHITE);
            g2d.drawString("Te quiero", h.x - 10, h.y + 35);
            h.caer();
        }

        // Mensaje final
        if (t > Math.PI * 2) {
            g.setColor(new Color(0, 0, 0, 180));
            g.fillRect(0, getHeight() - 60, getWidth(), 50);
            g.setColor(Color.WHITE);
            g.setFont(new Font("SansSerif", Font.BOLD, 24));
            g.drawString("¡Feliz cumpleaños Ruth Ariana! 🎂💖", 240, getHeight() - 25);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (t <= Math.PI * 2) {
            t += 0.03;
        }

        // Agregar hoja cada 10 segundos
        long ahora = System.currentTimeMillis();
        if (ahora - ultimoTiempoHoja >= 10000) {
            hojas.add(new Hoja(750 + rand.nextInt(50), 240));
            ultimoTiempoHoja = ahora;
        }

        repaint();
    }

    class Hoja {
        int x, y;
        double velocidadY;

        public Hoja(int x, int y) {
            this.x = x;
            this.y = y;
            this.velocidadY = 0.8 + rand.nextDouble() * 0.5;
        }

        public void caer() {
            y += velocidadY;
            if (y > 900) {
                y = 240;
                x = 750 + rand.nextInt(50);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tarjeta para Ruth Ariana");
        TarjetaCumpleRuth panel = new TarjetaCumpleRuth();
        frame.add(panel);
        frame.setSize(900, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}







