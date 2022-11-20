package ucr.ac.cr.sigiealumniapi.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
            joinColumns = {@JoinColumn(name = "recinto_id")},
            inverseJoinColumns = {@JoinColumn(name = "personagraduada_id")}
    )
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id") //Evita los ciclos de reperencias circulares
    private List<PersonaGraduada> personasGraduadas;

    public Recinto(String id, String nombre, String direccion, String numTelefono, String sitioWeb, List<PersonaGraduada> personasGraduadas) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.numTelefono = numTelefono;
        this.sitioWeb = sitioWeb;
        this.personasGraduadas = personasGraduadas;
    }

    public Recinto() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public List<PersonaGraduada> getPersonasGraduadas() {
        return personasGraduadas;
    }

    public void setPersonasGraduadas(List<PersonaGraduada> personasGraduadas) {
        this.personasGraduadas = personasGraduadas;
    }
}