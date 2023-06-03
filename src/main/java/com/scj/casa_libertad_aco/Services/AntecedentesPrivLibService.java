
package com.scj.casa_libertad_aco.Services;

import com.scj.casa_libertad_aco.Entities.AntecedentesPrivLib;
import com.scj.casa_libertad_aco.Entities.Delitos;
import com.scj.casa_libertad_aco.Entities.EstablecimientosCarc;
import com.scj.casa_libertad_aco.Entities.SituacionJuridica;
import com.scj.casa_libertad_aco.Entities.Usuarios;
import com.scj.casa_libertad_aco.Repositories.AntecedentesPrivLibRepository;
import com.scj.casa_libertad_aco.Repositories.DelitosRepository;
import com.scj.casa_libertad_aco.Repositories.EstablecimientosCarcRepository;
import com.scj.casa_libertad_aco.Repositories.SituacionJuridicaRepository;
import com.scj.casa_libertad_aco.Repositories.UsuariosRepository;
import com.scj.casa_libertad_aco.entradaDTOs.AntecedentesDTO;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

@Service
public class AntecedentesPrivLibService {
    
    @Autowired
    private AntecedentesPrivLibRepository antecedentesPrivLibRepository;
    
    @Autowired
    private UsuariosRepository usuariosRepository;
    
    @Autowired
    private DelitosRepository delitosRepository;
    
    @Autowired
    private EstablecimientosCarcRepository establecimientosCarcRepository;
    
    @Autowired
    private SituacionJuridicaRepository situacionJuridicaRepository; 
    
