
package com.scj.casa_libertad_aco.Repositories;



import com.scj.casa_libertad_aco.Entities.Delitos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DelitosRepository extends JpaRepository<Delitos,Integer> {
    
    public Delitos findByUniqId(int uniqId);


    
}
