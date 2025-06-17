//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.stream.IntStream;

/**
 * Versión mejorada: replica de forma más fiel (mínima) la distribución
 * de la app de escritorio de Spotify mostrada en la captura.
 *
 * Estructura general:
 * ┌──────────────────────────────────────────────────────────────┐
 * │ TopBar                                                     │
 * ├─LeftIconBar─┬─SideLibrary──┬──────── Main View ─────┬─Right │
 * │             │             │  Playlists / Tabs      │ Panel │
 * ├──────────────────────────────────────────────────────────────┤
 * │ PlayerBar                                                  │
 * └──────────────────────────────────────────────────────────────┘
 *
 * 100 % Swing estándar, sin dependencias externas.
 */
public class SpotifyLikeApp extends JFrame {

    /* Colores */
    private static final Color BG          = new Color(18, 18, 18);   // fondo global
    private static final Color CARD_BG     = new Color(40, 40, 40);   // tarjetas
    private static final Color ACCENT      = new Color(30, 215, 96);  // verde Spotify
    private static final Color LIGHT_GRAY  = new Color(179, 179, 179);

    public SpotifyLikeApp() {
        super("GotMusic");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1366, 768);
        setLocationRelativeTo(null);
        getContentPane().setBackground(BG);
        setLayout(new BorderLayout());

