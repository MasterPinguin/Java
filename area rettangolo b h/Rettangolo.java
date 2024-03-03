/*
Scrivere un programma che dati in ingresso la base e l'altezza visualizzi a video sulla stessa riga i valori inseriti e l'Area del Rettangolo.
*/

import java.util.Scanner;

public class Rettangolo
{ 
    public static void main(String args[]) 
    {
        Scanner x= new Scanner(System.in);  	
        int a,b,area;
        a = x.nextInt();      
        b = x.nextInt();      
        area=b*a;
        System.out.println("l’area del rettangolo e’:"+ area);
    }
}










Es 3

/*
Scrivere un programma che dati in ingresso il raggio calcoli l'area e il perimetro
del cerchio.
*/

import java.util.Scanner;

class Cerchio
{ 
    public static void main(String args[]) 
    {
        Scanner x = new Scanner(System.in);  	
        double r, p=3.14 ,area ,perimetro;
        r = x.nextDouble(); 
        area=(r*r)*p;
        perimetro=(r*2)*p;
        System.out.println("l’area del cerchio e’:"+ area);
        System.out.println("Il perimetro del cerchio e’:"+ perimetro);
    }
}

Es 4

/*
Scrivere un programma che calcoli l'area del triangolo
*/

import java.util.Scanner;

class Triangolo
{ 
    public static void main(String args[]) 
    {
        Scanner x = new Scanner(System.in);  	
        int a,b,area;
        a = x.nextInt();      
        b = x.nextInt();      
        area=(b*a)/2;
        System.out.println("l’area del triangolo e’:"+ area);
    }
}





Es 5

/*
Scrivere un programma che calcoli l'area del triangolo
*/

import java.util.Scanner;

class Triangolo
{ 
    public static void main(String args[]) 
    {
        Scanner y = new Scanner(System.in);  	
        int a,b,x;
        System.out.println("ax+b=0");
        System.out.print("inserisci a:");
        a = y.nextInt();
        System.out.print("inserisci b:");
        b = y.nextInt();      
        x=-b/a;
        System.out.println("il risultato dell'equazione e’:"+ x);
    }
}




















