
package com.scj.casa_libertad_aco.Controllers;

import com.scj.casa_libertad_aco.Entities.Formatos;
import com.scj.casa_libertad_aco.Services.FormatosService;
import com.scj.casa_libertad_aco.entradaDTOs.FormatosDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, 
    RequestMethod.DELETE})
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
            @RequestBody FormatosDTO formatosDTO){
        formatosService.crearFormato(numeroDocumento,formatosDTO);
        return ResponseEntity.status(201).build();   
    }
    
    @PutMapping("/actualizar")
    public ResponseEntity actualizaFormatos(@RequestParam String numeroDocumento,
            @RequestBody FormatosDTO formatosDTO)throws Exception {
        formatosService.actualizaFormato(numeroDocumento, formatosDTO);
        return ResponseEntity.status(201).build();

    }
        
    
}
