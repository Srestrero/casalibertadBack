
package com.scj.casa_libertad_aco.Services;

import com.scj.casa_libertad_aco.Entities.BandejaArticulacion;
import com.scj.casa_libertad_aco.Repositories.BandejaArticulacionRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BandejaArticulacionService {
    
    @Autowired
    private BandejaArticulacionRepository bandejaArticulacionRepository;
    
    /*
    R-Consultar
    */
    public List<BandejaArticulacion> consultaBandejaArticulacion() throws Exception{
        
        try{
            List<BandejaArticulacion> lista = bandejaArticulacionRepository.findAll();
            
            int cont = 0;
            
            List<BandejaArticulacion> listado = new ArrayList();
            for(BandejaArticulacion item:lista){
                if(cont<12){
                    item.setId(cont);
                    item.setNumeroDocumento(lista.get(cont).getNumeroDocumento());
                    item.setNombres(lista.get(cont).getNombres());
                    item.setPrimerApellido(lista.get(cont).getPrimerApellido());
                    item.setSegundoApellido(lista.get(cont).getSegundoApellido());
                    item.setAccion(lista.get(cont).getAccion());
                    
                    listado.add(cont, item);
                    
                    
                    cont = cont + 1;
                }
            }
            return listado;
    }catch(Exception e){
        return null;
    }
    }
    
    public String eliminarUsuarioBandeja(int id){
        bandejaArticulacionRepository.deleteById(id);
        return "usuario removido de la bandeja" +id;
    }
    
    public BandejaArticulacion creaBandejaArticulacion(BandejaArticulacion bandejaArticulacion){
        
        BandejaArticulacion bandeja = new BandejaArticulacion();
        bandeja.setNumeroDocumento(bandejaArticulacion.getNumeroDocumento());
        bandeja.setNombres(bandejaArticulacion.getNombres());
        bandeja.setPrimerApellido(bandejaArticulacion.getPrimerApellido());
        bandeja.setSegundoApellido(bandejaArticulacion.getSegundoApellido());
        bandeja.setAccion(bandejaArticulacion.getAccion());
        
        return bandejaArticulacionRepository.save(bandeja);
    
    }
    
    
    
}
