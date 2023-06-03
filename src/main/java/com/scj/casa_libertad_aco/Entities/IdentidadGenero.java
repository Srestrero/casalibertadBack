
package com.scj.casa_libertad_aco.Entities;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "iden__d__gene")
public class IdentidadGenero implements Serializable {
    
    @Id
    private int uniqid;
    
    @Column(name = "identidad")
    private String identidadGenero;
    
}
