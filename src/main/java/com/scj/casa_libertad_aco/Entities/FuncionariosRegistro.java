
package com.scj.casa_libertad_aco.Entities;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "funcs_registro")
public class FuncionariosRegistro implements Serializable {
    
    @Id
    private int uniqid;
    
    @Column(name = "nombre_funcionario")
    private String nombreFuncionRegistro;
    
    
}
