/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel.Umroh.Mihrab.Qolbi.Controller;

import Travel.Umroh.Mihrab.Qolbi.Dto.DataJadwalDto;
import Travel.Umroh.Mihrab.Qolbi.Service.DataJadwalService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author user
 */
@Controller
@RequestMapping
public class DataTravelController {
    
//    @Autowired
//    DataJadwalService dataJadwalService;
    
    @Autowired
    DataJadwalService dataJadwalService;
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String lihatIndex(){
        return "index";
    }
    
    @RequestMapping(value="/dataJadwal",method = RequestMethod.GET)
    public String dataJadwal(ModelMap model) throws Exception{
        try {
            List<DataJadwalDto> DataJadwalDTO=dataJadwalService.getListDataJadwal();
            model.addAttribute("DataJadwalDTO", DataJadwalDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return "DataJadwal";
    }
    
    @RequestMapping(value = "/doTambahDataJadwal", method = RequestMethod.GET)
    public String doTambahDataJadwal(ModelMap model){
        DataJadwalDto dto = null;    
        
        try {
            dto = new DataJadwalDto();
            model.addAttribute("jadwalDto", dto);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return "insertJadwal";
    }
    
    @RequestMapping(value = "/saveJadwal", method = RequestMethod.POST)
    public String saveLaptop(DataJadwalDto jadwalDto, ModelMap model) throws Exception{                
        ModelAndView mdl = new ModelAndView();
        dataJadwalService.saveDataJadwal(jadwalDto);                
        return "redirect:dataJadwal.htm";
    }
    
    @RequestMapping(value = "/deleteDataJadwal", method = RequestMethod.GET)
    public String hapusData(String id_jadwal, ModelMap model) throws Exception{        
        dataJadwalService.deleteDataJadwal(id_jadwal);
        return "redirect:dataJadwal.htm";
    }
    
    @RequestMapping(value = "/getDataUpdateJadwal", method = RequestMethod.GET)
    public String getUpdateDataJadwal(String id_jadwal, ModelMap model) throws Exception{
        DataJadwalDto jadwalDto =dataJadwalService.getUpdateDataJadwal(id_jadwal);
        model.addAttribute("jadwalDto", jadwalDto);
        return "updateJadwal";
    }
    
    @RequestMapping(value = "/updateJadwal", method = RequestMethod.POST)
    public String editData(DataJadwalDto jadwalDto) throws Exception{
        dataJadwalService.doUpdateDataJadwal(jadwalDto);
        return "redirect:dataJadwal.htm";
    }
}
