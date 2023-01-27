
package com.scj.casa_libertad_aco.Services;

import com.scj.casa_libertad_aco.Entities.Formatos;
import com.scj.casa_libertad_aco.Entities.Usuarios;
import com.scj.casa_libertad_aco.Repositories.FormatosRepository;
import com.scj.casa_libertad_aco.Repositories.UsuariosRepository;
import com.scj.casa_libertad_aco.entradaDTOs.FormatosDTO;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;


@Service
public class FormatosService {
    
    @Autowired
    private FormatosRepository formatosRepository;
    
    @Autowired
    private UsuariosRepository usuariosRepository;
    
    
    
    /*
    R-Consultar
    */
    public FormatosDTO consultaFormato(String numeroDocumento) throws Exception {
        try {
            Usuarios usuario = usuariosRepository.findByNumeroDocumento(numeroDocumento);
            Formatos formato = formatosRepository.findByUsuarios(usuario);
            if(formato==null){
                return null;
            }
            FormatosDTO formatosDTO = new FormatosDTO();
            formatosDTO.setConsentimiento_firma(formato.getConsentimientoFirma());
            formatosDTO.setTrat_datos_firma(formato.getTratamientoDatosFirma());
            formatosDTO.setAutoriz_imagen_firma(formato.getAutorizImagenFirma());
            formatosDTO.setAdjunto_concentimiento(formato.getConsentimiento());
            formatosDTO.setAdjunto_trat_datos(formato.getAutorTratamDatos());
            formatosDTO.setAdjunto_uso_imagen(formato.getAutorUsoImagen());
            formatosDTO.setMedio_att_no_presencial(formato.getMediosAttNoPresenc());
            formatosDTO.setEstado(formato.getEstado());

            return formatosDTO;
        } catch (Exception e) {
            return null;
        }
            
        
        }
    
    /*
    C-Crear
    */
    public Formatos crearFormato(String numeroDocumento,FormatosDTO formatosDTO){
        Formatos formato = new Formatos();
        formato.setConsentimientoFirma(formatosDTO.getConsentimiento_firma());
        formato.setTratamientoDatosFirma(formatosDTO.getTrat_datos_firma());
        formato.setAutorizImagenFirma(formatosDTO.getAutoriz_imagen_firma());
        formato.setConsentimiento(formatosDTO.getAdjunto_concentimiento());
        formato.setAutorTratamDatos(formatosDTO.getAdjunto_trat_datos());
        formato.setAutorUsoImagen(formatosDTO.getAdjunto_uso_imagen());
        formato.setMediosAttNoPresenc(formatosDTO.getMedio_att_no_presencial());
        formato.setEstado(formatosDTO.getEstado());
        formato.setUsuarios(usuariosRepository.findByNumeroDocumento(numeroDocumento));
        
        return formatosRepository.save(formato);    
    }
            
    /*
    U-actualizar
    */
    public Formatos actualizaFormato(String numeroDocumento,FormatosDTO formatosDTO)
            throws Exception{
        try{
        Formatos formato = new Formatos();
        if(formato==null){
            return null;
        }
        formato.setConsentimientoFirma(formatosDTO.getConsentimiento_firma());
        formato.setTratamientoDatosFirma(formatosDTO.getTrat_datos_firma());
        formato.setAutorizImagenFirma(formatosDTO.getAutoriz_imagen_firma());
        formato.setConsentimiento(formatosDTO.getAdjunto_concentimiento());
        formato.setAutorTratamDatos(formatosDTO.getAdjunto_trat_datos());
        formato.setAutorUsoImagen(formatosDTO.getAdjunto_uso_imagen());
        formato.setMediosAttNoPresenc(formatosDTO.getMedio_att_no_presencial());
        formato.setEstado(formatosDTO.getEstado());
        formato.setUsuarios(usuariosRepository.findByNumeroDocumento(numeroDocumento));
        
        return formatosRepository.save(formato);
        }catch(Exception e){
            return null;
        
        }
    }
        
    
}
    

