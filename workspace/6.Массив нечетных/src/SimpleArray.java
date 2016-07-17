import javax.swing.JOptionPane;

public class SimpleArray {
	public static void main(String[] args) {
		int i, size;
		String text = "мАССИВ ДЛЯ НЕЧЕТНЫХ ЧИСЕЛ\n";
		size = Integer.parseInt(JOptionPane.showInputDialog("Укажите размер массива"));
		int[] nums = new int[size];
		for (i = 0; i < size; i++) {
			nums[i] = 2 * i + 1;
			text += nums[i] + " ";
		}
		JOptionPane.showMessageDialog(null, text);
	}

}
