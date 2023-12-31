
package com.scj.casa_libertad_aco.Services;

import com.scj.casa_libertad_aco.Controllers.ViviendasController;
import com.scj.casa_libertad_aco.Entities.Usuarios;
import com.scj.casa_libertad_aco.Entities.Viviendas;
import com.scj.casa_libertad_aco.Repositories.UsuariosRepository;
import com.scj.casa_libertad_aco.Repositories.ViviendasRepository;
import com.scj.casa_libertad_aco.salidaDTOs.ConsultaViviendaDTO;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;


@Service
public class ViviendasService {
    
    @Autowired
    private ViviendasRepository viviendasRepository;
    
    @Autowired
    private UsuariosRepository usuariosRepository;
    
    /*
    R-Consultar
    */
    public ConsultaViviendaDTO consultarVivienda(String numeroDocumento)throws Exception{
        try{
            Usuarios usuarios = usuariosRepository.findByNumeroDocumento(numeroDocumento);
            Viviendas vivienda = usuarios.getViviendaTipo();
            if(vivienda==null){
                //ConsultaViviendaDTO consulta = new ConsultaViviendaDTO();
                return null; //consulta; 
            }
            ConsultaViviendaDTO consulta = new ConsultaViviendaDTO();
            consulta.setUniqid(vivienda.getUniqid());
            
            return consulta;
        }catch(Exception e){
            return null;
        }
    }
    
    /*
    C-crear objeto vivienda en usuarios
    */
    public Usuarios crearViviendaUsuario(String numeroDocumento,int tipo){
        Usuarios usuario = usuariosRepository.findByNumeroDocumento(numeroDocumento);
        Viviendas vivienda = viviendasRepository.findByUniqid(tipo);
        if(vivienda==null){
        usuario.setViviendaTipo(vivienda);
        usuariosRepository.save(usuario);
        //return usuariio;
        }else{
            try {
                //ViviendasController viviendas = new ViviendasController();
                actualizaViviendaUsuario(numeroDocumento,tipo);
            } catch (Exception ex) {
                Logger.getLogger(ViviendasService.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return usuario; 
    
    }
    
    /*
    U-Actualizar
    */
    public Usuarios actualizaViviendaUsuario(String numeroDocumento,int tipo)throws Exception{
        try{
        Usuarios usuario = usuariosRepository.findByNumeroDocumento(numeroDocumento);
        Viviendas vivienda = viviendasRepository.findByUniqid(tipo);
        usuario.setViviendaTipo(vivienda);
        usuariosRepository.save(usuario);
        return usuario;
        }catch(Exception e){
        return null;
        }
    
    }
    
    
}
