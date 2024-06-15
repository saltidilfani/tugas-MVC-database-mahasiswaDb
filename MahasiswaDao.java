
package salti.model;

import salti.model.Mahasiswa;
import java.util.ArrayList;
import java.util.List;

public class MahasiswaDao 
{
    private List<Mahasiswa> data = new ArrayList<Mahasiswa>();
    
    public MahasiswaDao()
    {
        data.add(new Mahasiswa("98312100","ALi","Padang","L","17-02-2002"));
        data.add(new Mahasiswa("98312101","Asi","Jakarta","P","03-05-2003"));
        data.add(new Mahasiswa("98312102","Budi","Padang Panjang","L","29-02-2004"));
    }
    
    public void insert(Mahasiswa m)
    {
        data.add(m);
    }
    
    public void update(int index, Mahasiswa m)
    {
        data.set(index, m);
    }
    
    public void delete(int index)
    {
        data.remove(index);
    }

    public Mahasiswa getMahasiswa(int index)
    {
        return data.get(index);
    }

    public List<Mahasiswa> getAllMahasiswa() 
    {
        return data;
    }
    
    
}
