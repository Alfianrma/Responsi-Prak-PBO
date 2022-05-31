package responsi;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ViewMenu extends JFrame{
    JLabel lNama = new JLabel("Nama");
    JLabel lNPortofolio = new JLabel("Nilai Portofolio");
    JLabel lNMicroteaching = new JLabel("Nilai Microteaching");
    JLabel lNWawancara = new JLabel("Nilai Wawancara");
    JLabel l = new JLabel("");
    JTextField tfNama = new JTextField();
    JTextField tfNPortofolio = new JTextField();
    JTextField tfNmicroteaching= new JTextField();
    JTextField tfNWawancara= new JTextField();

    JButton btnTambah = new JButton("Tambah");
    JButton btnUpdate = new JButton("Update");
    JButton btnDelete = new JButton("Delete");
    JButton btnClear = new JButton("Clear");

    JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    Object namaKolom[] = {"Nama", "Portofolio", "Microteaching", "Wawancara", "Nilai Akhir"};

    public ViewMenu(){
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        setSize(700,450);
        setTitle("Menu Aslab");


        add(scrollPane);
        scrollPane.setBounds(20, 20, 480, 300);

        add(lNama);
        lNama.setBounds(510, 20, 90, 20);
        add(tfNama);
        tfNama.setBounds(510, 40, 120, 20);

        add(lNPortofolio);
        lNPortofolio.setBounds(510, 60, 90, 20);
        add(tfNPortofolio);
        tfNPortofolio.setBounds(510, 80, 120, 20);

        add(lNMicroteaching);
        lNMicroteaching.setBounds(510, 100, 120, 20);
        add(tfNmicroteaching);
        tfNmicroteaching.setBounds(510, 120, 120, 20);

        add(lNWawancara);
        add(tfNWawancara);
        lNWawancara.setBounds(510, 140, 100, 20);
        tfNWawancara.setBounds(510, 160, 120, 20);

        add(btnTambah);
        btnTambah.setBounds(510, 190, 90, 20);

        add(btnUpdate);
        btnUpdate.setBounds(510, 220, 90, 20);

        add(btnDelete);
        btnDelete.setBounds(510,250,90,20);

        add(btnClear);
        btnClear.setBounds(510,280,90,20);
        add(l);
        l.setBounds(1,1,1,1);



        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(null);

    }

    public String getNama() {
        return tfNama.getText();
    }

    public String getNPortofolio() {
        return tfNPortofolio.getText();
    }

    public String getNMicroteaching() {
        return tfNmicroteaching.getText();
    }

    public String getNWawancara() {
        return tfNWawancara.getText();
    }
}
