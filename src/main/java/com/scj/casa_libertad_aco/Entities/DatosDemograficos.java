
package com.scj.casa_libertad_aco.Entities;

import java.util.Date;
import java.io.Serializable;
import javax.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "datos_demog")
public class DatosDemograficos implements Serializable{
    
    @Id
    private int uniqid;
    
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    
    @ManyToOne
    @JoinColumn(name = "nacionalidades_uniqid")
    private Nacionalidades nacionalidad;
    
    @ManyToOne
    @JoinColumn(name= "paises_uniqid")
    private Paises pais;
    
    @Column(name = "otro_pais")
    private String otroPais;
    
    @ManyToOne
    @JoinColumn(name= "estado_civil_uniqid")
    private EstadoCivil estadoCivil;
    
    @ManyToOne
    @JoinColumn(name= "etnias_uniqid")
    private Etnias etnia;
    
    @Column(name = "otra_etnia")
    private String otraEtnia;
    
    @ManyToOne
    @JoinColumn(name= "sexos_uniqid")
    private Sexos sexo;
    
    @ManyToOne
    @JoinColumn(name= "iden_d_gene_uniqid")
    private IdentidadGenero identidadGenero;
    
    @ManyToOne
    @JoinColumn(name= "orie_sex_uniqid")
    private OrientacionSexual orientacionSexual;
    
   
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
    @JoinColumn(name= "usuarios_uniqid")
    private Usuarios usuarios;
    
         
}
