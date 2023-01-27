
package com.scj.casa_libertad_aco.Repositories;

import com.scj.casa_libertad_aco.Entities.Usuarios;
import com.scj.casa_libertad_aco.Entities.ProgramasCasaLib;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramasCasaLibRepository extends JpaRepository<ProgramasCasaLib,Integer> {
    
            public ProgramasCasaLib findByUniqid(int uniqid);
            public ProgramasCasaLib findByUsuarios(Usuarios usuarios);

    
}
