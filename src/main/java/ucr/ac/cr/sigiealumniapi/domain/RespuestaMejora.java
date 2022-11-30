package ucr.ac.cr.sigiealumniapi.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class RespuestaMejora {
    @Id
    private int id;
    private String propuesta;


    @ManyToOne
    @JoinColumn(name = "categoria_consulta_id")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id") //Evita los ciclos de reperencias circulares
    private CategoriaConsulta categoriaConsulta;


    @ManyToOne
    @JoinColumn(name = "consulta_mejora_id")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id") //Evita los ciclos de reperencias circulares
    private ConsultaMejora consultaMejora;


    @ManyToOne
    @JoinColumn(name = "autor_id")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id") //Evita los ciclos de reperencias circulares
    private PersonaGraduada autor;

    public RespuestaMejora() {
    }

    public RespuestaMejora(int id, String propuesta, CategoriaConsulta categoriaConsulta, ConsultaMejora consultaMejora, PersonaGraduada autor) {
        this.id = id;
        this.propuesta = propuesta;
        this.categoriaConsulta = categoriaConsulta;
        this.consultaMejora = consultaMejora;
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPropuesta() {
        return propuesta;
    }

    public void setPropuesta(String propuesta) {
        this.propuesta = propuesta;
    }

    public CategoriaConsulta getCategoriaConsulta() {
        return categoriaConsulta;
    }

    public void setCategoriaConsulta(CategoriaConsulta categoriaConsulta) {
        this.categoriaConsulta = categoriaConsulta;
    }

    public ConsultaMejora getConsultaMejora() {
        return consultaMejora;
    }

    public void setConsultaMejora(ConsultaMejora consultaMejora) {
        this.consultaMejora = consultaMejora;
    }

    public PersonaGraduada getAutor() {
        return autor;
    }

    public void setAutor(PersonaGraduada autor) {
        this.autor = autor;
    }
}
