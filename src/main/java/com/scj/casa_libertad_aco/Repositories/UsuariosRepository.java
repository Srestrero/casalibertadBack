
package com.scj.casa_libertad_aco.Repositories;

import com.scj.casa_libertad_aco.Entities.Usuarios;
//import com.scj.casa_libertad_aco.Entities.Viviendas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios,Integer> {
    
            public Usuarios findByUniqid(int uniqid);
            public Usuarios findByNumeroDocumento(String numeroDocumento);
            //public Usuarios save(Viviendas vivienda);
            

    
}
