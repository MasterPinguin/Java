import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;
import javax.imageio.*;

// struct della Skin
class Skin {
    private Image image;
    private int prezzo;
    private boolean ho;

    public Skin(Image image, int prezzo, boolean ho) {
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

public class InfiniteScrollPane extends JPanel {
    private int currentImageIndex = 0;
    public int portafoglio = 2000, start=0, ciclo=0; 
    private final int NUMBER_OF_IMAGES = 5, DISPLAYED_IMAGES = 3, IMAGE_WIDTH = 100, IMAGE_HEIGHT = 100, SCROLL_SPEED = 2000; 
    public String skinn="img/c.png";
    private String[] Sk = {"img/c1.png","img/c.png","img/c2.png","img/c3.png","img/cc.png"};
    private ArrayList<Skin> images = new ArrayList<>();
    private Timer timer;
    private JButton actionButton, home, play,l1,l2,l3,l4,l5,resetButton;
    private static JButton[] buttons = new JButton[5];
    private BufferedImage backgroundImage;
    public int selez=1, x=1;
    public boolean SonoH=true;
    public Level1 Level1 = new Level1("3/terra.png", skinn);

    // pannello di scroll infinito 
    public InfiniteScrollPane() {

        loadImages();

        // movimento con clic
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                if (x < getWidth() / 2) {
                    currentImageIndex = (currentImageIndex - 1 + NUMBER_OF_IMAGES) % NUMBER_OF_IMAGES;
                } else {
                    currentImageIndex = (currentImageIndex + 1 ) % NUMBER_OF_IMAGES;
                }
                updateActionButton();
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                timer.stop();
            }
        });
        
