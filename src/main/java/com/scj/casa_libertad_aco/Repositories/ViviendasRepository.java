
package com.scj.casa_libertad_aco.Repositories;

import com.scj.casa_libertad_aco.Entities.Viviendas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViviendasRepository extends JpaRepository<Viviendas,Integer> {
    
    
    public Viviendas findByUniqid(int uniqid);
    

    
}