    /*
    Crear
    */
    public AntecedentesPrivLib crearAntecedentes(String numeroDocumento,AntecedentesDTO antecedentesDTO){
        Usuarios usuarios = usuariosRepository.findByNumeroDocumento(numeroDocumento);
        AntecedentesPrivLib antecedentes= antecedentesPrivLibRepository.findByUsuarios(usuarios);
        if(antecedentes == null){
        AntecedentesPrivLib nuevoAntecedentes= new AntecedentesPrivLib();
        nuevoAntecedentes.setFechaLibertad(antecedentesDTO.getFecha_libertad());
        nuevoAntecedentes.setMesesCondena(antecedentesDTO.getMeses_condena());
        //antecedentesPrivLib.setOtroEstabCarce(antecedentesDTO.getOtro_estab_carce());
        nuevoAntecedentes.setUltimoProceso(antecedentesDTO.getUltimoProceso());
        nuevoAntecedentes.setAprehendAdolesc(antecedentesDTO.getAprehend_adolesc());
        nuevoAntecedentes.setAprehendMayor(antecedentesDTO.getAprehend_mayor());
        nuevoAntecedentes.setProcesoActual(antecedentesDTO.getProceso_actual());
        
        Delitos delitos = delitosRepository.findByUniqid(antecedentesDTO.getDelitos_uniqid());
        nuevoAntecedentes.setDelitos(delitos);
        
        EstablecimientosCarc establecimientosCarc = establecimientosCarcRepository.findByUniqid(antecedentesDTO.getEstab_carcs_uniqid());
        nuevoAntecedentes.setEstabCarcelarios(establecimientosCarc);
       
        SituacionJuridica situacionJuridica = situacionJuridicaRepository.findByUniqid(antecedentesDTO.getSit_jurid_uniqid());
        nuevoAntecedentes.setSituacionJuridicas(situacionJuridica);
        
        nuevoAntecedentes.setPersoneria(antecedentesDTO.getPersoneria());
        nuevoAntecedentes.setProcuraduria(antecedentesDTO.getProcuraduria());
        nuevoAntecedentes.setContraloria(antecedentesDTO.getContraloria());
        nuevoAntecedentes.setRamaJudicial(antecedentesDTO.getRama_judicial());
        nuevoAntecedentes.setPolicia(antecedentesDTO.getPolicia());
        nuevoAntecedentes.setCodigoSeguridad(antecedentesDTO.getCodigo_seguridad());
        nuevoAntecedentes.setSisipec(antecedentesDTO.getSisipec());
        
        nuevoAntecedentes.setUsuarios(usuariosRepository.findByNumeroDocumento(numeroDocumento));
        
        return antecedentesPrivLibRepository.save(nuevoAntecedentes);
        }else{
            try {
                actualizaAntecedentes(numeroDocumento,antecedentesDTO);
            } catch (Exception ex) {
                Logger.getLogger(AntecedentesPrivLibService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return antecedentesPrivLibRepository.findByUsuarios(usuarios);
    }
    
    /*
    R-Consultar
    */
    public AntecedentesDTO consultarAntecedentes(String numeroDocumento)throws Exception{
        try{
        Usuarios usuarios = usuariosRepository.findByNumeroDocumento(numeroDocumento);
        AntecedentesPrivLib antecedentesPrivLib =  antecedentesPrivLibRepository.findByUsuarios(usuarios);
        if(antecedentesPrivLib==null){
            return null;
        }
        AntecedentesDTO antecedentes = new AntecedentesDTO();
        antecedentes.setFecha_libertad(antecedentesPrivLib.getFechaLibertad());
        antecedentes.setMeses_condena(antecedentesPrivLib.getMesesCondena());
        //antecedentes.setOtro_estab_carce(antecedentesPrivLib.getUltimoProceso());
        antecedentes.setUltimoProceso(antecedentesPrivLib.getUltimoProceso());
        antecedentes.setAprehend_adolesc(antecedentesPrivLib.getAprehendAdolesc());
        antecedentes.setAprehend_mayor(antecedentesPrivLib.getAprehendMayor());
        antecedentes.setProceso_actual(antecedentesPrivLib.getProcesoActual());
        antecedentes.setDelitos_uniqid(antecedentesPrivLib.getDelitos().getUniqid());
        antecedentes.setEstab_carcs_uniqid(antecedentesPrivLib.getEstabCarcelarios().getUniqid());
        antecedentes.setSit_jurid_uniqid(antecedentesPrivLib.getSituacionJuridicas().getUniqid());
        antecedentes.setPersoneria(antecedentesPrivLib.getPersoneria());
        antecedentes.setProcuraduria(antecedentesPrivLib.getProcuraduria());
        antecedentes.setContraloria(antecedentesPrivLib.getContraloria());
        antecedentes.setRama_judicial(antecedentesPrivLib.getRamaJudicial());
        antecedentes.setPolicia(antecedentesPrivLib.getPolicia());
        antecedentes.setCodigo_seguridad(antecedentesPrivLib.getCodigoSeguridad());
        antecedentes.setSisipec(antecedentesPrivLib.getSisipec());
        //antecedentes.setUsuarios_uniqid(antecedentesPrivLib.getUsuarios().getUniqid());
        
        return antecedentes;
                        
        }catch(Exception e){
        return null;
        }
    }
    
    /*
    U-Actualizar
    */
    public AntecedentesPrivLib actualizaAntecedentes(String numeroDocumento, AntecedentesDTO antecedentesDTO)
            throws Exception {
        try {
            Usuarios usuarios = usuariosRepository.findByNumeroDocumento(numeroDocumento);
            AntecedentesPrivLib antecedentesPrivLib = antecedentesPrivLibRepository.findByUsuarios(usuarios);
            if (antecedentesPrivLib == null) {
                return null;
            }
            
            antecedentesPrivLib.setFechaLibertad(antecedentesDTO.getFecha_libertad());
            antecedentesPrivLib.setMesesCondena(antecedentesDTO.getMeses_condena());
            //antecedentesPrivLib.setOtroEstabCarce(antecedentesDTO.getOtro_estab_carce());
            antecedentesPrivLib.setUltimoProceso(antecedentesDTO.getUltimoProceso());
            antecedentesPrivLib.setAprehendAdolesc(antecedentesDTO.getAprehend_adolesc());
            antecedentesPrivLib.setAprehendMayor(antecedentesDTO.getAprehend_mayor());
            antecedentesPrivLib.setProcesoActual(antecedentesDTO.getProceso_actual());

            Delitos delitos = delitosRepository.findByUniqid(antecedentesDTO.getDelitos_uniqid());
            antecedentesPrivLib.setDelitos(delitos);

            EstablecimientosCarc establecimientosCarc = establecimientosCarcRepository.findByUniqid(antecedentesDTO.getEstab_carcs_uniqid());
            antecedentesPrivLib.setEstabCarcelarios(establecimientosCarc);

            SituacionJuridica situacionJuridica = situacionJuridicaRepository.findByUniqid(antecedentesDTO.getSit_jurid_uniqid());
            antecedentesPrivLib.setSituacionJuridicas(situacionJuridica);

            antecedentesPrivLib.setPersoneria(antecedentesDTO.getPersoneria());
            antecedentesPrivLib.setProcuraduria(antecedentesDTO.getProcuraduria());
            antecedentesPrivLib.setContraloria(antecedentesDTO.getContraloria());
            antecedentesPrivLib.setRamaJudicial(antecedentesDTO.getRama_judicial());
            antecedentesPrivLib.setPolicia(antecedentesDTO.getPolicia());
            antecedentesPrivLib.setCodigoSeguridad(antecedentesDTO.getCodigo_seguridad());
            antecedentesPrivLib.setSisipec(antecedentesDTO.getSisipec());

            antecedentesPrivLib.setUsuarios(usuariosRepository.findByNumeroDocumento(numeroDocumento));

            return antecedentesPrivLibRepository.save(antecedentesPrivLib);

        } catch (Exception e) {
            return null;
        }
    }

}
