package ucr.ac.cr.sigiealumniapi.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.sql.Date;

@Entity
public class PersonaCoordinadora {
    @Id
    private String id;
    private String nombre;
    private String apellidos;
    private String correoInstitucional;
    private String correoPersonal;
    private Date fechaInicio;

    @OneToOne(mappedBy = "coordinador")
    private PlanEstudio planEstudio;

    public PersonaCoordinadora() {
    }

}
