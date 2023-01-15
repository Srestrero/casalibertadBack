
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
        AntecedentesPrivLib antecedentesPrivLib = new AntecedentesPrivLib();
        antecedentesPrivLib.setFechaLibertad(antecedentesDTO.getFecha_libertad());
        antecedentesPrivLib.setMesesCondena(antecedentesDTO.getMeses_condena());
        antecedentesPrivLib.setOtroEstabCarce(antecedentesDTO.getOtro_estab_carce());
        antecedentesPrivLib.setAprehendAdolesc(antecedentesDTO.getAprehend_adolesc());
        antecedentesPrivLib.setAprehendMayor(antecedentesDTO.getAprehend_mayor());
        antecedentesPrivLib.setProcesoActual(antecedentesDTO.getProceso_actual());
        
        Delitos delitos = delitosRepository.findByUniqId(antecedentesDTO.getDelitos_uniqid());
        antecedentesPrivLib.setDelitos(delitos);
        
        EstablecimientosCarc establecimientosCarc = establecimientosCarcRepository.findByUniqId(antecedentesDTO.getEstab_carcs_uniqid());
        antecedentesPrivLib.setEstabCarcelarios(establecimientosCarc);
       
        SituacionJuridica situacionJuridica = situacionJuridicaRepository.findByUniqId(antecedentesDTO.getSit_jurid_uniqid());
        antecedentesPrivLib.setSituacionJuridicas(situacionJuridica);
        
        antecedentesPrivLib.setUsuarios(usuariosRepository.findByNumeroDocumento(numeroDocumento));
        
        return antecedentesPrivLibRepository.save(antecedentesPrivLib);
    }
    
    /*
    R-Consultar
    */
    public AntecedentesDTO consultarAntecedentes(String numDocumento)throws Exception{
        try{
        Usuarios usuarios = usuariosRepository.findByNumeroDocumento(numDocumento);
        AntecedentesPrivLib antecedentesPrivLib =  antecedentesPrivLibRepository.findByUsuarios(usuarios);
        AntecedentesDTO antecedentes = new AntecedentesDTO();
        antecedentes.setFecha_libertad(antecedentesPrivLib.getFechaLibertad());
        antecedentes.setMeses_condena(antecedentesPrivLib.getMesesCondena());
        antecedentes.setOtro_estab_carce(antecedentesPrivLib.getOtroEstabCarce());
        antecedentes.setAprehend_adolesc(antecedentesPrivLib.getAprehendAdolesc());
        antecedentes.setAprehend_mayor(antecedentesPrivLib.getAprehendMayor());
        antecedentes.setProceso_actual(antecedentesPrivLib.getProcesoActual());
        antecedentes.setDelitos_uniqid(antecedentesPrivLib.getDelitos().getUniqId());
        antecedentes.setEstab_carcs_uniqid(antecedentesPrivLib.getEstabCarcelarios().getUniqId());
        antecedentes.setSit_jurid_uniqid(antecedentesPrivLib.getSituacionJuridicas().getUniqId());
        antecedentes.setPersoneria(antecedentesPrivLib.getPersoneria());
        antecedentes.setProcuraduria(antecedentesPrivLib.getProcuraduria());
        antecedentes.setContraloria(antecedentesPrivLib.getContraloria());
        antecedentes.setRama_judicial(antecedentesPrivLib.getRamaJudicial());
        antecedentes.setPolicia(antecedentesPrivLib.getPolicia());
        antecedentes.setCodigo_seguridad(antecedentesPrivLib.getCodigoSeguridad());
        antecedentes.setSisipec(antecedentesPrivLib.getSisipec());
        
        return antecedentes;
                        
        }catch(Exception e){
        return null;
        }
    }
    
    /*
    U-Actualizar
    */
    public AntecedentesPrivLib actualizaAntecedentes(String numeroDocumento, AntecedentesDTO antecedentesDTO) throws Exception {
        try {

            AntecedentesPrivLib antecedentesPrivLib = new AntecedentesPrivLib();
            antecedentesPrivLib.setFechaLibertad(antecedentesDTO.getFecha_libertad());
            antecedentesPrivLib.setMesesCondena(antecedentesDTO.getMeses_condena());
            antecedentesPrivLib.setOtroEstabCarce(antecedentesDTO.getOtro_estab_carce());
            antecedentesPrivLib.setAprehendAdolesc(antecedentesDTO.getAprehend_adolesc());
            antecedentesPrivLib.setAprehendMayor(antecedentesDTO.getAprehend_mayor());
            antecedentesPrivLib.setProcesoActual(antecedentesDTO.getProceso_actual());

            Delitos delitos = delitosRepository.findByUniqId(antecedentesDTO.getDelitos_uniqid());
            antecedentesPrivLib.setDelitos(delitos);

            EstablecimientosCarc establecimientosCarc = establecimientosCarcRepository.findByUniqId(antecedentesDTO.getEstab_carcs_uniqid());
            antecedentesPrivLib.setEstabCarcelarios(establecimientosCarc);

            SituacionJuridica situacionJuridica = situacionJuridicaRepository.findByUniqId(antecedentesDTO.getSit_jurid_uniqid());
            antecedentesPrivLib.setSituacionJuridicas(situacionJuridica);

            antecedentesPrivLib.setUsuarios(usuariosRepository.findByNumeroDocumento(numeroDocumento));
            
            return antecedentesPrivLibRepository.save(antecedentesPrivLib);

        
        }catch(Exception e){
        return null;
        }
    }
    
}
