package ucr.ac.cr.sigiealumniapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucr.ac.cr.sigiealumniapi.domain.PlanEstudio;

@Repository
public interface PlanEstudioRepository extends JpaRepository<PlanEstudio, Integer> {
//    @Override
//    @Query("SELECT ps.codCarrera , cd.id, cd.nombre FROM PlanEstudio ps JOIN ps.coordinador cd")
//    List<PlanEstudio> findAll();
}


