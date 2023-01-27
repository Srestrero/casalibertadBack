
package com.scj.casa_libertad_aco.Entities;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "expectativas")
public class Expectativas implements Serializable {
    
    @Id
    private int uniqid;
    
    @Column(name = "expectativa")
    private String expectativaProgr;
    
    
}
