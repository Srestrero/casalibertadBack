
package com.scj.casa_libertad_aco.Repositories;

import com.scj.casa_libertad_aco.Entities.Contactos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ContactosRepository extends JpaRepository<Contactos,Integer> {
    
    public Contactos findByUniqid(int uniqid);
    
}
