
package com.scj.casa_libertad_aco.Entities;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "viviendas")
public class Viviendas implements Serializable {
    
    @Id
    private int uniqid;
    
    @Column(name = "tipo_vivienda")
    private String tipoVivienda;
    
    
}
