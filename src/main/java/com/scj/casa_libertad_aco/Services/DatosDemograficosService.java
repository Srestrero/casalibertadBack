
package com.scj.casa_libertad_aco.Services;

import com.scj.casa_libertad_aco.Entities.DatosDemograficos;
import com.scj.casa_libertad_aco.Repositories.DatosDemograficosRepository;
import com.scj.casa_libertad_aco.Repositories.EstadoCivilRepository;
import com.scj.casa_libertad_aco.Repositories.EtniasRepository;
import com.scj.casa_libertad_aco.Repositories.IdentidadGeneroRepository;
import com.scj.casa_libertad_aco.Repositories.NacionalidadesRepository;
import com.scj.casa_libertad_aco.Repositories.OrientacionSexualRepository;
import com.scj.casa_libertad_aco.Repositories.PaisesRepository;
import com.scj.casa_libertad_aco.Repositories.SexosRepository;
import com.scj.casa_libertad_aco.Repositories.UsuariosRepository;
import com.scj.casa_libertad_aco.salidaDTOs.ConsultaDatosDemDTO;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

@Service
public class DatosDemograficosService {
    
    @Autowired
    private DatosDemograficosRepository datosDemograficosRepository;
     
    @Autowired
    private NacionalidadesRepository nacionalidadesRepository;
    
    @Autowired
    private PaisesRepository paisesRepository;
    
    @Autowired
    private EstadoCivilRepository estadoCivilRepository;
    
    @Autowired
    private EtniasRepository etniasRepository;
    
    @Autowired
    private SexosRepository sexosRepository;
    
    @Autowired
    private IdentidadGeneroRepository identidadGeneroRepository;
    
    @Autowired
    private OrientacionSexualRepository orientacionSexualRepository;
    
    @Autowired
    private UsuariosRepository usuariosRepository;
    
    
   
    /*
    C-Crear
    */        
    public DatosDemograficos crearDatosDemog(String numeroDocumento,ConsultaDatosDemDTO consultadatosDemDTO){
        
        DatosDemograficos datosDem = new DatosDemograficos();
        datosDem.setFechaNacimiento(consultadatosDemDTO.getFecha_nacimiento());
        datosDem.setNacionalidad(nacionalidadesRepository.findByUniqId(consultadatosDemDTO.getNacionalidad()));
        datosDem.setPais(paisesRepository.findByUniqId(consultadatosDemDTO.getPais_origen()));
        //Hacer if(Pais es otro){return datosDem.setOtroPais...}else{return datosDem.SetOtroPais=null};
        //Hay que analizar bien esto!!!!!!!!!!!!!o a lo mejor hay que hacerlo con el javascript!!!!
        datosDem.setOtroPais(consultadatosDemDTO.getOtro_pais_origen());
        datosDem.setEstadoCivil(estadoCivilRepository.findByUniqId(consultadatosDemDTO.getEstado_civil()));
        datosDem.setEtnia(etniasRepository.findByUniqId(consultadatosDemDTO.getEtnia()));
        datosDem.setOtraEtnia(consultadatosDemDTO.getEspecifique());
        datosDem.setSexo(sexosRepository.findByUniqId(consultadatosDemDTO.getSexo()));
        datosDem.setIdentidadGenero(identidadGeneroRepository.findByUniqId(consultadatosDemDTO.getIdentidad_genero()));
        datosDem.setOrientacionSexual(orientacionSexualRepository.findByUniqId(consultadatosDemDTO.getOrientacion_sexual()));
        datosDem.setDiscapacitado(consultadatosDemDTO.getDiscapacitado());
        datosDem.setAyudaMovilidad(consultadatosDemDTO.getAyuda_movilidad());
        datosDem.setAyudaLectoescritura(consultadatosDemDTO.getAyuda_lectoescritura());
        datosDem.setAyudaTraduccionSeñales(consultadatosDemDTO.getAyuda_lectoescritura());
        datosDem.setVictimaConflictoArm(consultadatosDemDTO.getVict_conf_arma());
        datosDem.setUsuarios(usuariosRepository.findByNumeroDocumento(numeroDocumento));
        return datosDemograficosRepository.save(datosDem);
    }
    
