
package com.scj.casa_libertad_aco.Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "delitos")
public class Delitos implements Serializable {
    
    @ManyToMany(mappedBy = "delitos")
    private List<AntecedentesPrivLib> antecedentesPrivLibs;

    @Id
    private int uniqid;
    
    @Column(name = "delito")
    private String delito;
    
}
