import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import myprojectt.DSA;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton; 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;

public class FirstGUII {

	private JFrame frame;
    Connection conn=null;
    Statement stmt=null;
    private JTable table;
    private JTextField textFieldPID;
    private JTextField textFieldPname;
    private JTextField textFieldATime;
    private JTextField textFieldBTime;
    private JTextField textFieldPriority;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstGUII window = new FirstGUII();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FirstGUII() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
		DriverManager.registerDriver(new SQLServerDriver());
		conn=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1;instanceName=MSSQLSERVER;databaseName=mydb;encrypt=true;trustServerCertificate=true;", "sa","123456" );
		if(conn!=null) {
			stmt=conn.createStatement();
		}
		}catch(SQLException ere) {ere.printStackTrace();};
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		frame.setBounds(100, 100, 845, 737);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	    
		
		JLabel lblNewLabel = new JLabel("JOB QUEUE");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 28));
		lblNewLabel.setBounds(443, 96, 143, 22);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		JButton btnNewButton = new JButton("LOAD");
		btnNewButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 28));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="Select *from Process";
					DSA d=new DSA();
					ResultSet res=d.select(query);
			       table.setModel(DbUtils.resultSetToTableModel(res));
			       
					
				
				}catch(Exception ex) {ex.printStackTrace();};
			}
		});
		btnNewButton.setBounds(474, 621, 112, 32);
		frame.getContentPane().add(btnNewButton);
		
		JScrollPane tableJOB = new JScrollPane();
		tableJOB.setBounds(284, 129, 499, 464);
		frame.getContentPane().add(tableJOB);
		
		table = new JTable();
		tableJOB.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("PID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(22, 183, 69, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("PID");
		lblNewLabel_1_1_1.setBounds(208, 432, 49, 0);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Pname");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(26, 258, 83, 14);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("ATime");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2_1.setBounds(22, 327, 83, 14);
		frame.getContentPane().add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("BTime");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2_1_1.setBounds(10, 396, 112, 14);
		frame.getContentPane().add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("Priority");
		lblNewLabel_1_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2_1_2.setBounds(10, 465, 83, 14);
		frame.getContentPane().add(lblNewLabel_1_2_1_2);
		
		textFieldPID = new JTextField();
		textFieldPID.setFont(new Font("Tahoma", Font.BOLD, 26));
		textFieldPID.setBounds(101, 169, 143, 52);
		frame.getContentPane().add(textFieldPID);
		textFieldPID.setColumns(10);
		
		textFieldPname = new JTextField();
		textFieldPname.setColumns(10);
		textFieldPname.setBounds(101, 242, 143, 52);
		frame.getContentPane().add(textFieldPname);
		
		textFieldATime = new JTextField();
		textFieldATime.setColumns(10);
		textFieldATime.setBounds(101, 311, 143, 52);
		frame.getContentPane().add(textFieldATime);
		
		textFieldBTime = new JTextField();
		textFieldBTime.setColumns(10);
		textFieldBTime.setBounds(101, 380, 143, 52);
		frame.getContentPane().add(textFieldBTime);
		
		textFieldPriority = new JTextField();
		textFieldPriority.setColumns(10);
		textFieldPriority.setBounds(101, 453, 143, 45);
		frame.getContentPane().add(textFieldPriority);
		
		JButton btnNewButton_1 = new JButton("SAVE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="insert into Process(PID,Pname,ATime,BTime,Priority) values(?,?,?,?,?)";
					PreparedStatement pst=conn.prepareStatement(query);
 			        pst.setString(1, textFieldPID.getText());
 			       pst.setString(2, textFieldPname.getText());
			        
 			      pst.setString(3, textFieldATime.getText());
			        
 			     pst.setString(4, textFieldBTime.getText());
			        
 			    pst.setString(5, textFieldPriority.getText());
 			    pst.execute();
 			    JOptionPane.showMessageDialog(null, "Data Saved");
 			    pst.close();
			        
				}catch(Exception ex) {ex.printStackTrace();};
			}
		});
		btnNewButton_1.setBounds(120, 535, 112, 39);
		frame.getContentPane().add(btnNewButton_1);
	}
}
