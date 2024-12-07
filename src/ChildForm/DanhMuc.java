package ChildForm;

import ChildForm.AddData.addNoiThat;
import QLNoiThat.ConnectDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MaiCong
 */
public class DanhMuc extends javax.swing.JInternalFrame {
    
    final String header[] = {"Mã nội thất","Tên nội thất","Màu sắc","Kiểu loại","Chất liệu","Đơn giá"};
    final DefaultTableModel tb = new DefaultTableModel(header, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    ConnectDB cn = new ConnectDB();
    Connection conn;
    public DanhMuc() {
        initComponents();
        setMaximizable(true);
        this.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI)this.getUI();
        bui.setNorthPane(null);
        loadBang(); 
        
    }
    private void xoaTrang(){
    txtMaNT.setText("");txtTenNT.setText("");txtMau.setText("");txtKieu.setText("");txtChatLieu.setText("");txtDonGia.setText("");
    }
public void loadBang(){
    try{
        conn = cn.getConnection();
        int number;
        Vector row;
        String sql = "select * from NoiThat";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ResultSetMetaData metaData = rs.getMetaData();
        number = metaData.getColumnCount();
        tb.setRowCount(0);
        while(rs.next()){
            row = new Vector();
            for(int i =1; i <= number; i++)
                row.addElement(rs.getString(i));
            tb.addRow(row);
            dgvDanhMuc.setModel(tb);
        }
        st.close();
        rs.close(); 
        conn.close();   
    }catch(Exception e){
    }
    dgvDanhMuc.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if(dgvDanhMuc.getSelectedRow() >= 0){
                txtMaNT.setText(dgvDanhMuc.getValueAt(dgvDanhMuc.getSelectedRow(),0)+"");
                txtTenNT.setText(dgvDanhMuc.getValueAt(dgvDanhMuc.getSelectedRow(),1)+"");
                txtMau.setText(dgvDanhMuc.getValueAt(dgvDanhMuc.getSelectedRow(),2)+"");
                txtKieu.setText(dgvDanhMuc.getValueAt(dgvDanhMuc.getSelectedRow(),3)+"");
                txtChatLieu.setText(dgvDanhMuc.getValueAt(dgvDanhMuc.getSelectedRow(),4)+"");
                txtDonGia.setText(dgvDanhMuc.getValueAt(dgvDanhMuc.getSelectedRow(),5)+"");
            }
        }
    });
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        dgvDanhMuc = new javax.swing.JTable();
        txtMaNT = new javax.swing.JTextField();
        txtMau = new javax.swing.JTextField();
        txtTenNT = new javax.swing.JTextField();
        txtChatLieu = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtKieu = new javax.swing.JTextField();
        btnLuu = new javax.swing.JButton();
        btnLammoi = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();

        setBorder(null);
        setResizable(true);

        dgvDanhMuc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(dgvDanhMuc);

        txtMaNT.setEditable(false);
        txtMaNT.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtMaNT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNTActionPerformed(evt);
            }
        });

        txtMau.setEditable(false);
        txtMau.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        txtTenNT.setEditable(false);
        txtTenNT.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTenNT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenNTActionPerformed(evt);
            }
        });

        txtChatLieu.setEditable(false);
        txtChatLieu.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        txtDonGia.setEditable(false);
        txtDonGia.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Chất liệu :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Đơn giá :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Màu sắc :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Kiểu loại :");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Mã nội thất :");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Tên nội thất :");

        txtKieu.setEditable(false);
        txtKieu.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        btnLuu.setText("Lưu");
        btnLuu.setEnabled(false);
        btnLuu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLuuMouseClicked(evt);
            }
        });
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnLammoi.setText("Làm mới");
        btnLammoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLammoiMouseClicked(evt);
            }
        });
        btnLammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLammoiActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaMouseClicked(evt);
            }
        });
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaMouseClicked(evt);
            }
        });
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaNT, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addComponent(txtTenNT))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtKieu, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMau, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtChatLieu, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addComponent(txtDonGia))
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnLammoi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtChatLieu)
                            .addComponent(txtMau)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMaNT)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtDonGia))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTenNT)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtKieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenNTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenNTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenNTActionPerformed

    private void txtMaNTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNTActionPerformed

    private void btnLuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLuuMouseClicked
        conn = cn.getConnection();
        try {
            if(txtTenNT.getText().equals("")||txtMau.getText().equals("")||txtKieu.getText().equals("")||txtChatLieu.getText().equals("")||txtDonGia.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Bạn cần nhập đủ thông tin!");
            }else{
                Statement st = conn.createStatement();
                String sql ="Update NoiThat set TenNoiThat = N'"+txtTenNT.getText()+"',Mau = N'"+txtMau.getText()+"',KieuLoai = N'"+txtKieu.getText()+"',ChatLieu = N'"+txtChatLieu.getText()+"',DonGia = '"+txtDonGia.getText()+"' where MaNoiThat ='"+txtMaNT.getText()+"'";
                st = conn.createStatement();
                int kq = st.executeUpdate(sql);
                if (kq>0){
                    JOptionPane.showMessageDialog(this,"Cập nhật thành công!");
                    xoaTrang();
                }
                st.close();
            }
            conn.close();
        } catch (Exception e) {
        }
        txtTenNT.setEditable(false);txtMau.setEditable(false);txtKieu.setEditable(false);txtChatLieu.setEditable(false);txtDonGia.setEditable(false);btnLuu.setEnabled(false);
    }//GEN-LAST:event_btnLuuMouseClicked

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnLammoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLammoiMouseClicked
        loadBang();
    }//GEN-LAST:event_btnLammoiMouseClicked

    private void btnLammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLammoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLammoiActionPerformed

    private void btnSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        txtTenNT.setEditable(true);txtMau.setEditable(true);txtKieu.setEditable(true);txtChatLieu.setEditable(true);txtDonGia.setEditable(true);btnLuu.setEnabled(true);
        int x = dgvDanhMuc.getSelectedRow();
        if(x>0){
            txtMaNT.setText(dgvDanhMuc.getValueAt(x, 0)+"");
            txtTenNT.setText(dgvDanhMuc.getValueAt(x, 1)+"");
            txtMau.setText(dgvDanhMuc.getValueAt(x, 2)+"");
            txtKieu.setText(dgvDanhMuc.getValueAt(x, 3)+"");
            txtChatLieu.setText(dgvDanhMuc.getValueAt(x, 4)+"");
            txtDonGia.setText(dgvDanhMuc.getValueAt(x, 5)+"");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        new addNoiThat().setVisible(true);
    }//GEN-LAST:event_btnThemMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked
        conn = cn.getConnection();
        try {
            String sql ="Delete NoiThat where MaNoiThat = '"+txtMaNT.getText()+"'";
            Statement st = conn.createStatement();
            int chk  = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?","Thông báo",JOptionPane.YES_NO_OPTION);
            if(chk==JOptionPane.YES_OPTION){
                st.executeUpdate(sql);
                xoaTrang();
                JOptionPane.showMessageDialog(this,"Xóa thành công!");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnXoaMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLammoi;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JTable dgvDanhMuc;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtChatLieu;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtKieu;
    private javax.swing.JTextField txtMaNT;
    private javax.swing.JTextField txtMau;
    private javax.swing.JTextField txtTenNT;
    // End of variables declaration//GEN-END:variables
}
