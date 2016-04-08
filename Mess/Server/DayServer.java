package Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DayServer {

	private static PrintWriter writer;
	private static java.sql.Statement st;
	private static ArrayList<PrintWriter> streams; // Коллекция в торой хранятся PrintWriter'ы всех пользователей
	private static Connection c;
	private static ServerSocket ss;

	public static void main(String[] args) throws Exception {
		go();

	}

	private static void go() throws Exception {
		streams = new ArrayList<PrintWriter>();
		setDB();
		try {
			ss = new ServerSocket(5000);
			while (true) {
				Socket sock = ss.accept(); // ждем подключения клиента
				System.out.println("Got user!");
				writer = new PrintWriter(sock.getOutputStream());
				sendHistory();
				streams.add(writer); // добавляем райтер в коллекцию

				Thread t = new Thread(new Listener(sock)); // делаем и запускаем поток для слушанья клиента
				t.start();
			}
		} catch (Exception ex) {
		}

	}

	private static void sendHistory() throws Exception {

		String SQL = "SELECT * FROM `chat`";
		ResultSet rs = st.executeQuery(SQL);

		while (rs.next()) {
			writer.println(rs.getString("login") + ":" + rs.getString("msg"));
			writer.flush();
		}
	}

	private static void tellEveryone(String msg) throws Exception { // передаем сообщение всем участникам чата
		int x = msg.indexOf(':');
		String login = msg.substring(0, x); // получили логин

		save(login, msg);

		java.util.Iterator<PrintWriter> it = streams.iterator(); // делаем итератор
		while (it.hasNext()) { // пробегаемся по райтерам
			try {
				writer = it.next();
				writer.println(msg); // отправляем сообщение через райтер
				writer.flush();
			} catch (Exception ex) {
			}

		}

	}

	private static void save(String login, String msg) throws Exception {

		String SQL = "INSERT INTO `messenger`.`chat` (`login`, `msg`) VALUES ('" + login + "', '" + msg + "')";
		st.executeUpdate(SQL);
	}

	private static void setDB() throws Exception {

		String url = "jdbc:mysql://localhost:3306/Messenger";
		String login = "root";
		String pass = "root";
		Class.forName("com.mysql.jdbc.Driver");
		c = DriverManager.getConnection(url, login, pass);
		st = c.createStatement();
	}

	private static class Listener implements Runnable { // слушаем клиента

		BufferedReader reader;

		Listener(Socket sock) { // делаем конструктор чтобы получить сокет
			InputStreamReader is;
			try {
				is = new InputStreamReader(sock.getInputStream());
				reader = new BufferedReader(is);
			} catch (Exception e) {
			}
		}

		public void run() {
			String msg;
			try {
				while ((msg = reader.readLine()) != null) { // если письмо от пользователя не пустое то рассылаем его
					System.out.println(msg);
					tellEveryone(msg);
				}
			} catch (Exception ex) {
			}

		}

	}

}
