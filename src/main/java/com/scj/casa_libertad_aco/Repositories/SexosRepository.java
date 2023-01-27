
package com.scj.casa_libertad_aco.Repositories;

import com.scj.casa_libertad_aco.Entities.Sexos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SexosRepository extends JpaRepository<Sexos,Integer> {
    
    public Sexos findByUniqid(int uniqid);
    
}
