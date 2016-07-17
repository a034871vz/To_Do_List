import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAddress;
	private JLabel lblIp;
	private JTextField txtPort;
	private JLabel lblPort;
	private JLabel lblIpAddressDesc;
	private JLabel lblPortDesc;

	private LoginButton handle = new LoginButton();

	public Login() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		txtName = new JTextField();
		txtName.setBounds(79, 60, 142, 23);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblName.setBounds(119, 42, 61, 14);
		contentPane.add(lblName);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(79, 108, 142, 23);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);
		
		lblIp = new JLabel(" Ip Address:");
		lblIp.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblIp.setBounds(105, 90, 80, 14);
		contentPane.add(lblIp);
		
		txtPort = new JTextField();
		txtPort.setBounds(79, 178, 142, 23);
		contentPane.add(txtPort);
		txtPort.setColumns(10);
		
		lblPort = new JLabel("Port:");
		lblPort.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblPort.setBounds(120, 160, 46, 14);
		contentPane.add(lblPort);
		
		lblIpAddressDesc = new JLabel("(пр. 82.209.71.116)");
		lblIpAddressDesc.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblIpAddressDesc.setBounds(95, 133, 112, 16);
		contentPane.add(lblIpAddressDesc);
		
		lblPortDesc = new JLabel("(пр. 8192)");
		lblPortDesc.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblPortDesc.setBounds(105, 203, 80, 16);
		contentPane.add(lblPortDesc);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name = txtName.getText();
				String address = txtAddress.getText();
				int port = Integer.parseInt(txtPort.getText());
				login(name,address,port);
				
		}

		});
		btnLogin.setBounds(103, 281, 89, 23);
		contentPane.add(btnLogin);
	}
	
	private void login(String name, String address, int port) {
		dispose();
		System.out.println(name+ "," +address+"," +port);
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
