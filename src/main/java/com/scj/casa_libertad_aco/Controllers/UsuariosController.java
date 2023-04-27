
package com.scj.casa_libertad_aco.Controllers;

import com.scj.casa_libertad_aco.Entities.Usuarios;
import com.scj.casa_libertad_aco.Services.UsuariosService;
import com.scj.casa_libertad_aco.entradaDTOs.RegistroDTO;
import com.scj.casa_libertad_aco.salidaDTOs.ConsultaUsuariosDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, 
    RequestMethod.DELETE})
@RequestMapping("/registro")
public class UsuariosController {
    
    @Autowired
    private UsuariosService usuariosService;
    
    @GetMapping("/saludo")
    public String saludar(){
        return "Hola";
    }
    
    @GetMapping("/consultaxId")
    public Usuarios getUsuario(@RequestParam String documentNumber){
        
        return usuariosService.consultaUsuarios(documentNumber);
           
    }
    
    @GetMapping("/consulta")
     //public ConsultaUsuariosDTO consultarUsuario(@RequestParam String numeroDocumento)
           // throws Exception{ 
    public ResponseEntity<ConsultaUsuariosDTO> consultarUsuario(@RequestParam String numeroDocumento)
            throws Exception{   
    ConsultaUsuariosDTO usuarioDTO = usuariosService.consultaUsuario(numeroDocumento);
    return new ResponseEntity<ConsultaUsuariosDTO>(usuarioDTO,HttpStatus.OK);
    //return usuarioDTO;
    }
    
    @PostMapping("/save")
    public ResponseEntity salvarUsuario(@RequestBody RegistroDTO registro) throws Exception{
        usuariosService.creaUsuario(registro);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/actualizar") 
    public ResponseEntity crearUsuario(@RequestBody RegistroDTO registro) throws Exception{
        
        usuariosService.actualizarUsuario(registro);
        return ResponseEntity.status(201).build();
        
    }
    

    
    
}
