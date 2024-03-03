/* Festa */

import java.awt.*;
import javax.swing.*;  
import java.util.Scanner;

class Invitato 
{
    private String nome;
    private char sesso;
    private String telefono;
    
    public Invitato (String nome, char sesso, String telefono) 
    {
        this.nome = nome;
        this.sesso = sesso;
        this.telefono = telefono;
    }
    
    public Invitato (Invitato invitato) 
    {
        this.nome = invitato.getNome() ;
        this.sesso = invitato.getSesso();
        this.telefono = invitato.getTelefono();
    }
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public String getNome()
    {
        return nome;
    }
    
    public void setSesso (char sesso)
    {
        this.sesso=sesso;
    }
    
    public char getSesso()
    {
        return sesso;
    }

    public void setTelefono(String telefono)
    {
        this.telefono=telefono;
    }
    
    public String getTelefono()
    {
        return telefono;
    }

    public String toString() 
    {
        return nome + "," + sesso + "," + telefono;
    }
}

class Nodo
{
    private Invitato info;
    private Nodo link;
    
    public Nodo(Invitato persona)
    {
        info = new Invitato(persona);
        link = null;
    }
    
    public void setInfo(Invitato persona)
    {
        info = new Invitato(persona);
    }
    
    public Invitato getInfo()
    {
        return new Invitato(info);
    }
    
    public void setLink(Nodo link)
    {
        this.link = link;
    }
    
    public Nodo getLink()
    {
        return link;
    }
}
    
class FestaException extends Exception
{
    private String error = "";
    
    FestaException(String error)
    {
        this.error = error;
    }
    
    String getError()
    {
        return error;
    }
}
   
public class Festa
{
    private Nodo head;
    private int elementi;
    
    public Festa()
    {
        head = null;
        elementi=0;
    }
    
    private Nodo getLinkPosizione(int posizione) throws FestaException
    {
        int n = 1;
        Nodo p = head;
        
        if(head==null)  throw new FestaException("Lista vuota");
        
        if ((posizione>elementi) || (posizione<1))  throw new FestaException("Posizione errata");
        
        while ((p.getLink() != null) && (n<posizione)) 
        {
        p = p.getLink();
        n++;
        }
        
        return p;
    }
    
    private Nodo creaNodo(Invitato persona, Nodo link)
    {
        Nodo nuovoNodo = new Nodo(persona);
        nuovoNodo.setLink(link);
        return nuovoNodo;
    }
    
    public int getElementi()
    {
        return elementi;
    }
    
    public void inserisciInTesta(Invitato persona)
    {
        Nodo p = creaNodo(persona, head);
        head = p;
        elementi++;
        return;
    }
    
    public void inserisciInCoda(Invitato persona)
    {
        if(head==null) inserisciInTesta(persona);
        else
        {
            try
            {
                Nodo p = getLinkPosizione(elementi);
                p.setLink(creaNodo(persona, null));
                elementi++;
            }
            catch (FestaException exception)
            {
                
            }
            return;
        }
    }
    
    public void inserisciInPosizione(Invitato persona, int posizione) throws FestaException
    {
        if(posizione<=1) inserisciInTesta(persona);
        else
        {
            if(elementi<posizione) inserisciInCoda(persona);
            else
            {
                Nodo p = getLinkPosizione(posizione-1);
                p.setLink(creaNodo(persona, p.getLink()));
                elementi++;
            }
        }
        return;
    }
    
    public void eliminaInTesta() throws FestaException
    {
        if(head==null)  throw new FestaException("Lista vuota");
        head=head.getLink();
        elementi--;
        return;
    }
    
    public void eliminaInCoda() throws FestaException
    {
        if(head==null)  throw new FestaException("Lista vuota");
        Nodo p=getLinkPosizione(elementi-1);
        p.setLink(null);
        elementi--;
        return;
    }
    
    public void eliminaInPosizione(int posizione) throws FestaException
    {
        if(posizione==1) eliminaInTesta();
        else if (posizione==elementi) eliminaInCoda();
        else
        {
            Nodo ps = getLinkPosizione(posizione);
            Nodo pp = getLinkPosizione(posizione-1);
            pp.setLink(ps.getLink());
            elementi--;
        }
        return;
    }
    
    private String vista(Nodo p)
    {
        if(p==null) return "";
        return p.getInfo().toString()+"\n"+vista(p.getLink());
    }
    
    public String elenco()
    {
        return vista(head);
    }
    
    public String toString()
    {
        Nodo p = head;
        String lista = new String("head->");
        
        if(p==null) return lista+"null";
        
        while(p!=null)
        {
            lista = lista+"["+p.getInfo().toString()+"]";
            if(p.getLink()==null)   lista = lista+"null]";
            else    lista = lista+"+]->";
            p=p.getLink();
        }
        return lista;
    }
    
    public static void main (String[] args) 
    {
        Invitato i1 = new Invitato("Bianchi Giovanni",'M',"0586 854822");
        Invitato i2 = new Invitato("Rossi Marta",'F',"0586 84453");
        Invitato i3 = new Invitato("Neri Marco",'M',"0586 444722");
        Invitato i4 = new Invitato("Verdi Roberta",'F',"0586 974824");
        Festa f = new Festa();
        
        f.inserisciInTesta(i1);
        f.inserisciInTesta(i2);
        f.inserisciInCoda(i3);
        try{f.inserisciInPosizione(i4, 2);}
        catch(FestaException exception)
        {
            System.out.println(exception.getError());
        }
        
        System.out.println("Vista ricorsiva: ");
        System.out.println(f.elenco());
        System.out.println("-----------------");
        
        System.out.println(f.toString());
        System.out.println("-----------------");
        try{f.eliminaInPosizione(2);}
        catch(FestaException exception)
        {
            System.out.println(exception.getError());
        }
        System.out.println(f.toString());
        System.out.println("-----------------");
        try{f.eliminaInCoda();}
        catch(FestaException exception)
        {
            System.out.println(exception.getError());
        }
        System.out.println(f.toString());
        System.out.println("-----------------");
        try{f.eliminaInTesta();}
        catch(FestaException exception)
        {
            System.out.println(exception.getError());
        }
        System.out.println(f.toString());
        System.out.println("-----------------");
        try{f.eliminaInPosizione(5);}
        catch(FestaException exception)
        {
            System.out.println(exception.getError());
        }
        System.out.println(f.toString());
        System.out.println("-----------------");
        try{f.eliminaInPosizione(1);}
        catch(FestaException exception)
        {
            System.out.println(exception.getError());
        }
        System.out.println(f.toString());
        System.out.println("-----------------");
        try{f.eliminaInPosizione(1);}
        catch(FestaException exception)
        {
            System.out.println(exception.getError());
        }
    }
    
}