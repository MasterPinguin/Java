import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonArrayExample {
  private static JFrame frame;
  private static Container content;
  private static JButton[] buttons = new JButton[5];
  private static JButton resetButton;

  public static void main(String[] args) {
    frame = new JFrame("Button Array Example");
    content = frame.getContentPane();
    content.setLayout(new FlowLayout());
    createButtons();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }

  private static void createButtons() {
    for (int i = 0; i < buttons.length; i++) {
      buttons[i] = new JButton("Button " + (i + 1));
      final int buttonIndex = i;
      buttons[i].addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          handleButtonClick(buttonIndex);
        }
      });
      content.add(buttons[i]);
    }
  }

  private static void handleButtonClick(int index) {
    if (index == 4) {
      for (JButton button : buttons) {
        button.setVisible(false);
      }
      resetButton = new JButton("Reset");
      resetButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          resetButtons();
        }
      });
      content.add(resetButton);
      frame.pack();
    } else {
      System.out.println("You clicked Button " + (index + 1));
    }
  }

  private static void resetButtons() {
    for (JButton button : buttons) {
      button.setVisible(true);
    }
    resetButton.setVisible(false);
    frame.pack();
  }
}
