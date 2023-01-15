
package com.scj.casa_libertad_aco.Entities;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "orie_sex")
public class OrientacionSexual implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int uniqId;
    
    @Column(name = "orientacion" )
    private String orientacionSexual;
    
}
