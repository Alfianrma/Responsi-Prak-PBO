package responsi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ModelMenu {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/aslab_db";
    static final String USER = "root";
    static final String PASS = "";

    Connection koneksi;
    Statement statement;

    int nilai;

    public ModelMenu(){
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }

    public int getBanyakData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from aslab";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlData++;
            }
            return jmlData;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }

    public String[][] readContact(){
        try{
            int jmlData = 0;

            String data[][] = new String[getBanyakData()][5];

            String query = "Select * from aslab";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("judul");
                data[jmlData][1] = resultSet.getString("portofolio");
                data[jmlData][2] = resultSet.getString("microteaching");
                data[jmlData][3] = resultSet.getString("wawancara");
                data[jmlData][4] = resultSet.getString("nilai");
                jmlData++;
            }
            return data;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public void insertData(String Nama, String NPortofolio, String NMicroteaching, String NWawancara){
        int jmlData=0;
        try {
            String query = "Select * from aslab ";
            System.out.println(Nama + " " + NPortofolio + " " + NMicroteaching + " "+ NWawancara);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                jmlData++;
            }

            int Portofolio = Integer.valueOf(NPortofolio);
            int Microteaching = Integer.valueOf(NMicroteaching);
            int Wawancara = Integer.valueOf(NWawancara);
            nilai = (Portofolio + Microteaching + Wawancara)/3;

            if (jmlData==0) {
                if(Portofolio >100 || Microteaching >100 || Wawancara >100){
                    JOptionPane.showMessageDialog(null, "kesalahan input");
                }
                else {
                    query = "INSERT INTO aslab VALUES('" + Nama + "','" + NPortofolio + "','" + NMicroteaching + "','" + NWawancara + "','" + nilai + "')";

                    statement = (Statement) koneksi.createStatement();
                    statement.executeUpdate(query);
                    System.out.println("Berhasil ditambahkan");
                    JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Data sudah ada");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void updateContact(String Nama, String NPortofolio, String NMicroteaching, String NWawancara){
        int jmlData=0;
        try {
            String query = "Select * from aslab ";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                jmlData++;
            }

            if (jmlData==1) {
                query = "UPDATE aslab SET Nama='" + Nama + "', portofolio='" + NPortofolio + "', microteaching='" + NMicroteaching  + "', wawancara='" + NWawancara +"', nilai='" + nilai  +"' WHERE judul="+ Nama;
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil diupdate");
                JOptionPane.showMessageDialog(null, "Data Berhasil diupdate");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data Tidak Ada");
            }

        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void deleteContact (String Nama) {
        try{
            String query = "DELETE FROM aslab WHERE judul = '"+Nama+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");

        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }

}
