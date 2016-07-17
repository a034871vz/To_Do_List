import javax.swing.JOptionPane;

public class SimpleArray {
	public static void main(String[] args) {
		int m, n;
		String text = "Двумерный массив случайных чсел";
		n = Integer.parseInt(JOptionPane.showInputDialog("Строк в массиве"));
		m = Integer.parseInt(JOptionPane.showInputDialog("Столбцов в массиве"));
		int[][] nums = new int[n][m];
		for (int i = 0; i < n; i++) {
			text += "\n";
			for (int j = 0; j < m; j++) {
				nums[i][j] = (int) (10 * Math.random());
				text += nums[i][j] + " ";
			}

		}
		JOptionPane.showMessageDialog(null, text);
	}

}
