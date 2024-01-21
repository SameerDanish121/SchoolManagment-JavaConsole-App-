

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import myprojectt.DSA;
import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Font;

public class MyTask {

	private JFrame frame;
	private JTable table;
	private JTable table_1;
	private JButton btnNewButton;
	private JButton btnLoadReady;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTable table_2;
	private JScrollPane scrollPane_2;
	private JButton btnNewButton_2;
	private JTextField textAVGTaT;
	private JTextField textAVGWTime;
	private JTextField textAVGRTime;
	private JTextField textField;
	private JButton btnNewButton_3;
	private JButton btnNewButton_1_2;
	private JButton btnNewButton_4;
	private JTextField textField_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_1_3;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnSave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyTask window = new MyTask();
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
	public MyTask() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 1287, 729);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(9, 311, 408, 182);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(522, 310, 419, 186);
		frame.getContentPane().add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"PName", "ATime", "BTime", "Priority"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		btnNewButton = new JButton("LOAD");
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="Select PName,ATime,BTime,Priority from Process";
					DSA d=new DSA();
					ResultSet res=d.select(query);
			       table.setModel(DbUtils.resultSetToTableModel(res));
			       
					
				
				}catch(Exception ex) {ex.printStackTrace();};
			}
		});
		btnNewButton.setBounds(183, 497, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnLoadReady = new JButton("LOAD READY ");
		btnLoadReady.setBackground(Color.GRAY);
		btnLoadReady.setForeground(Color.BLUE);
		btnLoadReady.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableModel model=table.getModel();
				int[] index=table.getSelectedRows();
				Object[] row=new Object[4];
				DefaultTableModel model2=(DefaultTableModel) table_1.getModel()	;
			    for(int i=0;i<index.length;i++) {
			    	row[0]=model.getValueAt(index[i], 0);
			    	row[1]=model.getValueAt(index[i], 1);
			    	row[2]=model.getValueAt(index[i], 2);
			    	row[3]=model.getValueAt(index[i], 3);
			    	model2.addRow(row);
			    	
			    }
			    
			    DefaultTableModel model22=(DefaultTableModel) table.getModel();
			    for(int i=index.length-1;i>=0;i--) {
			    	model22.removeRow(index[i]);
			    }
			    model22.fireTableDataChanged();
			}
		});
		btnLoadReady.setBounds(643, 499, 143, 23);
		frame.getContentPane().add(btnLoadReady);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(14, 529, 1195, 112);
		frame.getContentPane().add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		table_2.setModel(new DefaultTableModel(
				
			new Object[][] {
			},
			new String[] {
				"Process Name", "A Time", "B Time", "Priority", "Completion Time", "T.A Time", "Waiting Time", "Response Time" 
				
			
			}));
		
		JButton btnNewButton_1 = new JButton("FCFS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel ReadyModel12=(DefaultTableModel) table_2.getModel();
				ReadyModel12.setRowCount(0);
				DefaultTableModel ReadyModel=(DefaultTableModel) table_1.getModel();
				DefaultTableModel ResultModel=(DefaultTableModel) table_2.getModel();
				int n=table_1.getRowCount();
				 String[] PName = new String[n]; // process Names
				 int ar[] = new int[n]; // arrival times
				 int bt[] = new int[n]; // burst or execution times
				 int pr[] = new int[n]; // Priority, no need for FCFS
			
				int ct[] = new int[n]; // completion times
				int ta[] = new int[n]; // turnaround times
				int wt[] = new int[n]; // waiting times
				int temp; // for sorting arrival time
				String temp2=null; // for sorting process names
				float avgwt=0,avgta=0; // for average times
				//Getting all Process Name, Arrival Time,Burst Time & Priority
				for (int count = 0; count < table_1.getRowCount(); count++){
				 PName[count]= (String) ReadyModel.getValueAt(count, 0);
				 ar[count]= (int) ReadyModel.getValueAt(count, 1);
				 bt[count]= (int) ReadyModel.getValueAt(count, 2);
				 pr[count]= (int) ReadyModel.getValueAt(count, 3);
				 } 
				//sorting according to arrival times
				for(int i = 0 ; i <n; i++)
				for(int j=0; j < n-(i+1) ; j++){
				if( ar[j] > ar[j+1] ){
				temp = ar[j];
				ar[j] = ar[j+1];
				ar[j+1] = temp;
				temp = bt[j];
				bt[j] = bt[j+1];
				bt[j+1] = temp;
				temp = pr[j];
				pr[j] = pr[j+1];
				pr[j+1] = temp;
				temp2 = PName[j];
				PName[j] = PName[j+1];
				PName[j+1] = temp2;
				}
				}
				// finding completion times
				for(int i = 0 ; i < n; i++)
				 {
				if( i == 0)
				ct[i] = ar[i] + bt[i];
				else
				 {
				if( ar[i] > ct[i-1])
				 ct[i] = ar[i] + bt[i];
				else
				ct[i] = ct[i-1] + bt[i];
				}
				ta[i] = ct[i] - ar[i] ;// turnaround time= completion time- arrival time
				wt[i] = ta[i] - bt[i] ;// waiting time= turnaround time- burst time
				avgwt += wt[i] ; // total waiting time for avg
				avgta += ta[i] ; // total turnaround time for avg
				 }
				//sorting according to Process Name
				 for(int i = 0 ; i <n; i++)
				for(int j=0; j < n-(i+1) ; j++){
				
				int res = PName[j].compareTo(PName[j+1]);
				if( res > 0 ){
				 temp2 = PName[j];
				PName[j] = PName[j+1];
				PName[j+1] = temp2;
				 temp = ar[j];
				ar[j] = ar[j+1];
				ar[j+1] = temp;
				temp = bt[j];
				bt[j] = bt[j+1];
				bt[j+1] = temp;
				temp = ct[j];
				ct[j] = ct[j+1];
				ct[j+1] = temp;
				temp = ta[j];
				ta[j] = ta[j+1];
				ta[j+1] = temp;
				temp = wt[j];
				wt[j] = wt[j+1];
				wt[j+1] = temp;
				temp = pr[j];
				pr[j] = pr[j+1];
				pr[j+1] = temp;
				 }
				 }
				// Adding rows into result table
				for(int i = 0 ; i< n; i++)
				ResultModel.addRow(new Object[]{PName[i],ar[i],bt[i],pr[i],ct[i],ta[i],wt[i],wt[i]});
				textAVGTaT.setText(Float.toString(avgta/n));
				textAVGWTime.setText(Float.toString(avgwt/n));
				textAVGRTime.setText(Float.toString(avgwt/n));
			
				
			}
		});
		btnNewButton_1.setBounds(1156, 159, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Clear Ready Queue");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_2.setBackground(Color.GRAY);
		btnNewButton_2.setForeground(Color.CYAN);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel ReadyModel=(DefaultTableModel) table_1.getModel();
				ReadyModel.setRowCount(0);
			}
		});
		btnNewButton_2.setBounds(1057, 286, 192, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Average TurnAround Time");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(33, 661, 145, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel AverageWaitingTime = new JLabel("Average Waiting Time");
		AverageWaitingTime.setForeground(Color.BLUE);
		AverageWaitingTime.setBounds(439, 663, 137, 14);
		frame.getContentPane().add(AverageWaitingTime);
		
		JLabel lblAverageResponseTime = new JLabel("Average Response Time");
		lblAverageResponseTime.setForeground(Color.BLUE);
		lblAverageResponseTime.setBounds(845, 663, 177, 14);
		frame.getContentPane().add(lblAverageResponseTime);
		
		textAVGTaT = new JTextField();
		textAVGTaT.setBackground(Color.WHITE);
		textAVGTaT.setBounds(180, 656, 125, 20);
		frame.getContentPane().add(textAVGTaT);
		textAVGTaT.setColumns(10);
		
		textAVGWTime = new JTextField();
		textAVGWTime.setBackground(Color.WHITE);
		textAVGWTime.setColumns(10);
		textAVGWTime.setBounds(567, 659, 137, 20);
		frame.getContentPane().add(textAVGWTime);
		
		textAVGRTime = new JTextField();
		textAVGRTime.setBackground(Color.WHITE);
		textAVGRTime.setColumns(10);
		textAVGRTime.setBounds(1008, 659, 125, 20);
		frame.getContentPane().add(textAVGRTime);
		
		JButton btnSJF = new JButton("SJF(NP)");
		btnSJF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel ReadyModel12=(DefaultTableModel) table_2.getModel();
				ReadyModel12.setRowCount(0);
				DefaultTableModel ReadyModel = (DefaultTableModel) table_1.getModel();
				DefaultTableModel ResultModel = (DefaultTableModel) table_2.getModel();
				//Object [] numdata=new Object[4];
				int n=table_1.getRowCount();
				String[] PName = new String[n]; // process Names
				int at[] = new int[n]; // arrival times
				int bt[] = new int[n]; // burst or execution times
				int pr[] = new int[n]; // Priority
				int ct[] = new int[n]; // completion times
				int ta[] = new int[n]; // turn around times
				int wt[] = new int[n]; // waiting times
				int f[] = new int[n]; //flag to checks process is
				 // completed or not
				int st=0, tot=0;
				float avgwt=0, avgta=0;
				//Getting all Process Name, Arrival Time & Burst Time
				 for (int count = 0; count < table_1.getRowCount(); count++){
				 PName[count]= (String) ReadyModel.getValueAt(count, 0);
				 at[count]= (int) ReadyModel.getValueAt(count, 1);
				 bt[count]= (int) ReadyModel.getValueAt(count, 2);
				 pr[count]= (int) ReadyModel.getValueAt(count, 3);
				 f[count]=0;

				 }

				boolean a = true;
				while(true){
				 int c=n, min=999;
				 if (tot == n) // total no of process = completed process loop will be terminated
				 break;
				 for (int i=0; i<n; i++)
				 {
				/*
				 * If i'th process arrival time <= system time and its flag=0 and burst<min
				 * That process will be executed first
				 */
				if ((at[i] <= st) && (f[i] == 0) && (bt[i]<min))
				 {
				min=bt[i];
				c=i;
				}
				 }
				/* If c==n means c value cannot updated because no process arrival time< system time
				so we increase the system time */
				if (c==n)
				 st++;
				else
				 {
				ct[c]=st+bt[c];
				st+=bt[c];
				ta[c]=ct[c]-at[c];
				wt[c]=ta[c]-bt[c];
				f[c]=1;
				tot++;
				}
				}
				for(int i=0;i<n;i++)
				 {
				 avgwt+= wt[i];
				
				avgta+= ta[i];
				 }
				for(int i = 0 ; i< n; i++)
				ResultModel.addRow(new Object[]{PName[i],at[i],bt[i],pr[i],ct[i],ta[i],wt[i],wt[i]});


				// printing average turnaround time, Waiting Time & Response Time.
//
//				 textAVGTaT.setText(df.format(avgta/n));
//				 textAVGWTime.setText(df.format(avgwt/n));
//				 textAVGRTime.setText(df.format(avgwt/n));
				textAVGTaT.setText(Float.toString(avgta/n));
				textAVGWTime.setText(Float.toString(avgwt/n));
				textAVGRTime.setText(Float.toString(avgwt/n));
			
			}
		});
		btnSJF.setBounds(1156, 193, 89, 23);
		frame.getContentPane().add(btnSJF);
		
		JButton btnSjfpremptive = new JButton("SJF(Premptive)");
		btnSjfpremptive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel ReadyModel12=(DefaultTableModel) table_2.getModel();
				ReadyModel12.setRowCount(0);
				DefaultTableModel ReadyModel = (DefaultTableModel) table_1.getModel();
				DefaultTableModel ResultModel = (DefaultTableModel) table_2.getModel();
				//Object [] numdata=new Object[4];
				int n=table_1.getRowCount();
				String[] PName = new String[n]; // process Names
				int at[] = new int[n]; // arrival times
				int bt[] = new int[n]; // burst or execution times
				int pr[] = new int[n]; // Priority
				int ct[] = new int[n]; // completion times
				int ta[] = new int[n]; // turn around times
				int wt[] = new int[n]; // waiting times
				int rt[] = new int[n]; // response times
				int f[] = new int[n]; // flag to checks process is completed or not
				int k[]= new int[n]; // it is also stores burst time
				int FT[]= new int[n]; // it stores first time cpu assign
				boolean flag[]= new boolean[n]; // to check first time cpu assign or not
				int i, st=0, tot=0;
				float avgwt=0, avgta=0,avgrt=0;
				//Getting all Process Name, Arrival Time & Burst Time
				for (int count = 0; count < table_1.getRowCount(); count++){
				 PName[count]= (String) ReadyModel.getValueAt(count, 0);
				 at[count]= (int) ReadyModel.getValueAt(count, 1);
				 bt[count]= (int) ReadyModel.getValueAt(count, 2);
				 pr[count]= (int) ReadyModel.getValueAt(count, 3);
				 k[count]= bt[count];
				 f[count]=0;
				 flag[count]=true;
				 }
				while(true){
				int min=99,c=n;
				if (tot==n)
				break;
				for ( i=0;i<n;i++)
				 {
				 if ((at[i]<=st) && (f[i]==0) && (bt[i]<min))
				{
				min=bt[i];
				c=i;
				}
				 } //for loop end
				if (c==n)
				st++;
				else
				{
				//System.out.print("\nSystem time is "+st);
				if (flag[c])
				 {
				FT[c]=st;
				flag[c]=false;
				}
				 bt[c]--;
				 st++;
				 if (bt[c]==0)
				 {
				 ct[c]= st;
				f[c]=1;
				tot++;
				 }

				 } //else end
				} //While loop end

				for(i=0;i<n;i++)
				 {
				 ta[i] = ct[i] - at[i];
				 wt[i] = ta[i] - k[i];
				 rt[i] = FT[i] - at[i];
				 avgwt+= wt[i];
				 avgta+= ta[i];
				 avgrt+= rt[i];
				 }


				for(i = 0 ; i< n; i++)
				ResultModel.addRow(new Object[]{PName[i],at[i],k[i],pr[i],ct[i],ta[i],wt[i],rt[i]});


				// df.setRoundingMode(RoundingMode.UP);
				textAVGTaT.setText(Float.toString(avgta/n));
				textAVGWTime.setText(Float.toString(avgwt/n));
				textAVGRTime.setText(Float.toString(avgwt/n));
			}
		});
		btnSjfpremptive.setBounds(1057, 193, 89, 23);
		frame.getContentPane().add(btnSjfpremptive);
		
		JButton btnNewButton_1_1 = new JButton("RR");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel ReadyModel12=(DefaultTableModel) table_2.getModel();
				ReadyModel12.setRowCount(0);
				 DefaultTableModel ReadyModel = (DefaultTableModel) table_1.getModel();
				 DefaultTableModel ResultModel = (DefaultTableModel) table_2.getModel();
				 int n=table_1.getRowCount();
				 class Process {
				  int id;
				  int arrivalTime;
				  int burstTime;
				  int remainingTime;
				  public Process(int id, int arrivalTime, int burstTime) {
				  this.id = id;
				  this.arrivalTime = arrivalTime;
				  this.burstTime = burstTime;
				  this.remainingTime = burstTime;
				  }
				  }
				 String[] PName = new String[n]; // process Names
				 int at[] = new int[n]; // arrival times
				 int bt[] = new int[n]; // burst or execution times
				 int pr[] = new int[n]; // Priority
				 int ct[] = new int[n]; // completion times
				 int ta[] = new int[n]; // turn around times
				 int wt[] = new int[n]; // waiting times
				 int rt[] = new int[n]; // response times
				 int rbt[] = new int[n]; // For Remaining Burst times
				 boolean flag[]= new boolean[n]; 
				 int FT[]= new int[n]; 
				 int quantum;
				 //String tq=textFieldTQ.getText();
				 quantum=Integer.parseInt(textField.getText());
				  float TotalWT=0, TotalTA=0,TotalRT=0;
				  int temp;
				 String temp2=null;
				  List<Process> processes = new ArrayList<>();

				 //Getting all Process Name, Arrival Time & Burst Time
				 for (int count = 0; count < table_1.getRowCount(); count++){
				  PName[count]= (String) ReadyModel.getValueAt(count, 0);
				  at[count]= (int) ReadyModel.getValueAt(count, 1);
				  bt[count]= (int) ReadyModel.getValueAt(count, 2);
				  pr[count]= (int) ReadyModel.getValueAt(count, 3);

				  flag[count]=true;
				  //System.out.print(PName[count]+" "+at[count]+" "+bt[count]+"\n");
				  //ResultModel.addRow(pid);
				  }
				 //sorting according to arrival times
				  for(int i = 0 ; i <n; i++)
				  {
				  for(int j=0; j < n-(i+1) ; j++)
				  {
				  if( at[j] > at[j+1] )
				  {
					  temp = at[j];
					  at[j] = at[j+1];
					  at[j+1] = temp;
					  temp = bt[j];
					  bt[j] = bt[j+1];
					  bt[j+1] = temp;
					  temp = pr[j];
					  pr[j] = pr[j+1];
					  pr[j+1] = temp;
					  temp2 = PName[j];
					  PName[j] = PName[j+1];
					  PName[j+1] = temp2;
					  }
					  }
					  }
					  //Checking Sorting
					  // for(int i = 0 ; i <n; i++)
					  // System.out.print(PName[i]+" "+at[i]+" "+bt[i]+"\n");

					 for (int count = 0; count < n; count++)
					  processes.add(new Process(count, at[count], bt[count]));

					  int currentTime = processes.get(0).arrivalTime;
					  System.out.print(currentTime+"\n");
					  int completed = 0;
					  for (Process process : processes)
					  {
					  rbt[process.id] = process.burstTime;
					  //System.out.print(remainingTime[process.id - 1]+"\n");
					  }
					  while (completed != n)
					  {
					 for (Process process : processes)
					  {
					  //For First time CPU Assignment
					  if (flag[process.id])
					  {
					  FT[process.id]=currentTime;
					  flag[process.id]=false;
					 //System.out.print("\nSystem time"+PName[c]+" is "+FT[c]);
					  }

					  if (process.arrivalTime <= currentTime && process.remainingTime > 0)
					  {

					  if (process.remainingTime <= quantum)
					  {

					  currentTime += process.remainingTime;
					  process.remainingTime = 0;
					  completed++;
					  ct[process.id]=currentTime;
					  ta[process.id] = currentTime - process.arrivalTime;
					  wt[process.id] = ta[process.id] - process.burstTime;
					  rt[process.id] = FT[process.id] - process.arrivalTime;
					  } else
					  {
					  currentTime += quantum;
					  process.remainingTime -= quantum;

					  }

					 }


					 }
					  }
					  for (int i = 0; i < n; i++)
					  {
					  TotalWT += wt[i];
					  TotalTA += ta[i];
					  TotalRT += rt[i];
					  }
					 //sorting according to Process Name
					 for(int i = 0 ; i <n; i++)
					  {
					 for(int j=0; j < n-(i+1) ; j++)
					  {
					  int res = PName[j].compareTo(PName[j+1]);
					  if( res > 0 )
					  {
					  temp2 = PName[j];
					  PName[j] = PName[j+1];
					  PName[j+1] = temp2;
					  temp = at[j];
					  at[j] = at[j+1];
					  at[j+1] = temp;
					  temp = bt[j];
					  bt[j] = bt[j+1];
					  bt[j+1] = temp;
					  temp = ct[j];
					  ct[j] = ct[j+1];
					  ct[j+1] = temp;
					  temp = ta[j];
					  ta[j] = ta[j+1];
					  ta[j+1] = temp;
					  temp = wt[j];
					  wt[j] = wt[j+1];
					  wt[j+1] = temp;
					  temp = rt[j];
					  rt[j] = rt[j+1];
					  rt[j+1] = temp;
					  temp = pr[j];
					  pr[j] = pr[j+1];
					  pr[j+1] = temp;
					  }
					  }
					  }
					  // Adding rows to result Table
					 for(int i = 0 ; i< n; i++)
					 ResultModel.addRow(new
					 Object[]{PName[i],at[i],rbt[i],pr[i],ct[i],ta[i],wt[i],rt[i]});


					 textAVGTaT.setText(Float.toString(TotalTA/n));
						textAVGWTime.setText(Float.toString(TotalWT/n));
						textAVGRTime.setText(Float.toString(TotalRT/n));
					 

						  
			}
		});
		btnNewButton_1_1.setBounds(1160, 227, 89, 23);
		frame.getContentPane().add(btnNewButton_1_1);
		
		textField = new JTextField();
		textField.setBackground(SystemColor.controlShadow);
		textField.setBounds(1160, 255, 89, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblTimeQunatum = new JLabel("Time Qunatum");
		lblTimeQunatum.setBounds(1057, 261, 78, 14);
		frame.getContentPane().add(lblTimeQunatum);
		
		btnNewButton_3 = new JButton("Clear Result Queue");
		btnNewButton_3.setBackground(Color.GRAY);
		btnNewButton_3.setForeground(Color.BLUE);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel ReadyModel12=(DefaultTableModel) table_2.getModel();
				ReadyModel12.setRowCount(0);
			}
		});
		btnNewButton_3.setBounds(1057, 320, 192, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		btnNewButton_1_2 = new JButton("");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel ReadyModel12=(DefaultTableModel) table_2.getModel();
				ReadyModel12.setRowCount(0);
					 DefaultTableModel ReadyModel = (DefaultTableModel) table_1.getModel();
					 DefaultTableModel ResultModel = (DefaultTableModel) table_2.getModel();
					 int n=table_1.getRowCount();
					class Process {
					 int id;
					 String Pname;
					 int arrivalTime;
					 int burstTime;
					 int priority;
					public Process(int id,String Pname, int arrivalTime, int burstTime, int priority) {
					 this.id = id;
					 this.Pname = Pname;
					 this.arrivalTime = arrivalTime;
					 this.burstTime = burstTime;
					 this.priority = priority;
					}
					}
					String[] PName = new String[n];
					int at[] = new int[n]; 
					int bt[] = new int[n]; 
					int pr[] = new int[n]; 
					int ct[] = new int[n]; // completion times
					int ta[] = new int[n]; // turn around times
					int wt[] = new int[n]; // waiting times
					int rt[] = new int[n]; // response times
					List<Process> processes = new ArrayList<>();
					int currentTime = 0;
					float TotalWT=0, TotalTA=0,TotalRT=0;
					int temp;
					String temp2=null;
					//Getting all Process Name, Arrival Time & Burst Time
					for (int count = 0; count < table_1.getRowCount(); count++){
					 PName[count]= (String) ReadyModel.getValueAt(count, 0);
					 at[count]= (int) ReadyModel.getValueAt(count, 1);
					 bt[count]= (int) ReadyModel.getValueAt(count, 2);
					 pr[count]= (int) ReadyModel.getValueAt(count, 3);
					processes.add(new Process(count,PName[count], at[count], bt[count], pr[count]));
					System.out.print(PName[count]+" "+at[count]+" "+bt[count]+" "+pr[count]+"\n");
					 } // End of for loop
					// Sort the processes by arrival time
					processes.sort(Comparator.comparingInt(p -> p.arrivalTime));
					while (!processes.isEmpty())
					 {
					 Process currentProcess = null;
					 int highestPriority = Integer.MAX_VALUE;
					 for (Process p : processes)
					 {
					 if (p.arrivalTime <= currentTime && p.priority < highestPriority)
					 {
					 highestPriority = p.priority;
					 currentProcess = p;
					 }// End if
					}// End for loop
					if (currentProcess == null)
					 {
					 currentTime++;
					 } else
					 {
					 processes.remove(currentProcess);
					//System.out.println(currentProcess.id + " started at time " + currentTime);
					// rt[currentProcess.id]=currentTime-currentProcess.arrivalTime;
					 currentTime += currentProcess.burstTime;
					 ct[currentProcess.id]=currentTime;
					 ta[currentProcess.id]=ct[currentProcess.id]-currentProcess.arrivalTime;
					 wt[currentProcess.id]=ta[currentProcess.id]-currentProcess.burstTime;
					 System.out.println("P" + currentProcess.id + " " + currentProcess.Pname + " " +
							 currentProcess.arrivalTime+ " " + currentProcess.burstTime+ " "
							 +ct[currentProcess.id]+ " " +ta[currentProcess.id]+ " " +wt[currentProcess.id] );

							 }// End else
							 } // End While lop
							  for (int i = 0; i < n; i++)
							  {
							  TotalWT += wt[i];
							  TotalTA += ta[i];
							  TotalRT += rt[i];
							  }
							  //sorting according to Process Name
							  for(int i = 0 ; i <n; i++)
							  {
							  for(int j=0; j < n-(i+1) ; j++)
							  {
							  int res = PName[j].compareTo(PName[j+1]);
							  if( res > 0 )
							  {
							  temp2 = PName[j];
							  PName[j] = PName[j+1];
							  PName[j+1] = temp2;
							  temp = at[j];
							  at[j] = at[j+1];
							  at[j+1] = temp;
							  temp = bt[j];
							  bt[j] = bt[j+1];
							  bt[j+1] = temp;
							  temp = ct[j];
							  ct[j] = ct[j+1];
							  ct[j+1] = temp;
							  temp = ta[j];
							  ta[j] = ta[j+1];
							  ta[j+1] = temp;
							  temp = wt[j];
							  wt[j] = wt[j+1];
							  wt[j+1] = temp;

							  temp = pr[j];
							  pr[j] = pr[j+1];
							  pr[j+1] = temp;
							  }
							  }
							  }
							 for(int i = 0 ; i< n; i++)
							
							 ResultModel.addRow(new Object[]{PName[i],at[i],bt[i],pr[i],ct[i],ta[i],wt[i],wt[i]});
							
							 textAVGTaT.setText(Float.toString(TotalTA/n));
								textAVGWTime.setText(Float.toString(TotalWT/n));
								textAVGRTime.setText(Float.toString(TotalRT/n));
							 
			}
		});
		btnNewButton_1_2.setBounds(1057, 159, 89, 23);
		frame.getContentPane().add(btnNewButton_1_2);
		
		btnNewButton_4 = new JButton("Clear Result Queue");
		btnNewButton_4.setBackground(Color.GRAY);
		btnNewButton_4.setForeground(Color.CYAN);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel ReadyModel12=(DefaultTableModel) table.getModel();
				ReadyModel12.setRowCount(0);
			}
		});
		btnNewButton_4.setBounds(1091, 113, 137, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(264, 34, 184, 27);
		frame.getContentPane().add(textField_1);
		
		lblNewLabel_1 = new JLabel("  PName");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		lblNewLabel_1.setBackground(Color.RED);
		lblNewLabel_1.setBounds(77, 36, 80, 29);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_1_1 = new JLabel("  ATime");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(76, 92, 80, 29);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		lblNewLabel_1_2 = new JLabel("  BTime");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		lblNewLabel_1_2.setBounds(75, 147, 80, 29);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		lblNewLabel_1_3 = new JLabel("  Priority");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		lblNewLabel_1_3.setBounds(70, 203, 80, 29);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(268, 92, 184, 27);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(259, 150, 184, 27);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(261, 204, 184, 27);
		frame.getContentPane().add(textField_4);
		
		btnSave = new JButton("SAVE");
		Connection conn=null;//build connection
		Statement stmt=null;//
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSave.setForeground(SystemColor.activeCaption);
		btnSave.setFont(new Font("Stencil", Font.ITALIC, 18));
		btnSave.setBackground(Color.BLACK);
		btnSave.setBounds(212, 266, 89, 23);
		frame.getContentPane().add(btnSave);
		
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try { // Write INSERT query and in values(?,?) for optional values and these
					
					String query="insert into Process(PName,ATime,BTime,PRIORITY) "+ "values (?,?,?,?)";
					DSA d=new DSA();
					// Prepared Statement will execute the statement & insert the values into the table
					PreparedStatement pst=d.con.prepareStatement(query);
				
					pst.setString(1, textField_1.getText());
					pst.setString(2, textField_2.getText());
					pst.setString(3, textField_3.getText());
					pst.setString(4, textField_4.getText());
					
					pst.execute();
					// for successful insertion of data
					JOptionPane.showMessageDialog(null, "Data Saved");
					
				
					pst.close();
					} catch (SQLException ex) {
					ex.printStackTrace();
					}
					}
			
		});
	}
}
