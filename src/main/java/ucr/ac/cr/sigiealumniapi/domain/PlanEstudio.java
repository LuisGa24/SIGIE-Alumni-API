package ucr.ac.cr.sigiealumniapi.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
public class PlanEstudio {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String codCarrera;
    private String nombreCarrera;
    private int anoAprobacion;

    @OneToOne
    @JoinColumn(name = "coordinador_id")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id") //Evita los ciclos de reperencias circulares
    private PersonaCoordinadora coordinador;

    @OneToMany
    @JoinColumn(name = "planestudio_id")
    private List<AreaDisciplinar> areasDisciplinares;

    @ManyToMany
    @JoinTable(
            name = "planestudio_personagraduada",
            joinColumns = {@JoinColumn(name = "planestudio_id")},
            inverseJoinColumns = {@JoinColumn(name = "personagraduada_id")}
    )
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id") //Evita los ciclos de reperencias circulares
    private List<PersonaGraduada> personasGraduadas; //= new java.util.ArrayList<>();

    public PlanEstudio() {
    }

    public PlanEstudio(int id, String codCarrera, String nombreCarrera, int anoAprobacion, PersonaCoordinadora coordinador, List<AreaDisciplinar> areasDisciplinares, List<PersonaGraduada> personasGraduadas) {
        this.id = id;
        this.codCarrera = codCarrera;
        this.nombreCarrera = nombreCarrera;
        this.anoAprobacion = anoAprobacion;
        this.coordinador = coordinador;
        this.areasDisciplinares = areasDisciplinares;
        this.personasGraduadas = personasGraduadas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodCarrera() {
        return codCarrera;
    }

    public void setCodCarrera(String codCarrera) {
        this.codCarrera = codCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public int getAnoAprobacion() {
        return anoAprobacion;
    }

    public void setAnoAprobacion(int anoAprobacion) {
        this.anoAprobacion = anoAprobacion;
    }

    public PersonaCoordinadora getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(PersonaCoordinadora coordinador) {
        this.coordinador = coordinador;
    }

    public List<AreaDisciplinar> getAreasDisciplinares() {
        return areasDisciplinares;
    }

    public void setAreasDisciplinares(List<AreaDisciplinar> areasDisciplinares) {
        this.areasDisciplinares = areasDisciplinares;
    }

    public List<PersonaGraduada> getPersonasGraduadas() {
        return personasGraduadas;
    }

    public void setPersonasGraduadas(List<PersonaGraduada> personasGraduadas) {
        this.personasGraduadas = personasGraduadas;
    }

}