        // movimento con frecce
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_LEFT) {
                    currentImageIndex = (currentImageIndex - 1 + NUMBER_OF_IMAGES) % NUMBER_OF_IMAGES;
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    currentImageIndex = (currentImageIndex + 1) % NUMBER_OF_IMAGES;
                }
                updateActionButton();
                repaint();
            }
        });
        setFocusable(true);

        // actionbutton
        actionButton = new JButton();
        actionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x;
                if(currentImageIndex == 4){x=0;}else{x=currentImageIndex+1;}

                if(images.get(x).getHo()) {
                    System.out.println("Selezionato");
                    skinn = Sk[x];
                    updateActionButton();
                    add(actionButton);
                    selez=currentImageIndex+1;
                } else {
                    updateActionButton();
                    add(actionButton);
                    if (portafoglio >= images.get(x).getPrezzo()) {
                        System.out.println("Acquistato");
                        portafoglio -= images.get(x).getPrezzo();
                        images.get(x).setHo(true);
                        updateActionButton();
                        add(actionButton);
                    } else {
                        System.out.println("Non hai abbastanza denaro");
                        updateActionButton();
                        add(actionButton);
                    }
                }
                System.out.println("nel portafoglio ti restano " + portafoglio);
                repaint();
            }
        });
        if(SonoH==false){
            updateHome();
            add(home);
            repaint();
        }

        // home
        home = new JButton();
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(SonoH==true){
                    SonoH=false;
                    System.out.println("false");
                }else{
                    SonoH=true;
                    System.out.println("true");
                }
                updateHome();
                add(home);
                repaint();
            }
        });
        updateHome();
        add(home);
        repaint();

        // play
        play = new JButton();
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePlay();
                add(play);
                System.out.println("PLAY "+x);
                start=x;
            }
        });
        if(SonoH==true){
            updatePlay();
            add(play);
            repaint();
        }

        //l1
        l1 = new JButton();
        l1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("1");
                x=1;
            }
        });
        if(SonoH==true){
            updatel(1);
            add(l1);
            repaint();
        }

        //l2
        l2 = new JButton();
        l2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("2");
                x=2;
            }
        });
        if(SonoH==true){
            updatel(2);
            add(l2);
            repaint();
        }

        //l3
        l3 = new JButton();
        l3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("3");
                x=3;
            }
        });
        if(SonoH==true){
            updatel(3);
            add(l3);
            repaint();
        }

        //l4
        l4 = new JButton();
        l4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("4");
                x=4;
            }
        });
        if(SonoH==true){
            updatel(4);
            add(l4);
            repaint();
        }

        //l5
        l5 = new JButton();
        l5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("5");
                x=5;
            }
        });
        if(SonoH==true){
            updatel(5);
            add(l5);
            repaint();
        }
    }

    // stampa actionbutton
    private void updateActionButton() {
        ImageIcon buy = new ImageIcon("img/buy.png");
        ImageIcon sel = new ImageIcon("img/seleziona.png");
        int x = (currentImageIndex + 1) % NUMBER_OF_IMAGES;
        if (images.get(x).getHo()) {
            actionButton.setIcon(sel);
            actionButton.setOpaque(false);
            actionButton.setContentAreaFilled(false);
            actionButton.setBorderPainted(false);
            actionButton.setPreferredSize(new Dimension(sel.getIconWidth(), sel.getIconHeight()));
            actionButton.setLocation(445, 500);
        } else {
            actionButton.setIcon(buy);
            actionButton.setOpaque(false);
            actionButton.setContentAreaFilled(false);
            actionButton.setBorderPainted(false);
            actionButton.setPreferredSize(new Dimension(buy.getIconWidth(), buy.getIconHeight()));
            actionButton.setLocation(508, 500);
        }
    }

    // stampa home
    private void updateHome() {
        ImageIcon Home;
        if(start==0){
            if(SonoH==true){ Home = new ImageIcon("img/shop.png");} 
            else{ Home = new ImageIcon("img/home.png");}
        } else{
            Home = new ImageIcon("img/pausa.png");
        }
        Image casa = Home.getImage();
        Image newcasa = casa.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newHome = new ImageIcon(newcasa);
        home.setIcon(newHome);
        home.setOpaque(false);
        home.setContentAreaFilled(false);
        home.setBorderPainted(false);
        home.setPreferredSize(new Dimension(newHome.getIconWidth(), newHome.getIconHeight()));
        home.setLocation(10, 10);
    }

    // stampa Play
    private void updatePlay() {
        ImageIcon Play = new ImageIcon("img/play.png");
        play.setIcon(Play);
        play.setOpaque(false);
        play.setContentAreaFilled(false);
        play.setBorderPainted(false);
        play.setPreferredSize(new Dimension(Play.getIconWidth(), Play.getIconHeight()));
        play.setLocation(400, 100);
    }

    // stampa l
    private void updatel(int i) {
        ImageIcon L = new ImageIcon("img/l" + i + ".png");
        ImageIcon L1 = new ImageIcon("img/l1.png");
        if(i==1){
            l1.setIcon(L);
            l1.setOpaque(false);
            l1.setContentAreaFilled(false);
            l1.setBorderPainted(false);
            l1.setPreferredSize(new Dimension(L1.getIconWidth(), L1.getIconHeight()));
            l1.setLocation(110, 550);
        }
        if(i==2){
            l2.setIcon(L);
            l2.setOpaque(false);
            l2.setContentAreaFilled(false);
            l2.setBorderPainted(false);
            l2.setPreferredSize(new Dimension(L1.getIconWidth(), L1.getIconHeight()));
            l2.setLocation(325, 550);
        }
        if(i==3){
            l3.setIcon(L);
            l3.setOpaque(false);
            l3.setContentAreaFilled(false);
            l3.setBorderPainted(false);
            l3.setPreferredSize(new Dimension(L1.getIconWidth(), L1.getIconHeight()));
            l3.setLocation(535, 550);
        }
        if(i==4){
            l4.setIcon(L);
            l4.setOpaque(false);
            l4.setContentAreaFilled(false);
            l4.setBorderPainted(false);
            l4.setPreferredSize(new Dimension(L1.getIconWidth(), L1.getIconHeight()));
            l4.setLocation(735, 550);
        }
        if(i==5){
            l5.setIcon(L);
            l5.setOpaque(false);
            l5.setContentAreaFilled(false);
            l5.setBorderPainted(false);
            l5.setPreferredSize(new Dimension(L1.getIconWidth(), L1.getIconHeight()));
            l5.setLocation(935, 550);
        }
    }

    // carica skin
    private void loadImages() {
        images.add(new Skin(new ImageIcon("img/c1.png").getImage(), 1000, false));
        images.add(new Skin(new ImageIcon("img/c.png").getImage(), 200, true));
        images.add(new Skin(new ImageIcon("img/c2.png").getImage(), 500, false));
        images.add(new Skin(new ImageIcon("img/c3.png").getImage(), 800, false));
        images.add(new Skin(new ImageIcon("img/cc.png").getImage(), 300, false));
    }

    // stampa
    @Override
    protected void paintComponent(Graphics g2) {
        super.paintComponent(g2);
        BufferedImage[] numberImages = new BufferedImage[10];
        BufferedImage coin = null, sele = null, str = null;

        if (start==0){
            try {
                backgroundImage = ImageIO.read(new File("img/sfondo.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            g2.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

            updateHome();
            add(home);
            
            try {
            coin = ImageIO.read(new File("img/c.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                for (int i = 0; i < 10; i++) {
                numberImages[i] = ImageIO.read(new File( "img/" + i + ".png"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            String number = Integer.toString(portafoglio);
            int x = 1000;
            for (int y = 0; y < number.length(); y++) {
                int n = Character.getNumericValue(number.charAt(y));
                g2.drawImage(numberImages[n], x, 10, 35, 50, null);
                x += 35;
            }
            g2.drawImage(coin, x, 10, 49, 49, null);
            if(!SonoH){
                remove(play);
                revalidate();
                repaint();
                
                remove(l1);
                revalidate();
                repaint();

                remove(l2);
                revalidate();
                repaint();

                remove(l3);
                revalidate();
                repaint();

                remove(l4);
                revalidate();
                repaint();

                remove(l5);
                revalidate();
                repaint();

                int offset = 355;
                for (int i = 0; i < DISPLAYED_IMAGES; i++) {
                    int index = (currentImageIndex + i) % NUMBER_OF_IMAGES;
                    Image image = images.get(index).getImage();
                    if (i == 1) {
                        InfiniteScrollPane infiniteScrollPane = new InfiniteScrollPane();
                        updateActionButton();
                        add(actionButton);

                        g2.drawImage(image, i * IMAGE_WIDTH + offset, 300, IMAGE_WIDTH + 50, IMAGE_HEIGHT + 50, null);

                        if (images.get(index).getHo()) {
                            if(selez == 5){selez = 0;}
                            if(selez != 10 && selez == index)
                            {
                                try {
                                sele = ImageIO.read(new File("img/a2.png"));
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }else{
                                try {
                                sele = ImageIO.read(new File("img/a.png"));
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            g2.drawImage(sele, IMAGE_WIDTH + 480, IMAGE_HEIGHT + 343, 45, 45, null);
                        } else {
                            String numberr = Integer.toString(images.get(index).getPrezzo());
                            int x1 = IMAGE_WIDTH + 465;
                            if(images.get(index).getPrezzo()<1000){x1 += 14;}

                            for (int y = 0; y < numberr.length(); y++) {
                                int n = Character.getNumericValue(numberr.charAt(y));
                                g2.drawImage(numberImages[n], x1, IMAGE_HEIGHT + 350, 14, 20, null);
                                repaint();
                                x1 += 14;
                            }
                            g2.drawImage(coin, x1, IMAGE_HEIGHT + 350, 19, 19, null);
                        }
                    } else {
                        g2.drawImage(image, i * IMAGE_WIDTH +25 + offset, 350, IMAGE_WIDTH, IMAGE_HEIGHT, null);
                    }

                    offset += 70;
                }
            }else{
                try {
                    str = ImageIO.read(new File("img/l.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                g2.drawImage(str, 100, 540, 1000, 100, this);

                updatel(1);
                add(l1);
                repaint();

                updatel(2);
                add(l2);
                repaint();

                updatel(3);
                add(l3);
                repaint();

                updatel(4);
                add(l4);
                repaint();

                updatel(5);
                add(l5);
                repaint();

                updatePlay();
                add(play);
                remove(actionButton);
                revalidate(); 
                repaint();
            }
        }
        else if(start>=1 && start<=5){

            if(ciclo==0){
                ciclo++;
                remove(play);
                revalidate();
                repaint();
                
                remove(l1);
                revalidate();
                repaint();

                remove(l2);
                revalidate();
                repaint();

                remove(l3);
                revalidate();
                repaint();

                remove(l4);
                revalidate();
                repaint();

                remove(l5);
                revalidate();
                repaint();

                remove(home);
                revalidate();
                repaint();

                Level1 = new Level1("3/terra.png",skinn);
                Level1.start();
                Level1.setPortafoglio(portafoglio);
            }

            Level1.setSize(1200, 700);
            Level1.setLocation(0,0);
            portafoglio=Level1.getPortafoglio();
            start=Level1.getHome();
            Level1.requestFocus();
            add(Level1);

            if(Level1.getHp()){
                Level1.setHp(false);
                remove(Level1);
                revalidate();
                repaint();
                start=0;
                ciclo=0;
            }
        /*
        }else if(start==2){
            
        }else if(start==3){
            
        }else if(start==4){
            
        }else if(start==5){
        */
            
        }
    }

    // Main
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1200, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InfiniteScrollPane infiniteScrollPane = new InfiniteScrollPane();
        frame.add(infiniteScrollPane);
        frame.setResizable(false);
        frame.pack();
        frame.setSize(1200, 700);
        frame.setVisible(true);
    }

}