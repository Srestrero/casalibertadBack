
package com.scj.casa_libertad_aco.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "formatos")
public class Formatos implements Serializable{
    
    @Id
    private int uniqid;
    
    @Column(name = "consentimiento_firma")
    private String consentimientoFirma;
    
    @Column(name = "trat_datos_firma")
    private String tratamientoDatosFirma;
    
    @Column(name = "autoriz_imagen_firma")
    private String autorizImagenFirma;

    @Column(name = "nom_consentimiento_firma")
    private String nombreConsentimientoFirma;

    @Column(name = "nom_trat_datos_firma")
    private String nombreTratamientoDatosFirma;

    @Column(name = "nom_autoriz_imagen_firma")
    private String nombreAutorizImagenFirma;
    
    //@JoinColumn(name = "adjunto_concentimiento")
    //@JsonIgnore
    @Column(name="adjunto_concentimiento",nullable=true)
    @Basic(optional=true, fetch=FetchType.EAGER)
    @Lob
    private byte[] consentimiento;
    
    //@JoinColumn(name = "adjunto_trat_datos")
    //@JsonIgnore
    @Column(name="adjunto_trat_datos",nullable=true)
    @Basic(optional=true, fetch=FetchType.EAGER)
    @Lob
    private byte[] autorTratamDatos;
    
    //@JoinColumn(name = "adjunto_uso_imagen")
    //@JsonIgnore
    @Column(name="adjunto_uso_imagen",nullable=true)
    @Basic(optional=true, fetch=FetchType.EAGER)
    @Lob
    private byte[] autorUsoImagen;
    
    @Column(name = "medio_att_no_presencial")
    private String mediosAttNoPresenc;
    
    @Column(name = "estado")
    private String estado;
    
    @ManyToOne
    @JoinColumn(name = "usuarios_uniqid")
    private Usuarios usuarios ;
    
    
    
    



    
   

    
    
    
    
    
    
}
