
package salti.controller;

import salti.model.Mahasiswa;
import salti.view.FormMahasiswa;
import salti.model.MahasiswaDao;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MahasiswaController 
{
    FormMahasiswa formMahasiswa;
    Mahasiswa mahasiswa;
    MahasiswaDao mahasiswaDao;
    int index;
    
    public MahasiswaController(FormMahasiswa formMahasiswa)
    {
        this.formMahasiswa = formMahasiswa;
        mahasiswaDao = new MahasiswaDao();
    }
    
    public void cancel()
    {
        formMahasiswa.getTxtNOBP().setText("");
        formMahasiswa.getTxtNama().setText("");
        formMahasiswa.getTxtAlamat().setText("");
        formMahasiswa.getTxtTglLahir().setText("");
        isiJenisKelamin();
    }
    
    public void isiJenisKelamin()
    {
        formMahasiswa.getCboJenisKelamin().removeAllItems();
        formMahasiswa.getCboJenisKelamin().addItem("L");
        formMahasiswa.getCboJenisKelamin().addItem("P");
    }
    
    public void insert()
    {
        mahasiswa = new Mahasiswa();
        mahasiswa.setNobp(formMahasiswa.getTxtNOBP().getText());
        mahasiswa.setNama(formMahasiswa.getTxtNama().getText());
        mahasiswa.setAlamat(formMahasiswa.getTxtAlamat().getText());
        mahasiswa.setJenisKelamin(formMahasiswa.getCboJenisKelamin().getSelectedItem().toString());
        mahasiswa.setTglalhir(formMahasiswa.getTxtTglLahir().getText());
        mahasiswaDao.insert(mahasiswa);
        JOptionPane.showMessageDialog(formMahasiswa, "Entry Data Ok");
    }
    
   
    public void getMahasiswa(){
        int index = formMahasiswa.getTabelMahasiswa().getSelectedRow();
        mahasiswa = mahasiswaDao.getMahasiswa(index);
        if(mahasiswa != null){
            formMahasiswa.getTxtNOBP().setText(mahasiswa.getNobp());
            formMahasiswa.getTxtNama().setText(mahasiswa.getNama());
            formMahasiswa.getTxtAlamat().setText(mahasiswa.getAlamat());
            formMahasiswa.getCboJenisKelamin().setSelectedItem(mahasiswa.getJenisKelamin());
            formMahasiswa.getTxtTglLahir().setText(mahasiswa.getTglalhir());
        }
    }
    
    public void viewData()
    {
        DefaultTableModel model = (DefaultTableModel)formMahasiswa.getTabelMahasiswa().getModel();
        model.setNumRows(0);
        List<Mahasiswa> list = mahasiswaDao.getAllMahasiswa();
        for(Mahasiswa mahasiswa :list)
        {
            Object[] data = 
            {
                mahasiswa.getNobp(),
                mahasiswa.getNama(),
                mahasiswa.getAlamat(),
                mahasiswa.getJenisKelamin(),
                mahasiswa.getTglalhir()
            };
            model.addRow(data);
        }
    }
    
       
    public void update()
    {
        mahasiswa.setNobp(formMahasiswa.getTxtNOBP().getText());
        mahasiswa.setNama(formMahasiswa.getTxtNama().getText());
        mahasiswa.setAlamat(formMahasiswa.getTxtAlamat().getText());
        mahasiswa.setJenisKelamin(formMahasiswa.getCboJenisKelamin().getSelectedItem().toString());
        mahasiswa.setTglalhir(formMahasiswa.getTxtTglLahir().getText());
        JOptionPane.showMessageDialog(formMahasiswa, "Update Data OK");
    }
    
    public void delete()
        {
            mahasiswaDao.delete(index);
            JOptionPane.showMessageDialog(formMahasiswa, "Delete Data Ok");
        }
}
