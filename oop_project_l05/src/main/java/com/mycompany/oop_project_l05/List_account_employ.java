/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.oop_project_l05;

import com.mycompany.oop_project_l05.Model.Employee;
import com.mycompany.oop_project_l05.Model.EmployeeDAO;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;

import javax.swing.table.DefaultTableModel;


/**
 *
 * @author sonki
 */
public class List_account_employ extends javax.swing.JFrame {
    private EmployeeDAO employeeDAO;
    private List<Employee> employees;
    /**
     * Creates new form List_account_employ
     */
    public List_account_employ() {
        initComponents();
        employeeDAO = new EmployeeDAO(); // Khởi tạo đối tượng EmployeeDAO
        hienThiDuLieuNhanVien();
    }
    
    private void hienThiDuLieuNhanVien() {
        DefaultTableModel model = (DefaultTableModel) List_employ.getModel();
        model.setRowCount(0); // Xóa tất cả các hàng hiện tại

        // Giả sử EmployeeDAO có một phương thức để lấy dữ liệu nhân viên
        // và trả về một List<Employee>
        
        employees = employeeDAO.layDanhSachNhanVien(); 

        for (Employee employee : employees) {
            Object[] rowData = {
                employee.getUsername(),
                employee.getPassword(),
                employee.getEmployeeId(),
                employee.getName(),
                employee.getEmail(),
                employee.getPhone(),
                employee.getSalary()
            };
            model.addRow(rowData);
        }
    }
    private void showEmployeeData() {
        // Lấy dòng được chọn
        int selectedRow = List_employ.getSelectedRow();

        // Kiểm tra xem có dòng nào được chọn không
        if (selectedRow != -1) {
            // Lấy dữ liệu của dòng được chọn từ list employees
            Employee selectedEmployee = employees.get(selectedRow);

            // Đặt dữ liệu lên các trường văn bản
            Text_username.setText(selectedEmployee.getUsername());
            Text_password.setText(selectedEmployee.getPassword());
            Text_employ_id.setText(String.valueOf(selectedEmployee.getEmployeeId()));
            Text_name.setText(selectedEmployee.getName());
            Text_phone.setText(selectedEmployee.getPhone());
            Text_salary.setText(selectedEmployee.getSalary().toString());
            Text_ID.setText(selectedEmployee.getEmail());
        } else {
            // Nếu không có dòng nào được chọn, thông báo hoặc xử lý tùy ý
            System.out.println("Vui lòng chọn một nhân viên để hiển thị thông tin.");
        }
    }
   private void addEmployee() {
    if (areTextFieldsEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin nhân viên.");
        return;
    }

    try {
        String username = Text_username.getText();
        String password = Text_password.getText();
        int employeeId = Integer.parseInt(Text_employ_id.getText());
        String name = Text_name.getText();
        String email = Text_ID.getText();
        String phone = Text_phone.getText();
        BigDecimal salary = new BigDecimal(Text_salary.getText());

        Employee newEmployee = new Employee(username, password, employeeId, name, email, phone, salary);

        boolean success = employeeDAO.themNhanVien(newEmployee);

        if (success) {
            JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công");
            hienThiDuLieuNhanVien();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm nhân viên thất bại");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng số cho mã nhân viên và lương.");
    }
}

