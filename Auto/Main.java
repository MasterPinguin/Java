/*
AUTOMOBILE
*/
import java.util.Scanner;
import java.lang.Math;

class Auto
{
    Scanner k = new Scanner(System.in);
    
    // attributi
    int numeroMarcia, giriMotore, velocita, X;
    String modello, V;
    boolean motoreAcceso=false , y;

    // costruttore
    public Auto(String modello, int numeroMarcia, int giriMotore)
    {
        this.modello=modello;
        this.numeroMarcia=numeroMarcia;
        this.giriMotore=giriMotore;
    }
    
    // metodo
    public String getAuto()
    {
        return ("Il modello dell'auto e':" + modello);
    }
    
    // metodo1
    public void accendiMotore()
    {
        motoreAcceso=true;
    }
    
    // metodo2
    public void spegniMotore()
    {
        motoreAcceso=false;
    }
    
    // metodo3
    public int accellera(int numeroGiriAumento)
    {
        giriMotore=giriMotore+numeroGiriAumento;
        velocita=((giriMotore*numeroMarcia)/100);
        //controlli
        if(velocita<=0 || motoreAcceso==false)
        {
            if(velocita<=0)
            {
                System.out.println(" attenzione l'auto ha decellerato fino a spegnersi ");
                spegniMotore();
            }
            if(motoreAcceso==false) 
            {
                y=false;
                do
                {
                    if(y==true) System.out.println(" attenzione scelta sbagliata!!!!!");
                    System.out.println(" attenzione l'auto era spenta vuoi accenderla? 1 per Si, 2 per No");
                    X = k.nextInt();
                    y=true;
                }while(X<1 || X>2);
                
                if(X==1) accendiMotore();
                
            }
        }
        if(motoreAcceso==true) return velocita;
        else return 0;
    }
    
    // metodo4
    public int decellera(int numeroGiriInMeno)
    {
        giriMotore=giriMotore-numeroGiriInMeno;
        velocita=((giriMotore*numeroMarcia)/100);
        //controlli
        if(velocita<=0 || motoreAcceso==false)
        {
            if(velocita<=0)
            {
                System.out.println(" attenzione l'auto ha decellerato fino a spegnersi ");
                spegniMotore();
            }
            if(motoreAcceso==false)
            {
                y=false;
                do
                {
                    if(y==true) System.out.println(" attenzione scelta sbagliata!!!!!");
                    System.out.println(" attenzione l'auto era spenta vuoi accenderla? 1 per Si, 2 per No");
                    X = k.nextInt();
                    y=true;
                }while(X<1 || X>2);
                
                if(X==1) accendiMotore();
                
            }
        }
        if(motoreAcceso==true) return velocita;
        else return 0;
    }
    
    //metodo5
    public void cambiaMarcia (int nMarcia)
    {
        numeroMarcia=nMarcia;
    }
    
    //metodo6
    public int getVelocita()
    {
        return velocita;
    }
    
    //metodo7
    public int getMarcia()
    {
        return numeroMarcia;
    }
    
    //metodo8
    public int getGiri()
    {
        return giriMotore;
    }
    
}

 // ContoCorrente
public class Main
{
    public static void main(String argv[])
    {
        int numeroMarcia, giriMotore, velocita, scelta, x;
        String modello;
        boolean motoreAcceso, y;
        
        Scanner k = new Scanner(System.in);
        
        System.out.println("Inserisci il nome del modello dell'auto: ");
        modello = k.nextLine();
        
        y=false;
        do
        {
            if(y==true) System.out.println(" attenzione la marcia dell auto non puo superare questo limite!!!!!");
            System.out.println("Inserisci la marcia dell'auto: (valore compreso tra 0 e 6) ");
            numeroMarcia = k.nextInt();
            y=true;
        }while(numeroMarcia<0 || numeroMarcia>6);
        
        y=false;
        do
        {
            if(y==true) System.out.println(" attenzione i giri del motore non possono superare questo limite!!!!!");
            System.out.println("Inserisci il numero di giri del motore:  (valore compreso tra 0 e 5000)");
            giriMotore = k.nextInt();
            y=true;
        }while(giriMotore<0 || giriMotore>5000);
        
        // dichiarazione dellgli oggetti
        Auto a;
        
        // instanziare  l'oggetto
        a = new Auto(modello, numeroMarcia, giriMotore);
        
        do
        {
            System.out.println(" ");
            
            System.out.println("1) accendi motore ");
            System.out.println("2) spegni motore ");
            System.out.println("3) cambia marcia ");
            System.out.println("4) accelera ");
            System.out.println("5) decelera ");
            System.out.println("6) ESCI ");
            System.out.println(" ");
            
            System.out.println("Inserisci la tua scelta: ");
            scelta = k.nextInt();
            
            switch (scelta)
            {
            case 1:
                System.out.println(" Motore acceso!!!");
                a.accendiMotore();
                break;
    
            case 2:
                System.out.println(" Motore spento!!!");
                a.spegniMotore();
                break;
    
            case 3:
                System.out.println(" Hai scelto di cambiare la marcia!!!");
                y=false;
                do
                {
                    if(y==true) System.out.println(" attenzione la marcia dell auto non puo superare questo limite!!!!!");
                    System.out.println("Inserisci la marcia dell'auto: (valore compreso tra 0 e 6) ");
                    numeroMarcia = k.nextInt();
                    y=true;
                }while(numeroMarcia<0 || numeroMarcia>6);
                
                a.cambiaMarcia(numeroMarcia);
                break;
    
            case 4:
                
                System.out.println(" Hai scelto di accellerare !!!");
                
                y=false;
                do
                {
                    if(y==true) System.out.println(" attenzione non e' possibile cosi facendo superi il massimo di giri !!!!!");
                    System.out.println("Inserisci di quanto vuoi aumentare i giri:");
                    x = k.nextInt();
                    y=true;
                }while((numeroMarcia+x)<0 || (numeroMarcia+x)>5000);
                
                velocita=a.accellera(x);
                break;
            
            case 5:
                System.out.println(" Hai scelto di decellerare !!!");
                y=false;
                do
                {
                    if(y==true) System.out.println(" attenzione non e' possibile cosi facendo superi il minimo di giri !!!!!");
                    System.out.println("Inserisci di quanto vuoi aumentare i giri:");
                    x = k.nextInt();
                    y=true;
                }while((numeroMarcia-x)<0 || (numeroMarcia-x)>5000);
                velocita=a.decellera(x);
                break;
            
            default:
                System.out.println("Attenzione scelta sbagliata!!!!!");
            }
            
            System.out.println("Stato motore: velocita " + a.getVelocita() + ", Marcia " + a.getMarcia() + ", Giri " + a.getGiri());
        }while(scelta!=6);
    }
}
