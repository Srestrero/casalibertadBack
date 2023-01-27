
package com.scj.casa_libertad_aco.salidaDTOs;

import java.util.Date;
import lombok.*;

@Data
public class ConsultaUsuariosDTO {
    
    //String numero_documento
    int tipo_documento;
    String num_documento;
    String condiciones_programa;
    String canal_atencion_acogida;
    String aceptacion_terminos;
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
    String observaciones;
    
    
}
