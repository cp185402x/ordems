package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.UIManager;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("OrdemS - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeuU = new JLabel("Nome de usu\u00E1rio");
		lblSeuU.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSeuU.setBounds(10, 87, 284, 14);
		contentPane.add(lblSeuU);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSenha.setBounds(10, 143, 284, 14);
		contentPane.add(lblSenha);
		
		JLabel lblOrdems = new JLabel("OrdemS");
		lblOrdems.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrdems.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblOrdems.setBackground(Color.GRAY);
		lblOrdems.setBounds(10, 32, 284, 29);
		contentPane.add(lblOrdems);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(10, 103, 284, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passwordField.setBounds(10, 158, 284, 29);
		contentPane.add(passwordField);
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.setBackground(UIManager.getColor("Button.background"));
		btnLogar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogar.setBounds(10, 210, 284, 29);
		contentPane.add(btnLogar);
	}
}
