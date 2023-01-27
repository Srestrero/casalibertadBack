
package com.scj.casa_libertad_aco.Repositories;

import com.scj.casa_libertad_aco.Entities.Formatos;
import com.scj.casa_libertad_aco.Entities.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormatosRepository extends JpaRepository<Formatos,Integer> {
    
    public Formatos findByUniqid(int uniqid);
    public Formatos findByUsuarios(Usuarios usuarios); 
    
}
