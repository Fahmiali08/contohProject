/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel.Umroh.Mihrab.Qolbi.Dao.Impl;

import Travel.Umroh.Mihrab.Qolbi.Dao.DataJadwalDao;
import Travel.Umroh.Mihrab.Qolbi.Model.DataJadwalModel;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author user
 */
public class DataJadwalDaoImpl extends HibernateUtil implements DataJadwalDao {

    @Override
    public List<Object[]> getListDataJadwal() throws Exception{
        List<Object[]> listData = null;
        try {
            String sql = "select * from jadwal_tbl";
            Query query = createNativeQuery(sql);
            listData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    @Override
    public void saveDataJadwal(DataJadwalModel jadwalModel) {
        try {
            getSession().save(jadwalModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteJadwal(String id_jadwal) {
        DataJadwalModel ddm = new DataJadwalModel();
        ddm.setId_jadwal(id_jadwal);
        getSession().delete(ddm);
    }

    @Override
    public List<DataJadwalModel> getListJadwalUpdate(String id_jadwal) {
        List<DataJadwalModel> dataList = null;
        String sql = "select model from DataJadwalModel model where id_jadwal=:id";
        Query query = createQuery(sql).setParameter("id", id_jadwal);
        dataList = query.list();
        return dataList;
    }

    @Override
    public void updateJadwal(DataJadwalModel ddm) {
        getSession().saveOrUpdate(ddm);
    }
    
}
