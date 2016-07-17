import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Events extends JFrame{
    private JLabel l1 = new JLabel("");
    private JLabel l2 = new JLabel("");
    private JButton b1 = new JButton("Click for text");
    private JButton b2 = new JButton("Click for more text");
    private int x = 0, y = 0;

    public Events(){
        setLayout(new FlowLayout());
        add(b1);
        add(l1);
        add(b2);
        add(l2);

        Event e = new Event();
        b1.addActionListener(e);

        Event2 ev = new Event2();
        b2.addActionListener(ev);
    }
    public class Event implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if(x == 0) {
                l1.setText("Now you can see words here");
                x = 1;
            } else if(x == 1) {
                l1.setText(" ");
                x = 0;
            }
        }
    }

    public class Event2 implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if(y == 0) {
                l2.setText("This is label 2's text");
                y = 1;
            } else if(y == 1) {
                l2.setText(" ");
                y = 0;
            }

        }
    }

    public static void main (String args []){
        Events gui = new Events();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(300,100);
        gui.setTitle("Хуй!");
        gui.setVisible(true);
    }
}
