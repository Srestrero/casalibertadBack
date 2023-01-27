
package com.scj.casa_libertad_aco.Entities;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contactos")
public class Contactos implements Serializable {
    
    @Id
    private int uniqid;
    
    @Column(name = "nombre")
    private String nombreContacto;
    
    @Column(name = "primer_apellido")
    private String primerApellidoCont;
    
    @Column(name = "segundo_apellido")
    private String segundoApeliidoCont;
    
    @Column(name = "cel_numero")
    private Long celContacto;
    
    @Column(name = "parentesco")
    private String parentesco;
    
    @OneToOne
    @JoinColumn(name = "usuarios_uniqid")
    private Usuarios usuarios;
    
    
    
}
