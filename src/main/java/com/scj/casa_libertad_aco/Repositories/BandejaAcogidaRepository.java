
package com.scj.casa_libertad_aco.Repositories;

import com.scj.casa_libertad_aco.Entities.BandejaAcogida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BandejaAcogidaRepository extends JpaRepository<BandejaAcogida,Integer> {
    
    public BandejaAcogida findById(int id);
    public BandejaAcogida findByNumeroDocumento(String numeroDocumento);
    
    
}
