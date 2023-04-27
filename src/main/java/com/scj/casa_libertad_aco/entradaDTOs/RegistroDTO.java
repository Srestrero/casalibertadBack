
package com.scj.casa_libertad_aco.entradaDTOs;

import java.util.Date;
import lombok.*;

@Data
public class RegistroDTO {
    
    //String numero_documento;
    String condiciones_programa;
    String canal_atencion;
    String aceptacion_terminos;
    int tipo_documento;
    String num_documento;
    String nombres;
    String primer_apellido;
    String segundo_apellido;
    Date fecha_expedicion;
    String direccion;
    String info_complementaria;
    String verificacion_direccion;
    String localidad;
    String barrio;
    String estrato;
    long tel_fijo;
    long cel_1;
    long cel_2;
    String correo;
    String nombre_contacto;
    String primer_apellido_cont;
    String segundo_apellido_cont;
    long cel_contacto;
    String parentesco;
    String observaciones;
    
    
    
}
