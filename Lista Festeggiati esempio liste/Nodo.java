/* Festa */
import java.awt.*;
import javax.swing.*;  
import java.util.Scanner;

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