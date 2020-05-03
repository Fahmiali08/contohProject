package Travel.Umroh.Mihrab.Qolbi.Service;

import Travel.Umroh.Mihrab.Qolbi.Dto.DataJadwalDto;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public interface DataJadwalService {

    public List<DataJadwalDto> getListDataJadwal() throws Exception;

    public void saveDataJadwal(DataJadwalDto jadwalDto);

    public void deleteDataJadwal(String id_jadwal);

    public DataJadwalDto getUpdateDataJadwal(String id_jadwal);

    public void doUpdateDataJadwal(DataJadwalDto jadwalDto);
    
}
