package responsi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ControllerMenu {
    ViewMenu viewmenuu;
    ModelMenu modelmenuu;

    public ControllerMenu(ViewMenu viewmenu, ModelMenu modelmenu){
        this.viewmenuu = viewmenu;
        this.modelmenuu = modelmenu;

        if (modelmenuu.getBanyakData()!=0) {
            String dataKontak[][] = modelmenuu.readContact();
            viewmenuu.tabel.setModel((new JTable(dataKontak, viewmenuu.namaKolom)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }

        viewmenuu.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String Nama = viewmenuu.getNama();
                String portofolio = viewmenuu.getNPortofolio();
                String microteaching = viewmenuu.getNMicroteaching();
                String wawancara = viewmenuu.getNWawancara();

                modelmenuu.insertData(Nama, portofolio, microteaching, wawancara);

                String dataKontak[][] = modelmenuu.readContact();
                viewmenuu.tabel.setModel((new JTable(dataKontak, viewmenuu.namaKolom)).getModel());
            }
        });

        viewmenuu.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String Nama = viewmenuu.getNama();
                String portofolio = viewmenuu.getNPortofolio();
                String microteaching = viewmenuu.getNMicroteaching();
                String wawancara = viewmenuu.getNWawancara();
                modelmenuu.updateContact(Nama, portofolio, microteaching, wawancara);

                String dataKontak[][] = modelmenuu.readContact();
                viewmenuu.tabel.setModel((new JTable(dataKontak, viewmenuu.namaKolom)).getModel());
            }
        });

        viewmenuu.btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                viewmenuu.tfNama.setText("");
                viewmenuu.tfNPortofolio.setText("");
                viewmenuu.tfNmicroteaching.setText("");
                viewmenuu.tfNWawancara.setText("");
            }
        });

        viewmenuu.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = viewmenuu.tabel.getSelectedRow();


                String dataterpilih1 = viewmenuu.tabel.getValueAt(baris, 0).toString();
                String dataterpilih2 = viewmenuu.tabel.getValueAt(baris, 1).toString();
                String dataterpilih3 = viewmenuu.tabel.getValueAt(baris, 2).toString();
                String dataterpilih4 = viewmenuu.tabel.getValueAt(baris, 3).toString();

                viewmenuu.tfNama.setText(dataterpilih1);
                viewmenuu.tfNPortofolio.setText(dataterpilih2);
                viewmenuu.tfNmicroteaching.setText(dataterpilih3);
                viewmenuu.tfNWawancara.setText(dataterpilih4);


            }
        }
        );

        viewmenuu.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                modelmenuu.deleteContact(viewmenuu.tfNama.getText());
            }
        });
    }

}
