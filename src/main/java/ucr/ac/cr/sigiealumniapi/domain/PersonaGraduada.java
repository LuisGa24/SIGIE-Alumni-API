package ucr.ac.cr.sigiealumniapi.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
public class PersonaGraduada {
    @Id
    private String id;
    private String nombre;
    private String apellidos;
    private int anoGraduacion;
    private String numCarne;
    private Number promedioPonderado;
    private String telefono;
    private String correo;

    @ManyToMany(mappedBy = "personasGraduadas")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id") //Evita los ciclos de reperencias circulares
    private List<Recinto> recintos;

    @ManyToMany(mappedBy = "personasGraduadas")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id") //Evita los ciclos de reperencias circulares
    private List<PlanEstudio> carreras;

    public PersonaGraduada(String id, String nombre, String apellidos, int anoGraduacion, String numCarne, Number promedioPonderado, String telefono, String correo, List<Recinto> recintos, List<PlanEstudio> carreras) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.anoGraduacion = anoGraduacion;
        this.numCarne = numCarne;
        this.promedioPonderado = promedioPonderado;
        this.telefono = telefono;
        this.correo = correo;
        this.recintos = recintos;
        this.carreras = carreras;
    }

    public PersonaGraduada() {

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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getAnoGraduacion() {
        return anoGraduacion;
    }

    public void setAnoGraduacion(int anoGraduacion) {
        this.anoGraduacion = anoGraduacion;
    }

    public String getNumCarne() {
        return numCarne;
    }

    public void setNumCarne(String numCarne) {
        this.numCarne = numCarne;
    }

    public Number getPromedioPonderado() {
        return promedioPonderado;
    }

    public void setPromedioPonderado(Number promedioPonderado) {
        this.promedioPonderado = promedioPonderado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Recinto> getRecintos() {
        return recintos;
    }

    public void setRecintos(List<Recinto> recintos) {
        this.recintos = recintos;
    }

    public List<PlanEstudio> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<PlanEstudio> carreras) {
        this.carreras = carreras;
    }
}