
package com.scj.casa_libertad_aco.Entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bandeja_acogida")
public class BandejaAcogida implements Serializable {
    
    @Id
    @Column(name="uniqid")
    private int id;
    
    @Column(name = "numero_documento")
    private String numeroDocumento;
    
    @Column(name = "nombres")
    private String nombres;
    
    @Column(name = "primer_apelido")
    private String primerApellido;
    
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    
    @Column(name = "accion")
    private String accion;
    
    
    
}
