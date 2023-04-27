
package com.scj.casa_libertad_aco.Services;

import com.scj.casa_libertad_aco.Entities.Paises;
import com.scj.casa_libertad_aco.Repositories.PaisesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisesService {
    
    @Autowired
    private PaisesRepository paisesRepository;
    
    public List<Paises> traerPaises(){
        List<Paises> lista = paisesRepository.findAll();
        return lista;
    }
    
}
