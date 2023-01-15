
package com.scj.casa_libertad_aco.Services;

import com.scj.casa_libertad_aco.Entities.DocumentoTipos;
import com.scj.casa_libertad_aco.Repositories.DocumentoTiposRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

@Service
public class DocumentoTiposService {
    
    @Autowired
    DocumentoTiposRepository documentoTipoRepository;
    
    /*
    R-consultar
    */
    public DocumentoTipos getDocumentoTipo(int tipo_documeto_uniqid)throws Exception{
        try{
        DocumentoTipos documento = documentoTipoRepository.findByUniqId(tipo_documeto_uniqid);
        return documento;
        }catch(Exception e){
        return null;
        }
        
    }
    
}
