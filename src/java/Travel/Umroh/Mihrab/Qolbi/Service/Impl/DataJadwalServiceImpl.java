/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel.Umroh.Mihrab.Qolbi.Service.Impl;

import Travel.Umroh.Mihrab.Qolbi.Dao.DataJadwalDao;
import Travel.Umroh.Mihrab.Qolbi.Dto.DataJadwalDto;
import Travel.Umroh.Mihrab.Qolbi.Model.DataJadwalModel;
import Travel.Umroh.Mihrab.Qolbi.Service.DataJadwalService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */
@Service
public class DataJadwalServiceImpl implements DataJadwalService{

    @Autowired
    DataJadwalDao dataJadwalDao;
    
    @Override
    public List<DataJadwalDto> getListDataJadwal() throws Exception{
        List<DataJadwalDto> listDto = new ArrayList<>();
        List<Object[]> data = null;
         try {
            data = dataJadwalDao.getListDataJadwal();
        } catch (Exception ex) {
            Logger.getLogger(DataJadwalServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(data != null){
            for (Object[] ddm : data) {
                DataJadwalDto dto = new DataJadwalDto();
                if(ddm[0]!= null){
                    dto.setId_jadwal(ddm[0].toString());
                }
                if(ddm[1]!= null){
                    dto.setNama_jadwal(ddm[1].toString());
                }
                if(ddm[2]!= null){
                    dto.setId_paket(ddm[2].toString());
                }
                
                if(ddm[3]!= null){
                    dto.setTanggal_berangkat(ddm[3].toString());
                }
                
                if(ddm[4]!= null){
                    dto.setTanggal_kembali(ddm[4].toString());
                }
                listDto.add(dto);
            }
        }
        else{
            DataJadwalDto dto = new DataJadwalDto();
            dto.setNama_jadwal("Ninda Try Alviani");
            listDto.add(dto);
        }
        return listDto;
    }

    @Override
    public void saveDataJadwal(DataJadwalDto jadwalDto) {
        DataJadwalModel jadwalModel = new DataJadwalModel();
        try {
            jadwalModel.setId_jadwal(jadwalDto.getId_jadwal());
            jadwalModel.setNama_jadwal(jadwalDto.getNama_jadwal());
            jadwalModel.setId_paket(jadwalDto.getId_paket());
            jadwalModel.setTanggal_berangkat(jadwalDto.getTanggal_berangkat());
            jadwalModel.setTanggal_kembali(jadwalDto.getTanggal_kembali());
                        
            dataJadwalDao.saveDataJadwal(jadwalModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDataJadwal(String id_jadwal) {
        try {
            dataJadwalDao.deleteJadwal(id_jadwal);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public DataJadwalDto getUpdateDataJadwal(String id_jadwal) {
        List<DataJadwalModel> dataList = dataJadwalDao.getListJadwalUpdate(id_jadwal);
        DataJadwalDto dto = new DataJadwalDto();
        if(dataList != null){
            for (DataJadwalModel ddm : dataList) {       
                if(ddm.getId_jadwal()!= null){
                    dto.setId_jadwal(ddm.getId_jadwal());
                }
                if(ddm.getNama_jadwal()!= null){
                    dto.setNama_jadwal(ddm.getNama_jadwal());
                }
                if(ddm.getId_paket()!= null){
                    dto.setId_paket(ddm.getId_paket());
                }
                if(ddm.getTanggal_berangkat()!= null){
                    dto.setTanggal_berangkat(ddm.getTanggal_berangkat());
                }
                if(ddm.getTanggal_kembali()!= null){
                    dto.setTanggal_kembali(ddm.getTanggal_kembali());
                }
                
            }
        }
        return dto;
    }

    @Override
    public void doUpdateDataJadwal(DataJadwalDto jadwalDto) {
        DataJadwalModel ddm = new DataJadwalModel();
        try {
            ddm.setId_jadwal(jadwalDto.getId_jadwal());
            ddm.setNama_jadwal(jadwalDto.getNama_jadwal());
            ddm.setId_paket(jadwalDto.getId_paket());
            ddm.setTanggal_berangkat(jadwalDto.getTanggal_berangkat());
            ddm.setTanggal_kembali(jadwalDto.getTanggal_kembali());
        } catch (Exception e) {
            e.printStackTrace();
        }
        dataJadwalDao.updateJadwal(ddm);
    }
    
}
