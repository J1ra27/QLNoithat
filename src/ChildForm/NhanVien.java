package ChildForm;

import ChildForm.AddData.addKhachHang;
import ChildForm.AddData.addNhanVien;
import Databox.DataboxGioiTinh;
import QLNoiThat.ConnectDB;
import QLNoiThat.Login;
import java.util.List;
import java.sql.*;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;


public class NhanVien extends javax.swing.JInternalFrame {

    final String header[] = {"Mã nhân viên","Họ tên","Giới tính","Số điện thoại","Công việc"};
    final DefaultTableModel tb = new DefaultTableModel(header, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    ConnectDB cn = new ConnectDB();
    Connection conn;
    public NhanVien() {
        initComponents();
        initComponents();
        setMaximizable(true);
        this.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI)this.getUI();
        bui.setNorthPane(null);
        loadBang();
    }
public void loadBang(){
    try{
        conn = cn.getConnection();
        int number;
        Vector row;
        String sql = "select * from NhanVien";
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
            dgvNhanVien.setModel(tb);
        }
        st.close();
        rs.close(); 
        conn.close();   
    }catch(Exception e){
    }
    dgvNhanVien.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if(dgvNhanVien.getSelectedRow() >= 0){
                txtMaNV.setText(dgvNhanVien.getValueAt(dgvNhanVien.getSelectedRow(),0)+"");
                txtTenNV.setText(dgvNhanVien.getValueAt(dgvNhanVien.getSelectedRow(),1)+"");
                txtGioiTinh.setText(dgvNhanVien.getValueAt(dgvNhanVien.getSelectedRow(),2)+"");
                txtSDT.setText(dgvNhanVien.getValueAt(dgvNhanVien.getSelectedRow(),3)+"");
                txtCongViec.setText(dgvNhanVien.getValueAt(dgvNhanVien.getSelectedRow(),4)+"");
            }
        }
    });
}
private void xoaTrang(){
    txtMaNV.setText("");txtTenNV.setText("");txtGioiTinh.setText("");txtSDT.setText("");txtCongViec.setText("");
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnThem = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        txtCongViec = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        dgvNhanVien = new javax.swing.JTable();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        txtGioiTinh = new javax.swing.JTextField();
        btnLuu = new javax.swing.JButton();
        btnLammoi = new javax.swing.JButton();

        setResizable(true);

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

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Mã nhân viên :");

        txtMaNV.setEditable(false);
        txtMaNV.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNVActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Tên nhân viên :");

        txtTenNV.setEditable(false);
        txtTenNV.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTenNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenNVActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Giới tính :");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("SDT :");

        txtSDT.setEditable(false);
        txtSDT.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });

        txtCongViec.setEditable(false);
        txtCongViec.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtCongViec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCongViecActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Công việc :");

        dgvNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Họ tên", "Giới tính", "Số điện thoại","Công việc"
            }
        )
        {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        }
    );
    dgvNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            dgvNhanVienMouseClicked(evt);
        }
    });
    jScrollPane2.setViewportView(dgvNhanVien);

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

    txtGioiTinh.setEditable(false);
    txtGioiTinh.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    txtGioiTinh.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtGioiTinhActionPerformed(evt);
        }
    });

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

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(28, 28, 28)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabel10)
                .addComponent(jLabel9))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(txtMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addComponent(txtTenNV))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(jLabel12)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(jLabel11)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(18, 18, 18)
            .addComponent(jLabel13)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtCongViec, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(10, Short.MAX_VALUE))
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(16, 16, 16)
            .addComponent(btnLammoi)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(15, 15, 15))
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane2)
            .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(33, 33, 33)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMaNV)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTenNV)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCongViec)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addComponent(txtGioiTinh))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSDT)
                        .addComponent(jLabel12))))
            .addGap(18, 18, 18)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnLammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(16, 16, 16))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemActionPerformed

    private void txtMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNVActionPerformed

    private void txtTenNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenNVActionPerformed

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTActionPerformed

    private void txtCongViecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCongViecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCongViecActionPerformed

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        new addNhanVien().setVisible(true);
    }//GEN-LAST:event_btnThemMouseClicked

    private void btnSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        txtTenNV.setEditable(true);txtGioiTinh.setEditable(true);txtSDT.setEditable(true);txtCongViec.setEditable(true);btnLuu.setEnabled(true);
        int x = dgvNhanVien.getSelectedRow();
        if(x>0){
            txtMaNV.setText(dgvNhanVien.getValueAt(x, 0)+"");
            txtTenNV.setText(dgvNhanVien.getValueAt(x, 1)+"");
            txtGioiTinh.setText(dgvNhanVien.getValueAt(x, 2)+"");
            txtSDT.setText(dgvNhanVien.getValueAt(x, 3)+"");
            txtCongViec.setText(dgvNhanVien.getValueAt(x, 4)+"");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked
        conn = cn.getConnection();
        try {
            String sql ="Delete NhanVien where MaNhanVien = '"+txtMaNV.getText()+"'";
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

    private void txtGioiTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGioiTinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGioiTinhActionPerformed

    private void btnLuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLuuMouseClicked
    conn = cn.getConnection();
        try {
            if(txtTenNV.getText().equals("")||txtSDT.getText().equals("")||txtCongViec.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Bạn cần nhập đủ thông tin!");
            }else{
                Statement st = conn.createStatement();
                String sql ="Update NhanVien set TenNhanVien = N'"+txtTenNV.getText()+"',GioiTinh = N'"+txtGioiTinh.getText()+"',SDT = '"+txtSDT.getText()+"',CongViec = N'"+txtCongViec.getText()+"' where MaNhanVien ='"+txtMaNV.getText()+"'";
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
txtTenNV.setEditable(false);txtGioiTinh.setEditable(false);txtSDT.setEditable(false);txtCongViec.setEditable(false);btnLuu.setEnabled(false);
    }//GEN-LAST:event_btnLuuMouseClicked

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLuuActionPerformed

    private void dgvNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dgvNhanVienMouseClicked
        
    }//GEN-LAST:event_dgvNhanVienMouseClicked

    private void btnLammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLammoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLammoiActionPerformed

    private void btnLammoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLammoiMouseClicked
        loadBang();
    }//GEN-LAST:event_btnLammoiMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLammoi;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JTable dgvNhanVien;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtCongViec;
    private javax.swing.JTextField txtGioiTinh;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenNV;
    // End of variables declaration//GEN-END:variables
}
