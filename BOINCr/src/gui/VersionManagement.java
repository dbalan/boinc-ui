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
public class VersionManagement extends JFrame {

	private JPanel contentPane;
	private JTextField zipField;
	private JTextField xmlField;
	private JCheckBox chckbxSigned;
	private JButton btnSelectsign;
	private String appid;
	/**
	 * Create the frame.
	 */
	public VersionManagement(String id) {
		this.appid=id;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 403, 251);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel label = new JLabel("__________     :");
		
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
		
		JLabel label_1 = new JLabel("_________       :");
		
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
        	    chooser.setFileFilter(new FileFilter() {
        	        public boolean accept(File f) {
        	            return f.isDirectory() || f.getName().toLowerCase().endsWith(".xml");
        	        }
        	        
        	        public String getDescription() {
        	            return "xml files";
        	        }
        	    });
        	    //
        	    // disable the "All files" option.
        	    //
        	    chooser.setAcceptAllFileFilterUsed(false);
        	    //    
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
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(57)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(zipField, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(xmlField, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(chckbxSigned, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)))
								.addComponent(label_1)))
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
					.addContainerGap(27, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(btnSelectZip)
						.addComponent(zipField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxSigned)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(xmlField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSelectsign))
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel)
						.addComponent(btnOk))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}
}
