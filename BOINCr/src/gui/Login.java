package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Login {

	private JFrame frame;
	private JTextField userField,dbField;
	private JPasswordField pwdField;
	public Login() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("LOGIN");
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("53px"),
				ColumnSpec.decode("140px"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("140px"),},
			new RowSpec[] {
				RowSpec.decode("44px"),
				RowSpec.decode("29px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("30px"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("19px"),
				RowSpec.decode("30px"),
				RowSpec.decode("25px"),}));
		
		JLabel lblUsername = new JLabel("Username");
		panel.add(lblUsername, "2, 2, left, fill");
		
		JLabel lblPassword = new JLabel("Password");
		panel.add(lblPassword, "2, 4, left, fill");
		
		JLabel lblNewLabel = new JLabel("Database");
		lblNewLabel.setLabelFor(lblNewLabel);
		panel.add(lblNewLabel, "2, 6, left, center");
		
		userField = new JTextField();
		lblUsername.setLabelFor(userField);
		panel.add(userField, "4, 2, left, center");
		userField.setColumns(12);
		
		pwdField = new JPasswordField();
		lblPassword.setLabelFor(pwdField);
		pwdField.setColumns(12);
		panel.add(pwdField, "4, 4, left, center");
		
		dbField = new JTextField();
		panel.add(dbField, "4, 6, left, top");
		dbField.setColumns(12);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		panel.add(btnCancel, "2, 8, fill, top");
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String user=userField.getText();
				String pwd=new String(pwdField.getPassword());
				String db=dbField.getText();
				String server="localhost";
				
				if(Main.A.getConnected(user, pwd, server, db)){	
					Main.win.setVisible(true);
					frame.dispose();
				}
				else{   
					String errmsg="<html><p align=\"center\"><strong><p align=\"center\">Login error</p></strong>" +
						"<p>Check Username and password</p></p></html>";
					ImageIcon icon=new ImageIcon(Login.class.getResource("/com/sun/java/swing/plaf/windows/icons/Error.gif"));		
					JOptionPane.showMessageDialog(frame, errmsg, "Login Error", 0,icon);
				} 
			}
		});
		panel.add(btnLogin, "4, 8, fill, top");
	}
}
