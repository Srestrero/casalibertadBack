
package com.scj.casa_libertad_aco.Entities;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "progr")
public class ProgramasCasaLib implements Serializable {
    
    @Id
    private int uniqid;
    
    @Column(name = "otr_medio_conoc")
    private String otroMedioConoc;
    
    @Column(name = "nombres_otro_func")
    private String nombresOtroFunc;
    
    @ManyToOne
    @JoinColumn(name = "medios_conoc_uniqid")
    private MediosConocimiento mediosConocs;
    
    @ManyToOne
    @JoinColumn(name = "expectativas_uniqid")
    private Expectativas expectativas;
    
    @ManyToOne
    @JoinColumn(name = "funcs_registro_uniqid")
    private FuncionariosRegistro funcionarioRegistros ;
    
    
    @ManyToOne
    @JoinColumn(name = "usuarios_uniqid")
    private Usuarios usuarios ;
    
    
    
    
}
