
package com.scj.casa_libertad_aco.entradaDTOs;


import lombok.Data;

@Data
public class FormatosDTO {
    
    String consentimiento_firma;
    String trat_datos_firma;
    String autoriz_imagen_firma;
    byte[] adjunto_concentimiento;
    byte[] adjunto_trat_datos;
    byte[] adjunto_uso_imagen;
    String medio_att_no_presencial;
    String estado;    
}
