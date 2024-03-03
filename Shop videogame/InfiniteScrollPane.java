import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;
import javax.imageio.*;

public class InfiniteScrollPane extends JPanel {
    private int currentImageIndex = 0;
    private int portafoglio = 2000;
    private final int NUMBER_OF_IMAGES = 5;
    private final int DISPLAYED_IMAGES = 3;
    private final int IMAGE_WIDTH = 100;
    private final int IMAGE_HEIGHT = 100;
    private final int SCROLL_SPEED = 1000; 

    private ArrayList<Immagine> images = new ArrayList<>();
    private Timer timer;
    private JButton actionButton;

    public InfiniteScrollPane() {

        loadImages();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int imageIndex = x / IMAGE_WIDTH;
                currentImageIndex = (currentImageIndex - imageIndex - 1 + NUMBER_OF_IMAGES) % NUMBER_OF_IMAGES;
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                startScrolling();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                stopScrolling();
            }
        });
        
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_LEFT) {
                    currentImageIndex = (currentImageIndex - 1 + NUMBER_OF_IMAGES) % NUMBER_OF_IMAGES;
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    currentImageIndex = (currentImageIndex + 1) % NUMBER_OF_IMAGES;
                }
                repaint();
            }
        });
        setFocusable(true);

        // Create and add action button
        actionButton = new JButton();
        ImageIcon buy = new ImageIcon("img/buy.png");
        ImageIcon sel = new ImageIcon("img/seleziona.png");
        actionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int x;
                if(currentImageIndex == 4){x=0;}else{x=currentImageIndex+1;}

                if(images.get(x).getHo()) {
                    System.out.println("Selezionato");
                    actionButton.setIcon(sel);
                    actionButton.setOpaque(false);
                    actionButton.setContentAreaFilled(false);
                    actionButton.setBorderPainted(false);
                    actionButton.setPreferredSize(new Dimension(sel.getIconWidth(), sel.getIconHeight()));
                    add(actionButton);
                } else {
                    actionButton.setIcon(buy);
                    actionButton.setOpaque(false);
                    actionButton.setContentAreaFilled(false);
                    actionButton.setBorderPainted(false);
                    actionButton.setPreferredSize(new Dimension(buy.getIconWidth(), buy.getIconHeight()));
                    add(actionButton);
                    if (portafoglio >= images.get(x).getPrezzo()) {
                        System.out.println("Acquistato");
                        portafoglio -= images.get(x).getPrezzo();
                        images.get(x).setHo(true);
                        actionButton.setIcon(sel);
                        actionButton.setOpaque(false);
                        actionButton.setContentAreaFilled(false);
                        actionButton.setBorderPainted(false);
                        actionButton.setPreferredSize(new Dimension(sel.getIconWidth(), sel.getIconHeight())); 
                        add(actionButton);
                    } else {
                        System.out.println("Non hai abbastanza denaro");
                        actionButton.setIcon(buy);
                        actionButton.setOpaque(false);
                        actionButton.setContentAreaFilled(false);
                        actionButton.setBorderPainted(false);
                        actionButton.setPreferredSize(new Dimension(buy.getIconWidth(), buy.getIconHeight()));
                        add(actionButton);
                    }
                }
                System.out.println("nel portafoglio ti restano " + portafoglio);
                repaint();
            }
        });

        int X;
        if(currentImageIndex == 4){X=0;}else{X=currentImageIndex+1;}
        if(images.get(X).getHo()) {
            actionButton.setIcon(sel);
            actionButton.setOpaque(false);
            actionButton.setContentAreaFilled(false);
            actionButton.setBorderPainted(false);
            actionButton.setPreferredSize(new Dimension(sel.getIconWidth(), sel.getIconHeight()));
        } else {
            actionButton.setIcon(buy);
            actionButton.setOpaque(false);
            actionButton.setContentAreaFilled(false);
            actionButton.setBorderPainted(false);
            actionButton.setPreferredSize(new Dimension(buy.getIconWidth(), buy.getIconHeight()));
        }
        add(actionButton);
    }

    private void startScrolling() {
        timer = new Timer(SCROLL_SPEED, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentImageIndex = (currentImageIndex + 1 ) % NUMBER_OF_IMAGES;
                repaint();
            }
        });
    timer.start();
    }

    private void stopScrolling() {
        timer.stop();
    }

    private void loadImages() {
        images.add(new Immagine(new ImageIcon("img/c1.png").getImage(), 1000, false));
        images.add(new Immagine(new ImageIcon("img/c2.png").getImage(), 500, false));
        images.add(new Immagine(new ImageIcon("img/c3.png").getImage(), 800, false));
        images.add(new Immagine(new ImageIcon("img/cc.png").getImage(), 300, false));
        images.add(new Immagine(new ImageIcon("img/c.png").getImage(), 200, false));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int offset = 0;
        for (int i = 0; i < DISPLAYED_IMAGES; i++) {
            int index = (currentImageIndex + i) % NUMBER_OF_IMAGES;
            Image image = images.get(index).getImage();
            if (i == 1) {
                InfiniteScrollPane infiniteScrollPane = new InfiniteScrollPane();
                ImageIcon buy = new ImageIcon("img/buy.png");
                ImageIcon sel = new ImageIcon("img/seleziona.png");
                if(images.get(index).getHo()) {
                    actionButton.setIcon(sel);
                    actionButton.setOpaque(false);
                    actionButton.setContentAreaFilled(false);
                    actionButton.setBorderPainted(false);
                    actionButton.setPreferredSize(new Dimension(sel.getIconWidth(), sel.getIconHeight()));
                } else {
                    actionButton.setIcon(buy);
                    actionButton.setOpaque(false);
                    actionButton.setContentAreaFilled(false);
                    actionButton.setBorderPainted(false);
                    actionButton.setPreferredSize(new Dimension(buy.getIconWidth(), buy.getIconHeight()));
                }
                add(actionButton);

                g2.drawImage(image, i * IMAGE_WIDTH + offset, 0, IMAGE_WIDTH + 50, IMAGE_HEIGHT + 50, null);

                if (images.get(index).getHo()) {
                    g2.setColor(new Color(0, 200, 100));
                    g2.drawString("Acquistato", IMAGE_WIDTH + 78, IMAGE_HEIGHT + 50);
                } else {
                    g2.setColor(Color.RED);
                    g2.drawString("Prezzo: " + images.get(index).getPrezzo(), IMAGE_WIDTH + 75, IMAGE_HEIGHT + 50);
                }
            } else {
                g2.drawImage(image, i * IMAGE_WIDTH +25 + offset, 50, IMAGE_WIDTH, IMAGE_HEIGHT, null);
            }

            offset += 30;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InfiniteScrollPane infiniteScrollPane = new InfiniteScrollPane();
        frame.add(infiniteScrollPane);
        frame.pack();
        frame.setVisible(true);
    }

}

class Immagine {
    private Image image;
    private int prezzo;
    private boolean ho;

    public Immagine(Image image, int prezzo, boolean ho) {
        this.image = image;
        this.prezzo = prezzo;
        this.ho = ho;
    }

    public Image getImage() {
        return image;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public boolean getHo() {
        return ho;
    }

    public void setHo(boolean ho) {
        this.ho = ho;
    }
}