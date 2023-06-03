package com.scj.casa_libertad_aco.Controllers;

import com.scj.casa_libertad_aco.Services.DatosDemograficosService;
import com.scj.casa_libertad_aco.salidaDTOs.ConsultaDatosDemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/datos_demog")
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, 
    RequestMethod.DELETE})
public class DatosDemograficosController {
    
    @Autowired
    public DatosDemograficosService datosDemograficosService;
    
    @GetMapping("/consulta")
    public ResponseEntity<ConsultaDatosDemDTO> consultarDatosDemograficos(@RequestParam String numeroDocumento) throws Exception{
        ConsultaDatosDemDTO datosDemDTO = datosDemograficosService.consultaDatosDemograficos(numeroDocumento);
        return new ResponseEntity<ConsultaDatosDemDTO>(datosDemDTO,HttpStatus.OK);
    }
    
    @PutMapping("/actualizar")
    public ResponseEntity actualizarDatosDemograficos(@RequestParam String numeroDocumento,
            @RequestBody ConsultaDatosDemDTO consultaDatosDemDTO)throws Exception{
        datosDemograficosService.actualizaDatosDemog(numeroDocumento, consultaDatosDemDTO);
        return ResponseEntity.status(201).build();
    }
    
    @PostMapping("/save")
    public ResponseEntity crearDatosDemograficos(@RequestParam String numeroDocumento,@RequestBody ConsultaDatosDemDTO consultaDatosDemDTO) throws Exception{
        datosDemograficosService.crearDatosDemog(numeroDocumento, consultaDatosDemDTO);
        return ResponseEntity.status(201).build();
    }
  

    
}
