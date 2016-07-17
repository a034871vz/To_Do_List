import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;

public class RandomGame extends JFrame {
    int randnum = (int) (Math.random() * 10 + 1) , guess;
    private JButton b = new JButton("Guess");
    private JTextField tf = new JTextField(5);
    private JLabel promtlabel = new JLabel("Enter a random number 1-10");
    private JLabel resultlabel = new JLabel("");
    private JLabel randomlabel = new JLabel("");

    public RandomGame(){
        setLayout(new FlowLayout());

        add(promtlabel);
        add(tf);
        add(b);
        add(resultlabel);
        add(randomlabel);

        Event e = new Event();
        b.addActionListener(e);
    }
    public  class Event implements ActionListener {
        public void actionPerformed(ActionEvent e ) {
            try {
                guess = (int)(Double.parseDouble(tf.getText()));

                if (guess == randnum){
                    resultlabel.setText("You won the game!");
                } else if(guess != randnum){
                    resultlabel.setText("You lost the game!");
                }
                randomlabel.setText("The random number generated was: "+ randnum);
            } catch (Exception ex){
                randomlabel.setText("Please enter number only");
            }
        }
    }

    public static void main(String args []) {
        RandomGame gui = new RandomGame();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(300,150);
        gui.setTitle("Хуй!");
        gui.setVisible(true);
    }
}
