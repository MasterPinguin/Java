/*
1) Creare in una classe Automobile, avente come attributi la cilindrata, la marca, 
il colore e il motoreacceso (boolean):

 
- il metodo costruttore

- il metodo messaInMoto che deﬁnisce in modo sommario l’accensione del motore dell’automobile

 

2)  creare una nuova classe contenente il metodo main, chiamata UsaAutomobile, il cui codice contiene 
l’istanza della classe mediante costruttore al quale vengono passati quattro parametri, l’uso dell’oggetto 
fiat500 e del relativo metodo messaInMoto().


3) aggiungere il metodo spegni() in grado di spegnere il motore dell’auto e visualizzarne lo stato

4) modiﬁca il codice sorgente modiﬁcando gli attributi di classi: aggiungi l’attributo serbatoio 
e capienzaMassima

5) aggiungi quindi un metodo faiIlPieno() in grado di effettuare il pieno dei litri passati come parametro,   
visualizzando quanti litri ci sono ancora nel serbatoio e se abbiamo superato il limite di capienza massima.

Usare l'operatore this.
*/
import java.util.Scanner;
import java.lang.Math;

class Automobile
{
    // attributi
    int serbatoio, capienzaMassima, y;
    String cilindrata, marca, colore, x;
    boolean motoreacceso=false;

    // costruttore
    public Automobile(String cilindrata, String marca, String colore, int serbatoio, int capienzaMassima)
    {
        this.cilindrata=cilindrata;
        this.marca=marca;
        this.colore=colore;
        this.serbatoio=serbatoio;
        this.capienzaMassima=capienzaMassima;
    }
    
    // metodo
    public boolean messaInMoto()
    {
        return (motoreacceso=true);
    }
    
    // metodo1
    public boolean spegni()
    {
        return (motoreacceso=false);
    }
    
    // metodo2
    public String faiIlPieno(int litri)
    {
        y=serbatoio+litri;
        if(y>capienzaMassima)
        {
            x=Integer.toString(y-capienzaMassima);
            return (" il serbatoio ha superato la capienza massima di " + x);
        }
        else
        {
            return (" il serbatoio è stato riempito con successo ");
        }
    }
}

 // ContoCorrente
public class Main
{
    public static void main(String argv[])
    {
        int serbatoio, capienzaMassima, y, y2, litri;
        String cilindrata, marca, colore;
        boolean motoreacceso;
        
        Scanner k = new Scanner(System.in);
        
        System.out.println("Inserisci la cilindrata: ");
        cilindrata = k.nextLine();
        
        System.out.println("Inserisci la marca: ");
        marca = k.nextLine();
        
        System.out.println("Inserisci il colore: ");
        colore = k.nextLine();
    
        System.out.println("Inserisci quanto contiene il serbatoio: ");
        serbatoio = k.nextInt();
        
        System.out.println("Inserisci la capienza massima del serbatoio: ");
        capienzaMassima = k.nextInt();
        
        System.out.println(" ");
        
        // dichiarazione dellgli oggetti
        Automobile a;
        
        // instanziare  l'oggetto
        a = new Automobile(cilindrata, marca, colore, serbatoio, capienzaMassima);
        
        // creazione dell'istanza
        
        do
        {
            System.out.println("Inserisci 1 per accendere l'Automobile e 2 se vuoi lasciarla spenta: ");
            y = k.nextInt();
            System.out.println(" ");
        }
        while(y<1 || y>2);
        if(y==1)
        {
            System.out.println("la tua automobile ora è in moto: " + a.messaInMoto());
            do
            {
                System.out.println("Inserisci 1 per spegnere l'Automobile e 2 se vuoi lasciarla accesa: ");
                y2 = k.nextInt();
            }
            while(y2<1 || y2>2);
            if(y2==1)
            {
                System.out.println("la tua automobile ora è in moto: " + a.spegni());
            }
            else
            {
                System.out.println("la tua automobile è rimasta accesa: ");
            }
        }
        else
        {
            System.out.println("la tua automobile è rimasta spenta: ");
        }
        
        System.out.println(" ");
        
        System.out.println("Inserisci quanto vuoi mettere per il pieno: ");
        litri = k.nextInt();
        System.out.println(" : " + a.faiIlPieno(litri) );
        
        System.out.println(" ");
        System.out.println(" ora sei pronto per andare a gardaland");
        
    }
}
