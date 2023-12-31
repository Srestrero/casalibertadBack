
package com.scj.casa_libertad_aco.Entities;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "documento_tipos")
public class DocumentoTipos implements Serializable {
    
    @Id
    private int uniqid;
    
    @Column(name = "nombre_documento")
    private String nombreDocumento;

}
