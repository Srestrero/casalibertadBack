

package com.scj.casa_libertad_aco.Services;

import com.scj.casa_libertad_aco.Entities.Contactos;
import com.scj.casa_libertad_aco.Entities.DocumentoTipos;
import com.scj.casa_libertad_aco.Entities.Usuarios;
import com.scj.casa_libertad_aco.Repositories.ContactosRepository;
import com.scj.casa_libertad_aco.Repositories.UsuariosRepository;
import com.scj.casa_libertad_aco.entradaDTOs.RegistroDTO;
import com.scj.casa_libertad_aco.salidaDTOs.ConsultaUsuariosDTO;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

@Service
public class UsuariosService {
    
    @Autowired
    private UsuariosRepository usuariosrepository;
    
    @Autowired
    private ContactosRepository contactosRepository;
    
    @Autowired
    private DocumentoTiposService documentoTipoService;
    
    
    /*
    R-Consultar
    */
    public ConsultaUsuariosDTO consultaUsuario(String numeroDocumento){
        try{
        Usuarios usuario = usuariosrepository.findByNumeroDocumento(numeroDocumento);
        ConsultaUsuariosDTO consultaUsuarioDTO = new ConsultaUsuariosDTO();
        consultaUsuarioDTO.setCondiciones_programa(usuario.getCondicionesPrograma());
        consultaUsuarioDTO.setCanal_atencion(usuario.getCanalAtencionAcogida());
        consultaUsuarioDTO.setAceptacion_terminos(usuario.getAceptacionTermsCondic());
        consultaUsuarioDTO.setTipo_documento(usuario.getDocumentoTipo().getUniqId());
        consultaUsuarioDTO.setNum_documento(usuario.getNumeroDocumento());
        consultaUsuarioDTO.setNombres(usuario.getNombres());
        consultaUsuarioDTO.setPrimer_apellido(usuario.getPrimerApellido());
        consultaUsuarioDTO.setSegundo_apellido(usuario.getSegundoApellido());
        consultaUsuarioDTO.setFecha_expedicion(usuario.getFechaExpedicionDoc());
        consultaUsuarioDTO.setDireccion(usuario.getDireccion());
        consultaUsuarioDTO.setInfo_complementaria(usuario.getInfoComplementaria());
        consultaUsuarioDTO.setVerificacion_direccion(usuario.getVerificacionDireccion());
        consultaUsuarioDTO.setLocalidad(usuario.getLocalidad());
        consultaUsuarioDTO.setBarrio(usuario.getBarrio());
        consultaUsuarioDTO.setEstrato(usuario.getEstratoSocio());
        consultaUsuarioDTO.setTel_fijo(usuario.getTelFijo());
        consultaUsuarioDTO.setCel_1(usuario.getCelular1());
        consultaUsuarioDTO.setCel_2(usuario.getCelular2());
        consultaUsuarioDTO.setCorreo(usuario.getEmail());
        consultaUsuarioDTO.setNombre_contacto(usuario.getContactos().getNombreContacto());
        consultaUsuarioDTO.setPrimer_apellido_cont(usuario.getContactos().getPrimerApellidoCont());
        consultaUsuarioDTO.setSegundo_apellido_cont(usuario.getContactos().getSegundoApeliidoCont());
        consultaUsuarioDTO.setCel_contacto(usuario.getContactos().getCelContacto());
        consultaUsuarioDTO.setObservaciones(usuario.getObservaciones());
        
        return consultaUsuarioDTO;
        }catch(Exception e){
        return null;
        }
    }
    
    /*
    U-Actualizar
    */
    public Usuarios actualizarUsuario(RegistroDTO registro)throws Exception{
        
        try{
           Contactos contacto = new Contactos();
           DocumentoTipos documentoTipo = documentoTipoService.getDocumentoTipo(registro.getTipo_documento());
           Usuarios existeUsuario = usuariosrepository.findByNumeroDocumento(registro.getNum_documento()); 
           existeUsuario.setDocumentoTipo(documentoTipo);
           existeUsuario.setCondicionesPrograma(registro.getCondiciones_programa());
           existeUsuario.setCanalAtencionAcogida(registro.getCanal_atencion());
           existeUsuario.setAceptacionTermsCondic(registro.getAceptacion_terminos());
           existeUsuario.setNumeroDocumento(registro.getNum_documento());
           existeUsuario.setNombres(registro.getNombres());
           existeUsuario.setPrimerApellido(registro.getPrimer_apellido_cont());
           existeUsuario.setSegundoApellido(registro.getSegundo_apellido());
           existeUsuario.setFechaExpedicionDoc(registro.getFecha_expedicion());
           existeUsuario.setDireccion(registro.getDireccion());
           existeUsuario.setInfoComplementaria(registro.getInfo_complementaria());
           existeUsuario.setVerificacionDireccion(registro.getVerificacion_direccion());
           existeUsuario.setLocalidad(registro.getLocalidad());
           existeUsuario.setBarrio(registro.getBarrio());
           existeUsuario.setEstratoSocio(registro.getEstrato());
           existeUsuario.setTelFijo(registro.getTel_fijo());
           existeUsuario.setCelular1(registro.getCel_1());
           existeUsuario.setCelular2(registro.getCel_2());
           existeUsuario.setEmail(registro.getCorreo());
           existeUsuario.setObservaciones(registro.getObservaciones());
           
           contacto.setNombreContacto(registro.getNombre_contacto());
           contacto.setPrimerApellidoCont(registro.getPrimer_apellido_cont());
           contacto.setSegundoApeliidoCont(registro.getSegundo_apellido_cont());
           contacto.setCelContacto(registro.getCel_contacto());
           contacto.setUsuarios(existeUsuario);
           
           contactosRepository.save(contacto);
           
           existeUsuario.setContactos(contacto);
           
           return existeUsuario;
           
        }catch (Exception e){
            return null;
        }   
    }
    
    
}
