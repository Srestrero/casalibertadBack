
package com.scj.casa_libertad_aco.Repositories;

import com.scj.casa_libertad_aco.Entities.Etnias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtniasRepository extends JpaRepository<Etnias,Integer>{
    
    public Etnias findByUniqId(int uniqId);
    
}
