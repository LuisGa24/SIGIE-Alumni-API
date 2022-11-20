package ucr.ac.cr.sigiealumniapi.domain;

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
    private List<Recinto> recintos;

    @ManyToMany(mappedBy = "personasGraduadas")
    private List<PlanEstudio> carreras;




}