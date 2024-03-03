import java.awt.*;

class FinestraAwt
{
  public static void main(String argv[])
  {
    Frame f = new Frame();
    Panel p = new Panel();
    Label l = new Label("Etichetta");
    Button b = new Button("Pulsante");
    p.add(l);
    p.add(b);

    f.add(p);
    f.setSize(300,200);
    f.setVisible(true);
  }
}