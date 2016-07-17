import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reader extends JFrame{
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,plus,minus,umn,del,rav,znak,C;
	//JLabel l1,l2,l3,l4;
	JTextField t1,t2;
	int i, k;
	String a, b;
	eHandler handler = new eHandler();
	
	public Reader (String s){
		super(s);
		setLayout(new FlowLayout());
		b0 = new JButton("0");
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		rav = new JButton("=");
		plus = new JButton("+");
		minus = new JButton("-");
		umn = new JButton("*");
		del = new JButton("/");
		znak = new JButton("+-");
		C = new JButton("Стереть");
		t1 = new JTextField(20);
		t1 = new JTextField(20);
		add (t1);
		add (t2);
		add (b7);add (b8);add (b9);add (plus);add (b4);add (b5); add (b6);add (minus);add (b1);add (b2);add (b3);add (del);add (b0);add (rav);add (znak);
		add (umn);add (C);
		plus.addActionListener(handler);
		minus.addActionListener(handler);
		umn.addActionListener(handler);
		del.addActionListener(handler);
		C.addActionListener(handler);
	}
	
	public class eHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
	
			if(e.getSource()==plus){
				i = Integer.parseInt(t1.getText());
				k = Integer.parseInt(t2.getText());
				i=i+k;
				a = "" + i;                     
				rav.setText(a); 
				}
			if(e.getSource()==minus){
				i = Integer.parseInt(t1.getText());
				k = Integer.parseInt(t2.getText());
				i=i-k;
				a = "" + i;                     
				rav.setText(a); 
				}
			if(e.getSource()==umn){
				i = Integer.parseInt(t1.getText());
				k = Integer.parseInt(t2.getText());
				i=i*k;
				a = "" + i;                     
				rav.setText(a); 
				}
			if(e.getSource()==del){
				i = Integer.parseInt(t1.getText());
				k = Integer.parseInt(t2.getText());
				i=i/k;
				a = "" + i;                     
				rav.setText(a); 
				}
			
			if(e.getSource()==C){
				t1.setText(null);
				t2.setText(null);
				rav.setText(null);
			}		
	}
		
	}		
}
