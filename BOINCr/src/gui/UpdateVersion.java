package gui;
/**
 * @author abilng
 *
 */
import java.awt.BorderLayout;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

@SuppressWarnings("serial")
public class UpdateVersion extends JFrame {

	private JPanel contentPane;
	private JTextField zipField;
	private JTextField xmlField;
	private JCheckBox chckbxSigned;
	private JButton btnSelectsign;
	private String appid;
	/**
	 * Create the frame.
	 */
	public UpdateVersion(String id) {
		this.appid=id;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 403, 251);
		setTitle("Update Version");
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblZipfile = new JLabel("Zip File ");
		
		zipField = new JTextField();
		zipField.setEditable(false);
		zipField.setColumns(10);
		
		JButton btnSelectZip = new JButton("select");
		btnSelectZip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        		JFileChooser chooser;
		        		String choosertitle=null;
		        	    chooser = new JFileChooser(); 
		        	    chooser.setCurrentDirectory(new java.io.File("."));
		        	    chooser.setDialogTitle(choosertitle);
		        	    chooser.setFileFilter(new FileFilter() {
		        	        public boolean accept(File f) {
		        	            return f.isDirectory() || f.getName().toLowerCase().endsWith(".zip");
		        	        }
		        	        
		        	        public String getDescription() {
		        	            return "zip files";
		        	        }
		        	    });
		        	    //
		        	    // disable the "All files" option.
		        	    //
		        	    chooser.setAcceptAllFileFilterUsed(false);
		        	    //    
		        	    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { 
		        	    	zipField.setText(chooser.getSelectedFile().toString());
		        	      }
		        	   
		        }
		});
		
		chckbxSigned = new JCheckBox("Signed");
		chckbxSigned.setSelected(true);
		chckbxSigned.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxSigned.isSelected()){
					xmlField.setEnabled(false);
					btnSelectsign.setEnabled(false);
				}else{
					xmlField.setEnabled(true);
					btnSelectsign.setEnabled(true);
				}
				
			}
		});
		
		JLabel lblKeyFile = new JLabel("Key File");
		
		xmlField = new JTextField();
		xmlField.setEnabled(false);
		xmlField.setEditable(false);
		xmlField.setColumns(10);
		
		btnSelectsign = new JButton("select");
		btnSelectsign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
        		JFileChooser chooser;
        		String choosertitle=null;
        	    chooser = new JFileChooser(); 
        	    chooser.setCurrentDirectory(new java.io.File("."));
        	    chooser.setDialogTitle(choosertitle);
        	    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { 
        	    	xmlField.setText(chooser.getSelectedFile().toString());
        	      }
        	   
        }
});
		btnSelectsign.setEnabled(false);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.Win.setEnabled(true);
				dispose();
			}
		});
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(zipField.getText().isEmpty()||((!chckbxSigned.isSelected())&&xmlField.getText().isEmpty())) return;
				else{
					/*
					 * perform backend
					 */
					dispose();
					Main.Win.setmsg(appid);
					Main.Win.setEnabled(true);
				}
			}
		});
		
		JLabel label = new JLabel(":");
		
		JLabel label_2 = new JLabel(":");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(57)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblZipfile, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblKeyFile, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
							.addGap(6)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label, GroupLayout.DEFAULT_SIZE, 7, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(zipField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(chckbxSigned, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(xmlField)))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(82)
							.addComponent(btnCancel)
							.addGap(30)
							.addComponent(btnOk, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addComponent(btnSelectZip))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSelectsign)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblZipfile)
						.addComponent(btnSelectZip)
						.addComponent(zipField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxSigned)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblKeyFile)
								.addComponent(xmlField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSelectsign)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(8)
							.addComponent(label_2)))
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel)
						.addComponent(btnOk))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}
}
