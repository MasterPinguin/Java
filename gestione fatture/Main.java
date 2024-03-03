/*
Realizzare un programma per gestire la fatturazione, addebitando le fatture ai clienti

e accreditando i pagamenti ricevuti.

Il problema richiede la descrizione di un sistema di fatturazione che limiteremo al caso di

emissione della fattura ad un cliente per un solo prodotto.Le entità rilevanti per questa

descrizione sono il Cliente e la Fattura. I clienti sono descritti con i loro dati anagrafici e 
il saldodei loro pagamenti. Il saldo aumenta se al cliente viene addebitata una fattura, al contrario

diminuisce se il cliente esegue un pagamento. La fattura è intestata ad un cliente e contiene la

descrizione del prodotto, la quantità e il prezzo unitario. Il totale della fattura viene calcolata 
sommando l'imponibile (prezzo unitario * quantità) e l'imposta (imponibile * aliquota IVA).
*/
import java.util.Scanner;
import java.lang.Math;

class Cliente
{
    // attributi
    int partitaIva;
    String nome;
    double saldo;

    // costruttore
    public Cliente(String nome, int partitaIva, double saldo)
    {
        this.nome=nome;
        this.partitaIva=partitaIva;
        this.saldo=saldo;
    }
    
    // metodo
    public void addebita(double x)
    {
        saldo=saldo+x;
    }
    
    // metodo
    public void paga(double x)
    {
        saldo=saldo-x;
    }
    
    // metodo2
    public void stampaSituazione()
    {
        System.out.println("il tuo addebitato è di: "+ saldo);
    }
}

class Fattura
{
    // attributi
    int quantita;
    String destinatario, descrizione;
    double prezzoUnitario;

    // costruttore
    public Fattura(String descrizione, String destinatario, int quantita, double prezzoUnitario)
    {
        this.descrizione=descrizione;
        this.destinatario=destinatario;
        this.quantita=quantita;
        this.prezzoUnitario=prezzoUnitario;
    }
    
    // metodo
    public double calcolaImponibile()
    {
        return (prezzoUnitario*quantita);
    }
    
    // metodo1
    public double calcolaImposta()
    {
        return (calcolaImponibile()*0.22);
    }
    
    // metodo1
    public double totaleFattura()
    {
        return (calcolaImposta()+calcolaImponibile());
    }
    
    // metodo2
    public void emettiFattura()
    {
        System.out.println("l'imponibile è di: "+ calcolaImponibile());
        System.out.println("l'imposta è di: "+ calcolaImposta());
        System.out.println("la fattura è di: "+ totaleFattura());
    }
}

 // ContoCorrente
public class Main
{
    public static void main(String argv[])
    {
        int quantita, partitaIva=0, y, y2;
        String destinatario, descrizione, nome;
        double prezzoUnitario, saldo=0;
        
        Scanner k = new Scanner(System.in);
        
        System.out.println("Inserisci il nome: ");
        nome = k.nextLine();
        
        do
        {
            System.out.println("Inserisci 1 se hai la partitaIva e 2 se non ce l'hai: ");
            y = k.nextInt();
        }
        while(y<1 || y>2);
        if(y==1)
        {
            System.out.println("Inserisci la percentuale di sconto che applichi con la partitaIva: ");
            partitaIva = k.nextInt();
        }
        
        System.out.println(" ");
        
        // dichiarazione dellgli oggetti
        Cliente a;
        
        // instanziare  l'oggetto
        a = new Cliente( nome, partitaIva, saldo);
        
        // creazione dell'istanza
        
        do
        {
            do
            {
                System.out.println("Inserisci 1 se vuoi acquistare qualcosa e 2 se non vuoi: ");
                y = k.nextInt();
            }
            while(y<1 || y>2);
            if(y==1)
            {
                do
                {
                    System.out.println("Inserisci 1 se il destinatario sei tu e 2 se no: ");
                    y2 = k.nextInt();
                }
                while(y2<1 || y2>2);
                if(y2==1)
                {
                    destinatario=nome;
                }
                else
                {
                    System.out.println("Inserisci il destinatario: ");
                    destinatario = k.nextLine();
                }
                
                System.out.println("Inserisci la descrizione del prodotto: ");
                descrizione = k.nextLine();
                
                
                System.out.println("Inserisci il numero di prodotti che vuoi acquistare: ");
                quantita = k.nextInt();
                
                System.out.println("Inserisci il prezzo unitario: ");
                prezzoUnitario = k.nextDouble();
                
                System.out.println(" ");
                
                // dichiarazione dellgli oggetti
                Fattura b;
        
                // instanziare  l'oggetto
                b = new Fattura(descrizione, destinatario, quantita, prezzoUnitario);
                
                b.emettiFattura();

                do
                {
                    System.out.println("Inserisci 1 se vuoi pagarlo adesso e 2 se non vuoi addebitarlo: ");
                    y2 = k.nextInt();
                }
                while(y2<1 || y2>2);
                if(y2==1)
                {
                    a.paga(b.totaleFattura());
                }
                else
                {
                    a.addebita(b.totaleFattura());
                }
                
                do
                {
                    System.out.println("Inserisci 1 se vuoi acquistare qualcos'altro e 2 se non vuoi: ");
                    y2 = k.nextInt();
                }
                while(y2<1 || y2>2);
            }
            else
            {
                y2=2;
            }
        }
        while(y2==1);
        
        
        System.out.println(" ");
        
        a.stampaSituazione();
        
        System.out.println(" ");
        System.out.println(" ora sei piu povero di prima ");
        
    }
}
