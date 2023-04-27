
package com.scj.casa_libertad_aco.Controllers;

import com.scj.casa_libertad_aco.Entities.Paises;
import com.scj.casa_libertad_aco.Services.PaisesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, 
    RequestMethod.DELETE})
@RequestMapping("/paises")
public class PaisesController {
    
    @Autowired
    private PaisesService paisesService;
    
    
    @GetMapping("/all")
    public List<Paises> consultarPaises() throws Exception{
    
        List<Paises> listado = paisesService.traerPaises();
        
        return listado;
    }
   
}
