
package com.scj.casa_libertad_aco.Repositories;

import com.scj.casa_libertad_aco.Entities.SituacionJuridica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SituacionJuridicaRepository extends JpaRepository<SituacionJuridica,Integer> {
    
        public SituacionJuridica findByUniqId(int uniqId);

    
}
