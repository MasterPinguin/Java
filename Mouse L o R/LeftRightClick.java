import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeftRightClick {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Left or Right Click");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 400);

    JPanel panel = new JPanel();
    panel.setPreferredSize(new Dimension(400, 400));
    panel.setBackground(Color.WHITE);

    panel.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        int x = e.getX();
        if (x < panel.getWidth() / 2) {
          System.out.println("Left side clicked");
        } else {
          System.out.println("Right side clicked");
        }
      }
    });

    frame.add(panel);
    frame.pack();
    frame.setVisible(true);
  }
}
