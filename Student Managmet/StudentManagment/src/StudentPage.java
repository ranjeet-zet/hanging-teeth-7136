import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import java.awt.Choice;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.List;
import java.awt.ComponentOrientation;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JScrollBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;
import javax.swing.JSplitPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.UIManager;

public class StudentPage extends JFrame {

	
	private JPanel contentPane;
	private JTable table;
	private JTable livecourse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentPage frame = new StudentPage();
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
	@SuppressWarnings({ "rawtypes", "unchecked", "serial" })
	public StudentPage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ranje\\Downloads\\qqqq.png"));
		setResizable(false);
		setTitle("Student Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1201, 737);
		contentPane = new JPanel();
//		setUndecorated(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 102));
		panel_1.setBounds(0, 0, 1201, 64);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ranje\\Downloads\\qqqq.png"));
		lblNewLabel_1.setBounds(803, 10, 45, 44);
		panel_1.add(lblNewLabel_1);
		
		JLabel userNameShow = new JLabel("Ranjeet Kuamr");
		userNameShow.setFont(new Font("Tahoma", Font.PLAIN, 18));
		userNameShow.setBounds(858, 10, 186, 44);
		panel_1.add(userNameShow);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				trialPanel.hide();
				UpdateDetails up=new UpdateDetails();
				up.setVisible(true);
			}
		});
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\ranje\\Downloads\\update.png"));
		lblNewLabel_1_1.setBounds(10, 10, 45, 44);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblRollno = new JLabel("RollNo");
		lblRollno.setHorizontalAlignment(SwingConstants.CENTER);
		lblRollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRollno.setBounds(1072, 10, 104, 44);
		panel_1.add(lblRollno);
		String[] columnNames = {"First Name"};
		Object[][] data = {
			    {"Kathy" },
			    {"John"},
			    {"Sue" },
			    {"Jane"},
			    {"Joe"}
			};
		table = new JTable(data,columnNames);
		table.setFillsViewportHeight(true);
		table.setCellSelectionEnabled(true);
		table.setBackground(new Color(240, 240, 240));
		table.setForeground(Color.BLACK);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setRowHeight(30);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setBounds(20, 129, 174, 561);
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("Your Course Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 84, 299, 45);
		contentPane.add(lblNewLabel);
		
		
		String[] columnNames1 = {"First Name"};
		Object[][] data1 = {
			    {"Kathy" },
			    {"John"},
			    {"Sue" },
			    {"Jane"},
			    {"Joe"}
			};
		
		livecourse = new JTable(data,columnNames1);
		livecourse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			int row=	livecourse.getSelectedRow();
			System.out.print(row);
			}
		});
	
		livecourse.setFillsViewportHeight(true);
		livecourse.setCellSelectionEnabled(true);
		livecourse.setBackground(new Color(240, 240, 240));
		livecourse.setForeground(Color.BLACK);
		livecourse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		livecourse.setRowHeight(30);
		livecourse.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		livecourse.setBounds(880, 129, 297, 561);
		contentPane.add(livecourse);
		
		
		JLabel lblLiveCourseName = new JLabel("Live Course Name");
		lblLiveCourseName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLiveCourseName.setBounds(878, 84, 299, 45);
		contentPane.add(lblLiveCourseName);
		
	}
	public JTable getTable() {
		return table;
	}
}
