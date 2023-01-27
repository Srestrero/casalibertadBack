
package com.scj.casa_libertad_aco.Repositories;

import com.scj.casa_libertad_aco.Entities.Paises;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisesRepository extends JpaRepository<Paises,Integer> {
    
        public Paises findByUniqid(int uniqid);

    
}
