
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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public DatosDemograficos crearDatosDemog(String numeroDocumento, ConsultaDatosDemDTO consultadatosDemDTO){
            Usuarios usuarios= usuariosRepository.findByNumeroDocumento(numeroDocumento);
            DatosDemograficos datos = datosDemograficosRepository.findByUsuarios(usuarios);
            if(datos==null){
            DatosDemograficos datosDemo = new DatosDemograficos();
            
            datosDemo.setFechaNacimiento(consultadatosDemDTO.getFecha_nacimiento());
            datosDemo.setNacionalidad(nacionalidadesRepository.findByUniqid(consultadatosDemDTO.getNacionalidad()));
            datosDemo.setPais(paisesRepository.findByUniqid(consultadatosDemDTO.getPais_origen()));
            datosDemo.setEstadoCivil(estadoCivilRepository.findByUniqid(consultadatosDemDTO.getEstado_civil()));
            datosDemo.setEtnia(etniasRepository.findByUniqid(consultadatosDemDTO.getEtnia()));
            datosDemo.setOtraEtnia(consultadatosDemDTO.getEspecifique());
            datosDemo.setSexo(sexosRepository.findByUniqid(consultadatosDemDTO.getSexo()));
            //datosDem.setIdentidadGenero(identidadGeneroRepository.findByUniqid(consultadatosDemDTO.getIdentidad_genero()));
            datosDemo.setIdentidadGenero(identidadGeneroRepository.findByUniqid(consultadatosDemDTO.getIdentidad_genero()));
            datosDemo.setOrientacionSexual(orientacionSexualRepository.findByUniqid(consultadatosDemDTO.getOrientacion_sexual()));
            datosDemo.setDiscapacitado(consultadatosDemDTO.getDiscapacitado());
            datosDemo.setAyudaMovilidad(consultadatosDemDTO.getAyuda_movilidad());
            datosDemo.setAyudaLectoescritura(consultadatosDemDTO.getAyuda_lectoescritura());
            datosDemo.setAyudaTraduccionSeñales(consultadatosDemDTO.getAyuda_traduccion());
            datosDemo.setVictimaConflictoArm(consultadatosDemDTO.getVict_conf_arma());
            datosDemo.setUsuarios(usuariosRepository.findByNumeroDocumento(numeroDocumento));
            
            datosDemograficosRepository.save(datosDemo);
            
            return datosDemograficosRepository.findByUsuarios(usuarios);
            }else{
                try { 
                    actualizaDatosDemog(numeroDocumento,consultadatosDemDTO);
                } catch (Exception ex) {
                    Logger.getLogger(DatosDemograficosService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return datosDemograficosRepository.findByUsuarios(usuarios);
    
    }
    /*
    R-consultar
    */
    public ConsultaDatosDemDTO consultaDatosDemograficos(String numeroDocumento) throws Exception {
            
        try {
            Usuarios usuario = usuariosRepository.findByNumeroDocumento(numeroDocumento);
            DatosDemograficos datosDemograficos = datosDemograficosRepository.findByUsuarios(usuario);
            
            if (datosDemograficos == null) {
                return null;
            }
            ConsultaDatosDemDTO consultaDatosDemDTO = new ConsultaDatosDemDTO();
            
            consultaDatosDemDTO.setFecha_nacimiento(datosDemograficos.getFechaNacimiento());
            consultaDatosDemDTO.setNacionalidad(datosDemograficos.getNacionalidad().getUniqid());
            consultaDatosDemDTO.setPais_origen(datosDemograficos.getPais().getUniqid());
            //consultaDatosDemDTO.setOtro_pais_origen(datosDemograficos.getOtroPais());
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
    public DatosDemograficos actualizaDatosDemog(String numeroDocumento, ConsultaDatosDemDTO consultadatosDemDTO)
            throws Exception {
        try {
            Usuarios usuario = usuariosRepository.findByNumeroDocumento(numeroDocumento);
            DatosDemograficos datosDemograficos = datosDemograficosRepository.findByUsuarios(usuario);
            if (datosDemograficos == null) {
                return null;
            }

            //DatosDemograficos datosDem = new DatosDemograficos();
            datosDemograficos.setFechaNacimiento(consultadatosDemDTO.getFecha_nacimiento());
            datosDemograficos.setNacionalidad(nacionalidadesRepository.findByUniqid(consultadatosDemDTO.getNacionalidad()));
            datosDemograficos.setPais(paisesRepository.findByUniqid(consultadatosDemDTO.getPais_origen()));
            //datosDem.setOtroPais(consultadatosDemDTO.getOtro_pais_origen());
            datosDemograficos.setEstadoCivil(estadoCivilRepository.findByUniqid(consultadatosDemDTO.getEstado_civil()));
            datosDemograficos.setEtnia(etniasRepository.findByUniqid(consultadatosDemDTO.getEtnia()));
            datosDemograficos.setOtraEtnia(consultadatosDemDTO.getEspecifique());
            datosDemograficos.setSexo(sexosRepository.findByUniqid(consultadatosDemDTO.getSexo()));
            datosDemograficos.setIdentidadGenero(identidadGeneroRepository.findByUniqid(consultadatosDemDTO.getIdentidad_genero()));
            datosDemograficos.setOrientacionSexual(orientacionSexualRepository.findByUniqid(consultadatosDemDTO.getOrientacion_sexual()));
            datosDemograficos.setDiscapacitado(consultadatosDemDTO.getDiscapacitado());
            datosDemograficos.setAyudaMovilidad(consultadatosDemDTO.getAyuda_movilidad());
            datosDemograficos.setAyudaLectoescritura(consultadatosDemDTO.getAyuda_lectoescritura());
            datosDemograficos.setAyudaTraduccionSeñales(consultadatosDemDTO.getAyuda_traduccion());
            datosDemograficos.setVictimaConflictoArm(consultadatosDemDTO.getVict_conf_arma());
            datosDemograficos.setUsuarios(usuariosRepository.findByNumeroDocumento(numeroDocumento));
            
            datosDemograficosRepository.save(datosDemograficos);
            
            return datosDemograficosRepository.findByUsuarios(usuario);

        } catch (Exception e) {
            return null;
        }
    }
    
    
}
