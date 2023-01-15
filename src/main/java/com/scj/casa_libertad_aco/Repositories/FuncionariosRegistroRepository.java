
package com.scj.casa_libertad_aco.Repositories;


import com.scj.casa_libertad_aco.Entities.FuncionariosRegistro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionariosRegistroRepository extends JpaRepository<FuncionariosRegistro,Integer> {
    
    public FuncionariosRegistro findByUniqId(int uniqId);
    
}
