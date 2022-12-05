package ucr.ac.cr.sigiealumniapi;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import ucr.ac.cr.sigiealumniapi.domain.*;
import ucr.ac.cr.sigiealumniapi.repository.AreaDisciplinarRepository;
import ucr.ac.cr.sigiealumniapi.repository.ConsultaMejoraRepository;

import java.sql.Date;
import java.util.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SigieAlumniApiApplicationTests {

    @Autowired
    private ConsultaMejoraRepository repositorio;

    @Test
    void contextLoads() {
    }

    @Test
    @Rollback(false)
    public void guardarConsulta() {
        //Creación de espacios necesarios para salvar
        PlanEstudio planEstudio = new PlanEstudio();
        List<PersonaGraduada> personaGraduada = new ArrayList<PersonaGraduada>();
        List<RespuestaMejora> respuestas = new ArrayList<RespuestaMejora>();
        //Guarda con area disciplinar ya existente
        AreaDisciplinar areaDisciplinar = new AreaDisciplinar(0, "Programacion");
        //La fecha de publicación será la fecha actual
        Date fechaPublicacion = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        //Creacion de las Categorias
        List<CategoriaConsulta> categoriasConsulta = new ArrayList<CategoriaConsulta>();
        CategoriaConsulta categoria = new CategoriaConsulta(5, "Técnicas");
        categoriasConsulta.add(categoria);
        //Creación de Recinto de Turrubares
        List<Recinto> recintos = new ArrayList<Recinto>();
        Recinto recintoTurrubares = new Recinto(0, "Turrubares", "Turrubares Centro", "89475035", "turrubares.ucr.ac.cr",
                personaGraduada);
        recintos.add(recintoTurrubares);
        //Creación de la Consulta de Mejora
        ConsultaMejora consulta = new ConsultaMejora(0, "Avance de Plan 2019", "Objetivo",
                "Debe rellenar los espacios según considere necesario", fechaPublicacion, 2019, 2017
                , "Joseph", "Martinez", "j.martinez@ucr.ac.cr",
                recintos, areaDisciplinar, planEstudio, respuestas, categoriasConsulta);
        ConsultaMejora consultaGuardada = repositorio.save(consulta);
        assertNotNull(consultaGuardada);
    }
}
