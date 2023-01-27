
package com.scj.casa_libertad_aco.Entities;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "etnias")
public class Etnias implements Serializable{
    
    @Id
    private int uniqid;
    
    @Column(name = "etnia")
    private String etnia;
    
}
