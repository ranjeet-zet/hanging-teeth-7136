import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ranje\\Downloads\\qqqq.png"));
		setResizable(false);
		setTitle("SignUp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 153));
		panel.setBounds(462, 0, 404, 482);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(24, 35, 292, 21);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 20));
		
		textField = new JTextField();
		textField.setBounds(24, 61, 292, 27);
		panel.add(textField);
		textField.setToolTipText("");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(24, 98, 292, 21);
		panel.add(lblEmail);
		lblEmail.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 20));
		
		textField_1 = new JTextField();
		textField_1.setBounds(24, 117, 292, 27);
		panel.add(textField_1);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(24, 154, 292, 21);
		panel.add(lblPassword);
		lblPassword.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 20));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(24, 174, 292, 27);
		panel.add(passwordField);
		
		JButton btnNewButton_1 = new JButton("SignUp");
		btnNewButton_1.setBounds(54, 231, 224, 44);
		panel.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 18));
		btnNewButton_1.setBackground(new Color(50, 205, 50));
		
		JButton btnNewButton = new JButton("LogIn");
		btnNewButton.setBounds(75, 289, 180, 33);
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBackground(new Color(255, 215, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 464, 425);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ranje\\Downloads\\student.png"));
		lblNewLabel_1.setBounds(0, 0, 464, 425);
		panel_1.add(lblNewLabel_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Welcome wel=new Welcome();
				dispose();
				wel.setVisible(true);
			}
		});
	}
}
