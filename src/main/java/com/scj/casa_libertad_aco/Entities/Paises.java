
package com.scj.casa_libertad_aco.Entities;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "paises")
public class Paises implements Serializable {
    
    @Id
    private int uniqid;
    
    @Column(name = "pais")
    private String pais;
    
}
