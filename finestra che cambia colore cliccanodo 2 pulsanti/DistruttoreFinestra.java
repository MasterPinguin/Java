//Distruttore di finestra

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Se si registra un oggetto di questa classe come ascoltatore
 * di un oggetto della classe JFrame, esso terminer� il
 * programma e chiuder� il JFrame quando l'utente preme
 * il pulsante di chiusura del JFrame.
 */
public class DistruttoreFinestra extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}