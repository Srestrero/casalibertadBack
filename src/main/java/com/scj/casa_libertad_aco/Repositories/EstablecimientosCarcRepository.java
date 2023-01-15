 
package com.scj.casa_libertad_aco.Repositories;

import com.scj.casa_libertad_aco.Entities.EstablecimientosCarc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstablecimientosCarcRepository extends JpaRepository<EstablecimientosCarc,Integer> {
    
    public EstablecimientosCarc findByUniqId(int uniqId);
    
}
