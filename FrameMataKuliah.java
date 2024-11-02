/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pbo_tm11;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
import pbo_tm11.MataKuliahDB;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.util.JRLoader;
import java.sql.Connection;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
/**
 *
 * @author win 10
 */
public class FrameMataKuliah extends javax.swing.JFrame {
    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;
    String driver = "org.postgresql.Driver";
    String koneksi = "jdbc:postgresql://localhost:5432/PBO_TM10";
    String user = "postgres";
    String password = "123456";
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Creates new form FrameMataKuliah
     */
    public FrameMataKuliah() {
        initComponents();
        tampil();
    }

    public void tampil() {
        // TODO code application logi
        try (Connection conn = DriverManager.getConnection(koneksi, user, password); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM MataKuliah ORDER BY KodeMK")) {

            DefaultTableModel model = (DefaultTableModel) tblMataKuliah.getModel();

            model.setRowCount(0);

            while (rs.next()) {
                Object[] rowData = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
                model.addRow(rowData);
            }
        } catch (SQLException ex) {
            System.err.println("Terjadi kesalahan: " + ex.getMessage());
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfKodeMK = new javax.swing.JTextField();
        tfNamaMK = new javax.swing.JTextField();
        tfSKS = new javax.swing.JTextField();
        tfSemesterAjar = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMataKuliah = new javax.swing.JTable();
        btnCetak = new javax.swing.JButton();
        btnUpload = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("DATA MATA KULIAH");

        jLabel2.setText("Kode Mata Kuliah");

        jLabel3.setText("Nama Mata Kuliah");

        jLabel4.setText("SKS");

        jLabel5.setText("Semester Ajar");

        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnInsert.setText("INSERT");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnExit.setText("EXIT");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        tblMataKuliah.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode MK", "SKS", "Nama MK", "Semester Ajar"
            }
        ));
        tblMataKuliah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMataKuliahMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMataKuliah);

        btnCetak.setText("CETAK ");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        btnUpload.setText("UPLOAD");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(btnInsert))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfNamaMK, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tfSKS, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                                        .addComponent(tfKodeMK, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(tfSemesterAjar, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(btnUpdate)
                                .addGap(47, 47, 47)
                                .addComponent(btnDelete)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExit)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(btnCetak)
                .addGap(55, 55, 55)
                .addComponent(btnUpload)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExit)
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfKodeMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfSKS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfNamaMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfSemesterAjar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 36, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCetak)
                    .addComponent(btnUpload))
                .addGap(65, 65, 65))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        String kodeMK, sks, namaMK, semesterAjar;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(koneksi, user, password);
            conn.setAutoCommit(false);
            String sql = "INSERT INTO MataKuliah(kodeMK, sks, namaMK, semesterAjar) VALUES(?,?,?,?)";
            pstmt = conn.prepareStatement(sql);

            kodeMK = tfKodeMK.getText();
            sks = tfSKS.getText();
            namaMK = tfNamaMK.getText();
            semesterAjar = tfSemesterAjar.getText();
            
            pstmt.setLong(1, Long.parseLong(kodeMK));
            pstmt.setLong(2, Long.parseLong(sks));
            pstmt.setString(3, (namaMK));
            pstmt.setLong(4, Long.parseLong(semesterAjar));
            pstmt.executeUpdate();

            conn.commit();
            pstmt.close();
            conn.close();

            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + ex.getMessage());
        }

        bersih();
        tampil();                    
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
         String kodeMK, sks, namaMK, semesterAjar;

    if (tfKodeMK.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Kode Mata Kuliah harus diisi");
        return;
    }
    if (tfSKS.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "SKS Mata Kuliah harus diisi");
        return;
    }
    if (tfNamaMK.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Nama Mata Kuliah harus diisi");
        return;
    }
    if (tfSemesterAjar.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Semester Ajar harus diisi");
        return;
    }

   try {
    Class.forName(driver);
    String sql = "UPDATE MataKuliah SET sks = ?, namaMK = ?, semesterAjar = ? WHERE KodeMK = ?";
    conn = DriverManager.getConnection(koneksi, user, password);
    pstmt = conn.prepareStatement(sql);

    kodeMK = tfKodeMK.getText();
    sks = tfSKS.getText();
    namaMK = tfNamaMK.getText();
    semesterAjar = tfSemesterAjar.getText();
    
    pstmt.setInt(1, Integer.parseInt(sks));
    pstmt.setString(2, namaMK);
    pstmt.setInt(3, Integer.parseInt(semesterAjar));
    pstmt.setString(4, kodeMK);
   
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data berhasil diupdate");
                bersih();
            } else {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FrameMataKuliah.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Input tidak valid: " + ex.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        tampil();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:

        String kodeMK = tfKodeMK.getText();

        if (kodeMK.isEmpty()) {
            JOptionPane.showMessageDialog(null, "KodeMK tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(koneksi, user, password);

            int jawab = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus MataKuliah dengan KodeMK: " + kodeMK + "?", "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION);

            if (jawab == JOptionPane.YES_OPTION) {
                String deleteSql = "DELETE FROM MataKuliah WHERE KodeMK = ?";
                pstmt = conn.prepareStatement(deleteSql);

                // Asumsikan KodeMK adalah String, gunakan setString
                pstmt.setString(1, kodeMK);

                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                } else {
                    JOptionPane.showMessageDialog(null, "Data tidak ditemukan untuk KodeMK: " + kodeMK);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Penghapusan dibatalkan");
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver tidak ditemukan!", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Cek Lagi!!!", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Format KodeMK tidak valid: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        tampil();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void tblMataKuliahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMataKuliahMouseClicked
        // TODO add your handling code here:
        int row = tblMataKuliah.getSelectedRow();
        tfKodeMK.setText(tblMataKuliah.getValueAt(row, 0).toString());
        tfSKS.setText(tblMataKuliah.getValueAt(row, 1).toString());
        tfNamaMK.setText(tblMataKuliah.getValueAt(row, 2).toString());
        tfSemesterAjar.setText(tblMataKuliah.getValueAt(row, 3).toString());
        tampil();
    }//GEN-LAST:event_tblMataKuliahMouseClicked

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // TODO add your handling code here:
       try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/PBO_TM10", "postgres", "123456");
            }

            String path = "src/pbo_tm11/PBO_TM11.jasper";
            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(path);

            if (conn != null) {
                JasperPrint jprint = JasperFillManager.fillReport(report, null, conn);
                JasperViewer jviewer = new JasperViewer(jprint, false);
                jviewer.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
                jviewer.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Koneksi database tidak tersedia.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Koneksi database gagal: " + e.getMessage());
        } catch (JRException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal mencetak laporan: " + e.getMessage());
        }
       tampil();
    }//GEN-LAST:event_btnCetakActionPerformed

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
        // TODO add your handling code here:
         JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File filePilihan = jfc.getSelectedFile();
            System.out.println("File yang dipilih : " + filePilihan.getAbsolutePath());
            try {
                BufferedReader br = new BufferedReader(new FileReader(filePilihan));
                String baris;
                String pemisah = ";";
                while ((baris = br.readLine()) != null) {
                    String[] matakuliah = baris.split(pemisah);

                    if (matakuliah.length >= 4) {
                        String kodeMK = matakuliah[0];
                        String sks = matakuliah[1];
                        String namaMK = matakuliah[2];
                        String semesterAjar = matakuliah[3];

                        if (!kodeMK.isEmpty() && !sks.isEmpty() && !namaMK.isEmpty() && !semesterAjar.isEmpty()) {
                            try {
                                Class.forName(driver);
                                conn = DriverManager.getConnection(koneksi, user, password);
                                conn.setAutoCommit(false);
                                String sql = "INSERT INTO MataKuliah (kodeMK, sks, namaMK, semesterAjar) VALUES (?, ?, ?, ?)";
                                pstmt = conn.prepareStatement(sql);

                                pstmt.setString(1, kodeMK);
                                pstmt.setInt(2, Integer.parseInt(sks));
                                pstmt.setString(3, namaMK);                   
                                pstmt.setInt(4, Integer.parseInt(semesterAjar));

                                int k = pstmt.executeUpdate();

                                if (k > 0) {
                                    conn.commit();
                                    JOptionPane.showMessageDialog(null, "Input Data Berhasil!");
                                }
                            } catch (SQLException e) {
                                JOptionPane.showMessageDialog(null, "Input Data Gagal: " + e.getMessage());
                            } catch (ClassNotFoundException ex) {
                                JOptionPane.showMessageDialog(null, "Driver tidak ditemukan: " + ex.getMessage());
                            } finally {
                                try {
                                    if (pstmt != null) {
                                        pstmt.close();
                                    }
                                    if (conn != null) {
                                        conn.close();
                                    }
                                } catch (SQLException closeEx) {
                                    JOptionPane.showMessageDialog(null, "Close Gagal: " + closeEx.getMessage());
                                }
                            }
                        }
                    } else {
                        System.out.println("Baris tidak memiliki cukup kolom: " + baris);
                    }
                }
                br.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MataKuliahDB.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MataKuliahDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        tampil();
    }//GEN-LAST:event_btnUploadActionPerformed

    private void bersih() {
        tfKodeMK.setText("");
        tfSKS.setText("");
        tfNamaMK.setText("");
        tfSemesterAjar.setText("");
        tampil();
    }

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
            java.util.logging.Logger.getLogger(FrameMataKuliah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameMataKuliah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameMataKuliah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameMataKuliah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMataKuliah().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpload;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMataKuliah;
    private javax.swing.JTextField tfKodeMK;
    private javax.swing.JTextField tfNamaMK;
    private javax.swing.JTextField tfSKS;
    private javax.swing.JTextField tfSemesterAjar;
    // End of variables declaration//GEN-END:variables
}
