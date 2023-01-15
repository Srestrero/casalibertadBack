
package com.scj.casa_libertad_aco.Controllers;

import com.scj.casa_libertad_aco.Entities.Viviendas;
import com.scj.casa_libertad_aco.Services.ViviendasService;
import com.scj.casa_libertad_aco.salidaDTOs.ConsultaViviendaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vivienda")
public class ViviendasController {
    
    @Autowired
    private ViviendasService viviendasService;
    
    @GetMapping("/consulta")
    public ResponseEntity<ConsultaViviendaDTO> consultarViviendas(@RequestParam String numeroDocumento)
            throws Exception{
        ConsultaViviendaDTO consulta = viviendasService.consultarVivienda(numeroDocumento);
        return new ResponseEntity<ConsultaViviendaDTO>(consulta,HttpStatus.OK);
    }
    
    @PostMapping("/save")
    public ResponseEntity crearViviendaUsuario(@RequestParam String numeroDocumento,@RequestParam int tipo){
        viviendasService.crearViviendaUsuario(numeroDocumento,tipo);
        return ResponseEntity.status(201).build();   
    }
    
    @PutMapping("/actualizar")
    public ResponseEntity actualizarViviendaUsuario(@RequestParam String numeroDocumento,@RequestParam int tipo)
            throws Exception{
        viviendasService.actualizaViviendaUsuario(numeroDocumento,tipo);
        return ResponseEntity.status(201).build();   
    }
    
    
    
    
}
    
    
    
    
    
    

