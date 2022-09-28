import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public class UpdateDetails extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField email;
	private JTextField rollNo;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateDetails frame = new UpdateDetails();
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
	public UpdateDetails() {
		
		setTitle("Update Details");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ranje\\Downloads\\update.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 580, 458);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(51, 31, 91, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(51, 77, 91, 36);
		contentPane.add(lblEmail);
		
		JLabel lblRollno = new JLabel("RollNo");
		lblRollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRollno.setBounds(51, 123, 58, 36);
		contentPane.add(lblRollno);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(51, 169, 108, 36);
		contentPane.add(lblPassword);
		
		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.PLAIN, 17));
		name.setBounds(159, 37, 274, 31);
		contentPane.add(name);
		name.setColumns(10);
		name.setText("Ranjeet");
		
		email = new JTextField();
		email.setForeground(Color.GRAY);
		email.setEditable(false);
		email.setColumns(10);
		email.setBounds(159, 83, 274, 31);
		email.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(email);
		email.setText("rk6914128@gmail.com");
		
		rollNo = new JTextField();
		rollNo.setForeground(Color.GRAY);
		rollNo.setEditable(false);
		rollNo.setColumns(10);
		rollNo.setBounds(159, 129, 274, 31);
		rollNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(rollNo);
		rollNo.setText("fw19_0329");
		
		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 17));
		password.setToolTipText("");
		password.setBounds(159, 169, 274, 31);
		contentPane.add(password);
		
		JButton change = new JButton("Change");
		change.setBackground(new Color(0, 153, 51));
		change.setFont(new Font("Tahoma", Font.PLAIN, 20));
		change.setBounds(209, 225, 131, 41);
		contentPane.add(change);
		
		JButton back = new JButton("Back");
		back.setBackground(new Color(0, 255, 204));
		back.setFont(new Font("Tahoma", Font.PLAIN, 20));
		back.setBounds(219, 276, 108, 31);
		contentPane.add(back);
	}
}
