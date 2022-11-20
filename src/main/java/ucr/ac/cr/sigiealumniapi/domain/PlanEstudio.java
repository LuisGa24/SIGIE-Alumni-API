package ucr.ac.cr.sigiealumniapi.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class PlanEstudio {
    @Id
    private String id;
    private String codCarrera;
    private String nombreCarrera;
    private int anoAprovacion;

    @OneToOne
    @JoinColumn(name = "coordinador_id")
    private PersonaCoordinadora coordinador;

    @OneToMany
    @JoinColumn(name = "planestudio_id")
    private List<AreaDisciplinar> areasDisciplinares;

    @ManyToMany
    @JoinTable(
            name = "planestudio_personagraduada",
            joinColumns = { @JoinColumn(name = "planestudio_id") },
            inverseJoinColumns = { @JoinColumn(name = "personagraduada_id") }
    )
    private List<PersonaGraduada> personasGraduadas; //= new java.util.ArrayList<>();

    public PlanEstudio() {
    }

}