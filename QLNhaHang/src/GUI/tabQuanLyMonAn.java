/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import CRUD.layDuLieuSQL;
import Object.MonAn;
import Object.NhomMonAn;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.util.HashSet;
import java.util.Set;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
/**
 *
 * @author HoCanhQuy
 */
public class tabQuanLyMonAn extends javax.swing.JPanel {

    DefaultTableModel tableModel;
    layDuLieuSQL layDuLieu = new layDuLieuSQL();
    int selected = -1;
    public tabQuanLyMonAn() {
        initComponents();
        layDuLieu();
        FlatSVGIcon iconAdd = new FlatSVGIcon("Images/add.svg", 25, 25);
        btnThemMon.setIcon(iconAdd);
        FlatSVGIcon iconDel = new FlatSVGIcon("Images/delete.svg", 25, 25);
        btnXoaMon.setIcon(iconDel);
        FlatSVGIcon iconChange = new FlatSVGIcon("Images/edit.svg", 25, 25);
        btnSuaMon.setIcon(iconChange);
        FlatSVGIcon iconRefresh = new FlatSVGIcon("Images/refresh.svg", 25, 25);
        btnLamMoi.setIcon(iconRefresh);
        tbHienThiMonAn.setShowGrid(true);
        tbHienThiMonAn.setGridColor(new Color(224, 224, 224));
    }
    public void layDuLieu(){
        tableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };
        
        tableModel.addColumn("Mã món");
        tableModel.addColumn("Tên món");
        tableModel.addColumn("Đơn vị tính");
        tableModel.addColumn("Đơn giá");
        tableModel.addColumn("Trạng thái");
        tableModel.addColumn("Tên nhóm");
        
        cbTrangThai.removeAllItems();
        cbTrangThai.addItem("Chọn trạng thái");
        cbTrangThai.addItem("Hoạt động");
        cbTrangThai.addItem("Ngừng kinh doanh");
        
        Set<String> set = new HashSet<>();
        for(MonAn mon: layDuLieu.getDsMonAn()){
            long donGia = (long) mon.getDonGia();
            set.add(mon.getDonViTinh());
            tableModel.addRow(new Object[]{
                mon.getMaMonAn(),
                mon.getTenMon(),
                mon.getDonViTinh(),
                donGia,
                mon.getTrangThai(),
                mon.getMaNhom()
            });
        }
        tbHienThiMonAn.setModel(tableModel);
        cbDonViTinh.removeAllItems();
        cbDonViTinh.addItem("Chọn đơn vị");
        for(String s: set){
            cbDonViTinh.addItem(s);
        }
        
