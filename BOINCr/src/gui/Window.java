package gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
public class Window {

	private JFrame frame;
	private JTable table;
	public Window() {
		initialize();
		{
			new Login();
		}
		setVisible(false);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(1000,500));
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
					Main.A.exit();
					System.exit(0);
			}
			});
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu FileMenu = new JMenu("File");
		menuBar.add(FileMenu);
		
		final JMenuItem MenuDisconect = new JMenuItem("Disconnect");
		FileMenu.add(MenuDisconect);
		MenuDisconect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(MenuDisconect, "Disconnect Database ?","Exit",JOptionPane.OK_CANCEL_OPTION)==0)
				{
					Main.A.exit();
					setVisible(false);
					new Login();
				}
			}
		});
		
		final JMenuItem MenuExit = new JMenuItem("Exit");
		MenuExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(MenuExit, "Exit _______ ?","Exit",JOptionPane.OK_CANCEL_OPTION)==0){
					Main.A.exit();
					System.exit(0);
				}
					
			}
		});
		FileMenu.add(MenuExit);
		JPanel Applicatonpannel = new JPanel();
		tabbedPane.addTab("Applications", null, Applicatonpannel, null);
		tabbedPane.setEnabledAt(0, true);
		GridBagLayout gbl_Applicatonpannel = new GridBagLayout();
		gbl_Applicatonpannel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_Applicatonpannel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_Applicatonpannel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_Applicatonpannel.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		Applicatonpannel.setLayout(gbl_Applicatonpannel);
		
		JPanel Table = new JPanel();
		Table.setLayout(new BorderLayout(0, 0));
		
		
		JScrollPane Tablepanel = new JScrollPane(Table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		GridBagConstraints gbc_Tablepanel = new GridBagConstraints();
		gbc_Tablepanel.gridheight = 7;
		gbc_Tablepanel.gridwidth = 12;
		gbc_Tablepanel.insets = new Insets(0, 0, 5, 5);
		gbc_Tablepanel.fill = GridBagConstraints.BOTH;
		gbc_Tablepanel.gridx = 0;
		gbc_Tablepanel.gridy = 1;
		Applicatonpannel.add(Tablepanel, gbc_Tablepanel);

		//data for testing
		Object[][] data = {
				{ "4567" , "8675Gail" },
				{ "Ken7566", "5555" },
				{ "Viviane5634", "5887" },
				{ "Melanie7345", "9222" },
				{ "Anne1237", "3333" },
				{ "John5656", "3144" },
				{ "Matt5672", "2176" },
				{ "Claire6741", "4244" },
				{ "Erwin9023", "5159" },
				{ "Ellen1134", "5332" },
				{ "Jennif5689", "1212" },
				{ "Ed9030", "1313" },
				{ "He6751", "1415" },
				{ "Anne1237", "3333" },
				{ "John5656", "3144" },
				{ "Matt5672", "2176" },
				{ "Claire6741", "4244" },
				{ "Erwin9023", "5159" },
				{ "Ellen1134", "5332" },
				{ "Jennif5689", "1212" },
				};

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(data,
			new String[] {
				"NO", "APPLICATION"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		table.getColumnModel().getColumn(1).setPreferredWidth(105);
		table.setFillsViewportHeight(true);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setAutoscrolls(true);
		Table.add(table, BorderLayout.CENTER);
		
		final JButton Deletebtn = new JButton("Delete Applicaton");
		Deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row=table.getSelectedRow();
				if(row==-1) return;
				String str=(String) table.getValueAt(row,1);
				if (JOptionPane.showConfirmDialog(Deletebtn, "delete "+str+" ?")==0){
					//delete
					JOptionPane.showMessageDialog(Deletebtn, "deteted");
				}
			}
		});
		GridBagConstraints gbc_Deletebtn = new GridBagConstraints();
		gbc_Deletebtn.fill = GridBagConstraints.HORIZONTAL;
		gbc_Deletebtn.insets = new Insets(0, 0, 5, 0);
		gbc_Deletebtn.gridx = 12;
		gbc_Deletebtn.gridy = 5;
		Applicatonpannel.add(Deletebtn, gbc_Deletebtn);
		
		JButton Addbtn = new JButton("Add Applicaton");
		Addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setEnabled(false);
				new Add();
				}
		});
		
		GridBagConstraints gbc_Addbtn = new GridBagConstraints();
		gbc_Addbtn.fill = GridBagConstraints.HORIZONTAL;
		gbc_Addbtn.insets = new Insets(0, 0, 5, 0);
		gbc_Addbtn.gridx = 12;
		gbc_Addbtn.gridy = 6;
		Applicatonpannel.add(Addbtn, gbc_Addbtn);
		
		JTabbedPane tabbedPanel2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("test", null, tabbedPanel2, null);
		tabbedPane.setEnabledAt(1, true);
		
	}
	public void setVisible(boolean val){
		frame.setVisible(val);
	}
	public void setEnabled(boolean val){
		frame.setEnabled(val);
	}
}