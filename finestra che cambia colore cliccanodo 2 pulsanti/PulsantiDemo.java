//Pulsanti Demo

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Un semplice esempio dell'uso di pulsanti in un JFrame.
 */
public class PulsantiDemo extends JFrame implements ActionListener {
    public static final int LARGHEZZA = 300;
    public static final int ALTEZZA = 200;

    public PulsantiDemo() {
        setSize(LARGHEZZA, ALTEZZA);

        addWindowListener(new DistruttoreFinestra());
        setTitle("Esempio pulsanti");
        Container pannello = getContentPane();
        pannello.setBackground(Color.BLUE);

        setLayout(new FlowLayout());

        JButton pulsanteStop = new JButton("Rosso");
        pulsanteStop.addActionListener(this);
        add(pulsanteStop);

        JButton pulsanteVia = new JButton("Verde");
        pulsanteVia.addActionListener(this);
        add(pulsanteVia);        
    }

    public void actionPerformed(ActionEvent e) {
        Container pannello = getContentPane();

        if (e.getActionCommand().equals("Rosso"))
            pannello.setBackground(Color.RED);
        else if (e.getActionCommand().equals("Verde"))
            pannello.setBackground(Color.GREEN);
        else
            System.out.println("Errore nell'interfaccia.");
    }

    /*Crea e visualizza una finestra della classe EsempioPulsanti.*/
    public static void main(String args[]) {
        PulsantiDemo gui = new PulsantiDemo();
        gui.setVisible(true);
    }
}