    private void editEmployee() {
        if (areTextFieldsEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin nhân viên.");
            return;
        }

        try {
            String username = Text_username.getText();
            String password = Text_password.getText();
            int employeeId = Integer.parseInt(Text_employ_id.getText());
            String name = Text_name.getText();
            String email = Text_ID.getText();
            String phone = Text_phone.getText();
            BigDecimal salary = new BigDecimal(Text_salary.getText());

            Employee updatedEmployee = new Employee(username, password, employeeId, name, email, phone, salary);

            boolean success = employeeDAO.suaNhanVien(updatedEmployee);

            if (success) {
                JOptionPane.showMessageDialog(this, "Sửa nhân viên thành công");
                hienThiDuLieuNhanVien();
            } else {
                JOptionPane.showMessageDialog(this, "Sửa nhân viên thất bại");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng số cho lương.");
        }
    }
    private void deleteEmployee() {
        if (areTextFieldsEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin nhân viên.");
            return;
        }

        try {
            String username = Text_username.getText();
            String password = Text_password.getText();
            int employeeId = Integer.parseInt(Text_employ_id.getText());
            String name = Text_name.getText();
            String email = Text_ID.getText();
            String phone = Text_phone.getText();
            BigDecimal salary = new BigDecimal(Text_salary.getText());
            Employee deleteEmployee = new Employee(username, password, employeeId, name, email, phone, salary);
            boolean success = employeeDAO.xoaNhanVien(deleteEmployee);

            if (success) {
                JOptionPane.showMessageDialog(this, "Xóa nhân viên thành công");
                hienThiDuLieuNhanVien();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa nhân viên thất bại");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng số cho lương.");
        }
    }


    private boolean areTextFieldsEmpty() {
        return Text_username.getText().trim().isEmpty() &&
            Text_password.getText().trim().isEmpty() &&
            Text_employ_id.getText().trim().isEmpty() &&
            Text_name.getText().trim().isEmpty() &&
            Text_ID.getText().trim().isEmpty() &&
            Text_phone.getText().trim().isEmpty() &&
            Text_salary.getText().trim().isEmpty();
    }


    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        List_employ = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        Add_employ = new javax.swing.JToggleButton();
        Edit_employ = new javax.swing.JToggleButton();
        Delete_employ = new javax.swing.JToggleButton();
        Revenue = new javax.swing.JToggleButton();
        SHOW = new javax.swing.JToggleButton();
        Text_username = new javax.swing.JTextField();
        Text_name = new javax.swing.JTextField();
        Text_phone = new javax.swing.JTextField();
        Text_salary = new javax.swing.JTextField();
        Text_ID = new javax.swing.JTextField();
        Text_employ_id = new javax.swing.JTextField();
        Text_password = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        List_employ.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Username", "Password", "Employ ID", "Name", "Email", "Phone", "Salary"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(List_employ);

        Add_employ.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Add_employ.setText("Thêm");
        Add_employ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_employActionPerformed(evt);
            }
        });

        Edit_employ.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Edit_employ.setText("Sửa");
        Edit_employ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Edit_employActionPerformed(evt);
            }
        });

        Delete_employ.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Delete_employ.setText("Xóa");
        Delete_employ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_employActionPerformed(evt);
            }
        });

        Revenue.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Revenue.setText("Doanh thu");
        Revenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RevenueActionPerformed(evt);
            }
        });

        SHOW.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SHOW.setText("SHOW");
        SHOW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SHOWActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Revenue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Delete_employ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Edit_employ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Add_employ, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SHOW, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(Add_employ, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Edit_employ, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Delete_employ, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Revenue, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SHOW, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
        );

        Text_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_usernameActionPerformed(evt);
            }
        });

        Text_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_nameActionPerformed(evt);
            }
        });

        Text_phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_phoneActionPerformed(evt);
            }
        });

        Text_salary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_salaryActionPerformed(evt);
            }
        });

        Text_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_IDActionPerformed(evt);
            }
        });

        Text_employ_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_employ_idActionPerformed(evt);
            }
        });

        Text_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_passwordActionPerformed(evt);
            }
        });

        jLabel1.setText("Password");

        jLabel2.setText("Name");

        jLabel3.setText("Phone");

        jLabel4.setText("Salary");

        jLabel5.setText("Employ ID");

        jLabel6.setText("Username");

        jLabel7.setText("Email");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(Text_password, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Text_username, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Text_employ_id, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                                .addGap(77, 77, 77)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Text_salary)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Text_name, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(Text_phone)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Text_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(88, 88, 88)))
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Text_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addComponent(Text_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Text_password)
                                .addComponent(Text_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Text_salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Text_employ_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Text_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Delete_employActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_employActionPerformed
        // TODO add your handling code here:
        
        deleteEmployee();
    }//GEN-LAST:event_Delete_employActionPerformed

    private void RevenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RevenueActionPerformed
        // TODO add your handling code here:
        new Revenue_employ().setVisible(true);
        
    }//GEN-LAST:event_RevenueActionPerformed

    private void Text_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_passwordActionPerformed

    private void Text_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_usernameActionPerformed

    private void Text_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_nameActionPerformed

    private void Text_phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_phoneActionPerformed

    private void Text_employ_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_employ_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_employ_idActionPerformed

    private void Text_salaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_salaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_salaryActionPerformed

    private void Text_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_IDActionPerformed

    private void SHOWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SHOWActionPerformed
        // TODO add your handling code here:
        showEmployeeData();
        
    }//GEN-LAST:event_SHOWActionPerformed

    private void Add_employActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_employActionPerformed
        // TODO add your handling code here:
        addEmployee();
    }//GEN-LAST:event_Add_employActionPerformed

    private void Edit_employActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Edit_employActionPerformed
        // TODO add your handling code here:
        editEmployee();
    }//GEN-LAST:event_Edit_employActionPerformed

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
            java.util.logging.Logger.getLogger(List_account_employ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(List_account_employ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(List_account_employ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(List_account_employ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new List_account_employ().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Add_employ;
    private javax.swing.JToggleButton Delete_employ;
    private javax.swing.JToggleButton Edit_employ;
    private javax.swing.JTable List_employ;
    private javax.swing.JToggleButton Revenue;
    private javax.swing.JToggleButton SHOW;
    private javax.swing.JTextField Text_ID;
    private javax.swing.JTextField Text_employ_id;
    private javax.swing.JTextField Text_name;
    private javax.swing.JTextField Text_password;
    private javax.swing.JTextField Text_phone;
    private javax.swing.JTextField Text_salary;
    private javax.swing.JTextField Text_username;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void setEmployeeDataToFields(Employee selectedEmployee) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
