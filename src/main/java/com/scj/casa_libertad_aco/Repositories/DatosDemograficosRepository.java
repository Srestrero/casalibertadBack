
package com.scj.casa_libertad_aco.Repositories;

import com.scj.casa_libertad_aco.Entities.DatosDemograficos;
import com.scj.casa_libertad_aco.Entities.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatosDemograficosRepository extends JpaRepository<DatosDemograficos,Integer> {
    
    public DatosDemograficos findByUniqid(int uniqid);
    public DatosDemograficos findByUsuarios(Usuarios usuarios);
    
    
}
