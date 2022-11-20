package ucr.ac.cr.sigiealumniapi.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class ConsultaMejora {
    @Id
    private String id;
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
            joinColumns = { @JoinColumn(name = "consultamejora_id") },
            inverseJoinColumns = { @JoinColumn(name = "recinto_id") }
    )
    private List <Recinto> recintos;

    @ManyToOne
    @JoinColumn(name = "area_disciplinar_id")
    private AreaDisciplinar areaDisciplinar;

    @ManyToOne
    @JoinColumn(name = "plan_estudio_id")
    private PlanEstudio planEstudio;

    @OneToMany(mappedBy="consultaMejora")
    private List<RespuestaMejora> respuestas;


    public ConsultaMejora() {
    }
}