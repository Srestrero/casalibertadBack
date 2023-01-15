
package com.scj.casa_libertad_aco.Entities;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "sexos")
public class Sexos implements Serializable  {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int uniqId;
    
    @Column(name = "sexo")
    private String sexo;
    
}
