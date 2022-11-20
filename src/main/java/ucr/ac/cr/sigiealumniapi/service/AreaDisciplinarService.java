package ucr.ac.cr.sigiealumniapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.sigiealumniapi.domain.AreaDisciplinar;
import ucr.ac.cr.sigiealumniapi.repository.AreaDisciplinarRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AreaDisciplinarService {
    @Autowired
    private AreaDisciplinarRepository areaDisciplinarRepository;

    public List<AreaDisciplinar> listAll() {return areaDisciplinarRepository.findAll();}

    public void save(AreaDisciplinar areaDisciplinar) {
        areaDisciplinarRepository.save(areaDisciplinar);
    }

    public AreaDisciplinar get(int id) {
        return areaDisciplinarRepository.findById(id).get();
    }

    public void delete(int id) {
        areaDisciplinarRepository.deleteById(id);
    }
}
