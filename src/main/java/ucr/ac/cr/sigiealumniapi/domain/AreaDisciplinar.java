package ucr.ac.cr.sigiealumniapi.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AreaDisciplinar {
    @Id
    private String id;
    private String nombre;

    public AreaDisciplinar() {
    }

    public AreaDisciplinar(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
}