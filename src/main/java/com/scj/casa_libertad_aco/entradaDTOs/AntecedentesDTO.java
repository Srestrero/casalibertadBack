
package com.scj.casa_libertad_aco.entradaDTOs;

import java.util.Date;
import lombok.Data;

@Data
public class AntecedentesDTO {
    
    Date fecha_libertad;
    int meses_condena;
    String ultimoProceso;
    int aprehend_adolesc;
    int aprehend_mayor;
    String proceso_actual;
    int[] delitos_uniqid;
    int estab_carcs_uniqid;
    int sit_jurid_uniqid;
    String personeria;
    String procuraduria;
    String contraloria;
    String rama_judicial;
    String policia;
    String codigo_seguridad;
    String sisipec;
    int usuarios_uniqid;   
}
