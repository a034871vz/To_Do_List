import javax.swing.JOptionPane;

public class UsingMoreIf {
	public static void main(String[] args) {
		String text, str;
		text = JOptionPane.showInputDialog("Введите целое число");
		if (text == null) {
			System.exit(0);
		}
		int num = Integer.parseInt(text);
		if (num < 0) {
			str = "Число отрицательное";
		} else if (num > 100) {
			str = "Число очень большое";
		} else if (num > 10) {
			str = "Число ,больше десяти";
		} else {
			str = "Число в пределах десяти";
		}
		JOptionPane.showMessageDialog(null, str);
	}
}