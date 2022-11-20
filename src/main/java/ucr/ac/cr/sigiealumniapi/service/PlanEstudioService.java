package ucr.ac.cr.sigiealumniapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.sigiealumniapi.domain.PlanEstudio;
import ucr.ac.cr.sigiealumniapi.repository.PlanEstudioRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PlanEstudioService {
    @Autowired
    private PlanEstudioRepository planEstudioRepository;

    public List<PlanEstudio> listAll() {return planEstudioRepository.findAll();}

    public void save(PlanEstudio planEstudio) {
        planEstudioRepository.save(planEstudio);
    }

    public PlanEstudio get(int id) {
        return planEstudioRepository.findById(id).get();
    }

    public void delete(int id) {
        planEstudioRepository.deleteById(id);
    }
}
