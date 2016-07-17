import javax.swing.JOptionPane;

public class UsingSwitch {
	public static void main(String[] args) {
		int num;
		String text, str;
		text = JOptionPane.showInputDialog("Введите целое число от 0 до 10:");
		num = Integer.parseInt(text);
		switch (num) {
		case 0:
			str = "Вы ввели нулвое значение";
			break;
		case 1:
			str = "Вы ввели единичное значение";
			break;
		case 2:
		case 3:
		case 5:
		case 7:
			str = "Вы ввели просто число";
			break;
		case 4:
		case 6:
		case 8:
		case 10:
			str = "Вы ввели четное число";
			break;
		default:
			str = "Вы ввели 9 или выходящее за пределы диапазона";
		}
		JOptionPane.showMessageDialog(null, str);
	}

}
