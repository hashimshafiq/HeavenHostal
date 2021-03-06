/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heavenhostal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hashim
 */
public class DeleteCustomer extends javax.swing.JFrame {

    /**
     * Creates new form DeleteCustomer
     */
    public DeleteCustomer() {
        initComponents();
        setResizable(false);
        setSize(660,280);
        getContentPane().setBackground(Color.YELLOW);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("deleteuser.png")));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
        MyHandler handler = new MyHandler();
        validatebut.addActionListener(handler);
        deletebut.addActionListener(handler);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cnictext = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        validatebut = new javax.swing.JButton();
        deletebut = new javax.swing.JButton();
        cancelbut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Delete Customer");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("CNIC:");

        cnictext.setBackground(new java.awt.Color(204, 255, 204));
        cnictext.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "CNIC", "Phone", "Occupation"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        validatebut.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        validatebut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heavenhostal/confirm.png"))); // NOI18N
        validatebut.setText("Validate");

        deletebut.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        deletebut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heavenhostal/deleteuser.png"))); // NOI18N
        deletebut.setText("Delete");

        cancelbut.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        cancelbut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heavenhostal/cancel.png"))); // NOI18N
        cancelbut.setText("Cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(validatebut)
                        .addGap(26, 26, 26)
                        .addComponent(deletebut)
                        .addGap(33, 33, 33)
                        .addComponent(cancelbut))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addComponent(cnictext, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)))
                .addGap(21, 21, 21))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelbut, deletebut, validatebut});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cnictext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(validatebut)
                    .addComponent(deletebut)
                    .addComponent(cancelbut))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public class MyHandler implements ActionListener{
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        DBConnection dbs = new DBConnection();
        Connection conn = dbs.db();
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Validate")){
                int counter = model.getRowCount();
                
                for(int i =counter-1;i>=0;i-- ){
                    
                    model.removeRow(i);
                }
                try{
                    Statement stmt = conn.createStatement();
                    String query = "select * from customer where cnic = '"+cnictext.getText()+"'";
                    ResultSet rs = stmt.executeQuery(query);
                    while(rs.next()){
                        if(rs.getString(2).equals(cnictext.getText())){
                            String[] st = new String[4];
                            st[0] = rs.getString(1);
                            st[1] = rs.getString(2);
                            st[2] = rs.getString(3);
                            st[3] = rs.getString(4);
                            model.addRow(st);
                        }
                    }
                    
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"Error retrieving Database","Error", 0);
                }
            
            }else if(e.getActionCommand().equals("Delete")){
               
                if(jTable1.isRowSelected(0)){
                    String cnic = (String)model.getValueAt(0, 1);
                    try{
                        Statement stmt = conn.createStatement();
                        int choice = JOptionPane.showConfirmDialog(null,"Are You Sure to Delete this Record ?","Delete Confirmation", 2);
                        
                        if(choice == JOptionPane.OK_OPTION){
                            String query = "delete from customer where cnic = '"+cnic+"'";
                            String query2 = "update rooms set roomstatus = 'available',ownername = 'null', cnic = 'null' where cnic = '"+cnic+"'";
                            int result = stmt.executeUpdate(query);
                            int result2 = stmt.executeUpdate(query2);
                            if(result > 0 && result2>0){
                                model.removeRow(0);
                                JOptionPane.showMessageDialog(null,"Record Deleted Successfully","Info",1);
                                
                            }
                        }
                    }catch(SQLException | HeadlessException ex){
                        JOptionPane.showMessageDialog(null,"Error Deleting Row","Error",0);
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Please Select Field From Table To Delete","Error",0);
                }
            }
        }
    
    
    
    }
   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelbut;
    private javax.swing.JTextField cnictext;
    private javax.swing.JButton deletebut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton validatebut;
    // End of variables declaration//GEN-END:variables
}
