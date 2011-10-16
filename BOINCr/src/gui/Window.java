package gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;



import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import backend.ProjectDetails;
public class Window {

	private JFrame frame;
	private JTable table;
	private Object[][] data;
	private String ProjectDetails;
	private String ProjectPath;
	public Window() {
		Login l=new Login();
		l.setVisible(true);
		//initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	void initialize() {
		
		frame = new JFrame();
		frame.setTitle("BONICr");
		frame.setSize(550, 400);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		//frame.setIconImage(Toolkit.getDefaultToolkit().getImage("path"));
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
					Main.Auth.exit();
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
		MenuDisconect.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.CTRL_MASK));
		FileMenu.add(MenuDisconect);
		MenuDisconect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(MenuDisconect, "Disconnect Database ?","Exit",JOptionPane.OK_CANCEL_OPTION)==0)
				{
					Main.Auth.exit();
					setVisible(false);
					frame.pack();
					new Main();
				}
			}
		});
		
		final JMenuItem MenuExit = new JMenuItem("Exit");
		MenuExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(MenuExit, "Exit _______ ?","Exit",JOptionPane.OK_CANCEL_OPTION)==0){
					Main.Auth.exit();
					System.exit(0);
				}
					
			}
		});
		FileMenu.add(MenuExit);
		
		JMenu HelpMenu =new JMenu("Help");
		menuBar.add(HelpMenu);
		
		final JMenuItem MenuAbout= new JMenuItem("About");
		MenuAbout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg){
				String str="<html><p align =\"center\"><p>About</p><p></html>";
				JOptionPane.showMessageDialog(MenuAbout,str,"About",JOptionPane.INFORMATION_MESSAGE/*,new ImageIcon(icon)*/);
			}
		});
		HelpMenu.add(MenuAbout);
		
		
		JPanel ProjectPanel = new JPanel();
		tabbedPane.addTab("Project", null, ProjectPanel, null);
		tabbedPane.setEnabledAt(0, true);
		ProjectPanel.setLayout(new BorderLayout(0, 0));
		
		try {
			ProjectDetails=(new ProjectDetails(ProjectPath).projecthtml());
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		JLabel lblProject = new JLabel(ProjectDetails,JLabel.CENTER);
		ProjectPanel.add(lblProject, BorderLayout.CENTER);
		
		JLabel lblHead=new JLabel("<html><p><br><br><strong>PROJECT DETAILS</strong></p></html>",JLabel.CENTER);
		ProjectPanel.add(lblHead, BorderLayout.NORTH);
		
		
		JPanel Applicatonpannel = new JPanel();
		tabbedPane.addTab("App Management", null, Applicatonpannel, null);
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

		
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setapptable();
		table.setFillsViewportHeight(true);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setAutoscrolls(true);
		Table.add(table, BorderLayout.CENTER);
		
		JTableHeader tableheader=table.getTableHeader();
		Table.add(tableheader, BorderLayout.NORTH);
		
		JButton btnDetails = new JButton("Details");
		ActionListener delails=new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				int row=table.getSelectedRow();
				if(row==-1) return;
				String str=table.getValueAt(row,0).toString();
				new Details(str);
			}
		};
		btnDetails.registerKeyboardAction(delails,KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false),JComponent.WHEN_IN_FOCUSED_WINDOW);
		btnDetails.addActionListener(delails);
		GridBagConstraints gbc_btnDetails = new GridBagConstraints();
		gbc_btnDetails.fill = GridBagConstraints.BOTH;
		gbc_btnDetails.insets = new Insets(0, 0, 5, 0);
		gbc_btnDetails.gridx = 12;
		gbc_btnDetails.gridy = 4;
		Applicatonpannel.add(btnDetails, gbc_btnDetails);
		
		final JButton Deletebtn = new JButton("Delete Applicaton");
		ActionListener delete=new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row=table.getSelectedRow();
				if(row==-1) return;
				String str=(String) table.getValueAt(row,1);
				if (JOptionPane.showConfirmDialog(Deletebtn, "delete "+str+" ?",null,JOptionPane.YES_NO_OPTION)==0){
					/* delete application from database 
					*/
					//delete
					setapptable();
					JOptionPane.showMessageDialog(Deletebtn, "deteted");
				}
			}
		};
		Deletebtn.registerKeyboardAction(delete,KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0, false),JComponent.WHEN_IN_FOCUSED_WINDOW);
		Deletebtn.addActionListener(delete);
		
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
				new AddApplication();
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
	@SuppressWarnings("serial")
	public void setapptable(){
		//getdata from database;
		data=Main.Auth.getDataArray("id,user_friendly_name", "app");		
		table.setModel(new DefaultTableModel(data,
				new String[] {
					"ID", "APPLICATION"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false,false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		table.getColumnModel().getColumn(0).setMaxWidth(35);
	}
	public void setProjectPath(String path){
		ProjectPath=path;
	}
}