        add(createTopBar(), BorderLayout.NORTH);
        add(createCenterArea(), BorderLayout.CENTER);
        add(createPlayerBar(), BorderLayout.SOUTH);
    }

    /* ---------------- TOP BAR ---------------- */
    private JPanel createTopBar() {
        JPanel top = new JPanel(new BorderLayout());
        top.setBackground(BG);
        top.setPreferredSize(new Dimension(0, 60));

        // Navegación atrás/adelante
        JPanel nav = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 12));
        nav.setOpaque(false);
        nav.add(flatIconBtn("←"));
        nav.add(flatIconBtn("→"));
        top.add(nav, BorderLayout.WEST);

        // Search
        JPanel searchWrapper = new JPanel(new BorderLayout());
        searchWrapper.setBackground(new Color(48,48,48));
        searchWrapper.setBorder(new EmptyBorder(6, 10, 6, 10));
        JTextField search = new JTextField();
        search.setText("¿Qué quieres reproducir?");
        search.setForeground(LIGHT_GRAY);
        search.setBorder(null);
        search.setCaretColor(Color.WHITE);
        search.setOpaque(false);
        searchWrapper.add(search, BorderLayout.CENTER);
        searchWrapper.setPreferredSize(new Dimension(360, 32));
        top.add(searchWrapper, BorderLayout.CENTER);

        // Iconos derecha
        JPanel rightIcons = new JPanel(new FlowLayout(FlowLayout.RIGHT, 14, 12));
        rightIcons.setOpaque(false);
        rightIcons.add(flatIconBtn("🔔"));
        rightIcons.add(flatIconBtn("👥"));
        rightIcons.add(profileCircle("A"));
        top.add(rightIcons, BorderLayout.EAST);
        return top;
    }

    private JButton profileCircle(String text) {
        JButton b = new JButton(text);
        style(b);
        b.setPreferredSize(new Dimension(32,32));
        b.setBackground(new Color(128, 58, 139));
        b.setFont(b.getFont().deriveFont(Font.BOLD, 14f));
        return b;
    }

    /* ---------------- CENTER AREA (3 columnas + right) ---------------- */
    private Component createCenterArea() {
        JSplitPane rightSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        rightSplit.setDividerSize(0);
        rightSplit.setBorder(null);

        // Right panel (Tus me gusta)
        rightSplit.setRightComponent(createRightPanel());
        rightSplit.setResizeWeight(1.0); // right fixed

        // Inside: middle area and left library
        JSplitPane midSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        midSplit.setDividerSize(0);
        midSplit.setBorder(null);
        midSplit.setResizeWeight(0.8);

        midSplit.setLeftComponent(createMainScroll());
        midSplit.setRightComponent(new JPanel()); // placeholder invisible (0 width)

        rightSplit.setLeftComponent(midSplit);

        // Left icon bar and library
        JSplitPane leftSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        leftSplit.setDividerSize(0);
        leftSplit.setBorder(null);
        leftSplit.setResizeWeight(0);
        leftSplit.setLeftComponent(createLeftIconBar());
        leftSplit.setRightComponent(rightSplit);

        return leftSplit;
    }

    /* ---- Leftmost narrow icon bar ---- */
    private JScrollPane createLeftIconBar() {
        JPanel col = new JPanel();
        col.setLayout(new BoxLayout(col, BoxLayout.Y_AXIS));
        col.setBackground(BG);
        col.setBorder(new EmptyBorder(8, 8, 8, 8));
        col.setPreferredSize(new Dimension(64, 0));

        String[] emoji = {"🏠", "🔍", "📚", "🎧", "📝", "⚙️"};
        for (String e : emoji) {
            JButton b = flatIconBtn(e);
            b.setMaximumSize(new Dimension(48,48));
            col.add(b);
            col.add(Box.createVerticalStrut(8));
        }
        return new JScrollPane(col) {{
            setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            setBorder(null);
            getVerticalScrollBar().setUnitIncrement(16);
        }};
    }

    /* ---- Main content scroll: categories + playlists ---- */
    private JScrollPane createMainScroll() {
        JPanel container = new JPanel(new BorderLayout());
        container.setBackground(BG);

        // Tabs Todo/Música/Podcasts
        JPanel tabs = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 12));
        tabs.setOpaque(false);
        for (String t : new String[]{"Todo", "Música", "Podcasts"}) {
            JButton btn = new JButton(t);
            style(btn);
            btn.setBackground(t.equals("Todo") ? Color.WHITE : new Color(48,48,48));
            btn.setForeground(t.equals("Todo") ? Color.BLACK : Color.WHITE);
            tabs.add(btn);
        }
        container.add(tabs, BorderLayout.NORTH);

        // Grid playlists
        JPanel grid = new JPanel(new GridLayout(0, 4, 16, 16));
        grid.setBackground(BG);
        grid.setBorder(new EmptyBorder(10, 20, 20, 20));

        IntStream.rangeClosed(1, 12).forEach(i -> grid.add(new RectCard("Lista " + i, i)));

        JScrollPane scroll = new JScrollPane(grid);
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        container.add(scroll, BorderLayout.CENTER);
        return new JScrollPane(container) {{
            setBorder(null);
            getVerticalScrollBar().setUnitIncrement(16);
            setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        }};
    }

    /* ---- Right panel (Tus me gusta) ---- */
    private JPanel createRightPanel() {
        JPanel right = new JPanel(new BorderLayout());
        right.setPreferredSize(new Dimension(300, 0));
        right.setBackground(BG);
        right.setBorder(new EmptyBorder(20, 10, 20, 20));

        JLabel header = new JLabel("Tus me gusta");
        header.setForeground(Color.WHITE);
        header.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        right.add(header, BorderLayout.NORTH);

        // Cover
        JLabel cover = new JLabel();
        try {
            cover.setIcon(new ImageIcon(new URL("https://i.scdn.co/image/ab67616d0000b27312f276b6c7473c554b45c94a")));
        } catch (Exception ex) {
            cover.setOpaque(true);
            cover.setBackground(Color.DARK_GRAY);
        }
        cover.setPreferredSize(new Dimension(260, 260));
        cover.setBorder(new EmptyBorder(10,0,10,0));
        right.add(cover, BorderLayout.CENTER);

        JPanel meta = new JPanel();
        meta.setLayout(new BoxLayout(meta, BoxLayout.Y_AXIS));
        meta.setOpaque(false);
        JLabel song = new JLabel("Art Deco");
        song.setForeground(Color.WHITE);
        song.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        JLabel artist = new JLabel("Lana Del Rey");
        artist.setForeground(LIGHT_GRAY);
        meta.add(song);
        meta.add(artist);
        right.add(meta, BorderLayout.SOUTH);
        return right;
    }

    /* ---------------- PLAYER BAR ---------------- */
    private JPanel createPlayerBar() {
        JPanel bar = new JPanel(new BorderLayout());
        bar.setBackground(BG);
        bar.setPreferredSize(new Dimension(0, 90));

        // Left: track info
        JPanel info = new JPanel(new FlowLayout(FlowLayout.LEFT, 14, 14));
        info.setOpaque(false);
        JLabel cover = new JLabel();
        cover.setPreferredSize(new Dimension(56,56));
        cover.setOpaque(true);
        cover.setBackground(Color.DARK_GRAY);
        info.add(cover);
        JPanel txt = new JPanel();
        txt.setOpaque(false);
        txt.setLayout(new BoxLayout(txt, BoxLayout.Y_AXIS));
        JLabel track = new JLabel("Canción actual");
        track.setForeground(Color.WHITE);
        JLabel artist = new JLabel("Artista");
        artist.setForeground(LIGHT_GRAY);
        artist.setFont(artist.getFont().deriveFont(12f));
        txt.add(track); txt.add(artist);
        info.add(txt);
        bar.add(info, BorderLayout.WEST);

        // Center controls
        JPanel ctrls = new JPanel(new FlowLayout(FlowLayout.CENTER, 14, 20));
        ctrls.setOpaque(false);
        for (String s : new String[]{"⏮", "▶/⏸", "⏭"}) {
            JButton b = flatIconBtn(s);
            b.setFont(b.getFont().deriveFont(20f));
            ctrls.add(b);
        }
        bar.add(ctrls, BorderLayout.CENTER);

        // Right: progress bar (simple)
        JProgressBar progress = new JProgressBar();
        progress.setValue(50);
        progress.setBackground(CARD_BG);
        progress.setForeground(ACCENT);
        progress.setPreferredSize(new Dimension(240, 8));
        bar.add(progress, BorderLayout.EAST);
        return bar;
    }

    /* ---------------- UTILIDADES ---------------- */
    private JButton flatIconBtn(String txt) {
        JButton b = new JButton(txt);
        style(b);
        b.setPreferredSize(new Dimension(32,32));
        return b;
    }

    private void style(JButton b) {
        b.setFocusable(false);
        b.setBorderPainted(false);
        b.setBackground(BG);
        b.setForeground(Color.WHITE);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    /* ---- Rectangular card usada en la cuadrícula ---- */
    private class RectCard extends JPanel {
        RectCard(String name, int seed) {
            setLayout(new BorderLayout());
            setBackground(CARD_BG);
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            setPreferredSize(new Dimension(160, 64));

            JLabel icon = new JLabel();
            icon.setPreferredSize(new Dimension(60,60));
            try {
                icon.setIcon(new ImageIcon(new URL("https://picsum.photos/seed/" + seed + "/60/60")));
            } catch (Exception e) {
                icon.setOpaque(true);
                icon.setBackground(Color.DARK_GRAY);
            }
            add(icon, BorderLayout.WEST);

            JLabel txt = new JLabel(name);
            txt.setForeground(Color.WHITE);
            txt.setBorder(new EmptyBorder(0, 8, 0, 0));
            add(txt, BorderLayout.CENTER);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new SpotifyLikeApp().setVisible(true));
    }
}

