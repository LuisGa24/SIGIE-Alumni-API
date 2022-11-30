package ucr.ac.cr.sigiealumniapi.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class ConsultaMejora {
    @Id
    private int id;
    private String titulo;
    private String objetivo;
    private String instrucciones;
    private Date fechaFinalizacion;
    private int anoGraduacionMax;
    private int anoGraduacionMin;
    private String nombrePersonaResponsableConsulta;
    private String apellidosPersonaResponsableConsulta;
    private String correoPersonaResponsableConsulta;

    @ManyToMany
    @JoinTable(
            name = "consultamejora_recinto",
            joinColumns = {@JoinColumn(name = "consultamejora_id")},
            inverseJoinColumns = {@JoinColumn(name = "recinto_id")}
    )
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id") //Evita los ciclos de reperencias circulares
    private List<Recinto> recintos;

    @ManyToOne
    @JoinColumn(name = "area_disciplinar_id")
    private AreaDisciplinar areaDisciplinar;

    @ManyToOne
    @JoinColumn(name = "plan_estudio_id")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id") //Evita los ciclos de reperencias circulares
    private PlanEstudio planEstudio;

    @OneToMany(mappedBy = "consultaMejora")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id") //Evita los ciclos de reperencias circulares
    private List<RespuestaMejora> respuestas;


    public ConsultaMejora() {
    }

    public ConsultaMejora(int id, String titulo, String objetivo, String instrucciones, Date fechaFinalizacion, int anoGraduacionMax, int anoGraduacionMin, String nombrePersonaResponsableConsulta, String apellidosPersonaResponsableConsulta, String correoPersonaResponsableConsulta, List<Recinto> recintos, AreaDisciplinar areaDisciplinar, PlanEstudio planEstudio, List<RespuestaMejora> respuestas) {
        this.id = id;
        this.titulo = titulo;
        this.objetivo = objetivo;
        this.instrucciones = instrucciones;
        this.fechaFinalizacion = fechaFinalizacion;
        this.anoGraduacionMax = anoGraduacionMax;
        this.anoGraduacionMin = anoGraduacionMin;
        this.nombrePersonaResponsableConsulta = nombrePersonaResponsableConsulta;
        this.apellidosPersonaResponsableConsulta = apellidosPersonaResponsableConsulta;
        this.correoPersonaResponsableConsulta = correoPersonaResponsableConsulta;
        this.recintos = recintos;
        this.areaDisciplinar = areaDisciplinar;
        this.planEstudio = planEstudio;
        this.respuestas = respuestas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public int getAnoGraduacionMax() {
        return anoGraduacionMax;
    }

    public void setAnoGraduacionMax(int anoGraduacionMax) {
        this.anoGraduacionMax = anoGraduacionMax;
    }

    public int getAnoGraduacionMin() {
        return anoGraduacionMin;
    }

    public void setAnoGraduacionMin(int anoGraduacionMin) {
        this.anoGraduacionMin = anoGraduacionMin;
    }

    public String getNombrePersonaResponsableConsulta() {
        return nombrePersonaResponsableConsulta;
    }

    public void setNombrePersonaResponsableConsulta(String nombrePersonaResponsableConsulta) {
        this.nombrePersonaResponsableConsulta = nombrePersonaResponsableConsulta;
    }

    public String getApellidosPersonaResponsableConsulta() {
        return apellidosPersonaResponsableConsulta;
    }

    public void setApellidosPersonaResponsableConsulta(String apellidosPersonaResponsableConsulta) {
        this.apellidosPersonaResponsableConsulta = apellidosPersonaResponsableConsulta;
    }

    public String getCorreoPersonaResponsableConsulta() {
        return correoPersonaResponsableConsulta;
    }

    public void setCorreoPersonaResponsableConsulta(String correoPersonaResponsableConsulta) {
        this.correoPersonaResponsableConsulta = correoPersonaResponsableConsulta;
    }

    public List<Recinto> getRecintos() {
        return recintos;
    }

    public void setRecintos(List<Recinto> recintos) {
        this.recintos = recintos;
    }

    public AreaDisciplinar getAreaDisciplinar() {
        return areaDisciplinar;
    }

    public void setAreaDisciplinar(AreaDisciplinar areaDisciplinar) {
        this.areaDisciplinar = areaDisciplinar;
    }

    public PlanEstudio getPlanEstudio() {
        return planEstudio;
    }

    public void setPlanEstudio(PlanEstudio planEstudio) {
        this.planEstudio = planEstudio;
    }

    public List<RespuestaMejora> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<RespuestaMejora> respuestas) {
        this.respuestas = respuestas;
    }
}