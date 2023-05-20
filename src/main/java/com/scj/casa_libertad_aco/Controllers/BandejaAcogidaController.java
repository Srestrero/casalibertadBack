
package com.scj.casa_libertad_aco.Controllers;

import com.scj.casa_libertad_aco.Entities.BandejaAcogida;
import com.scj.casa_libertad_aco.Services.BandejaAcogidaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, 
    RequestMethod.DELETE})//,allowedHeaders="*")
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
        //bandejaAcogidaService.eliminarUsuarioBandeja(bandejaAcogida.getId());
        bandejaAcogidaService.eliminarUsuarioBandeja(bandejaAcogida.getNumeroDocumento());
        return ResponseEntity.status(204).build();
    }
    @PostMapping("/save")
    public ResponseEntity crearUsuarioBandeja(@RequestBody BandejaAcogida bandejaAcogida){
        bandejaAcogidaService.creaBandejaAcogida(bandejaAcogida);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/actualizar")
    public ResponseEntity actualizaUsuarioBandeja(@RequestBody BandejaAcogida bandejaAcogida)
            throws Exception{
        bandejaAcogidaService.actualizaBandeja(bandejaAcogida);
        return ResponseEntity.status(201).build();

    }
    
}
