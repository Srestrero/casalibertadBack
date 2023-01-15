
package com.scj.casa_libertad_aco.Controllers;

import com.scj.casa_libertad_aco.Entities.ProgramasCasaLib;
import com.scj.casa_libertad_aco.Services.ProgramasCasaLibService;
import com.scj.casa_libertad_aco.salidaDTOs.ConsultaProgramasCasaLibDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/programas")
public class ProgramasCasaLibController {
    
    @Autowired
    private ProgramasCasaLibService programasCasaLibService;
    
    @GetMapping("/consulta")
    public ResponseEntity<ConsultaProgramasCasaLibDTO> consultarProgramas(@RequestParam 
            String numeroDocumento) throws Exception {
        ConsultaProgramasCasaLibDTO programas = programasCasaLibService.consultaProgramas(numeroDocumento);
        return new ResponseEntity<ConsultaProgramasCasaLibDTO>(programas, HttpStatus.OK);
    }
    
    @PostMapping("/save")
    public ResponseEntity crearProgramasCasaLib(@RequestParam String numeroDocumento,
            @RequestBody ConsultaProgramasCasaLibDTO consultaProgramasCasaLibDTO ){
        programasCasaLibService.crearProgramasCasaLib(numeroDocumento, consultaProgramasCasaLibDTO);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/actualizar")
    public ResponseEntity actualizarProgramasCasaLib(@RequestParam  String numeroDocumento,
            @RequestBody ConsultaProgramasCasaLibDTO consultaProgramasCasaLibDTO )throws Exception{
        programasCasaLibService.actualizaProgramasCasaLib(numeroDocumento, consultaProgramasCasaLibDTO);
        return ResponseEntity.status(201).build(); 
        
    }

    
    
    
}
