package a034871vz.mess;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class Incoming extends Thread {
	Socket sock;
	
	BufferedReader in = null;// читает текст от потока ввода символов, буферезируя их
	String msg = null;

	Incoming(Socket s) // Создаём новый поток
	{
		sock = s;
		try {
			InputStreamReader isr = new InputStreamReader(sock.getInputStream());// Считываем информацию поступившую от клиента
			in = new BufferedReader(isr);// Заносим информацию в буфер
		} catch (IOException e) {
			System.out.println("ошибка: " + e);
		}
	}

	public void run() // Точка входа созданного потока
	{
		while (true) {
			try {
				// Выполняет чтение строки символов из
				// текущего потока и возвращает данные в виде
				// строки, которые заносятся в буфер
				msg = in.readLine();
				if (msg != null) {
					Server.Message = msg;
					msg = null;
				}
			} catch (IOException e) {
				break;
			}
		}
	}
}

public class Server extends Thread {
	String lastm;
	Socket socket;
	int i = 0;
	// класс для расширения потоков ввода вывода
	PrintStream ps;
	public static String Message = null;
	private static ServerSocket server;

	public Server(Socket s) {
		lastm = null;
		socket = s;
		try {
			// класс, который занимается
			// выводом информации
			ps = new PrintStream(s.getOutputStream());
		} catch (IOException e) {
			System.out.println("ошибка: " + e);
		}
	}

	public static void main(String[] args) {
		try {
			server = new ServerSocket(5000);
			while (true) {
				Socket s = null;
				// Ждём подключения клиента
				s = server.accept();
				Server nst = new Server(s);
				Incoming incom = new Incoming(s);
				// Запускаем потоки
				nst.start();
				incom.start();
			}
		} catch (IOException e) {
			System.out.println("ошибка: " + e);
		}
	}

	public void run() {
		while (true) {
			if ((Message != null) && (lastm != Message)) {
				lastm = Message;
				// отправляем сообщение на экран приложения
				send(lastm);
			}
			try {
				// поток спит 100 миллисекунд
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("ошибка: " + e);
			}
		}
	}

	public void send(String msg) {
		ps.println(msg);
		// очистили буфер объекта класса ps
		ps.flush();
	}
}
