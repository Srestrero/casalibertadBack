
package com.scj.casa_libertad_aco.Entities;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "estab_carcs")
public class EstablecimientosCarc implements Serializable {
    
    @Id
    private int uniqid;
    
    @Column(name = "establecimiento")
    private String establecimientoCarc;
    
    
}
