
package com.scj.casa_libertad_aco.Controllers;

import com.scj.casa_libertad_aco.Services.DatosDemograficosService;
import com.scj.casa_libertad_aco.salidaDTOs.ConsultaDatosDemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, 
    RequestMethod.DELETE})
@RequestMapping("/datos_demog")
public class DatosDemograficosController {
    
    @Autowired
    private DatosDemograficosService datosDemograficosService;
    
    
    @GetMapping("/consulta")
    public ResponseEntity<ConsultaDatosDemDTO> consultarDatosDemograficos(
            @RequestParam String numeroDocumento)throws Exception{
        ConsultaDatosDemDTO datosDemDTO = datosDemograficosService.consultaDatosDemograficos(numeroDocumento);
        return new ResponseEntity<ConsultaDatosDemDTO>(datosDemDTO,HttpStatus.OK);
    }
                        
    @PostMapping("/save") 
    public ResponseEntity crearDatosDemograficos(@RequestParam String numeroDocumento,
            @RequestBody ConsultaDatosDemDTO consultaDatosDemDTO){
        datosDemograficosService.crearDatosDemog(numeroDocumento,consultaDatosDemDTO);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/actualizar") 
    public ResponseEntity actualizarDatosDemograficos(@RequestParam String numeroDocumento,
            @RequestBody ConsultaDatosDemDTO consultaDatosDemDTO)throws Exception{
        datosDemograficosService.actualizaDatosDemog(numeroDocumento,consultaDatosDemDTO);
        return ResponseEntity.status(201).build();
    }  
}
