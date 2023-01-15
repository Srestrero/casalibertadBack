
package com.scj.casa_libertad_aco.Controllers;

import java.lang.annotation.*;
import com.scj.casa_libertad_aco.Entities.AntecedentesPrivLib;
import com.scj.casa_libertad_aco.Services.AntecedentesPrivLibService;
import com.scj.casa_libertad_aco.entradaDTOs.AntecedentesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/antecedentes")
public class AntecedentesPrivLibController {
    
    @Autowired
    AntecedentesPrivLibService antecedentesPrivLibService;
    
   /* @GetMapping("/{id}")
    public List<AntecedentesPrivLib> mostrarTodosLosAntecedents(){
        return antecedentesPrivLibService. 
    }*/
    
    @PostMapping("/save")
    public ResponseEntity crearAntecedentesPrivLib(@RequestParam String numeroDocumento,
            @RequestBody AntecedentesDTO antecedentesDTO ){
        antecedentesPrivLibService.crearAntecedentes(numeroDocumento,antecedentesDTO);
        return ResponseEntity.status(201).build();
    }
    
    @GetMapping("/consultar")
    public ResponseEntity<AntecedentesDTO> consultaAntecedentes(@RequestParam String numDocumento)
            throws Exception{
        AntecedentesDTO antecedentes = antecedentesPrivLibService.consultarAntecedentes(numDocumento);
        return new ResponseEntity<AntecedentesDTO>(antecedentes,HttpStatus.OK);
    }
    
   @PutMapping("/acualizar")
    public ResponseEntity actualizarAntecedentesPrivLib(@RequestParam String numeroDocumento,
            @RequestBody AntecedentesDTO antecedentesDTO )throws Exception{
        antecedentesPrivLibService.actualizaAntecedentes(numeroDocumento,antecedentesDTO);
        return ResponseEntity.status(201).build();
    } 
    
    
    
  
    
    
    
    
    
    
    
    
    
    
    
}
