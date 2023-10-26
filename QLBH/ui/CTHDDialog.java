/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package QLBH.ui;

import QLBH.CTHD;
import QLBH.Helpers.MessageDialogHelper;
import QLBH.ChiTiet;
import QLBH.Helpers.DataValidator;
import QLBH.HoaDon;
import QLBH.KhachHang;
import QLBH.NhanVien;
import QLBH.SanPham;
import QLBH.dao.CTHDDAO;
import QLBH.dao.ChiTietDao;
import QLBH.dao.HoaDonDao;
import QLBH.dao.KhachHangDao;
import QLBH.dao.NhanVienDao;
import QLBH.dao.SanPhamDao;
import com.toedter.calendar.HDBHPanel;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VAN ANH
 */
public class CTHDDialog extends javax.swing.JDialog {

    private final ArrayList<ChiTiet> list;
    private JOptionPane parentForm;
    private DefaultTableModel tblModel;
    protected static String SOHDTV;

    private final ArrayList<CTHD> listCT;

    /**
     * Creates new form QLNVPanel
     *
     * @param SOHD
     */
    public CTHDDialog(String SOHD) {

        SOHDTV = SOHD;
        initComponents();
        list = new ChiTietDao().getListCT();
        initTable();
        loadData();
        setLocationRelativeTo(null);
        this.listCT = null;
        txtSL.setText("");
        txtDVT.setText("");
        txtGIA.setText("");
        txtNUOCSX.setText("");
        txtTENSP.setText("");
        txtTONGGIA.setText("");
        loadData();
    }

    private void initTable() {
        tblModel = new DefaultTableModel();
        tblModel.setColumnIdentifiers(new String[]{"MASP", "TÊN SP", "NSX", "GIÁ",
            "ĐVT", "SL", "THÀNH TIỀN"});
        tblCHITIET.setModel(tblModel);
        showCombo();
    }

