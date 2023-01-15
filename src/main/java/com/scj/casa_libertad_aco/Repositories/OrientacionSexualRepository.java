
package com.scj.casa_libertad_aco.Repositories;

import com.scj.casa_libertad_aco.Entities.OrientacionSexual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrientacionSexualRepository extends JpaRepository<OrientacionSexual,Integer> {
    
    public OrientacionSexual findByUniqId(int uniqId);
    
}
