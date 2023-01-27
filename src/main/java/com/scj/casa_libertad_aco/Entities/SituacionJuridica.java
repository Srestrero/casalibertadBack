
package com.scj.casa_libertad_aco.Entities;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "sit_jurid")
public class SituacionJuridica implements Serializable {
    
    @Id
    private int uniqid;
    
    @Column(name = "situacion")
    private String situacionJur;
    
    
}
