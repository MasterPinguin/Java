/*
Creare una classe per la gestione degli articoli chiamata Prodotto. 
Ciascun prodotto possiede un codice identiﬁcativo (di tipo intero), una descrizione (di tipo stringa), 
un prezzo (espresso in Euro, quindi di tipo reale), lo sconto applicato (in percentuale, quindi di tipo reale). Vogliamo realizzare i seguenti costruttori:

1.    un costruttore con tutte le variabili d’istanza;

2.    un costruttore senza il codice (assegnare codice -1);

3.    un costruttore senza prezzo e senza sconto (assegnare prezzo convenzionale 0 7 e sconto 0);

4.    un costruttore con soltanto la descrizione del prodotto.

Aggiungere inﬁne i metodi get() per l’accesso agli attributi.

Usare l'operatore this.
*/
import java.util.Scanner;
import java.lang.Math;

class Prodotto
{
    // attributi
    int codice=0;
    String descrizione;
    double prezzo=0, sconto=0;

    // costruttore
    public Prodotto(int codice, String descrizione, double prezzo, double sconto)
    {
        this.codice=codice;
        this.descrizione=descrizione;
        this.prezzo=prezzo;
        this.sconto=sconto;
    }
    
    // costruttore1
    public Prodotto()
    {
        this.codice=-1;
        this.descrizione="-1";
        this.prezzo=-1;
        this.sconto=-1;
    }
    
    // costruttore2
    public Prodotto(int codice, String descrizione)
    {
        this.codice=codice;
        this.descrizione=descrizione;
        this.prezzo=Math.floor(Math.random()*(7-0+1)+0);
        this.sconto=0;
    }
    
    // costruttore3
    public Prodotto(String descrizion)
    {
        this.descrizione=descrizione;
    }
    
    // metodo1
    public int getcodice()
    {
        return codice;
    }
    
    // metodo2
    public String getdescrizione()
    {
        return descrizione;
    }
    
    // metodo3
    public double getprezzo()
    {
        return prezzo;
    }
    
    // metodo4
    public double getsconto()
    {
        return sconto;
    }

}

 // ContoCorrente
public class Main
{
    public static void main(String argv[])
    {
        int codice, scelta;
        String descrizione;
        double prezzo, sconto;
        
        Scanner k = new Scanner(System.in);
        
        // dichiarazione dellgli oggetti
        Prodotto a;
        
        System.out.println("1) inserisci tutti i valori del prodotto: ");
        System.out.println("2) non inserisci nulla: ");
        System.out.println("3) Inserisci solo il codice e la descrizione del prodotto: ");
        System.out.println("4) Inserisci la descrizione del prodotto: ");
        
        System.out.println("Inserisci la tua scelta: ");
        scelta = k.nextInt();
        
        do
        {
            switch (scelta)
            {
            case 1:
                System.out.println("Inserisci il codice del prodotto: ");
                codice = k.nextInt();
            
                System.out.println("Inserisci la descrizione del prodotto: ");
                descrizione = k.nextLine();
                
                System.out.println("Inserisci il costo del prodotto: ");
                prezzo = k.nextDouble();
                
                System.out.println("Inserisci lo sconto del prodotto: ");
                sconto = k.nextDouble();
                
                System.out.println(" ");
                
                // instanziare  l'oggetto
                a = new Prodotto(codice, descrizione, prezzo, sconto);
                
                break;
    
            case 2:
                
                // instanziare  l'oggetto
                //a = new Prodotto();
                
                break;
    
            case 3:
                System.out.println("Inserisci il codice del prodotto: ");
                codice = k.nextInt();
            
                System.out.println("Inserisci la descrizione del prodotto: ");
                descrizione = k.nextLine();
                
                System.out.println(" ");
                break;
                
                // instanziare  l'oggetto
                //a = new Prodotto(codice, descrizione);
    
            case 4:
                System.out.println("Inserisci la descrizione del prodotto: ");
                descrizione = k.nextLine();
                
                System.out.println(" ");
                break;
                
                // instanziare  l'oggetto
                //a = new Prodotto(descrizione);
    
            default:
                System.out.println("Attenzione scelta sbagliata!!!!!");
            }
        }
        while(scelta>4 || scelta<1);
        
        // creazione dell'istanza
        System.out.print("Il prodotto scelto con codice: " + a.getcodice());
        System.out.println(" ha come descrizione: " + a.getdescrizione() );
        System.out.print(" con un prezzo di " + a.getprezzo() );
        System.out.print(" e l'applicazione di uno sconto di: " + a.getsconto() );
    }
}
