package ucr.ac.cr.sigiealumniapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.sigiealumniapi.domain.ConsultaMejora;
import ucr.ac.cr.sigiealumniapi.repository.ConsultaMejoraRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ConsultaMejoraService {
    @Autowired
    private ConsultaMejoraRepository consultaMejoraRepository;

    public List<ConsultaMejora> listAll() {return consultaMejoraRepository.findAll();}

    public void save(ConsultaMejora consultaMejora) {
        consultaMejoraRepository.save(consultaMejora);
    }

    public ConsultaMejora get(int id) {
        return consultaMejoraRepository.findById(id).get();
    }

    public void delete(int id) {
        consultaMejoraRepository.deleteById(id);
    }
}
