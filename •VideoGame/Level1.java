import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Random;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.*;


public class Level1 extends JPanel implements Runnable {

    private BufferedImage image=null, player=null, backgroundImage, coin = null, cielo = null, sole = null, gover=null, cu = null , cuo = null;
    private BufferedImage[] numberImages = new BufferedImage[10];
    private int imageWidth, X = 0, y=495, portafoglio = 0, Xx=-50, o=0, O=0, k=0, w=2100 , K=0, w1=700, K2=0, W=1400, G=0, h, O1=0, H, Gg = 4000, Oo1=0, C=0, imageWidthS, imageWidthC, life=3,var=110, home=1, pino=0, pip;
    private Thread thread;
    private boolean running = false, isMoving, k1=false, Hp=false;
    private JButton homee,rest,rest1;
    public boolean P=false;
    private int randomNumber = 900;

    public Level1(String imagePath, String skinn) {

        Xx=-50;
        w=3100;
        w1=1700; 
        W=2400; 
        G=3700; 
        Gg=4700;
        life=3;
        Random random = new Random();
        O1 = random.nextInt(12);
        Oo1 = random.nextInt(12); 

        try {
            image = ImageIO.read(getClass().getResource(imagePath));
            imageWidth = image.getWidth();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            player = ImageIO.read(getClass().getResource(skinn));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            backgroundImage = ImageIO.read(new File("img/sfondo.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
        coin = ImageIO.read(new File("img/c.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
        gover = ImageIO.read(new File("img/gay.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            cielo = ImageIO.read(new File("3/nuvole.png"));
            imageWidthC = cielo.getWidth();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            sole = ImageIO.read(new File("3/sole.png"));
            imageWidthS = sole.getWidth();
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

        try {
            cu = ImageIO.read(new File( "img/qu.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            cuo = ImageIO.read(new File( "img/quo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!isMoving && running) {
                    isMoving = true;
                    k1=false;

                    try {
                        File file = new File("suoni/salto.wav");
                        AudioInputStream stream = AudioSystem.getAudioInputStream(file);
                        Clip clip = AudioSystem.getClip();
                        clip.open(stream);
                        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                        gainControl.setValue(-6.0206f); // Imposta il volume al 50%
                        clip.start();
                    } catch (UnsupportedAudioFileException ee) {
                        System.out.println("Unsupported audio file format: " + ee.getMessage());
                    } catch (IOException ee) {
                        System.out.println("Error reading audio file: " + ee.getMessage());
                    } catch (LineUnavailableException ee) {
                        System.out.println("Line unavailable: " + ee.getMessage());
                    }
                }
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_UP) {
                    if (!isMoving && running) {
                        isMoving = true;
                        k1=false;

                        try {
                            File file = new File("suoni/salto.wav");
                            AudioInputStream stream = AudioSystem.getAudioInputStream(file);
                            Clip clip = AudioSystem.getClip();
                            clip.open(stream);
                            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                            gainControl.setValue(-6.0206f); // Imposta il volume al 50%
                            clip.start();
                        } catch (UnsupportedAudioFileException ee) {
                            System.out.println("Unsupported audio file format: " + ee.getMessage());
                        } catch (IOException ee) {
                            System.out.println("Error reading audio file: " + ee.getMessage());
                        } catch (LineUnavailableException ee) {
                            System.out.println("Line unavailable: " + ee.getMessage());
                        }
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    if(!running){
                        start();
                        P=false;
                    }
                }
            }
        });
        setFocusable(true);

        // homee
        homee = new JButton();
        homee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(running){
                    if(!P){
                        P=true;
                        stop();
                    }else{
                        setVisible(false);
                        Hp=true;
                    }
                }else{
                    setVisible(false);
                    Hp=true;
                }
                update();
                add(homee);
                repaint();
            }
        });
        update();
        add(homee);
        homee.setBounds(120, 10, 100, 100);
        repaint();

        // rest
        rest = new JButton();
        rest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updater();
                add(rest);
                repaint();
                start();
                P=false;
            }
        });
        updater();
        add(rest);
        rest.setBounds(300, 300, 100, 100);
        repaint();


        // rest1
        rest1 = new JButton();
        rest1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updater1();
                add(rest1);
                repaint();
                start();
                Xx=-50;
                w=3100;
                w1=1700; 
                W=2400; 
                G=3700; 
                Gg=4700;
                life=3;
                Random random = new Random();
                O1 = random.nextInt(12);
                Oo1 = random.nextInt(12); 
                P=false;
            }
        });
        updater1();
        add(rest1);
        rest1.setBounds(300, 300, 100, 100);
        repaint();
    }

    // stampa home
    private void update() {
        ImageIcon Homee;
        if(!running){ Homee = new ImageIcon("img/home.png");}
        else if(!P){ Homee = new ImageIcon("img/pausa.png");} 
        else{ Homee = new ImageIcon("img/home.png");}
        Image casa = Homee.getImage();
        Image newcasa = casa.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newHome = new ImageIcon(newcasa);
        homee.setIcon(newHome);
        homee.setOpaque(false);
        homee.setContentAreaFilled(false);
        homee.setBorderPainted(false);
        homee.setPreferredSize(new Dimension(newHome.getIconWidth(), newHome.getIconHeight()));
        homee.setLocation(10, 10);
    }

    // stampa rest
    private void updater() {
        ImageIcon res;
        if(P){ res = new ImageIcon("img/riprendi .png");} 
        else{ res = new ImageIcon("img/Replay.png");}
        Image ca = res.getImage();
        Image newca = ca.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newH = new ImageIcon(newca);
        rest.setIcon(newH);
        rest.setOpaque(false);
        rest.setContentAreaFilled(false);
        rest.setBorderPainted(false);
        rest.setPreferredSize(new Dimension(newH.getIconWidth(), newH.getIconHeight()));
        if(P){ rest.setLocation(450, 300);} 
        else{ rest.setLocation(550, 400);}
    }

    // stampa rest1
    private void updater1() {
        ImageIcon ress = new ImageIcon("img/Replay.png");
        Image caa = ress.getImage();
        Image newcaa = caa.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newHa = new ImageIcon(newcaa);
        rest1.setIcon(newHa);
        rest1.setOpaque(false);
        rest1.setContentAreaFilled(false);
        rest1.setBorderPainted(false);
        rest1.setPreferredSize(new Dimension(newHa.getIconWidth(), newHa.getIconHeight()));
        rest1.setLocation(650, 300);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage coins = null, sfondo = null, sfondo1 = null, sfondo2 = null, ostacolo = null, ostacolo1 = null;
        Random random = new Random();

        if(pino==0){
            pip = random.nextInt(2)+1;
            try {
                File file = new File("suoni/suono"+pip+".wav");
                AudioInputStream stream = AudioSystem.getAudioInputStream(file);
                Clip clip = AudioSystem.getClip();
                clip.open(stream);
                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-15.0206f); // Imposta il volume al 50%
                clip.start();
                System.out.println("tua mamma");
            } catch (UnsupportedAudioFileException ee) {
                System.out.println("Unsupported audio file format: " + ee.getMessage());
            } catch (IOException ee) {
                System.out.println("Error reading audio file: " + ee.getMessage());
            } catch (LineUnavailableException ee) {
                System.out.println("Line unavailable: " + ee.getMessage());
            }
        }

        pino++;
        if(pino>=8000){pino=0;}

        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

        g.drawImage(sole, 200, 30, 200,200, null);
        
        g.drawImage(cielo, C, 10, null);
        if (C < imageWidthC) {
            g.drawImage(cielo, C + imageWidthC, 10, null);
        }
        if (C+imageWidthC < (imageWidthC+imageWidthC)) {
            g.drawImage(cielo, C + imageWidthC+imageWidthC, 10, null);
        }

        update();
        add(homee);

        int xx = 100;
        for (int i = 0; i < life && running; i++) {
            g.drawImage(cu, xx, 10, cu.getWidth(), cu.getHeight(), null);
            xx += 100;
        }
        if(life==1 && var<=100){
            g.drawImage(cuo, 200, 10, cuo.getWidth(), cuo.getHeight(), null);
        }else if(life==2 && var<=100){
            g.drawImage(cuo, 300, 10, cuo.getWidth(), cuo.getHeight(), null);
        }else if(life==3 && var<=100){
            g.drawImage(cuo, 400, 10, cuo.getWidth(), cuo.getHeight(), null);
        }
        var++;

        String number = Integer.toString(portafoglio);
        int x = 1000;
        for (int i = 0; i < number.length(); i++) {
            int n = Character.getNumericValue(number.charAt(i));
            g.drawImage(numberImages[n], x, 10, 35, 50, null);
            x += 35;
        }
        g.drawImage(coin, x, 10, 49, 49, null);

        if(w<=-300){
            k = random.nextInt(4);
            while(k<=K && k>=K+700 || k<=K2 && k>=K2+700){
                k = random.nextInt(4);
            }
            w = random.nextInt(501)+1200;
        }
        try {
            sfondo = ImageIO.read(new File("3/x"+k+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(sfondo, w, 550-sfondo.getHeight(), sfondo.getWidth(), sfondo.getHeight(), this);

        if(w1<=-300){
            K = random.nextInt(4);
            while(K<=k && K>=k+700 || K<=K2 && K>=K2+700){
                K = random.nextInt(4);
            }
            w1 = random.nextInt(501)+1200;
        }
        try {
            sfondo1 = ImageIO.read(new File("3/x"+K+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(sfondo1, w1, 550-sfondo1.getHeight(), sfondo1.getWidth(), sfondo1.getHeight(), this);

        if(W<=-300){
            K2 = random.nextInt(4);
            while(K2<=K && K2>=K+700|| K2<=k && K2>=k+700){
                K2 = random.nextInt(4);
            }
            W = random.nextInt(501)+1200;
        }
        try {
            sfondo2 = ImageIO.read(new File("3/x"+K2+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(sfondo2, W, 550-sfondo2.getHeight(), sfondo2.getWidth(), sfondo2.getHeight(), this);
        

        g.drawImage(image, X, 315, null);
        if (X < getWidth()) {
            g.drawImage(image, X + imageWidth, 315, null);
        }
        
        g.drawImage(player, 200 , y, null);

        if (isMoving) {
            try {
                Thread.sleep(6);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            if(!k1){ 
                y -= 11; 
                if(y<=340){ k1=true; }
            }
            if(k1){
                y += 11;
                if(y>=495){isMoving=false;}
            }
        }

        if (Xx <= -50 || (y>=360 && y<=410) && (Xx<=230 && Xx>=160)) {
            if((y>=360 && y<=410) && (Xx<=230 && Xx>=160)){
                portafoglio += 10;
                try {
                    File file = new File("suoni/salto.wav");
                    AudioInputStream stream = AudioSystem.getAudioInputStream(file);
                    Clip clip = AudioSystem.getClip();
                    clip.open(stream);
                    FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                    gainControl.setValue(-6.0206f); // Imposta il volume al 50%
                    clip.start();
                } catch (UnsupportedAudioFileException ee) {
                    System.out.println("Unsupported audio file format: " + ee.getMessage());
                } catch (IOException ee) {
                    System.out.println("Error reading audio file: " + ee.getMessage());
                } catch (LineUnavailableException ee) {
                    System.out.println("Line unavailable: " + ee.getMessage());
                }
            }
            Xx = random.nextInt(1200) + 2000;
        }
        o++;
        if(o==48){o = 0;}
        if(o%8==0){O = o/8;}
        try {
            coins = ImageIO.read(new File("img/Cc"+ O +".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(coins, Xx , 410, 49, 49, null);


        try {
            ostacolo = ImageIO.read(new File("3/z"+ O1 +".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(O1==6 || O1==2){
            h=570-ostacolo.getHeight()-15;
        }else{
            h=570-ostacolo.getHeight();
        }
        if(O1==7){
            H=230-ostacolo.getWidth()-15;
        }else if(O1==4){
            H=230-ostacolo.getWidth()-25;
        }else if(O1==3){
            H=230-ostacolo.getWidth()-30;
        }else{
            H=230-ostacolo.getWidth()-20;
        }
        if (G <= -300 || (y>=h && y<=570) && (G>=H && G<=230)) {
            if((y>=h && y<=570) && (G>=H && G<=230)){
                G=-300;
                life--;
                var=0;
                try {
                    File file = new File("suoni/salto.wav");
                    AudioInputStream stream = AudioSystem.getAudioInputStream(file);
                    Clip clip = AudioSystem.getClip();
                    clip.open(stream);
                    FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                    gainControl.setValue(-6.0206f); // Imposta il volume al 50%
                    clip.start();
                } catch (UnsupportedAudioFileException ee) {
                    System.out.println("Unsupported audio file format: " + ee.getMessage());
                } catch (IOException ee) {
                    System.out.println("Error reading audio file: " + ee.getMessage());
                } catch (LineUnavailableException ee) {
                    System.out.println("Line unavailable: " + ee.getMessage());
                }
                if(life==0){
                    stop();
                    Xx=-50;
                    w=3100;
                    w1=1700; 
                    W=2400; 
                    G=3700; 
                    Gg=4700;
                    life=3;
                    O1 = random.nextInt(12);
                    Oo1 = random.nextInt(12); 
                    try {
                        File file = new File("suoni/salto.wav");
                        AudioInputStream stream = AudioSystem.getAudioInputStream(file);
                        Clip clip = AudioSystem.getClip();
                        clip.open(stream);
                        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                        gainControl.setValue(-6.0206f); // Imposta il volume al 50%
                        clip.start();
                    } catch (UnsupportedAudioFileException ee) {
                        System.out.println("Unsupported audio file format: " + ee.getMessage());
                    } catch (IOException ee) {
                        System.out.println("Error reading audio file: " + ee.getMessage());
                    } catch (LineUnavailableException ee) {
                        System.out.println("Line unavailable: " + ee.getMessage());
                    }
                }
            }
            else{
                G = random.nextInt(1000) + 2000;
                O1 = random.nextInt(12);
                while(Gg>=G-500 && Gg<=G+500){
                    G = random.nextInt(1000) + 2000;
                }
            }
            
        }
        g.drawImage(ostacolo, G , h, ostacolo.getWidth(), ostacolo.getHeight(), null);
        
        try {
            ostacolo1 = ImageIO.read(new File("3/z"+ Oo1 +".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(Oo1==6 || Oo1==2){
            h=570-ostacolo1.getHeight()-15;
        }else{
            h=570-ostacolo1.getHeight();
        }
        if(Oo1==7){
            H=230-ostacolo1.getWidth()-15;
        }else if(Oo1==4){
            H=230-ostacolo1.getWidth()-25;
        }else if(Oo1==3){
            H=230-ostacolo1.getWidth()-30;
        }else {
            H=230-ostacolo1.getWidth()-20;
        }
        if (Gg <= -300 || (y>=h && y<=570) && (Gg>=H && Gg<=230)) {
            if((y>=h && y<=570) && (Gg>=H && Gg<=230)){
                life--;
                Gg=-300;
                var=0;
                try {
                    File file = new File("suoni/salto.wav");
                    AudioInputStream stream = AudioSystem.getAudioInputStream(file);
                    Clip clip = AudioSystem.getClip();
                    clip.open(stream);
                    FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                    gainControl.setValue(-6.0206f); // Imposta il volume al 50%
                    clip.start();
                } catch (UnsupportedAudioFileException ee) {
                    System.out.println("Unsupported audio file format: " + ee.getMessage());
                } catch (IOException ee) {
                    System.out.println("Error reading audio file: " + ee.getMessage());
                } catch (LineUnavailableException ee) {
                    System.out.println("Line unavailable: " + ee.getMessage());
                }
                if(life==0){
                    stop();
                    Xx=-50;
                    w=3100;
                    w1=1700; 
                    W=2400; 
                    G=3700; 
                    Gg=4700;
                    life=3;
                    O1 = random.nextInt(12);
                    Oo1 = random.nextInt(12);
                    try {
                        File file = new File("suoni/salto.wav");
                        AudioInputStream stream = AudioSystem.getAudioInputStream(file);
                        Clip clip = AudioSystem.getClip();
                        clip.open(stream);
                        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                        gainControl.setValue(-6.0206f); // Imposta il volume al 50%
                        clip.start();
                    } catch (UnsupportedAudioFileException ee) {
                        System.out.println("Unsupported audio file format: " + ee.getMessage());
                    } catch (IOException ee) {
                        System.out.println("Error reading audio file: " + ee.getMessage());
                    } catch (LineUnavailableException ee) {
                        System.out.println("Line unavailable: " + ee.getMessage());
                    }
                }
            }
            else{
                Gg = random.nextInt(1000) + 2000;
                Oo1 = random.nextInt(12);
                while(G>=Gg-500 && G<=Gg+500){
                    Gg = random.nextInt(1000) + 2000;
                }
            }
            
        }
        g.drawImage(ostacolo1, Gg , h, ostacolo1.getWidth(), ostacolo1.getHeight(), null);
        
        if(!running && !P){
            g.drawImage(gover, -30 , 100, gover.getWidth()-700, gover.getHeight()-200, null);
            var=110;
            updater();
            add(rest);
            repaint();
        }else if(P){
            updater();
            add(rest);
            repaint();

            updater1();
            add(rest1);
            repaint();

        }else{
            remove(rest);
            revalidate();
            repaint();

            remove(rest1);
            revalidate();
            repaint();
        }
    }

    public void start() {
        if (!running) {
            thread = new Thread(this);
            thread.start();
            running = true;
        }
    }

    public void stop() {
        if (running) {
            thread.interrupt();
            running = false;
        }
    }

    public int getHome() {
        return home;
    }

    public boolean getHp() {
        return Hp;
    }

    public void setHp(boolean Hp) {
        this.Hp=Hp;
    }
//
    public boolean getisMoving() {
        return isMoving;
    }

    public void setisMoving(boolean isMoving) {
        this.isMoving=isMoving;
    }
//
    public boolean getrunning() {
        return running;
    }
//
    public void setk1(boolean k1) {
        this.k1=k1;
    }
//
    public void setP(boolean P) {
        this.P=P;
    }
//
    public void setPortafoglio(int portafoglio) {
        this.portafoglio=portafoglio;
    }

    public int getPortafoglio() {
        return portafoglio;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            X -= 4;
            Xx -= 4;
            G -= 4;
            Gg -= 4;
            w -= 2;
            w1 -= 2;
            W -= 2;
            C -= 1;
            if (X <= -imageWidth) {
                X = 0;
            }
            repaint();
            if (C <= -imageWidthC) {
                C = 0;
            }
            repaint();
            try {
                Thread.sleep(6);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
    //*
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 700);
        Level1 Level1 = new Level1("3/terra.png","img/c1.png");
        frame.add(Level1);
        frame.setResizable(false);
        frame.setVisible(true);
        Level1.start();
    }
    //*/
}