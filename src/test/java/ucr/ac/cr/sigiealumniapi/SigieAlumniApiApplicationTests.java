package ucr.ac.cr.sigiealumniapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import ucr.ac.cr.sigiealumniapi.domain.*;
import ucr.ac.cr.sigiealumniapi.repository.ConsultaMejoraRepository;
import ucr.ac.cr.sigiealumniapi.repository.RecintoRepository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SigieAlumniApiApplicationTests {

    @Autowired
    private ConsultaMejoraRepository repositorioConsulta;
    @Autowired
    private RecintoRepository repositorioRecinto;

    @Test
    void contextLoads() {
    }

    @Test
    @Rollback(false)
    public void testGuardarConsulta() {
        //Creación de espacios necesarios para salvar
        PlanEstudio planEstudio = new PlanEstudio(1,
                "600002",
                "Informática Empresarial",
                1997,new PersonaCoordinadora(),new ArrayList<AreaDisciplinar>(),new ArrayList<PersonaGraduada>());
        List<PersonaGraduada> personaGraduada = new ArrayList<PersonaGraduada>();
        List<RespuestaMejora> respuestas = new ArrayList<RespuestaMejora>();
        //Guarda con area disciplinar ya existente
        AreaDisciplinar areaDisciplinar = new AreaDisciplinar(2, "Programación y Desarrollo de Software");
        //La fecha de publicación será la fecha actual
        Date fechaPublicacion = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        //Creacion de las Categorias
        List<CategoriaConsulta> categoriasConsulta = new ArrayList<CategoriaConsulta>();
        CategoriaConsulta categoria = new CategoriaConsulta(5, "Metodologías");
        categoriasConsulta.add(categoria);
        //Creación de Recinto de Turrubares
        List<Recinto> recintos = new ArrayList<Recinto>();
        Recinto recintoTurrubares = new Recinto(3,
                "Recinto de Guapiles",
                "Paraíso de Cartago, del parque de Paraíso, un kilometro y medio carretera a Orosi",
                "25110000",
                "https://paraiso.ucr.ac.cr/",
                personaGraduada);
        recintos.add(recintoTurrubares);
        //Creación de la Consulta de Mejora
        ConsultaMejora consulta = new ConsultaMejora(0, "Avance de Plan 2019", "Objetivo",
                "Debe rellenar los espacios según considere necesario", fechaPublicacion, 2019, 2017
                , "Joseph", "Martinez", "j.martinez@ucr.ac.cr",
                recintos, areaDisciplinar, planEstudio, respuestas, categoriasConsulta);
        ConsultaMejora consultaGuardada = repositorioConsulta.save(consulta);
        assertNotNull(consultaGuardada);
    }

    @Test
    public void testListarRecintos(){
        List<Recinto> recintos = (List<Recinto>) repositorioRecinto.findAll();
        for (Recinto recinto:recintos){
            System.out.println(recinto);
        }
        assertThat(recintos).size().isGreaterThan(0);
    }
}
