# 📖 Pertemuan Kesebelas - Praktikum mengupload file CSV kedalam aplikasi Java Swing Netbeans
## 📂 Topik Utama 
Langkah - langkah upload file CSV kedalam aplikasi Java Swing Netbeans

## 📜 Daftar Isi 
- [Java Swing MataKuliah](https://github.com/fauziaeka/TugasPBO_TM11/blob/main/FrameMataKuliah.java)
- [MataKuliahDB](https://github.com/fauziaeka/TugasPBO_TM11/blob/main/MataKuliahDB.java)
- [Frame MataKuliah](https://github.com/fauziaeka/TugasPBO_TM11/blob/main/FrameMataKuliah.form)
- [ReportMataKuliah.Jasper](https://github.com/fauziaeka/TugasPBO_TM10/blob/main/PBO_TM10.jasper)
- [ReportMataKuliah.jrxml](https://github.com/fauziaeka/TugasPBO_TM10/blob/main/PBO_TM10.jrxml)

## 📋 Langkah - Langkah 
1.	Membuat project baru dengan nama “PBO_TM11”

![image](https://github.com/user-attachments/assets/acb558b9-3a5c-4b34-9d6c-bb0319a35b0b)


2.	Membuat class JFrame Form pada project “PBO_TM11”

![image](https://github.com/user-attachments/assets/799e63a2-b0a1-4663-94e4-ce385947103f)


![image](https://github.com/user-attachments/assets/7f9940b2-db57-4eb6-83c2-bfc9da9b173f)


3.	Membuat desain pada JFrame Form 

![image](https://github.com/user-attachments/assets/80d8fbda-d23e-4c8b-9fc0-56097b466eb3)


4.	Mengisi class MataKuliahDB. Class ini berfungsi untuk mengonversi Resultset pada database menjadi TableModel agar dapat ditampilkan pada Jtable di GUI Java Swing sehingga saat pengisian data kita tidak perlu menulis kodenya secara manual.

```
package pbo_tm11;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class MataKuliahDB {

    public static TableModel resultSetToTableModel(ResultSet rs) {
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            Vector columnNames = new Vector();

            // Get the column names
            for (int column = 0; column < numberOfColumns; column++) {
                columnNames.addElement(metaData.getColumnLabel(column + 1));
            }

            // Get all rows.
            Vector rows = new Vector();

            while (rs.next()) {
                Vector newRow = new Vector();

                for (int i = 1; i <= numberOfColumns; i++) {
                    newRow.addElement(rs.getObject(i));
                }

                rows.addElement(newRow);
            }

            return new DefaultTableModel(rows, columnNames);
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }
}
```

5.	Membuat database
   
a. Membuat database dengan nama “PBO_TM10”
   
   ![image](https://github.com/user-attachments/assets/24e4f257-dc3f-40a3-bafa-e08a8cf3cddc)
  	
   ![image](https://github.com/user-attachments/assets/4b284dcc-ea4e-4504-9ada-5ec8879ff025)
   
b.	Masukkan query 
   
   ![image](https://github.com/user-attachments/assets/f2c7b7d0-31ab-44e5-94f6-0ee176a28e93)

   ![image](https://github.com/user-attachments/assets/852e164c-558d-48a3-9e9d-7aaadb61fa5a)

6.	Menyambungkan Netbeans dengan PostgreSql
   
    a.	Ketuk ‘Services’ , pilih ‘Databases’ kemudian pilih ‘New Connection’
  	
  	![image](https://github.com/user-attachments/assets/07f0c69f-1bd6-47d5-8839-67c2e5173852)
  	
  	b. Pilih PostgreSQL
  	
  	![image](https://github.com/user-attachments/assets/74bde8bf-054e-4307-bd3e-9b6bbbec507c)

    c.	Isi kolom Database sesuai dengan nama Database pada PostgreeSQL, kemudian isi password sesuai dengan password PostgreeSQL
  	
    ![image](https://github.com/user-attachments/assets/0c86b369-d391-42af-9053-135ddae0e033)

    d.	Select schema menjadi public
  	
    ![image](https://github.com/user-attachments/assets/d684ffd8-d844-45d4-b9bc-11b566f39550)

    e.	Pada kolom input connection ini akan otomatis terisi, klik Finish
  	
    ![image](https://github.com/user-attachments/assets/2a33a277-1769-49af-9846-7091b8b279bd)

    f. Klik service maka akan muncul keterangan bahwa koneksi telah berhasil 
  	
    ![image](https://github.com/user-attachments/assets/06606d4c-233f-4d2a-9d72-93123e45b559)

    g.	Kembali pada bagian ‘Project’, klik ‘Library’ setelah itu klik ‘Add Library’
  	
    ![image](https://github.com/user-attachments/assets/335e43d0-4937-48cc-ac9b-7c380c58811d)

    h.	Pilih ‘PostgreeSQL JDBC Driver’ kemudian klik ‘Add Library’
  	
    ![image](https://github.com/user-attachments/assets/84cf9921-428f-4a6c-8e49-9b9218d30ec3)

7.	Tambahkan library untuk Jasper Report
   
   ![image](https://github.com/user-attachments/assets/55b589a7-5c0f-4716-bef9-cfb25c71a22c)

8.	Tambahkan plugin IReport
    
   a.	Klik Tools, pilih plugins

  ![image](https://github.com/user-attachments/assets/208dc147-4d27-48d2-8831-b560704deb68)


  b.	Pilih tab downloaded, klik Add plugins kemudian pilih file yang ingin ditambahkan lalu klik ctrl+A dan tekan open
  
  ![image](https://github.com/user-attachments/assets/6adb9dc0-eef8-43d7-97dd-e00a3ab123e8)

9.	Membuat file laporan

  a.	Buat class baru untuk design reportnya dengan cara klik kanan pada package ‘pbo_tm11’ kemudian pilih ‘new’ dan pilih ‘report wizard’
  
![image](https://github.com/user-attachments/assets/77c4afec-ca11-4426-9689-1151bc092eb7)


  b.	Pilih design layout
  
  ![image](https://github.com/user-attachments/assets/6fcb41ba-9f83-4144-b65e-cacfdb6775c8)

  c.	Sambungkan ke database yang telah disiapkan, klik next. Kemudian masukkan nama database, username, dan password lalu klik next
  
  ![image](https://github.com/user-attachments/assets/cba7c67c-a694-4c5a-9775-6009e49287a3)

  d.	Pilih query dan ketikkan secara manual ‘select * from matakuliah;’ atau bisa juga pilih design query jika memiliki banyak table 
  
  ![image](https://github.com/user-attachments/assets/6c454561-1d27-44c4-b64a-fbc01485ee20)

  e.	Masukkan password database, klik OK
  
  ![image](https://github.com/user-attachments/assets/5b2b03a7-9844-4203-a2bc-8f4dd6f4783f)

  f.	Atur Group by sesuai dengan tabel pada database, lalu pindahkan ke sebelah kanan dan klik next
  
  ![image](https://github.com/user-attachments/assets/098326e4-0e64-4324-b61f-97fa232838ee)

  ![image](https://github.com/user-attachments/assets/69382f54-12fb-46b0-a846-cca53931b5c7)

  g.	Setelah muncul seperti ini, klik next
  
  ![image](https://github.com/user-attachments/assets/0cbe07f5-3c07-498d-8df3-a6f67bad3896)

  h.	Jika muncul tampilan seperti ini, maka telah berhasil membuat report baru
  
  ![image](https://github.com/user-attachments/assets/8a97871f-c179-454b-9aef-571dd53c0cbc)

  i.	Membuat design pada class Jasper Wizard 
  
 ![image](https://github.com/user-attachments/assets/b7c7eacc-ff99-4369-b6cf-ddea1969e52b)

10.	Memasukkan data ke CSV
    
a.	Membuat data Mata Kuliah yang terdiri dari 4 kolom yang berisi Kode Mata Kuliah, SKS, Nama Mata Kuliah dan Semester Ajar

![image](https://github.com/user-attachments/assets/34339e3c-4cba-470b-aa13-2e19762edda9)
 
b.	Simpan dalam format CSV (Comma Delimited)

![image](https://github.com/user-attachments/assets/b583a01f-317b-4fec-a0f5-dfdd977a1c0f)

11. Pada class FrameMataKuliah klik source dan isikan bagian tombol-tombol pada desain agar bisa bekerja 
    
  a.	Mendeklarasikan import kelas-kelas yang diperlukan untuk database, pengolahan input, antarmuka pengguna dengan swing, menyimpan detail koneksi database serta menyimpan import jasper report agar bisa bekerja 
```
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
```
  b.	Membuat method tampil untuk membuat koneksi ke database dengan menggunakan perintah DriverManager.getConnection dan menampilkan informasi tersebut dalam sebuah JTable dengan menggunakan perintah "SELECT * FROM MataKuliah;" 
```
 public void tampil() {
        // TODO code application login
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
```
  c.	Mengisi code pada btnInsert yang berfungsi untuk menambahkan data. Button ini berfungsi untuk menambahkan data pada 'Data Mata Kuliah'. Sebagai pengguna, kita diminta untuk mengisi informasi mengenai kodeMK, sks, namaMK, semesterAjar. Setelah dimasukkan, kita bisa menekan button Insert. Jika berhasil, akan muncul pesan 'Data Berhasil disimpan'.
```
 private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {                                          
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
    }                                  
```
  d.	Mengisi code pada btnUpdate yang berfungsi untuk memperbarui data. Pertama-tama masukkan kodeMK yang ingin diubah, kemudian masukkan informasi mengenai sks, namaMK, dan semesterAjar baru. Jika berhasil, sistem akan mencetak pemberitahuan bahwa 'Data berhasil diupdate'.
```
private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {                                          
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
    }                                                                  
```
  e.	Mengisi code pada btnDelete yang berfungsi untuk menghapus data pada 'Data Mata Kuliah'. Pengguna bisa memasukkan data yang ingin dihapus atau bisa juga dengan mengeklik data yang ingin dihapus pada kolom list. Kemudian akan muncul pesan konfirmasi apakah pengguna ingin menghapus data atau tidak. Jika 'iya' data otomatis akan dihapus dan jika 'tidak' maka data akan batal dihapus.
```
private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                          
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
    }                               
```
  f.	Mengisi code pada btnExit yang berfungsi untuk keluar dari halaman yang menampilkan GUI dengan kembali ke halaman awal.
```
 private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
        System.exit(0);
    }     
```
  g.	Mengisi code pada program tblMataKuliahMouseClicked yang berfungsi untuk menampilkan data dalam bentuk tabel. Selain itu, pengguna juga dapat mengedit data tersebut.
```
 private void tblMataKuliahMouseClicked(java.awt.event.MouseEvent evt) {                                           
        // TODO add your handling code here:
        int row = tblMataKuliah.getSelectedRow();
        tfKodeMK.setText(tblMataKuliah.getValueAt(row, 0).toString());
        tfSKS.setText(tblMataKuliah.getValueAt(row, 1).toString());
        tfNamaMK.setText(tblMataKuliah.getValueAt(row, 2).toString());
        tfSemesterAjar.setText(tblMataKuliah.getValueAt(row, 3).toString());
        tampil();
    }          
```
  h.	Mengisi code pada btnCetak yang berfungsi untuk mencetak file yang bisa disimpan ke dalam bentuk pdf 
```
 private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {                                         
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
    }                    
```
i. Mengisi code btnUpload yang berfungsi untuk mengupload file CSV ke dalam program 
```
 private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {                                          
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
    }                                  
```

j.	Mengisi code pada program bersih() yang berfungsi untuk memastikan bahwa setelah data dimasukkan atau operasi selesai, semua input dari pengguna direset untuk memudahkan pengguna memasukkan data baru tanpa harus menghapusnya secara manual.
```
 private void bersih() {
        tfKodeMK.setText("");
        tfSKS.setText("");
        tfNamaMK.setText("");
        tfSemesterAjar.setText("");
        tampil();
    }
```
12.	Hasil eksekusi Insert data
    
    ![image](https://github.com/user-attachments/assets/aec66d98-f967-4c2e-88f3-2489ad5e7d21)

13.	Hasil eksekusi Update data
    
    ![image](https://github.com/user-attachments/assets/b216d92b-071a-4ca7-9bfb-d784e05f047b)
   	
14.	Hasil eksekusi Delete data
    
    ![image](https://github.com/user-attachments/assets/0a475ebf-9b6a-45ce-9d60-1ee717995a13)

    ![image](https://github.com/user-attachments/assets/40e71686-97fc-4462-9479-e2474ce696ba)

15.	Hasil eksekusi Cetak data
    
  ![image](https://github.com/user-attachments/assets/e88b7401-5ac4-457c-938a-89d113e07342)

16. Hasil eksekusi Upload data
    
    a.  Pilih file yang akan diupload
    
    ![image](https://github.com/user-attachments/assets/898dc494-480e-443d-9ac3-c64358f0499a)

    b. Jika berhasil akan muncul pesan seperti berikut
    
    ![image](https://github.com/user-attachments/assets/c808f75f-103f-44e9-b343-c960d10ed86a)

    c. Data berhasil dimasukkan
    
    ![image](https://github.com/user-attachments/assets/26d0bd65-e69f-4661-bad8-fc2fbf1f6d8f)

    
17.	Hasil eksekusi Exit
    
   ![image](https://github.com/user-attachments/assets/0d900513-e5fe-4ab4-a3c9-5895dc019324)

   ![image](https://github.com/user-attachments/assets/cfd77011-7c57-485e-b99a-5698b3054d3a)
