
package com.scj.casa_libertad_aco.Controllers;

import com.scj.casa_libertad_aco.Entities.BandejaAcogida;
import com.scj.casa_libertad_aco.Services.BandejaAcogidaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, 
    RequestMethod.DELETE})
@RequestMapping("/bandaco")
public class BandejaAcogidaController {
    
    @Autowired
    private BandejaAcogidaService bandejaAcogidaService;
    
    
    @GetMapping("/consulta")
    public List<BandejaAcogida> consultarBandejaAcogida() throws Exception{
    
        List<BandejaAcogida> listado = bandejaAcogidaService.consultBandejaAcogida();
        
        return listado;
    } 
    
    @DeleteMapping("/delete")
    public ResponseEntity eliminaUsuarioBandeja(@RequestBody BandejaAcogida bandejaAcogida){
        bandejaAcogidaService.eliminarUsuarioBandeja(bandejaAcogida.getId());
        return ResponseEntity.status(204).build();
    }
    
}
