package by.a034871vz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;

public class Main {

    private static JLabel LL = new JLabel("Login");
    private static JLabel PL = new JLabel("Password");

    private static JButton LB = new JButton("Login in");
    private static JButton RB = new JButton("Registration");

    private static JTextField LTF = new JTextField(15);
    private static JTextField PTF = new JTextField(15);

    private static void go() {
        JFrame frame = new JFrame();

        frame.setSize(600, 400);
        frame.setTitle("My debiut");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());



        frame.add(LL, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        frame.add(LTF, new GridBagConstraints(1, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        frame.add(PL, new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        frame.add(PTF, new GridBagConstraints(1, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        frame.add(LB, new GridBagConstraints(0, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        frame.add(RB, new GridBagConstraints(1, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        LB.addActionListener(new Send());

        frame.setVisible(true);
        frame.pack();

    }

        private static class Send implements ActionListener{
            public void actionPerformed(ActionEvent event) {


                String a = LTF.getText();
                String b = new StringBuffer(a).reverse().toString();
                PTF.setText(b);
                LTF.setText(a);

        }



        }


    public static void main(String[] args) {
        go();
    }
}
