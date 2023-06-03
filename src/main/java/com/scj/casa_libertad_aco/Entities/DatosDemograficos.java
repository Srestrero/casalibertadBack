
package com.scj.casa_libertad_aco.Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="datos_demog")
public class DatosDemograficos implements Serializable {
    
    @Id
    private int uniqid;
    
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    
    @Column(name = "otra_etnia")
    private String otraEtnia;
    
    @Column(name = "discapacitado")
    private String discapacitado;
    
    @Column(name = "ayuda_movilidad")
    private String ayudaMovilidad;
    
    @Column(name = "ayuda_lectoescritura")
    private String ayudaLectoescritura;
    
    @Column(name = "ayuda_traduccion")
    private String ayudaTraduccionSeñales;
    
    @Column(name = "vict_conf_arma")
    private String victimaConflictoArm;
    
    @ManyToOne
    @JoinColumn(name = "nacionalidades_uniqid")
    private Nacionalidades nacionalidad; 
    
    @ManyToOne
    @JoinColumn(name = "paises_uniqid")
    private Paises pais;
    
    @ManyToOne
    @JoinColumn(name = "estado_civil_uniqid")
    private EstadoCivil estadoCivil;
    
    @ManyToOne
    @JoinColumn(name = "etnias_uniqid")
    private Etnias etnia;
    
    @ManyToOne
    @JoinColumn(name = "sexos_uniqid")
    private Sexos sexo;
    
    @ManyToOne
    @JoinColumn(name="iden__d__gene_uniqid")
    private IdentidadGenero identidadGenero;
    
    @ManyToOne
    @JoinColumn(name = "orie_sex_uniqid")
    private OrientacionSexual orientacionSexual;
    
    @ManyToOne
    @JoinColumn(name = "usuarios_uniqid")
    private Usuarios usuarios;
    
    
}
