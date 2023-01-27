
package com.scj.casa_libertad_aco.Entities;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "estado_civil")
public class EstadoCivil implements Serializable {
    
    @Id
    private int uniqid;
    
    @Column(name = "estado")
    private String estadoCivil;
    
}
