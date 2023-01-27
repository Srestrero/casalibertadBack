package com.scj.casa_libertad_aco.Services;

import com.scj.casa_libertad_aco.Entities.BandejaAcogida;
import com.scj.casa_libertad_aco.Repositories.BandejaAcogidaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BandejaAcogidaService {
    
    @Autowired
    private BandejaAcogidaRepository bandejaAcogidaRepository;
    
    /*
    R-Consultar
    */
    public List<BandejaAcogida> consultBandejaAcogida() throws Exception{
    
        try{
            List<BandejaAcogida> lista = bandejaAcogidaRepository.findAll();
            //List<BandejaAcogida> listado = null;
            int cont = 0;
            /*for(int i=0;lista.size();i++){
                if(cont<12){
                    BandejaAcogida item = lista.get(i);
                    listado.add(i,item);
                    cont = cont + 1;
                }
            }*/
            List<BandejaAcogida> listado = new ArrayList();
            for(BandejaAcogida item:lista){
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
    
    /*
    D-Eliminar
    */
    public String eliminarUsuarioBandeja(int id){
        bandejaAcogidaRepository.deleteById(id);
        return "usuario removido de la bandeja" +id;
    }
    
}
