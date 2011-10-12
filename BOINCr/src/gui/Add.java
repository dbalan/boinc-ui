package gui;

import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
//import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
public class Add {
	JFrame Addframe;
	private JTextField AppField;
	private JComboBox PlatformField;
	public Add() {
					initialize();	
					Addframe.setVisible(true);
					Addframe.requestFocus();
	}

	private void initialize() {
		Addframe = new JFrame();
		Addframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Addframe.setResizable(false);
		Addframe.setLocation(400, 200);
		Addframe.setMinimumSize(new Dimension(400,200));
		Addframe.setTitle("Add Application");
		Addframe.setAlwaysOnTop(true);
		
		final JPanel panel = new JPanel();
		Addframe.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
	
		JLabel lblApplication = new JLabel("Application");
		lblApplication.setBounds(61, 33, 117, 15);
		panel.add(lblApplication);
		
		JLabel lblPlatform = new JLabel("Platform");
		lblPlatform.setBounds(61, 73, 117, 15);
		panel.add(lblPlatform);
		
		AppField = new JTextField();
		lblApplication.setLabelFor(AppField);
		AppField.setBounds(196, 31, 171, 19);
		panel.add(AppField);
		AppField.setColumns(10);
		
		PlatformField = new JComboBox();
		setplatforms();
		PlatformField.setBounds(196, 71, 171, 19);
		panel.add(PlatformField);
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Addframe.dispose();
				Main.Win.setEnabled(true);
			}
		});
		btnCancel.setBounds(61, 115, 117, 25);
		panel.add(btnCancel);
		
		JButton btnAdd = new JButton("Add");
		ActionListener add = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String app=AppField.getText();
				String platform=PlatformField.getSelectedItem().toString();
				if(!app.isEmpty() &&!platform.isEmpty()){
					//final JPanel panel = new JPanel();
				    //if (JOptionPane.showConfirmDialog(panel, "Add "+app +" ("+platform+") "," Add Application",JOptionPane.OK_CANCEL_OPTION )==0){
					//addtodatabase
					//JOptionPane.showMessageDialog(btnAdd,app +" ("+platform+") added","Application added",JOptionPane.INFORMATION_MESSAGE);
					//Main.A.addApp(app,platform);
					Main.Win.setapptable();
					Addframe.dispose();
					Main.Win.setEnabled(true);
					
				//}
				//else return;
				}		
			}
		};
		btnAdd.addActionListener(add);
		btnAdd.registerKeyboardAction(add,KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false),JComponent.WHEN_IN_FOCUSED_WINDOW);
		btnAdd.setBounds(239, 115, 117, 25);
		panel.add(btnAdd);
		
		
		
	
	}
	public void setplatforms(){
		String[] data;
		ResultSet rs=Main.Auth.getresult("name","platform");
		int rows =Main.Auth.getRowsNos(rs);
		data=new String[rows];
		int i=0;
		try {
			while(rs.next()){
					data[i]=rs.getString("name");
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DefaultComboBoxModel platforms;
		platforms=new DefaultComboBoxModel(data);
		PlatformField.setModel(platforms);
	}
}
