package a034871vz.mess;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

import javax.swing.*;

public class Client {

	private static JTextArea ta;
	private static JTextField t;
	private static JLabel l;
	private static BufferedReader reader; // полyчает от сервера
	private static PrintWriter writer; // отправляет на сервер
	private static String login;
	private static Socket sock;

	public static void main(String[] args) {
		go();
	}

	private static void go() {
		
		JFrame frame = new JFrame();
	    login = JOptionPane.showInputDialog(frame, "Введите логин", "Авторизация",JOptionPane.QUESTION_MESSAGE);// получаем логин
	    
		JFrame f = new JFrame("DayMessenger 1.0"); // создаем фрейм
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		JPanel p = new JPanel(); // главная панель
		JPanel p1 = new JPanel();
		ta = new JTextArea(15, 30);
		l = new JLabel("Список пользователей: \n"); 
		ta.setLineWrap(true); // перенос по строкам
		ta.setEditable(false);
		ta.setWrapStyleWord(true);// перенос по словам, а не по символам
		JScrollPane sp = new JScrollPane(ta);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		t = new JTextField(20);
		JButton b1 = new JButton("Отправить");
		JButton b2 = new JButton("Позвонить");

		b1.addActionListener(new Send()); // слушаем кнопку отправить

		p.add(sp); // 
		p.add(t);
		p.add(b1);
		p1.add(l);
		p1.add(b2);
		setNet(); // устанавливаем соединение

		Thread thread = new Thread(new Listener()); // делаем поток для слушания
													// сервера
		thread.start();

		f.getContentPane().add(BorderLayout.CENTER, p);
		f.getContentPane().add(BorderLayout.EAST, p1);
		f.setSize(450, 315);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private static class Listener implements Runnable {
		public void run() {
			String msg;
			try {
				while ((msg = reader.readLine()) != null) {
					ta.append(msg + "\n");
				}
			} catch (Exception ex) {
			}
		}
	}

	private static class Send implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			String msg = login + ": " + t.getText();
			writer.println(msg);
			writer.flush();

			t.setText("");
			t.requestFocus();

		}
	}

	private static void setNet() {
		try {
			sock = new Socket("127.0.0.1", 5000);
			InputStreamReader is = new InputStreamReader(sock.getInputStream());
			reader = new BufferedReader(is);
			writer = new PrintWriter(sock.getOutputStream());
		} catch (Exception ex) {
		}

	}

}
