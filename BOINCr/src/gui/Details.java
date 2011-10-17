package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Details extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private String id;
	@SuppressWarnings("unused")
	private String name;
	/**
	 * Launch the application.
	 */
	public Details() {
		id="null";
		init();
		
	}
	public Details(String Appid){
		id=Appid;
		init();
	}
	private void init(){
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 200, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel msglabel = new JLabel();
			msglabel.setText(setmsg());
			contentPanel.add(msglabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	private String setmsg(){
		String msg="<HTML><p align=\"center\"><table>";		
		String tableTmp = "id="+id;
		try{
		ResultSet rs=Main.Auth.getResult("*","app",tableTmp); 
		if(rs!=null){
			rs.first();
			msg+="<tr><td>Name</td><td>"+rs.getString("name")+"</td>";
			msg+="<tr><td>Min-Version</td><td>"+rs.getString("min_version")+"</td>";
			msg+="<tr><td>Weight</td><td>"+rs.getString("weight")+"</td>";
			msg+="<tr><td>Target Result</td><td>"+rs.getString("name")+"</td>";
			name=rs.getString("name");
		}
			msg+="</table></p></HTML>";
			return msg;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


}
