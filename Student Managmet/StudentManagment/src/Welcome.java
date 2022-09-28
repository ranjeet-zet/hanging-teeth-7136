import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import javax.swing.ImageIcon;

public class Welcome extends JFrame {

	private JPanel contentPane;
	private JPasswordField passWord;
	private JTextField userName;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
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
	public Welcome() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ranje\\Downloads\\qqqq.png"));
		setResizable(false);
		setAutoRequestFocus(false);
		setType(Type.POPUP);
		setAlwaysOnTop(true);
//		setUndecorated(true);
		setTitle("LogIn");
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(139, 37, 831, 478);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ranje\\Downloads\\student.png"));
		lblNewLabel_1.setBounds(0, 0, 462, 447);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 153));
		panel.setBounds(463, -16, 354, 457);
		contentPane.add(panel);
		panel.setLayout(null);
		
				JLabel lblNewLabel = new JLabel("Username");
				lblNewLabel.setBounds(37, 61, 282, 21);
				panel.add(lblNewLabel);
				lblNewLabel.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 20));
				lblNewLabel.setForeground(new Color(0, 0, 0));
				
				userName = new JTextField();
				userName.setBounds(37, 84, 289, 31);
				panel.add(userName);
				userName.setForeground(new Color(0, 0, 0));
				userName.setColumns(22);
				
						JLabel lblPassword = new JLabel("Password");
						lblPassword.setBounds(37, 126, 289, 21);
						panel.add(lblPassword);
						lblPassword.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 20));
						lblPassword.setForeground(new Color(0, 0, 0));
						
								passWord = new JPasswordField();
								passWord.setBounds(37, 145, 289, 31);
								panel.add(passWord);
								passWord.setForeground(new Color(0, 0, 0));
								
										JButton btnNewButton = new JButton("LogIn");
										btnNewButton.setBounds(107, 186, 148, 31);
										panel.add(btnNewButton);
										btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
										btnNewButton.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
											}
										});
										btnNewButton.setForeground(new Color(0, 0, 0));
										btnNewButton.setBackground(new Color(144, 238, 144));
										
												
										
												btnNewButton_1 = new JButton("SignUp");
												btnNewButton_1.setBounds(123, 241, 116, 31);
												panel.add(btnNewButton_1);
												btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
												btnNewButton_1.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {

														SignUp sg = new SignUp();
														dispose();
														sg.setVisible(true);
													}
												});
												btnNewButton_1.setBackground(new Color(255, 215, 0));
	}
}
