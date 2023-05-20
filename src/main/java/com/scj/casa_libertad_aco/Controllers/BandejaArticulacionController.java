
package com.scj.casa_libertad_aco.Controllers;

import com.scj.casa_libertad_aco.Entities.BandejaArticulacion;
import com.scj.casa_libertad_aco.Services.BandejaArticulacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, 
    RequestMethod.DELETE})//,allowedHeaders="*")
@RequestMapping("/bandejaArtic")
public class BandejaArticulacionController {
    
    @Autowired
    private BandejaArticulacionService bandejaArticulacionService;
    
    @GetMapping("/consulta")
    public List<BandejaArticulacion> consultarBandejaArticulacion() throws Exception{
        
        List<BandejaArticulacion> listado = bandejaArticulacionService.consultaBandejaArticulacion();
        
        return listado;
        
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity eliminaUsuarioBandeja(@RequestBody BandejaArticulacion bandejaArticulacion){
        bandejaArticulacionService.eliminarUsuarioBandeja(bandejaArticulacion.getId());
        return ResponseEntity.status(204).build();
    }
    
    @PostMapping("/save")
    public ResponseEntity crearUsuarioBandeja(@RequestBody BandejaArticulacion bandejaArticulacion){
        bandejaArticulacionService.creaBandejaArticulacion(bandejaArticulacion);
        return ResponseEntity.status(200).build();
    }
    
}
