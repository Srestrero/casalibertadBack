
package com.scj.casa_libertad_aco.Repositories;

import com.scj.casa_libertad_aco.Entities.IdentidadGenero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentidadGeneroRepository extends JpaRepository<IdentidadGenero,Integer> {
    
    public IdentidadGenero findByUniqid(int uniqid);
    
}
