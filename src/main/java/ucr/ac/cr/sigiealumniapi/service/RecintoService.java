package ucr.ac.cr.sigiealumniapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.sigiealumniapi.domain.Recinto;
import ucr.ac.cr.sigiealumniapi.repository.RecintoRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RecintoService {
    @Autowired
    private RecintoRepository recintoRepository;

    public List<Recinto> listAll() {return recintoRepository.findAll();}

    public void save(Recinto recinto) {
        recintoRepository.save(recinto);
    }

    public Recinto get(int id) {
        return recintoRepository.findById(id).get();
    }

    public void delete(int id) {
        recintoRepository.deleteById(id);
    }
}
