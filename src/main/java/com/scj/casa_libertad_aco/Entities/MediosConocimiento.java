
package com.scj.casa_libertad_aco.Entities;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "medios_conoc")
public class MediosConocimiento implements Serializable {
    
    @Id
    private int uniqid;
    
    @Column(name = "medio")
    private String medioConocimiento;
    
    
}
