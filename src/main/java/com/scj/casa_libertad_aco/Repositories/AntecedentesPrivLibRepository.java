
package com.scj.casa_libertad_aco.Repositories;

import com.scj.casa_libertad_aco.Entities.AntecedentesPrivLib;
import com.scj.casa_libertad_aco.Entities.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AntecedentesPrivLibRepository extends JpaRepository<AntecedentesPrivLib,Integer> {
    
    public AntecedentesPrivLib findByUniqId(int uniqId);
    public AntecedentesPrivLib findByUsuarios(Usuarios usuarios);
    
}
