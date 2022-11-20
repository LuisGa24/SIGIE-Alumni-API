package ucr.ac.cr.sigiealumniapi.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class RespuestaMejora {
    @Id
    private String id;
    private String propuesta;


    @ManyToOne
    @JoinColumn(name = "categoria_consulta_id")
    private CategoriaConsulta categoriaConsulta;


    @ManyToOne
    @JoinColumn(name = "consulta_mejora_id")
    private ConsultaMejora consultaMejora;


    @ManyToOne
    @JoinColumn(name = "autor_id")
    private PersonaGraduada  autor;

}