        cbTenNhom.removeAllItems();
        cbTenNhom.addItem("Chọn tên nhóm");
        for(NhomMonAn nhom: layDuLieu.getDsNhomMonAn()){
            cbTenNhom.addItem(nhom.getTenNhom());
        }
    }
    
    boolean kiemTraDuLieu() {
    if (txtTenMon.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Tên món ăn không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    if (cbDonViTinh.getSelectedIndex() <= 0) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn đơn vị tính!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    if (txtDonGia.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Đơn giá không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    try {
        long donGia = Long.parseLong(txtDonGia.getText().trim());
        if (donGia < 0) {
            JOptionPane.showMessageDialog(this, "Đơn giá không được âm!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Đơn giá phải là một con số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    if (cbTrangThai.getSelectedIndex() <= 0) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn trạng thái!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    if (cbTenNhom.getSelectedIndex() <= 0) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn nhóm món ăn!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    return true;
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnThongTinMon = new javax.swing.JPanel();
        cbDonViTinh = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbTrangThai = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbTenNhom = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtTenMon = new javax.swing.JTextField();
        pnChucNang = new javax.swing.JPanel();
        btnThemMon = new javax.swing.JButton();
        btnSuaMon = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnXoaMon = new javax.swing.JButton();
        pnDanhSach = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHienThiMonAn = new javax.swing.JTable();

        pnThongTinMon.setBackground(new java.awt.Color(255, 255, 255));
        pnThongTinMon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin món ăn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 14), new java.awt.Color(51, 51, 51))); // NOI18N

        cbDonViTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Đơn giá:");

        jLabel4.setText("Trạng thái:");

        cbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Tên nhóm:");

        cbTenNhom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Đơn vị tính:");

        jLabel1.setText("Tên món ăn:");

        javax.swing.GroupLayout pnThongTinMonLayout = new javax.swing.GroupLayout(pnThongTinMon);
        pnThongTinMon.setLayout(pnThongTinMonLayout);
        pnThongTinMonLayout.setHorizontalGroup(
            pnThongTinMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThongTinMonLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pnThongTinMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(50, 50, 50)
                .addGroup(pnThongTinMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbTrangThai, 0, 262, Short.MAX_VALUE)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbDonViTinh, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTenMon, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbTenNhom, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70))
        );
        pnThongTinMonLayout.setVerticalGroup(
            pnThongTinMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTinMonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnThongTinMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTenMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnThongTinMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbDonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnThongTinMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnThongTinMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnThongTinMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbTenNhom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        pnChucNang.setBackground(new java.awt.Color(255, 255, 255));
        pnChucNang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 14), new java.awt.Color(51, 51, 51))); // NOI18N

        btnThemMon.setBackground(new java.awt.Color(51, 204, 255));
        btnThemMon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThemMon.setText("Thêm món ăn");
        btnThemMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMonActionPerformed(evt);
            }
        });

        btnSuaMon.setBackground(new java.awt.Color(51, 204, 255));
        btnSuaMon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSuaMon.setText("Sửa món ăn");
        btnSuaMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaMonActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(51, 204, 255));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnXoaMon.setBackground(new java.awt.Color(51, 204, 255));
        btnXoaMon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoaMon.setText("Xoá món ăn");
        btnXoaMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaMonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnChucNangLayout = new javax.swing.GroupLayout(pnChucNang);
        pnChucNang.setLayout(pnChucNangLayout);
        pnChucNangLayout.setHorizontalGroup(
            pnChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnChucNangLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pnChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThemMon, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(btnXoaMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(pnChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSuaMon, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        pnChucNangLayout.setVerticalGroup(
            pnChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChucNangLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemMon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaMon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaMon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        pnDanhSach.setBackground(new java.awt.Color(255, 255, 255));
        pnDanhSach.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách món ăn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 14))); // NOI18N

        tbHienThiMonAn.setModel(new javax.swing.table.DefaultTableModel(
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
        tbHienThiMonAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHienThiMonAnMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbHienThiMonAn);

        javax.swing.GroupLayout pnDanhSachLayout = new javax.swing.GroupLayout(pnDanhSach);
        pnDanhSach.setLayout(pnDanhSachLayout);
        pnDanhSachLayout.setHorizontalGroup(
            pnDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        pnDanhSachLayout.setVerticalGroup(
            pnDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnThongTinMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(pnDanhSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnThongTinMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnChucNang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnDanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMonActionPerformed
        // TODO add your handling code here:
        if (!kiemTraDuLieu()) {
            return;
        }

        String tenMon = txtTenMon.getText().trim();
        String donViTinh = cbDonViTinh.getSelectedItem().toString();
        long donGia = Long.parseLong(txtDonGia.getText().trim());
        String trangThai = cbTrangThai.getSelectedItem().toString();
        String tenNhom = cbTenNhom.getSelectedItem().toString();

        int maNhom = -1;
        for (NhomMonAn nhom : layDuLieu.getDsNhomMonAn()) {
            if (nhom.getTenNhom().equals(tenNhom)) {
                maNhom = nhom.getMaNhom();
                break;
            }
        }

        if (maNhom == -1) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy nhóm món ăn!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection conn = CRUD.ConnectSQL.getConnection();
            CallableStatement cs = conn.prepareCall("{call sp_ThemMonAn(?, ?, ?, ?, ?)}")) {

            cs.setString(1, tenMon);
            cs.setString(2, donViTinh);
            cs.setLong(3, donGia);
            cs.setString(4, trangThai);
            cs.setInt(5, maNhom);

            cs.execute();
            JOptionPane.showMessageDialog(this, "Thêm món ăn thành công!");
            layDuLieu();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi khi thêm món ăn: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnThemMonActionPerformed

    private void btnSuaMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaMonActionPerformed
        // TODO add your handling code here:
        int selectedRow = tbHienThiMonAn.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một món ăn để sửa!", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!kiemTraDuLieu()) {
            return;
        }

        String maMonAnStr = tbHienThiMonAn.getValueAt(selectedRow, 0).toString();
        int maMonAn = Integer.parseInt(maMonAnStr);

        String tenMon = txtTenMon.getText().trim();
        String donViTinh = cbDonViTinh.getSelectedItem().toString();
        long donGia = Long.parseLong(txtDonGia.getText().trim());
        String trangThai = cbTrangThai.getSelectedItem().toString();
        String tenNhom = cbTenNhom.getSelectedItem().toString();

        int maNhom = -1;
        for (NhomMonAn nhom : layDuLieu.getDsNhomMonAn()) {
            if (nhom.getTenNhom().equals(tenNhom)) {
                maNhom = nhom.getMaNhom();
                break;
            }
        }

        if (maNhom == -1) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy nhóm món ăn!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String sql = "{call sp_SuaMonAn(?, ?, ?, ?, ?, ?)}";
        try (Connection conn = CRUD.ConnectSQL.getConnection();
            CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, maMonAn);
            cs.setString(2, tenMon);
            cs.setString(3, donViTinh);
            cs.setLong(4, donGia);
            cs.setString(5, trangThai);
            cs.setInt(6, maNhom);

            cs.execute();
            JOptionPane.showMessageDialog(this, "Cập nhật món ăn thành công!");
            layDuLieu();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật món ăn: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSuaMonActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        txtTenMon.setText("");
        cbDonViTinh.setSelectedIndex(0);
        txtDonGia.setText("");
        cbTrangThai.setSelectedIndex(0);
        cbTenNhom.setSelectedItem(0);
        layDuLieu();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnXoaMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaMonActionPerformed
        // TODO add your handling code here:
        int selectedRow = tbHienThiMonAn.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một món ăn để xóa!", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
            "Việc xóa món ăn sẽ xóa cả các đánh giá và định lượng nguyên liệu liên quan.\nBạn có chắc chắn muốn xóa?",
            "Xác nhận xóa",
            JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        int maMonAn = Integer.parseInt(tbHienThiMonAn.getValueAt(selectedRow, 0).toString());

        String sql = "{call sp_XoaMonAn(?)}"; 
        try (Connection conn = CRUD.ConnectSQL.getConnection(); 
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, maMonAn);

            cs.execute();
            JOptionPane.showMessageDialog(this, "Xóa món ăn và các dữ liệu liên quan thành công!");
            layDuLieu();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi khi xóa món ăn: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        
//        try (Connection conn = CRUD.ConnectSQL.getConnection()) {
//            conn.setAutoCommit(false);
//
//            String checkCTHD_Sql = "SELECT COUNT(*) FROM CHITIETHOADON WHERE MaMonAn = ?";
//            try (PreparedStatement ps = conn.prepareStatement(checkCTHD_Sql)) {
//                ps.setInt(1, maMonAn);
//                ResultSet rs = ps.executeQuery();
//                if (rs.next() && rs.getInt(1) > 0) {
//                    JOptionPane.showMessageDialog(this, "Không thể xóa! Món ăn này đã tồn tại trong các hóa đơn.", "Xóa bị chặn", JOptionPane.ERROR_MESSAGE);
//                    conn.rollback();
//                    return;
//                }
//            }
//
//            String deleteDanhGiaSql = "DELETE FROM DANHGIA WHERE MaMonAn = ?";
//            try (PreparedStatement ps = conn.prepareStatement(deleteDanhGiaSql)) {
//                ps.setInt(1, maMonAn);
//                ps.executeUpdate();
//            }
//
//            String deleteNLMASql = "DELETE FROM NGUYENLIEU_MONAN WHERE MaMonAn = ?";
//            try (PreparedStatement ps = conn.prepareStatement(deleteNLMASql)) {
//                ps.setInt(1, maMonAn);
//                ps.executeUpdate();
//            }
//
//            try (CallableStatement cs = conn.prepareCall("{call sp_XoaMonAn(?)}")) {
//                cs.setInt(1, maMonAn);
//                cs.execute();
//            }
//
//            conn.commit();
//            JOptionPane.showMessageDialog(this, "Xóa món ăn và các dữ liệu liên quan thành công!");
//            layDuLieu();
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(this, "Lỗi khi xóa món ăn: " + ex.getMessage(), "Lỗi SQL", JOptionPane.ERROR_MESSAGE);
//        }
    }//GEN-LAST:event_btnXoaMonActionPerformed

    private void tbHienThiMonAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHienThiMonAnMouseClicked
        // TODO add your handling code here:
        selected = tbHienThiMonAn.getSelectedRow();
        if(selected >= 0){
            txtTenMon.setText(tbHienThiMonAn.getValueAt(selected, 1).toString());
            cbDonViTinh.setSelectedItem(tbHienThiMonAn.getValueAt(selected, 2).toString().trim());
            txtDonGia.setText(tbHienThiMonAn.getValueAt(selected, 3).toString());
            cbTrangThai.setSelectedItem(tbHienThiMonAn.getValueAt(selected, 4).toString());
            int maNhom = Integer.parseInt(tbHienThiMonAn.getValueAt(selected, 5).toString());
            for(NhomMonAn nhom : layDuLieu.getDsNhomMonAn()){
                if(nhom.getMaNhom()== maNhom){
                    cbTenNhom.setSelectedItem(nhom.getTenNhom());
                    return;
                }
            }
        }
    }//GEN-LAST:event_tbHienThiMonAnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSuaMon;
    private javax.swing.JButton btnThemMon;
    private javax.swing.JButton btnXoaMon;
    private javax.swing.JComboBox<String> cbDonViTinh;
    private javax.swing.JComboBox<String> cbTenNhom;
    private javax.swing.JComboBox<String> cbTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnChucNang;
    private javax.swing.JPanel pnDanhSach;
    private javax.swing.JPanel pnThongTinMon;
    private javax.swing.JTable tbHienThiMonAn;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtTenMon;
    // End of variables declaration//GEN-END:variables
}
