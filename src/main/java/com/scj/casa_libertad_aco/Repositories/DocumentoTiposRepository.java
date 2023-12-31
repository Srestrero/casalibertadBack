
package com.scj.casa_libertad_aco.Repositories;

import com.scj.casa_libertad_aco.Entities.DocumentoTipos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoTiposRepository extends JpaRepository<DocumentoTipos,Integer> {
    
    public DocumentoTipos findByUniqid(int uniqid);
    
}
