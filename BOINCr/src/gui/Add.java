package gui;

import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Add {
	JFrame Addframe;
	private JTextField AppField,PlatformField;
	public Add() {
					initialize();	
					Addframe.setVisible(true);
	}

	private void initialize() {
		Addframe = new JFrame();
		Addframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Addframe.setResizable(false);
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
		AppField.setBounds(225, 31, 114, 19);
		panel.add(AppField);
		AppField.setColumns(10);
		
		PlatformField = new JTextField();
		lblPlatform.setLabelFor(PlatformField);
		PlatformField.setBounds(225, 71, 114, 19);
		panel.add(PlatformField);
		PlatformField.setColumns(10);
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Addframe.dispose();
				Main.win.setEnabled(true);
			}
		});
		btnCancel.setBounds(61, 115, 117, 25);
		panel.add(btnCancel);
		
		final JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String app=AppField.getText();
				String platform=PlatformField.getText();
				if(!app.isEmpty() &&!platform.isEmpty()){
					//final JPanel panel = new JPanel();
				    //if (JOptionPane.showConfirmDialog(panel, "Add "+app +" ("+platform+") "," Add Application",JOptionPane.OK_CANCEL_OPTION )==0){
					//addtodatabase
					//JOptionPane.showMessageDialog(btnAdd,app +" ("+platform+") added","Application added",JOptionPane.INFORMATION_MESSAGE);
					Main.win.setapptable();
					Addframe.dispose();
					Main.win.setEnabled(true);
					
				//}
				//else return;
				}		
			}
		});
		btnAdd.setBounds(225, 115, 117, 25);
		panel.add(btnAdd);
	}
}
