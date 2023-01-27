
package com.scj.casa_libertad_aco.Entities;

import java.util.Date;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "ant_priv_lib")
public class AntecedentesPrivLib implements Serializable {
    
    @Id
    private int uniqid;
    
    @Column(name = "fecha_libertad")
    private Date fechaLibertad;
    
    @Column(name = "meses_condena")
    private int mesesCondena;
    
    @Column(name = "otro_estab_carce")
    private String otroEstabCarce;
    
    @Column(name = "aprehend_adolesc")
    private int aprehendAdolesc;
    
    @Column(name = "aprehend_mayor")
    private int aprehendMayor;
    
    @Column(name = "proceso_actual")
    private String procesoActual;
    
    @Column(name = "personeria")
    private String personeria;
    
    @Column(name = "procuraduria")
    private String procuraduria;
    
    @Column(name = "contraloria")
    private String contraloria;
    
    @Column(name = "rama_judicial")
    private String ramaJudicial;
    
    @Column(name = "policia")
    private String policia;
    
    @Column(name = "codigo_seguridad")
    private String codigoSeguridad;
    
    @Column(name = "sisipec")
    private String sisipec;
    
    @ManyToOne
    @JoinColumn(name = "delitos_uniqid")
    private Delitos delitos;
    
    @ManyToOne
    @JoinColumn(name = "estab_carcs_uniqid")
    private EstablecimientosCarc estabCarcelarios;
    
    @ManyToOne
    @JoinColumn(name = "sit_jurid_uniqid")
    private SituacionJuridica situacionJuridicas;
    
    @ManyToOne
    @JoinColumn(name = "usuarios_uniqid")
    private Usuarios usuarios;
       
    
}
