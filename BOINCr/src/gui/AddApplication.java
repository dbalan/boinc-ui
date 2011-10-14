package gui;

import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author akhil
 */
@SuppressWarnings("serial")
public class AddApplication extends javax.swing.JFrame {
	 
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox platformComboBox;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel longNameLabel;
    private javax.swing.JLabel platformLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane platformScrollPane;
    private javax.swing.JTable platformTable;
    private javax.swing.JTextField appNameField;
    private javax.swing.JTextField userFriendlyField;
    private javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel();
    //private int select[];
    //private static int k=0;
    

    /** Creates new form AddApp */
    public AddApplication() {
        initComponents();
        setResizable(false);
 		setVisible(true);
    }

    

   
    public  void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        appNameField = new javax.swing.JTextField();
        longNameLabel = new javax.swing.JLabel();
        userFriendlyField = new javax.swing.JTextField();
        platformLabel = new javax.swing.JLabel();
        platformComboBox = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        platformScrollPane = new javax.swing.JScrollPane();
        platformTable = new javax.swing.JTable(model);
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        nameLabel.setText("Name");
        longNameLabel.setText("Userfriendly Name");
        platformLabel.setText("Platform");

        platformComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "windows_intelx86",
        "i686-pc-linux-gnu"}));

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        model.addColumn((String)"Selected Items");
        platformScrollPane.setViewportView(platformTable);

        jButton2.setText("Done");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gl_jPanel1 = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(gl_jPanel1);
        gl_jPanel1.setHorizontalGroup(
            gl_jPanel1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gl_jPanel1.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(gl_jPanel1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(longNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(platformLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gl_jPanel1.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(platformScrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(userFriendlyField, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(appNameField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, gl_jPanel1.createSequentialGroup()
                        .addGroup(gl_jPanel1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(gl_jPanel1.createSequentialGroup()
                                .addComponent(platformComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gl_jPanel1.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(28, 28, 28)))
                        .addGroup(gl_jPanel1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))))
                .addContainerGap())
        );
        gl_jPanel1.setVerticalGroup(
            gl_jPanel1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gl_jPanel1.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(gl_jPanel1.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(appNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(gl_jPanel1.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(longNameLabel)
                    .addComponent(userFriendlyField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(gl_jPanel1.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(platformLabel)
                    .addComponent(platformComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(platformScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(gl_jPanel1.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }//GEN-END:initComponents

public void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
	int selectedindex = platformComboBox.getSelectedIndex();
	
	//String str = (String)jComboBox1.getSelectedItem();
	//System.out.println(str);
    Object[] obj = new Object[]{platformComboBox.getSelectedItem()};
    model.addRow(obj);
   // select[k++] = selectedindex; causes null pointer exception
    platformComboBox.removeItemAt(selectedindex);
}

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
	String name = appNameField.getText();
	String friendly_name = userFriendlyField.getText();
	
	//String[] platforms=getSelectedPlatform(platformTable);
	try {
		new backend.AddApplication(null, name, friendly_name);
		//javax.swing.JOptionPane.showMessageDialog(null,"Applications added");
	} catch (SQLException e) {
	e.printStackTrace();
	}
	Main.Win.setapptable();
	dispose();
	Main.Win.setEnabled(true);
}

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
	dispose(); //can be called when addApp object is static
	Main.Win.setEnabled(true);
}

public String[] getSelectedPlatform (JTable table) {
    DefaultTableModel dtm = (DefaultTableModel) table.getModel();
    int nRow = dtm.getRowCount();
    String[] tableData = new String[nRow];
    for (int i = 0 ; i < nRow ; i++)
            tableData[i] = dtm.getValueAt(i,0).toString();
    return tableData;
}

   
}