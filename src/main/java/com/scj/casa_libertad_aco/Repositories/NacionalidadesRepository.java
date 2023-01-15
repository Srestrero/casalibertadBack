
package com.scj.casa_libertad_aco.Repositories;

import com.scj.casa_libertad_aco.Entities.Nacionalidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NacionalidadesRepository extends JpaRepository<Nacionalidades,Integer> {
    
    public Nacionalidades findByUniqId(int uniqId);
    
}
