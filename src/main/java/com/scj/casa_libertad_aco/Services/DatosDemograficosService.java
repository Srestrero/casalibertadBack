
package com.scj.casa_libertad_aco.Services;

import com.scj.casa_libertad_aco.Entities.DatosDemograficos;
import com.scj.casa_libertad_aco.Entities.Usuarios;
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
        datosDem.setNacionalidad(nacionalidadesRepository.findByUniqid(consultadatosDemDTO.getNacionalidad()));
        datosDem.setPais(paisesRepository.findByUniqid(consultadatosDemDTO.getPais_origen()));
        //Hacer if(Pais es otro){return datosDem.setOtroPais...}else{return datosDem.SetOtroPais=null};
        //Hay que analizar bien esto!!!!!!!!!!!!!o a lo mejor hay que hacerlo con el javascript!!!!
        datosDem.setOtroPais(consultadatosDemDTO.getOtro_pais_origen());
        datosDem.setEstadoCivil(estadoCivilRepository.findByUniqid(consultadatosDemDTO.getEstado_civil()));
        datosDem.setEtnia(etniasRepository.findByUniqid(consultadatosDemDTO.getEtnia()));
        datosDem.setOtraEtnia(consultadatosDemDTO.getEspecifique());
        datosDem.setSexo(sexosRepository.findByUniqid(consultadatosDemDTO.getSexo()));
        datosDem.setIdentidadGenero(identidadGeneroRepository.findByUniqid(consultadatosDemDTO.getIdentidad_genero()));
        datosDem.setOrientacionSexual(orientacionSexualRepository.findByUniqid(consultadatosDemDTO.getOrientacion_sexual()));
        datosDem.setDiscapacitado(consultadatosDemDTO.getDiscapacitado());
        datosDem.setAyudaMovilidad(consultadatosDemDTO.getAyuda_movilidad());
        datosDem.setAyudaLectoescritura(consultadatosDemDTO.getAyuda_lectoescritura());
        datosDem.setAyudaTraduccionSeñales(consultadatosDemDTO.getAyuda_traduccion());
        datosDem.setVictimaConflictoArm(consultadatosDemDTO.getVict_conf_arma());
        datosDem.setUsuarios(usuariosRepository.findByNumeroDocumento(numeroDocumento));
        return datosDemograficosRepository.save(datosDem);
    }
    
    /*
    R-consultar
    */
    public ConsultaDatosDemDTO consultaDatosDemograficos(String numeroDocumento) throws Exception {
        try {
            Usuarios usuario = usuariosRepository.findByNumeroDocumento(numeroDocumento);
            DatosDemograficos datosDemograficos = datosDemograficosRepository.findByUsuarios(usuario);
            //ojo aqui hicimos correción del metodo del repositorio!!! Chequear
            if (datosDemograficos == null) {
                return null;
            }
            ConsultaDatosDemDTO consultaDatosDemDTO = new ConsultaDatosDemDTO();
            
            consultaDatosDemDTO.setFecha_nacimiento(datosDemograficos.getFechaNacimiento());
            consultaDatosDemDTO.setNacionalidad(datosDemograficos.getNacionalidad().getUniqid());
            consultaDatosDemDTO.setPais_origen(datosDemograficos.getPais().getUniqid());
            consultaDatosDemDTO.setOtro_pais_origen(datosDemograficos.getOtroPais());
            consultaDatosDemDTO.setEstado_civil(datosDemograficos.getEstadoCivil().getUniqid());
            consultaDatosDemDTO.setEtnia(datosDemograficos.getEtnia().getUniqid());
            consultaDatosDemDTO.setEspecifique(datosDemograficos.getOtraEtnia());
            consultaDatosDemDTO.setSexo(datosDemograficos.getSexo().getUniqid());
            consultaDatosDemDTO.setIdentidad_genero(datosDemograficos.getIdentidadGenero().getUniqid());
            consultaDatosDemDTO.setOrientacion_sexual(datosDemograficos.getOrientacionSexual().getUniqid());
            consultaDatosDemDTO.setDiscapacitado(datosDemograficos.getDiscapacitado());
            consultaDatosDemDTO.setAyuda_movilidad(datosDemograficos.getAyudaMovilidad());
            consultaDatosDemDTO.setAyuda_lectoescritura(datosDemograficos.getAyudaLectoescritura());
            consultaDatosDemDTO.setAyuda_traduccion(datosDemograficos.getAyudaTraduccionSeñales());
            consultaDatosDemDTO.setVict_conf_arma(datosDemograficos.getVictimaConflictoArm());

            return consultaDatosDemDTO;

        } catch (Exception e) {
            return null;

        }
    }

    /*
    U-Actualizar
    */
    public DatosDemograficos actualizaDatosDemog(String numeroDocumento,ConsultaDatosDemDTO consultadatosDemDTO)
            throws Exception{
        try{
            Usuarios usuario = usuariosRepository.findByNumeroDocumento(numeroDocumento);
            DatosDemograficos datosDemograficos = datosDemograficosRepository.findByUsuarios(usuario);
            if(datosDemograficos==null){
                return null;
            }
            
        DatosDemograficos datosDem = new DatosDemograficos();
        datosDem.setFechaNacimiento(consultadatosDemDTO.getFecha_nacimiento());
        datosDem.setNacionalidad(nacionalidadesRepository.findByUniqid(consultadatosDemDTO.getNacionalidad()));
        datosDem.setPais(paisesRepository.findByUniqid(consultadatosDemDTO.getPais_origen()));
        datosDem.setOtroPais(consultadatosDemDTO.getOtro_pais_origen());
        datosDem.setEstadoCivil(estadoCivilRepository.findByUniqid(consultadatosDemDTO.getEstado_civil()));
        datosDem.setEtnia(etniasRepository.findByUniqid(consultadatosDemDTO.getEtnia()));
        datosDem.setOtraEtnia(consultadatosDemDTO.getEspecifique());
        datosDem.setSexo(sexosRepository.findByUniqid(consultadatosDemDTO.getSexo()));
        datosDem.setIdentidadGenero(identidadGeneroRepository.findByUniqid(consultadatosDemDTO.getIdentidad_genero()));
        datosDem.setOrientacionSexual(orientacionSexualRepository.findByUniqid(consultadatosDemDTO.getOrientacion_sexual()));
        datosDem.setDiscapacitado(consultadatosDemDTO.getDiscapacitado());
        datosDem.setAyudaMovilidad(consultadatosDemDTO.getAyuda_movilidad());
        datosDem.setAyudaLectoescritura(consultadatosDemDTO.getAyuda_lectoescritura());
        datosDem.setAyudaTraduccionSeñales(consultadatosDemDTO.getAyuda_traduccion());
        datosDem.setVictimaConflictoArm(consultadatosDemDTO.getVict_conf_arma());
        //datosDem.setUsuarios(usuariosRepository.findByNumeroDocumento(numeroDocumento));
        return datosDemograficosRepository.save(datosDem);
        
        }catch(Exception e){
        return null;
        }
    }
    
    
}