    /*
    R-consultar
    */
    public ConsultaDatosDemDTO consultaDatosDemograficos(String numeroDocumento)throws Exception{
        try{
        DatosDemograficos datosDemograficos = datosDemograficosRepository.FindByNumeroDocumento(numeroDocumento);
        ConsultaDatosDemDTO consultaDatosDemDTO = new ConsultaDatosDemDTO();
        consultaDatosDemDTO.setFecha_nacimiento(datosDemograficos.getFechaNacimiento());
        consultaDatosDemDTO.setNacionalidad(datosDemograficos.getNacionalidad().getUniqId());
        consultaDatosDemDTO.setPais_origen(datosDemograficos.getPais().getUniqId());
        consultaDatosDemDTO.setOtro_pais_origen(datosDemograficos.getOtroPais());
        consultaDatosDemDTO.setEstado_civil(datosDemograficos.getEstadoCivil().getUniqId());
        consultaDatosDemDTO.setEtnia(datosDemograficos.getEtnia().getUniqId());
        consultaDatosDemDTO.setEspecifique(datosDemograficos.getOtraEtnia());
        consultaDatosDemDTO.setSexo(datosDemograficos.getSexo().getUniqId());
        consultaDatosDemDTO.setIdentidad_genero(datosDemograficos.getIdentidadGenero().getUniqId());
        consultaDatosDemDTO.setOrientacion_sexual(datosDemograficos.getOrientacionSexual().getUniqId());
        consultaDatosDemDTO.setDiscapacitado(datosDemograficos.getDiscapacitado());
        consultaDatosDemDTO.setAyuda_movilidad(datosDemograficos.getAyudaMovilidad());
        consultaDatosDemDTO.setAyuda_lectoescritura(datosDemograficos.getAyudaLectoescritura());
        consultaDatosDemDTO.setAyuda_traduccion(datosDemograficos.getAyudaTraduccionSeñales());
        consultaDatosDemDTO.setVict_conf_arma(datosDemograficos.getVictimaConflictoArm());
        
        return consultaDatosDemDTO;
        
        }catch(Exception e){
            return null;
            
        }       
    }
    
    /*
    U-Actualizar
    */
    public DatosDemograficos actualizaDatosDemog(String numeroDocumento,ConsultaDatosDemDTO consultadatosDemDTO)throws Exception{
        try{
        DatosDemograficos datosDem = new DatosDemograficos();
        datosDem.setFechaNacimiento(consultadatosDemDTO.getFecha_nacimiento());
        datosDem.setNacionalidad(nacionalidadesRepository.findByUniqId(consultadatosDemDTO.getNacionalidad()));
        datosDem.setPais(paisesRepository.findByUniqId(consultadatosDemDTO.getPais_origen()));
        datosDem.setOtroPais(consultadatosDemDTO.getOtro_pais_origen());
        datosDem.setEstadoCivil(estadoCivilRepository.findByUniqId(consultadatosDemDTO.getEstado_civil()));
        datosDem.setEtnia(etniasRepository.findByUniqId(consultadatosDemDTO.getEtnia()));
        datosDem.setOtraEtnia(consultadatosDemDTO.getEspecifique());
        datosDem.setSexo(sexosRepository.findByUniqId(consultadatosDemDTO.getSexo()));
        datosDem.setIdentidadGenero(identidadGeneroRepository.findByUniqId(consultadatosDemDTO.getIdentidad_genero()));
        datosDem.setOrientacionSexual(orientacionSexualRepository.findByUniqId(consultadatosDemDTO.getOrientacion_sexual()));
        datosDem.setDiscapacitado(consultadatosDemDTO.getDiscapacitado());
        datosDem.setAyudaMovilidad(consultadatosDemDTO.getAyuda_movilidad());
        datosDem.setAyudaLectoescritura(consultadatosDemDTO.getAyuda_lectoescritura());
        datosDem.setAyudaTraduccionSeñales(consultadatosDemDTO.getAyuda_lectoescritura());
        datosDem.setVictimaConflictoArm(consultadatosDemDTO.getVict_conf_arma());
        datosDem.setUsuarios(usuariosRepository.findByNumeroDocumento(numeroDocumento));
        return datosDemograficosRepository.save(datosDem);
        
        }catch(Exception e){
        return null;
        }
    }
    
    
}
