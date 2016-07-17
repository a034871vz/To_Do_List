import javax.swing.JOptionPane;

public class CharArray {
	public static void main(String[] args) {
		int size, i, j;
		String text = "Исходный массив: ";
		size = Integer.parseInt(JOptionPane.showInputDialog("Размер массива:"));
		char[] symbs = new char[size];
		char s = 'a';
		for (i = 0; i < size; i++) {
			symbs[i] = (char) (s + (byte) (Math.random() * 26));
			text += symbs[i] + " ";
		}
		text += "\n После сотировки:\n";
		for (i = 0; i < size; i++) {
			for (j = 0; j < size - 1 - i; j++) {
				if (symbs[j] > symbs[j + 1]) {
					s = symbs[j + 1];
					symbs[j + 1] = symbs[j];
					symbs[j] = s;
				}
			}
		}
		for (i = 0; i < size; i++) {
			text += symbs[i] + " ";
		}
		JOptionPane.showMessageDialog(null, text);
	}
}
