/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.carsproject;

import com.mycompany.carsproject.Object.Car;
import com.mycompany.carsproject.Object.Car_on_rent;
import com.mycompany.carsproject.Object.Car_on_rent_DAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author manhl
 */
public class returnForm extends javax.swing.JFrame {

    /**
     * Creates new form returnForm
     */
    public returnForm() {
        initComponents();
        displayActiveCarsOnRentOnTable();
        displayReturnedCarsOnRentOnTable();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Xedatrave = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        Xedangthue = new javax.swing.JTable();
        jTextField4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        Tra_xe = new javax.swing.JButton();
        Thanh_toan = new javax.swing.JButton();
        Lam_moi = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Bảng thống kê doanh thu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 560, 220, -1));

        jButton5.setText("< Trở về");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 43, 118, 42));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setText("Xe đang được thuê");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 83, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Trả xe");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 50, -1, -1));

        Xedatrave.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Mã xe", "Mã khách hàng", "Ngày trả", "Trễ", "Thành tiền", "Phạt"
            }
        ));
        Xedatrave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                XedatraveMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Xedatrave);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 339, 860, 185));

        Xedangthue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Mã xe", "Tên khách hàng", "Ngày thuê", "Ngày hẹn trả", "Thành tiền"
            }
        ));
        Xedangthue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                XedangthueMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(Xedangthue);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 117, 860, 170));

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 560, 255, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setText("Xe đã trả về");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 305, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Tổng hoá đơn:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 560, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Screenshot 2023-12-23 221452.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, -1, -1));

        jPanel1.setBackground(new java.awt.Color(244, 208, 0));

        jLabel2.setText("Mã hóa đơn");

        jLabel3.setText("Mã xe");

        jLabel4.setText("Mã khách hàng");

        jLabel6.setText("Ngày trả xe");

        Tra_xe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-return-20.png"))); // NOI18N
        Tra_xe.setText("     Trả Xe");
        Tra_xe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tra_xeActionPerformed(evt);
            }
        });

        Thanh_toan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-cash-20.png"))); // NOI18N
        Thanh_toan.setText("Thanh Toán");
        Thanh_toan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Thanh_toanActionPerformed(evt);
            }
        });

        Lam_moi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-update-file-24.png"))); // NOI18N
        Lam_moi.setText("  Làm mới");
        Lam_moi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Lam_moiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tra_xe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Lam_moi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Thanh_toan, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel6)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(12, 12, 12)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(Tra_xe, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(Thanh_toan, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(Lam_moi, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 103, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Screenshot 2023-12-23 221452.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
      private void displayActiveCarsOnRentOnTable() {
        Car_on_rent_DAO car_rentedDAO = new Car_on_rent_DAO();
        List<Car_on_rent> Cars_rented = car_rentedDAO.getAllCarOnRentWithFeesFromFunction();
        DefaultTableModel clear = (DefaultTableModel)Xedangthue.getModel();
        clear.setRowCount(0);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Rent ID");
        model.addColumn("Car ID");
        model.addColumn("Customer ID");
        model.addColumn("Ngày thuê");
        model.addColumn("Ngày hẹn trả");
        model.addColumn("Tổng tiền");
        for (Car_on_rent car : Cars_rented) {
            model.addRow(new Object[]{
                    car.getRentID(),
                    car.getCarID(),
                    car.getCustomerID(),
                    car.getRentDate(),
                    car.getReturnDate(),
                    car.getPrice()
            });
        }

        Xedangthue.setModel(model);
    }
      
      private void displayReturnedCarsOnRentOnTable() {
        Car_on_rent_DAO car_rentedDAO = new Car_on_rent_DAO();
        List<Car_on_rent> Cars_rented = car_rentedDAO.getReturnedCarFromFunction();
        DefaultTableModel clear = (DefaultTableModel)Xedatrave.getModel();
        clear.setRowCount(0);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Rent ID");
        model.addColumn("Car ID");
        model.addColumn("Customer ID");
        model.addColumn("Ngày trả");
        model.addColumn("Tiền thuê");
        model.addColumn("Muộn");
        model.addColumn("Tiền phạt");
        
        for (Car_on_rent car : Cars_rented) {
            int delay = car.getDelay();
            float Phat = car.getPhat();
            if(delay < 0 || Phat < 0 )
            {
                delay=0;
                Phat=0;
            }
            model.addRow(new Object[]{
                    car.getRentID(),
                    car.getCarID(),
                    car.getCustomerID(),
                    car.getTrueReturnDate(),
                    car.getPrice(),
                    delay,
                    Phat
            });
        }

        Xedatrave.setModel(model);
    }
      
      
    private void Tra_xeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tra_xeActionPerformed
        // TODO add your handling code here:
        // Lấy dữ liệu từ các thành phần trên giao diện
//        String carID = jTextField2.getText();
        String rentID = jTextField1.getText();
        java.sql.Date truereturnDate = new java.sql.Date(jDateChooser1.getDate().getTime());

    // Tạo đối tượng Car_on_rent
        Car_on_rent carOnRent = new Car_on_rent();
//        carOnRent.setCarID(carID);
        carOnRent.setRentID(rentID);
        carOnRent.setTrueReturnDate(truereturnDate);
//        System.out.println(carOnRent.getCarID());

    // Thêm hóa đơn thông qua đối tượng DAO
        Car_on_rent_DAO carOnRentDAO = new Car_on_rent_DAO();
        carOnRentDAO.AddToTemp(carOnRent);
        displayActiveCarsOnRentOnTable();
        displayReturnedCarsOnRentOnTable();
    // Cập nhật lại bảng Cars_on_rent (nếu cần)
    //updateCarsOnRentTable(); // Hàm này cần phải được triển khai để cập nhật hiển thị trên bảng Cars_on_rent
    
    }//GEN-LAST:event_Tra_xeActionPerformed

    private void Lam_moiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lam_moiActionPerformed
        // TODO add your handling code here:
        jTextField1.setText("");  // Mã hóa đơn
        jTextField2.setText("");  // Mã xe
        jTextField7.setText("");  // Mã khách hàng

    // Xóa dữ liệu từ JDateChooser
        jDateChooser1.setDate(null);  // Ngày trả xe

    // Các bước xóa thông tin khác nếu cần


    }//GEN-LAST:event_Lam_moiActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        choiceForm choiceform = new choiceForm();

    // Hiển thị JFrame manageCustomers
        choiceform.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void XedangthueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XedangthueMouseClicked
        // TODO add your handling code here:
        int selectedRow = Xedangthue.getSelectedRow();

        if (selectedRow != -1) {
        // Lấy giá trị của cột Car ID (giả sử là cột thứ 0)
            Object carIDObject = Xedangthue.getValueAt(selectedRow, 0);
            Object rentIDObject = Xedangthue.getValueAt(selectedRow, 1);
            Object cusIDObject = Xedangthue.getValueAt(selectedRow, 2);
//            java.sql.Date rentDate = new java.sql.Date(Rent_date.getDate().getTime());
//            java.sql.Date returnDate = new java.sql.Date(Return_date.getDate().getTime());
            
            if (carIDObject != null) {
                String carID = carIDObject.toString();
                jTextField1.setText(carID);
                String rentID = rentIDObject.toString();
                jTextField2.setText(rentID);
                String cusID = cusIDObject.toString();
                jTextField7.setText(cusID);
            }
    }//GEN-LAST:event_XedangthueMouseClicked
    }
    private void Thanh_toanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Thanh_toanActionPerformed
        // TODO add your handling code here:
         // TODO add your handling code here:
    String rentID = jTextField1.getText();
    String carID = jTextField2.getText();

    // Tạo đối tượng Car_on_rent
    Car_on_rent carOnRent = new Car_on_rent();
    carOnRent.setCarID(carID);
    carOnRent.setRentID(rentID);
    Car car = new Car();
    car.setCarID(carID);
    // Thêm hóa đơn thông qua đối tượng DAO
    Car_on_rent_DAO carOnRentDAO = new Car_on_rent_DAO();
 
    
    // Update revenue information
    carOnRentDAO.updateDoanhThu(car);
    carOnRentDAO.ReturnCarOnRent(carOnRent);
    displayActiveCarsOnRentOnTable();
    displayReturnedCarsOnRentOnTable();
    }//GEN-LAST:event_Thanh_toanActionPerformed

    private void XedatraveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XedatraveMouseClicked
        // TODO add your handling code here:
        int selectedRow = Xedatrave.getSelectedRow();

        if (selectedRow != -1) {
        // Lấy giá trị của cột Car ID (giả sử là cột thứ 0)
            Object carIDObject = Xedatrave.getValueAt(selectedRow, 0);
            Object rentIDObject = Xedatrave.getValueAt(selectedRow, 1);
            Object cusIDObject = Xedatrave.getValueAt(selectedRow, 2);
            Object returnDateObject = Xedatrave.getValueAt(selectedRow, 3);
            Object FeesObject = Xedatrave.getValueAt(selectedRow, 4);
            Object PhatObject = Xedatrave.getValueAt(selectedRow, 6);
//            java.sql.Date rentDate = new java.sql.Date(Rent_date.getDate().getTime());
//            java.sql.Date returnDate = new java.sql.Date(Return_date.getDate().getTime());
            
            if (carIDObject != null && rentIDObject != null && returnDateObject != null) {
                String carID = carIDObject.toString();
                jTextField1.setText(carID);
                String rentID = rentIDObject.toString();
                jTextField2.setText(rentID);
                String cusID = cusIDObject.toString();
                jTextField7.setText(cusID);
                String trueReturnDate = returnDateObject.toString();
                java.sql.Date date = java.sql.Date.valueOf(trueReturnDate);
                jDateChooser1.setDate(date);
                float fees = Float.parseFloat(FeesObject.toString());
                float Phat = Float.parseFloat(PhatObject.toString());
                float TongTien = fees+Phat;
                jTextField4.setText(TongTien+"");
            }
    }            
    }//GEN-LAST:event_XedatraveMouseClicked

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        RevenueForm revenue = new RevenueForm();
        revenue.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(returnForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(returnForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(returnForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(returnForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new returnForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Lam_moi;
    private javax.swing.JButton Thanh_toan;
    private javax.swing.JButton Tra_xe;
    private javax.swing.JTable Xedangthue;
    private javax.swing.JTable Xedatrave;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
