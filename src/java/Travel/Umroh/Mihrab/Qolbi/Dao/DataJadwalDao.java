/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel.Umroh.Mihrab.Qolbi.Dao;

import Travel.Umroh.Mihrab.Qolbi.Model.DataJadwalModel;
import java.util.List;

/**
 *
 * @author user
 */
public interface DataJadwalDao {

    public List<Object[]> getListDataJadwal() throws Exception;

    public void saveDataJadwal(DataJadwalModel jadwalModel);

    public void deleteJadwal(String id_jadwal);

    public List<DataJadwalModel> getListJadwalUpdate(String id_jadwal);

    public void updateJadwal(DataJadwalModel ddm);
    
}
