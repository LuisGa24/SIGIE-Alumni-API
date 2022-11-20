package ucr.ac.cr.sigiealumniapi.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Recinto {
    @Id
    private String id;
    private String nombre;
    private String direccion;
    private String numTelefono;
    private String sitioWeb;

    @ManyToMany
    @JoinTable(
            name = "recinto_personagraduada",
            joinColumns = { @JoinColumn(name = "recinto_id") },
            inverseJoinColumns = { @JoinColumn(name = "personagraduada_id") }
    )
    private List<PersonaGraduada> personasGraduadas;

}