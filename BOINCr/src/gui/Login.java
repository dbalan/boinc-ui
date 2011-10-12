package gui;
import gui.Main;
import javax.swing.*;

//import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class Login extends JFrame{
	
	private JButton jButton1 = new JButton("Login");
	private JLabel jLabel1 = new JLabel("Username*");
	private JLabel jLabel2 = new JLabel("Password*");
	private JLabel jLabel3 = new JLabel("Database*");
	private JPanel jPanel1  = new JPanel();
	private JPasswordField jPasswordField1 = new JPasswordField();
	private JTextField jTextField1 = new JTextField();
	private JTextField jTextField2 = new JTextField();
	private String Nul="";
	private JTextField hostField;
	private JTextField portField;
	private JLabel lblHost;
	private JLabel label;
	private JTextField pathField;
	
	public Login(){
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		requestFocus();
		setLocation(400, 200);
		//setIconImage(Toolkit.getDefaultToolkit().getImage("path"));
        getContentPane().setLayout(new java.awt.FlowLayout());
        
        lblHost = new JLabel("Host*");
        
        hostField = new JTextField();
        hostField.setColumns(10);
        hostField.setText("localhost");
        
        label = new JLabel(":");
        
        portField = new JTextField();
        portField.setColumns(10);
        portField.setText("3306");
        
JLabel lblProjectPath = new JLabel("ProjectPath");
        
        pathField = new JTextField();
        pathField.setColumns(10);
        javax.swing.GroupLayout gl_jPanel1 = new javax.swing.GroupLayout(jPanel1);
        gl_jPanel1.setHorizontalGroup(
        	gl_jPanel1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanel1.createSequentialGroup()
        			.addGap(72)
        			.addGroup(gl_jPanel1.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jButton1)
        				.addGroup(gl_jPanel1.createSequentialGroup()
        					.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
        						.addGroup(Alignment.TRAILING, gl_jPanel1.createSequentialGroup()
        							.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING, false)
        								.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
        								.addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        								.addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        								.addComponent(lblHost, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        							.addPreferredGap(ComponentPlacement.UNRELATED))
        						.addGroup(gl_jPanel1.createSequentialGroup()
        							.addComponent(lblProjectPath, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
        							.addGap(6)))
        					.addGroup(gl_jPanel1.createParallelGroup(Alignment.TRAILING, false)
        						.addComponent(pathField, Alignment.LEADING)
        						.addGroup(Alignment.LEADING, gl_jPanel1.createSequentialGroup()
        							.addComponent(hostField, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(label, GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(portField, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
        						.addComponent(jTextField1, Alignment.LEADING)
        						.addComponent(jPasswordField1, Alignment.LEADING)
        						.addComponent(jTextField2, Alignment.LEADING))))
        			.addGap(125))
        );
        gl_jPanel1.setVerticalGroup(
        	gl_jPanel1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanel1.createSequentialGroup()
        			.addGap(36)
        			.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jPasswordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel2))
        			.addGap(18)
        			.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel3)
        				.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblHost)
        				.addComponent(hostField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(label)
        				.addComponent(portField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblProjectPath)
        				.addComponent(pathField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jButton1)
        			.addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel1.setLayout(gl_jPanel1);
        
        ActionListener enter=new ActionListener(){
        	public void actionPerformed(ActionEvent ae){
        		if(jTextField1.getText().equals(Nul)){
        			JOptionPane.showMessageDialog(null,"Enter the Username");
        		}
        		else if(jPasswordField1.getPassword().equals(Nul)){
        			JOptionPane.showMessageDialog(null,"Enter the Password");
        		}
        		else if(jTextField2.getText().equals(Nul)){
        			JOptionPane.showMessageDialog(null,"Enter the Database Name");
        		}
        		else if(hostField.getText().equals(Nul)){
        			JOptionPane.showMessageDialog(null,"Enter the Host Address");
        		}
        		else if(portField.getText().equals(Nul)){
        			JOptionPane.showMessageDialog(null,"Enter the Port Number");
        		}
        		
        			
        		else{
        			String uname = jTextField1.getText();
        			String passwd = new String(jPasswordField1.getPassword());
        			String dbase = jTextField2.getText();
        			String host = hostField.getText()+":"+portField.getText();
        			if(Main.Auth.getConnected(uname, passwd, host, dbase)){
        				//JOptionPane.showMessageDialog(null,"connected to database");
        				Main.Win.initialize();
    					Main.Win.setVisible(true);
    					dispose();
        			}
        			else{
        				String errmsg="<html><p align=\"center\"><strong><p align=\"center\">Login error</p></strong>" +
        						"<p>invalid username or password</p></p></html>";
        				JOptionPane.showMessageDialog(null,errmsg);
        			}
        		}
        	}
        };
        jButton1.addActionListener(enter);
        jButton1.registerKeyboardAction(enter,KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false),JComponent.WHEN_IN_FOCUSED_WINDOW);
        getContentPane().add(jPanel1);
        pack();
        
	}
}
