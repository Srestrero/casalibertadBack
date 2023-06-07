
package com.scj.casa_libertad_aco.Controllers;

import com.scj.casa_libertad_aco.Services.FormatosService;
import com.scj.casa_libertad_aco.entradaDTOs.FormatosDTO;
//import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, 
    RequestMethod.DELETE})//,allowedHeaders="*")
@RequestMapping("/formatos")
public class FormatosController {
    
    @Autowired
    private FormatosService formatosService;
    
    @GetMapping("/consulta")
    public ResponseEntity<FormatosDTO> consultarFormatos(@RequestParam String numeroDocumento)
            throws Exception{   
    FormatosDTO formatosDTO = formatosService.consultaFormato(numeroDocumento);
    return new ResponseEntity<FormatosDTO>(formatosDTO,HttpStatus.OK);
    }
    
    @PostMapping("/save")
    public ResponseEntity crearFormatos(@RequestParam String numeroDocumento,
            @RequestParam String consentimientoFirma, @RequestParam String tratamientoDatosFirma, 
            @RequestParam String autorizImagenFirma, @RequestParam String mediosAttNoPresenc, 
            @RequestParam String estado,@RequestParam MultipartFile consentimiento, 
            @RequestParam MultipartFile autorTratamDatos, @RequestParam MultipartFile autorUsoImagen ){
        formatosService.crearFormato(numeroDocumento,consentimientoFirma,tratamientoDatosFirma,
                autorizImagenFirma,mediosAttNoPresenc,estado,consentimiento,autorTratamDatos,autorUsoImagen);
        return ResponseEntity.status(201).build();   
    }
    
    @PutMapping("/actualizar")
    public ResponseEntity actualizaFormatos(@RequestParam String numeroDocumento,
            @RequestParam String consentimientoFirma, @RequestParam String tratamientoDatosFirma, 
            @RequestParam String autorizImagenFirma, @RequestParam String mediosAttNoPresenc, 
            @RequestParam String estado,@RequestParam MultipartFile consentimiento, 
            @RequestParam MultipartFile autorTratamDatos, @RequestParam MultipartFile autorUsoImagen )throws Exception {
        formatosService.actualizaFormato(numeroDocumento,
            consentimientoFirma,tratamientoDatosFirma, 
            autorizImagenFirma,mediosAttNoPresenc, 
            estado,consentimiento, 
            autorTratamDatos, autorUsoImagen );
        return ResponseEntity.status(201).build();

    }
        
    
}
