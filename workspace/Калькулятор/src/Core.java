import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Core extends JFrame{
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,plus,minus,umn,del,rav;
	//JLabel l1,l2,l3,l4;
	JTextField t1,t2;
	int i, k;
	String a, b;
	eHandler handler = new eHandler();
	
	public Core (String s){
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
		//l1 = new JLabel("Введите ");
		//l3 = new JLabel("");
		//l4 = new JLabel("");
		t1 = new JTextField(10);
		t2 = new JTextField(10);
		add (b1);
		add (b2);
		//add (l1);
		add (t1);
		//add (l2);
		add (t2);
		//add (l3);
		//add (l4);
		b2.addActionListener(handler);
		b1.addActionListener(handler);
	}
	
	public class eHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try{
			if(e.getSource()==b2){
				i = Integer.parseInt(t1.getText());
				k = Integer.parseInt(t2.getText());
				i++;
				k++;
				a = "Ваше первое число теперь равно"+ i;
				b = "Ваше второе число теперь равно"+ k;
				//l3.setText(a);
				//l4.setText(b);
				
			}
			
			if(e.getSource()==b1){
				t1.setText(null);
				t2.setText(null);
				//l3.setText("");
				//l4.setText("");				
			}
		}catch (Exception ex){ JOptionPane.showMessageDialog(null, "Введите в поле число");}		
	}
		
	}		
}
