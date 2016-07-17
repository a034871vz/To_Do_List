import javax.swing.JFrame;

class pussy {
	public static void main(String args[]){
		Reader r = new Reader("Калькулятор");
		r.setVisible(true);
		r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		r.setSize(230, 250);
		r.setResizable(false);
		r.setLocationRelativeTo(null);
		
	}
}