

package com.scj.casa_libertad_aco.Services;

import com.scj.casa_libertad_aco.Entities.Contactos;
import com.scj.casa_libertad_aco.Entities.DocumentoTipos;
import com.scj.casa_libertad_aco.Entities.Usuarios;
import com.scj.casa_libertad_aco.Repositories.ContactosRepository;
import com.scj.casa_libertad_aco.Repositories.UsuariosRepository;
import com.scj.casa_libertad_aco.entradaDTOs.RegistroDTO;
import com.scj.casa_libertad_aco.salidaDTOs.ConsultaUsuariosDTO;
import java.time.LocalDate;
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
    C-Crear
    */
    public Usuarios creaUsuario(RegistroDTO registro) throws Exception {
        Usuarios usuarios = usuariosrepository.findByNumeroDocumento(registro.getNum_documento());
        try {
            Contactos contacto = new Contactos();
            DocumentoTipos documentoTipo = documentoTipoService.getDocumentoTipo(registro.getTipo_documento());
            //Usuarios existeUsuario = usuariosrepository.findByNumeroDocumento(registro.getNum_documento()); 
            //if(existeUsuario!=null){
            if (usuarios != null) {
                if (usuarios.getBarrio() == null) {
                    usuarios.setDocumentoTipo(documentoTipo);
                    usuarios.setCondicionesPrograma(registro.getCondiciones_programa());
                    usuarios.setCanalAtencionAcogida(registro.getCanal_atencion());
                    usuarios.setAceptacionTermsCondic(registro.getAceptacion_terminos());
                    usuarios.setNumeroDocumento(registro.getNum_documento());
                    usuarios.setNombres(registro.getNombres());
                    usuarios.setPrimerApellido(registro.getPrimer_apellido());
                    usuarios.setSegundoApellido(registro.getSegundo_apellido());
                    usuarios.setFechaExpedicionDoc(registro.getFecha_expedicion());
                    usuarios.setDireccion(registro.getDireccion());
                    usuarios.setInfoComplementaria(registro.getInfo_complementaria());
                    usuarios.setVerificacionDireccion(registro.getVerificacion_direccion());
                    usuarios.setLocalidad(registro.getLocalidad());
                    usuarios.setBarrio(registro.getBarrio());
                    usuarios.setEstratoSocio(registro.getEstrato());
                    usuarios.setTelFijo(registro.getTel_fijo());
                    usuarios.setCelular1(registro.getCel_1());
                    usuarios.setCelular2(registro.getCel_2());
                    usuarios.setEmail(registro.getCorreo());
                    usuarios.setObservaciones(registro.getObservaciones());
                    usuarios.setFechaAcogida(LocalDate.now());

                    contacto.setNombreContacto(registro.getNombre_contacto());
                    contacto.setPrimerApellidoCont(registro.getPrimer_apellido_cont());
                    contacto.setSegundoApeliidoCont(registro.getSegundo_apellido_cont());
                    contacto.setCelContacto(registro.getCel_contacto());
                    contacto.setParentesco(registro.getParentesco());
                    contacto.setUsuarios(usuarios);

                    contactosRepository.save(contacto);

                    Contactos con = contactosRepository.findByUsuarios(usuarios);//agregue

                    usuarios.setContactos(con);//cambie contacto por con
                    usuariosrepository.save(usuarios);

                    return usuarios;
                } else {
                    actualizarUsuario(registro);
                }
            }
        } catch (Exception e) {
            return null;
        }

        return usuariosrepository.findByNumeroDocumento(registro.getNum_documento());

    }

    
    
    /*
    R-Consultar
    */
    public ConsultaUsuariosDTO consultaUsuario(String numeroDocumento) throws Exception {
        
        try {
            Usuarios usuario = usuariosrepository.findByNumeroDocumento(numeroDocumento);
            ConsultaUsuariosDTO consultaUsuarioDTO = new ConsultaUsuariosDTO();
            if (usuario == null) {
                // se necesitari tipo de documento a ser pasado junto con el numero documento,
                //pero se supone que en recepcion se creo el usuario!!!
                return null;
            } else {
                consultaUsuarioDTO.setTipo_documento(usuario.getDocumentoTipo().getUniqid());
                consultaUsuarioDTO.setNum_documento(numeroDocumento);

                consultaUsuarioDTO.setCondiciones_programa(usuario.getCondicionesPrograma());
                consultaUsuarioDTO.setCanal_atencion_acogida(usuario.getCanalAtencionAcogida());
                //consultaUsuarioDTO.setCanal_atencion(usuario.getCanalAtencionAcogida());//aqui estaba el error
                consultaUsuarioDTO.setAceptacion_terminos(usuario.getAceptacionTermsCondic());//aqui tambien
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
                consultaUsuarioDTO.setObservaciones(usuario.getObservaciones());
                if (usuario.getContactos() == null) {//cambié la estructra habilitando el if por si nulo
                    /*Contactos cont=contactosRepository.findByUsuarios(usuario);//adicione debido al prblema que no crea el contactos_uniqid
                    if(cont!=null){
                    consultaUsuarioDTO.setNombre_contacto(cont.getNombreContacto());//adicione debido al prblema que no crea el contactos_uniqid
                    consultaUsuarioDTO.setPrimer_apellido_cont(cont.getPrimerApellidoCont());//adicione debido al prblema que no crea el contactos_uniqid
                    consultaUsuarioDTO.setSegundo_apellido_cont(cont.getSegundoApeliidoCont());//adicione debido al prblema que no crea el contactos_uniqid
                    consultaUsuarioDTO.setCel_contacto(cont.getCelContacto());//adicione debido al prblema que no crea el contactos_uniqid
                    consultaUsuarioDTO.setParentesco(cont.getParentesco());//adicione debido al prblema que no crea el contactos_uniqid*/
                    return consultaUsuarioDTO;
                    //}else{
                    //return consultaUsuarioDTO;
                    }
                //}

                consultaUsuarioDTO.setNombre_contacto(usuario.getContactos().getNombreContacto());
                consultaUsuarioDTO.setPrimer_apellido_cont(usuario.getContactos().getPrimerApellidoCont());
                consultaUsuarioDTO.setSegundo_apellido_cont(usuario.getContactos().getSegundoApeliidoCont());   
                consultaUsuarioDTO.setCel_contacto(usuario.getContactos().getCelContacto());
                consultaUsuarioDTO.setParentesco(usuario.getContactos().getParentesco());
                
                return consultaUsuarioDTO;
            }

            //return consultaUsuarioDTO;

        } catch (Exception e) {
            return null;
        }
    }


    /*
    U-Actualizar
    */
    public Usuarios actualizarUsuario(RegistroDTO registro)throws Exception{
        
        try{
           //Contactos contacto = contactosRepository.findByUsuarios(registro.getNum_documento());
           DocumentoTipos documentoTipo = documentoTipoService.getDocumentoTipo(registro.getTipo_documento());
           Usuarios existeUsuario = usuariosrepository.findByNumeroDocumento(registro.getNum_documento());
           Contactos contacto=contactosRepository.findByUsuarios(existeUsuario);
           if(existeUsuario!=null){
           existeUsuario.setDocumentoTipo(documentoTipo);
           existeUsuario.setCondicionesPrograma(registro.getCondiciones_programa());
           existeUsuario.setCanalAtencionAcogida(registro.getCanal_atencion());
           existeUsuario.setAceptacionTermsCondic(registro.getAceptacion_terminos());
           existeUsuario.setNumeroDocumento(registro.getNum_documento());
           existeUsuario.setNombres(registro.getNombres());
           existeUsuario.setPrimerApellido(registro.getPrimer_apellido());
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
           contacto.setParentesco(registro.getParentesco());
           contacto.setUsuarios(existeUsuario);
           
           
           contactosRepository.save(contacto);
           
           Contactos con = contactosRepository.findByUsuarios(existeUsuario);//agregue
           
           existeUsuario.setContactos(con);//cambie contacto por con
           
           usuariosrepository.save(existeUsuario);
           
           return usuariosrepository.findByNumeroDocumento(registro.getNum_documento());
           }else{
               return null;
           }
           
        }catch (Exception e){
            return null;
                }   
    }
    
    /*
    R-consultar por Id
    */
    public Usuarios consultaUsuarios(String documentNumber){
        return usuariosrepository.findByNumeroDocumento(documentNumber);
    
    }
    
    
}
