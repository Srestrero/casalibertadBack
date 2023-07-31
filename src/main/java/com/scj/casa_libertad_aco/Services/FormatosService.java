
package com.scj.casa_libertad_aco.Services;

import com.scj.casa_libertad_aco.Entities.Formatos;
import com.scj.casa_libertad_aco.Entities.Usuarios;
import com.scj.casa_libertad_aco.Repositories.FormatosRepository;
import com.scj.casa_libertad_aco.Repositories.UsuariosRepository;
import com.scj.casa_libertad_aco.entradaDTOs.FormatosDTO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


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
            formatosDTO.setNom_consentimiento_firma(formato.getNombreConsentimientoFirma());
            formatosDTO.setNom_trat_datos_firma(formato.getNombreTratamientoDatosFirma());
            formatosDTO.setNom_autoriz_imagen_firma(formato.getNombreAutorizImagenFirma());
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
    public Formatos crearFormato(String numeroDocumento, String consentimientoFirma, String tratamientoDatosFirma,String autorizImagenFirma,
                                 String nomConsentimientoFirma, String nomTratamientoDatosFirma,
            String nomAutorizImagenFirma, String mediosAttNoPresenc, String estado, MultipartFile consentimiento,
            MultipartFile autorTratamDatos, MultipartFile autorUsoImagen) {
        
        Usuarios usuarios=usuariosRepository.findByNumeroDocumento(numeroDocumento);
        Formatos formato=formatosRepository.findByUsuarios(usuarios);
        if(formato==null){
        formato = new Formatos();
        
        formato.setConsentimientoFirma(consentimientoFirma);
        formato.setTratamientoDatosFirma(tratamientoDatosFirma);
        formato.setAutorizImagenFirma(autorizImagenFirma);
        formato.setNombreConsentimientoFirma(nomConsentimientoFirma);
        formato.setNombreTratamientoDatosFirma(nomTratamientoDatosFirma);
        formato.setNombreAutorizImagenFirma(nomAutorizImagenFirma);

        try {
            //formato.setConsentimiento(formatosDTO.getAdjunto_concentimiento());
            formato.setConsentimiento(consentimiento.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(FormatosService.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            //formato.setAutorTratamDatos(formatosDTO.getAdjunto_trat_datos());
            formato.setAutorTratamDatos(autorTratamDatos.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(FormatosService.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            //formato.setAutorUsoImagen(formatosDTO.getAdjunto_uso_imagen());
            formato.setAutorUsoImagen(autorUsoImagen.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(FormatosService.class.getName()).log(Level.SEVERE, null, ex);
        }
        formato.setMediosAttNoPresenc(mediosAttNoPresenc);
        formato.setEstado(estado);
        formato.setUsuarios(usuariosRepository.findByNumeroDocumento(numeroDocumento));

        return formatosRepository.save(formato);
        }else{
            try {
                actualizaFormato(numeroDocumento,
                        consentimientoFirma,tratamientoDatosFirma,
                        autorizImagenFirma,nomConsentimientoFirma,nomTratamientoDatosFirma,
                        nomAutorizImagenFirma,mediosAttNoPresenc,
                        estado,consentimiento,
                        autorTratamDatos, autorUsoImagen );
            } catch (Exception ex) {
                Logger.getLogger(FormatosService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return formatosRepository.findByUsuarios(usuarios);
    }
        
    /*
    U-actualizar
    */
    public Formatos actualizaFormato(String numeroDocumento, String consentimientoFirma, String tratamientoDatosFirma,String autorizImagenFirma,
                                     String nomConsentimientoFirma, String nomTratamientoDatosFirma,
                                     String nomAutorizImagenFirma, String mediosAttNoPresenc, String estado, MultipartFile consentimiento,
                                     MultipartFile autorTratamDatos, MultipartFile autorUsoImagen)
            throws Exception {
        try {
            //Formatos formato = new Formatos();
            Usuarios usuarios=usuariosRepository.findByNumeroDocumento(numeroDocumento);
            Formatos formato=formatosRepository.findByUsuarios(usuarios);
            formato.setConsentimientoFirma(consentimientoFirma);
            formato.setTratamientoDatosFirma(tratamientoDatosFirma);
            formato.setAutorizImagenFirma(autorizImagenFirma);
            formato.setNombreConsentimientoFirma(nomConsentimientoFirma);
            formato.setNombreTratamientoDatosFirma(nomTratamientoDatosFirma);
            formato.setNombreAutorizImagenFirma(nomAutorizImagenFirma);
            try {
                //formato.setConsentimiento(formatosDTO.getAdjunto_concentimiento());
                formato.setConsentimiento(consentimiento.getBytes());
            } catch (IOException ex) {
                Logger.getLogger(FormatosService.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                //formato.setAutorTratamDatos(formatosDTO.getAdjunto_trat_datos());
                formato.setAutorTratamDatos(autorTratamDatos.getBytes());
            } catch (IOException ex) {
                Logger.getLogger(FormatosService.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                //formato.setAutorUsoImagen(formatosDTO.getAdjunto_uso_imagen());
                formato.setAutorUsoImagen(autorUsoImagen.getBytes());
            } catch (IOException ex) {
                Logger.getLogger(FormatosService.class.getName()).log(Level.SEVERE, null, ex);
            }
            formato.setMediosAttNoPresenc(mediosAttNoPresenc);
            formato.setEstado(estado);
            formato.setUsuarios(usuariosRepository.findByNumeroDocumento(numeroDocumento));

            return formatosRepository.save(formato);
            /*Formatos formato = new Formatos();
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
        
        return formatosRepository.save(formato);*/
        } catch (Exception e) {
            return null;

        }
    }
    
    
}
    

