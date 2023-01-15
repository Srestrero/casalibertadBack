
package com.scj.casa_libertad_aco.salidaDTOs;

import java.util.Date;
import lombok.*;

@Data
public class ConsultaDatosDemDTO {
    
    //String num_documento;
    Date fecha_nacimiento;
    int nacionalidad;
    int pais_origen;
    String otro_pais_origen;
    int estado_civil;
    int etnia;
    String especifique;
    int sexo;
    int identidad_genero;
    int orientacion_sexual;
    String discapacitado;
    String ayuda_movilidad;
    String ayuda_lectoescritura;
    String ayuda_traduccion;
    String vict_conf_arma;
    
}
