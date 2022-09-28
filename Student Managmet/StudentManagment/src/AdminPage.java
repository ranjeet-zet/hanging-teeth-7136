import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.MatteBorder;

public class AdminPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage frame = new AdminPage();
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
	public AdminPage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ranje\\Downloads\\Menue.png"));
		setTitle("AdminPanel");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1410, 775);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 51, 255));
		panel.setBounds(0, 0, 1407, 72);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome Admin");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ranje\\Downloads\\qqqq.png"));
		lblNewLabel.setBounds(1136, 10, 215, 52);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 153, 255));
		panel_1.setBounds(0, 68, 347, 685);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.print("Done");
			}
		});
		panel_2.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel_2.setBackground(new Color(51, 153, 255));
		panel_2.setBounds(29, 30, 297, 63);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Home");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ranje\\Downloads\\update.png"));
		lblNewLabel_1.setBounds(17, 0, 280, 63);
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel_2_1.setBackground(new Color(51, 153, 255));
		panel_2_1.setBounds(29, 118, 297, 63);
		panel_1.add(panel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Home");
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\ranje\\Downloads\\Menue.png"));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(17, 0, 280, 63);
		panel_2_1.add(lblNewLabel_1_1);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel_2_2.setBackground(new Color(51, 153, 255));
		panel_2_2.setBounds(29, 206, 297, 63);
		panel_1.add(panel_2_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Home");
		lblNewLabel_1_2.setIcon(new ImageIcon("C:\\Users\\ranje\\Downloads\\update.png"));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(17, 0, 280, 63);
		panel_2_2.add(lblNewLabel_1_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 51, 102));
		panel_5.setBounds(0, 577, 347, 63);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("LogOut");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\ranje\\Downloads\\cross.png"));
		lblNewLabel_4.setBounds(58, 0, 215, 58);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_5.add(lblNewLabel_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(357, 82, 1050, 195);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(153, 204, 255));
		panel_4.setBounds(138, 28, 317, 136);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\ranje\\Downloads\\qqqq.png"));
		lblNewLabel_2.setBounds(10, 37, 45, 52);
		panel_4.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Total Student Enrold");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(80, 10, 154, 42);
		panel_4.add(lblNewLabel_3);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBackground(new Color(153, 204, 255));
		panel_4_1.setBounds(593, 28, 317, 136);
		panel_3.add(panel_4_1);
		panel_4_1.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon("C:\\Users\\ranje\\Downloads\\qqqq.png"));
		lblNewLabel_2_1.setBounds(10, 40, 45, 52);
		panel_4_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Total Course Enrold");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(82, 10, 154, 42);
		panel_4_1.add(lblNewLabel_3_1);
	}

}
