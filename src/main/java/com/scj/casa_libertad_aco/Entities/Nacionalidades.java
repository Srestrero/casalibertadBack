
package com.scj.casa_libertad_aco.Entities;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "nacionalidades")
public class Nacionalidades implements Serializable {
    
    @Id
    private int uniqid;
    
    @Column(name = "nacionalidad")
    private String nacionalidad;
    
}