    private void loadData() {
        try {
            long tong = 0;
            ChiTietDao dao = new ChiTietDao();
            List<ChiTiet> list = dao.FindAll();
            tblModel.setRowCount(0);
            txtSOHD.setText(SOHDTV);
            //Tim HD
            HoaDon hd = new HoaDon();
            HoaDonDao hdDao = new HoaDonDao();
            hd = hdDao.FindByID(SOHDTV);
            txtNGHD.setText(hd.getNgHD());
            txtMANV.setText(hd.getMaNV());
            txtMAKH.setText(hd.getMaKH());
            NhanVienDao nvdao = new NhanVienDao();
            NhanVien nv = new NhanVien();
            nv = nvdao.FindByID(hd.getMaNV());
            txtTENNV.setText(nv.getHOTEN());
            KhachHangDao khdao = new KhachHangDao();
            KhachHang kh = new KhachHang();
            
            kh = khdao.FindByID(hd.getMaKH());
            if((kh!=null) && !(kh.getHoTen().equals(null)))
            txtTENKH.setText(kh.getHoTen());
            else txtTENKH.setText("");

            for (ChiTiet n : list) {

                if (n.getSOHD() == null ? SOHDTV.equals(null) : n.getSOHD().equals(SOHDTV)) {
                    tong += n.getTONGGIA();
                    tblModel.addRow(new Object[]{
                        n.getMASP(), n.getTENSP(), n.getNUOCSX(), n.getGIA(),
                        n.getDVT(), n.getSL(), n.getTONGGIA()});
                }
            }
            txtTONG.setText(String.valueOf(tong));
            tblModel.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "Lỗi!");
        }

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
        txtSOHD = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTENSP = new javax.swing.JTextField();
        txtNUOCSX = new javax.swing.JTextField();
        txtGIA = new javax.swing.JTextField();
        txtDVT = new javax.swing.JTextField();
        txtSL = new javax.swing.JTextField();
        txtTONGGIA = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCHITIET = new javax.swing.JTable();
        cbbMASP = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtTONG = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnLamMoi = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnPRINT = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtMAKH = new javax.swing.JTextField();
        txtTENKH = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtMANV = new javax.swing.JTextField();
        txtTENNV = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtNGHD = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 102));
        jLabel1.setText("CHI TIẾT HÓA ĐƠN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 9, -1, -1));

        txtSOHD.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtSOHD.setForeground(new java.awt.Color(255, 51, 0));
        txtSOHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSOHDActionPerformed(evt);
            }
        });
        getContentPane().add(txtSOHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 6, 156, -1));

        jPanel2.setBackground(new java.awt.Color(246, 239, 252));

        jLabel3.setText("Mã Sản Phẩm");

        jLabel4.setText("Tên Sản Phẩm");

        jLabel6.setText("Nước Sản Xuất");

        jLabel5.setText("Đơn Vị Tính");

        jLabel7.setText("Giá");

        jLabel8.setText("Số Lượng");

        jLabel9.setText("Tổng Giá");

        txtSL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSLActionPerformed(evt);
            }
        });

        txtTONGGIA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTONGGIAActionPerformed(evt);
            }
        });

        tblCHITIET.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCHITIET.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCHITIETMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblCHITIET);

        cbbMASP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMASPActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 102));
        jLabel2.setText("Tổng:");

        txtTONG.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        txtTONG.setForeground(new java.awt.Color(0, 153, 51));

        jPanel1.setBackground(new java.awt.Color(246, 239, 252));

        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLBH/icon/refresh16.png"))); // NOI18N
        btnLamMoi.setText("Làm Mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLBH/icon/plus16.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLBH/icon/update16.png"))); // NOI18N
        btnCapNhat.setText("Cập Nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLBH/icon/delete16.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnPRINT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLBH/icon/print.png"))); // NOI18N
        btnPRINT.setText("In Hóa Đơn");
        btnPRINT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPRINTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLamMoi)
                .addGap(18, 18, 18)
                .addComponent(btnThem)
                .addGap(18, 18, 18)
                .addComponent(btnCapNhat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPRINT)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLamMoi)
                    .addComponent(btnThem)
                    .addComponent(btnCapNhat)
                    .addComponent(btnXoa)
                    .addComponent(btnPRINT))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtTONG, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTONGGIA, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                            .addComponent(txtSL, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                            .addComponent(txtTENSP, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                            .addComponent(txtNUOCSX, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                            .addComponent(txtGIA, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                            .addComponent(txtDVT, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                            .addComponent(cbbMASP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(284, 284, 284))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbbMASP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTENSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtNUOCSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtGIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtDVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtTONGGIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTONG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 930, -1));

        jPanel3.setBackground(new java.awt.Color(246, 239, 252));

        jLabel10.setText("Mã Khách Hàng");

        jLabel11.setText("Tên Khách Hàng");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel10))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMAKH, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(txtTENKH))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtMAKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTENKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, 290, 90));

        jPanel4.setBackground(new java.awt.Color(246, 239, 252));

        jLabel12.setText("Mã Nhân Viên");

        jLabel13.setText("Tên Nhân Viên");

        jLabel14.setText("Ngày Lập Hóa Đơn");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNGHD, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                        .addComponent(jLabel12)))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMANV)
                    .addComponent(txtTENNV, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtMANV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNGHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTENNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 640, 90));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLBH/icon/backgound1.jpg"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 950, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblCHITIETMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCHITIETMouseClicked
        try {
            int row = tblCHITIET.getSelectedRow();
            if (row >= 0) {
                String id = (String) tblCHITIET.getValueAt(row, 0);
                ChiTietDao dao = new ChiTietDao();
                ChiTiet n = dao.FindByID1(SOHDTV, id);
                if (n != null) {
                    cbbMASP.setSelectedItem(n.getMASP());
                    txtTENSP.setText(n.getTENSP());
                    txtNUOCSX.setText(n.getNUOCSX());
                    txtGIA.setText(String.valueOf(n.getGIA()));

                    txtDVT.setText(n.getDVT());
                    txtSL.setText(String.valueOf(n.getSL()));
                    txtTONGGIA.setText(String.valueOf(n.getTONGGIA()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.toString(), "Lỗi");
        }
    }//GEN-LAST:event_tblCHITIETMouseClicked

    private void txtSOHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSOHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSOHDActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed

        txtSL.setText("");
        txtDVT.setText("");
        txtGIA.setText("");
        txtNUOCSX.setText("");
        txtTENSP.setText("");
        txtTONGGIA.setText("");
        loadData();
    }//GEN-LAST:event_btnLamMoiActionPerformed
long trigia_HD;
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        StringBuilder sb = new StringBuilder();
        trigia_HD=Long.parseLong(txtTONG.getText());
        DataValidator.validateEmpty(txtSL, sb, "Số lượng không được để trống.");
        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(parentForm, sb.toString(), "Lỗi");
            return;
        }
        CTHD n = new CTHD();
        n.setSoHD(SOHDTV);
        n.setMaSP(selectedItem);
        n.setSL(Integer.parseInt(txtSL.getText()));
        if (new CTHDDAO().Insert(n)) {
            MessageDialogHelper.showMessageDialog(parentForm, "CTHD đã được thêm!", "Thông báo!");
            loadData();
        } else {
            MessageDialogHelper.showErrorDialog(parentForm, "Thêm không thành công!", "Thông báo!");
        }
         SanPhamDao spdao = new SanPhamDao();
        SanPham sp = new SanPham();
        try {
            sp = spdao.FindByID(selectedItem);
        } catch (Exception ex) {
            Logger.getLogger(HDBHDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
         trigia_HD += sp.getGia() * Long.parseLong(txtSL.getText());
       txtTONG.setText(String.valueOf(trigia_HD));
        //cập nhật lại giá trị hd cho bảng hóa đơn sau khi thêm 1 cthd
            HoaDon hd = new HoaDon();
            hd.setSoHD(txtSOHD.getText());
            hd.setNgHD(txtNGHD.getText());
            hd.setMaKH(String.valueOf(txtMAKH.getText()));
            hd.setMaNV(String.valueOf(txtMANV.getText()));
            hd.setTriGia(trigia_HD);
            new HoaDonDao().Update(hd);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        StringBuilder sb = new StringBuilder();

        DataValidator.validateEmpty(txtSL, sb, "Số lượng không được để trống.");
        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(parentForm, sb.toString(), "Lỗi");
            return;
        }

        if (MessageDialogHelper.showConfirmDialog(parentForm, "Bạn có muốn cập nhật chi tiết hóa đơn không?",
                "Hỏi") == JOptionPane.YES_OPTION) {
            CTHD n = new CTHD();
            n.setSoHD(txtSOHD.getText());
            n.setMaSP(selectedItem);
            n.setSL(Integer.parseInt(txtSL.getText()));
            if (new CTHDDAO().Update(n)) {
                MessageDialogHelper.showMessageDialog(parentForm, "CTHD đã được cập nhật!", "Thông báo!");
                loadData();
            } else {
                MessageDialogHelper.showMessageDialog(parentForm, "Cập nhật không thành công do lỗi!", "Thông báo!");
            }
        }
        
        trigia_HD=Long.parseLong(txtTONG.getText());
              txtTONG.setText(String.valueOf(trigia_HD));
             //cập nhật lại giá trị hd cho bảng hóa đơn sau khi làm hóa đơn bán hàng 
            HoaDon hd = new HoaDon();
            hd.setSoHD(txtSOHD.getText());
            hd.setNgHD(txtNGHD.getText());
            hd.setMaKH(String.valueOf(txtMAKH.getText()));
            hd.setMaNV(String.valueOf(txtMANV.getText()));
            hd.setTriGia(trigia_HD);
            new HoaDonDao().Update(hd);

    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        StringBuilder sb = new StringBuilder();
         trigia_HD=Long.parseLong(txtTONG.getText());
        long thanhtien=Long.parseLong(txtTONGGIA.getText());
        if (sb.length() > 0) {
            MessageDialogHelper.showErrorDialog(parentForm, sb.toString(), "Lỗi");
            return;
        }
        if (MessageDialogHelper.showConfirmDialog(parentForm, "Bạn có muốn xoá CTHD không?",
                "Hỏi") == JOptionPane.YES_OPTION) {
            CTHDDAO dao = new CTHDDAO();
            if (dao.Delete(SOHDTV, selectedItem)) {
                MessageDialogHelper.showMessageDialog(parentForm, "CTHD đã được xóa!", "Thông báo!");
                loadData();
                btnLamMoiActionPerformed(evt);
            } else {
                MessageDialogHelper.showMessageDialog(parentForm, "Xóa không thành công do lỗi!", "Thông báo!");
            }
        }
        trigia_HD-=thanhtien;
       txtTONG.setText(String.valueOf(trigia_HD));
        //cập nhật lại giá trị hd cho bảng hóa đơn sau khi xóa CTHD 
            HoaDon hd = new HoaDon();
            hd.setSoHD(txtSOHD.getText());
            hd.setNgHD(txtNGHD.getText());
            hd.setMaKH(String.valueOf(txtMAKH.getText()));
            hd.setMaNV(String.valueOf(txtMANV.getText()));
            hd.setTriGia(trigia_HD);
            new HoaDonDao().Update(hd);
    }//GEN-LAST:event_btnXoaActionPerformed
    String selectedItem;
    private void cbbMASPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMASPActionPerformed
        // TODO add your handling code here:
        SanPhamDao dao = new SanPhamDao();
        SanPham sp = new SanPham();
        selectedItem = (String) cbbMASP.getSelectedItem();
        System.out.println(selectedItem);
        try {

            sp = dao.FindByID(selectedItem);
            txtTENSP.setText(sp.getTenSP());
            txtNUOCSX.setText(sp.getNuocSX());
            txtGIA.setText(String.valueOf(sp.getGia()));
            txtDVT.setText(sp.getDVT());

        } catch (Exception ex) {
            Logger.getLogger(HDBHPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbbMASPActionPerformed

    private void txtSLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSLActionPerformed
        // TODO add your handling code here:
        if (!txtSL.getText().equals(null)) {
            txtTONGGIA.setText(String.valueOf(Long.parseLong(txtGIA.getText()) * Integer.parseInt(txtSL.getText())));
        } else {
            txtTONGGIA.setText("");
        }

    }//GEN-LAST:event_txtSLActionPerformed

    private void txtTONGGIAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTONGGIAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTONGGIAActionPerformed

    private void btnPRINTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPRINTActionPerformed
        // TODO add your handling code here:
        String ThongTin;
        ThongTin = "HÓA ĐƠN *** Tổng Tiền: " + txtTONG.getText();

        MessageFormat header = new MessageFormat(ThongTin);

        MessageFormat footer = new MessageFormat("Trang {0, number, integer} * NV: " + txtTENNV.getText()
                + " * KH: " + txtTENKH.getText() + " * NGHD: " + txtNGHD.getText() + " * SOHD: " + txtSOHD.getText());
        try {

            tblCHITIET.print(JTable.PrintMode.NORMAL, header, footer);

        } catch (PrinterException ex) {
            Logger.getLogger(HDBHDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPRINTActionPerformed
    private void showCombo() {
        SanPhamDao dao = new SanPhamDao();
        List<String> data = null;
        try {
            data = dao.getData();
        } catch (Exception ex) {
            Logger.getLogger(HDBHPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (String string : data) {
            cbbMASP.addItem(string);
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
 /* Create and diHDlay the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new CTHDDialog().setVisible(true);
                CTHDDialog dialog = new CTHDDialog(SOHDTV);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnPRINT;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbMASP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblCHITIET;
    private javax.swing.JTextField txtDVT;
    private javax.swing.JTextField txtGIA;
    private javax.swing.JTextField txtMAKH;
    private javax.swing.JTextField txtMANV;
    private javax.swing.JTextField txtNGHD;
    private javax.swing.JTextField txtNUOCSX;
    private javax.swing.JTextField txtSL;
    private javax.swing.JTextField txtSOHD;
    private javax.swing.JTextField txtTENKH;
    private javax.swing.JTextField txtTENNV;
    private javax.swing.JTextField txtTENSP;
    private javax.swing.JTextField txtTONG;
    private javax.swing.JTextField txtTONGGIA;
    // End of variables declaration//GEN-END:variables
}