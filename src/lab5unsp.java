

import java.awt.EventQueue;

import javax.swing.JFrame;
//import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class lab5unsp {

	private JFrame frame;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable tble2;
	private JTable table_3;
	private JTextField textField;
	private JTable table_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lab5unsp window = new lab5unsp();
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
	public lab5unsp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 877, 754);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(0, 0, 434, 0);
		frame.getContentPane().add(table, BorderLayout.NORTH);
		
		table_1 = new JTable();
		table_1.setBounds(10, 30, 52, 131);
		frame.getContentPane().add(table_1);
		
		JLabel lblqueue = new JLabel("JOB QUEUE");
		lblqueue.setBounds(10, 5, 62, 14);
		frame.getContentPane().add(lblqueue);
		
		JButton btnload = new JButton("LOAD");
		btnload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnload.setBounds(0, 177, 62, 23);
		frame.getContentPane().add(btnload);
		
		table_2 = new JTable();
		table_2.setBounds(124, 176, 1, -46);
		frame.getContentPane().add(table_2);
		
		tble2 = new JTable();
		tble2.setBounds(91, 30, 52, 109);
		frame.getContentPane().add(tble2);
		
		JLabel lblprocess = new JLabel("READY QUEUE");
		lblprocess.setBounds(84, 5, 77, 14);
		frame.getContentPane().add(lblprocess);
		
		JButton btnloadrq = new JButton("LOAD RQ");
		btnloadrq.setBounds(72, 150, 89, 23);
		frame.getContentPane().add(btnloadrq);
		
		JLabel lblcpu = new JLabel("CPU SCHEDULING");
		lblcpu.setBounds(72, 181, 89, 14);
		frame.getContentPane().add(lblcpu);
		
		JRadioButton rdbtnfcps = new JRadioButton("FCFS");
		rdbtnfcps.setBounds(68, 196, 109, 23);
		frame.getContentPane().add(rdbtnfcps);
		
		JRadioButton rdbtnSjf = new JRadioButton("SJF");
		rdbtnSjf.setBounds(68, 217, 109, 23);
		frame.getContentPane().add(rdbtnSjf);
		
		JRadioButton rdbtnPirority = new JRadioButton("PIRORITY");
		rdbtnPirority.setBounds(68, 242, 109, 23);
		frame.getContentPane().add(rdbtnPirority);
		
		JRadioButton rdbtnRr = new JRadioButton("RR");
		rdbtnRr.setBounds(68, 268, 109, 23);
		frame.getContentPane().add(rdbtnRr);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(504, 30, 349, 55);
		frame.getContentPane().add(scrollPane);
		
		table_3 = new JTable();
		scrollPane.setViewportView(table_3);
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"At", "Bt", "Ct", "TT", "RT", "HW", "HW", "HW", "HW", "HW", "HW", "HW"
			}
		));
		
		JLabel lblCpu = new JLabel("CPU");
		lblCpu.setBounds(224, 5, 77, 14);
		frame.getContentPane().add(lblCpu);
		
		JButton btnRunProcess = new JButton("RUN PROCESS");
		btnRunProcess.setBounds(448, 86, 103, 23);
		frame.getContentPane().add(btnRunProcess);
		
		JLabel lblMemoryProtection = new JLabel("MEMORY PROTECTION");
		lblMemoryProtection.setBounds(213, 90, 111, 14);
		frame.getContentPane().add(lblMemoryProtection);
		
		JLabel lblMemoryRequest = new JLabel("MEMORY REQUEST");
		lblMemoryRequest.setBounds(247, 115, 103, 14);
		frame.getContentPane().add(lblMemoryRequest);
		
		textField = new JTextField();
		textField.setBounds(348, 110, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblHardwareProtection = new JLabel("HARDWARE PROTECTION");
		lblHardwareProtection.setBounds(247, 172, 131, 14);
		frame.getContentPane().add(lblHardwareProtection);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(388, 172, 30, 22);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(448, 172, 30, 22);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblHw = new JLabel("HW1");
		lblHw.setBounds(388, 150, 30, 14);
		frame.getContentPane().add(lblHw);
		
		JLabel lblHw_1 = new JLabel("HW1");
		lblHw_1.setBounds(448, 150, 77, 14);
		frame.getContentPane().add(lblHw_1);
		
		JLabel lblIoProtection = new JLabel("I/O PROTECTION");
		lblIoProtection.setBounds(247, 221, 131, 14);
		frame.getContentPane().add(lblIoProtection);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(388, 217, 30, 22);
		frame.getContentPane().add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(448, 217, 30, 22);
		frame.getContentPane().add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(504, 217, 30, 22);
		frame.getContentPane().add(comboBox_4);
		
		JLabel lblDisk = new JLabel("DISK 0");
		lblDisk.setBounds(388, 200, 46, 14);
		frame.getContentPane().add(lblDisk);
		
		JLabel lblDisk_1 = new JLabel("DISK 1");
		lblDisk_1.setBounds(448, 200, 46, 14);
		frame.getContentPane().add(lblDisk_1);
		
		JLabel lblDisk_2 = new JLabel("DISK 2");
		lblDisk_2.setBounds(504, 200, 48, 14);
		frame.getContentPane().add(lblDisk_2);
		
		table_4 = new JTable();
		table_4.setBounds(177, 253, 397, 39);
		frame.getContentPane().add(table_4);
	}
}
