package by.a034871vz;

import javax.swing.JFrame;

public class Main {
	private static Wind wind;
	public static void main(String[] args) {
		wind = new Wind();
		wind.setSize(640 , 480);
		wind.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wind.setLocationRelativeTo(null);
		wind.setResizable(false);
		wind.setVisible(true);
		

	}

}
