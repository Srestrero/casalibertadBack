
package com.scj.casa_libertad_aco.Entities;

import java.util.Date;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "usuarios")
public class Usuarios implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int uniqId;
    
    /*
    @OneToMany(cascade={CascadeType.PERSIST},mappedBy="usuario")
    @JsonIgnoreProperties("usuario")
    private List<VisitasEntity> visitas;
    */
    
    @ManyToOne
    @JoinColumn(name = "documento_tipos_uniqid")
    private DocumentoTipos documentoTipo;
    
    @Column(name = "numero_documento")
    private String numeroDocumento;
    
    @Column(name = "condiciones_programa")
    private String condicionesPrograma;
    
    @Column(name = "canal_atencion_acogida")
    private String canalAtencionAcogida;
    
    @Column(name = "aceptacion_terms_condic")
    private String aceptacionTermsCondic;
    
    @Column(name = "nombres")
    private String nombres;
    
    @Column(name = "primer_apellido")
    private String primerApellido;
    
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    
    @Column(name = "fecha_expedicion_documento")
    private Date fechaExpedicionDoc;
    
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name ="info_complementaria")
    private String infoComplementaria;
    
    @Column(name = "verificacion_direccion")
    private String verificacionDireccion;
    
    @Column(name = "localidad")
    private String localidad;
    
    @Column(name = "barrio")
    private String barrio;
    
    @Column(name = "estrato_socioeconomico")
    private String estratoSocio;
    
    @Column(name = "tel_fijo")
    private long telFijo;
    
    @Column(name = "celular_1")
    private long celular1;  
    
    @Column(name = "celular_2")
    private long celular2; 
    
    @Column(name = "email")
    private String email;
    
    @OneToOne
    @JoinColumn(name = "contactos_uniqid")
    private Contactos contactos;
    
    @Column(name = "observaciones")
    private String observaciones;
    
    @Column(name = "fecha_acogida")
    private Date fechaAcogida;
    
    @ManyToOne
    @JoinColumn(name = "viviendas_uniqid")
    private Viviendas viviendaTipo;
    
    
    
   
    
   
   
    
    
    
    
}
