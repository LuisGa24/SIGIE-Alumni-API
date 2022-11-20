package ucr.ac.cr.sigiealumniapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.sigiealumniapi.domain.CategoriaConsulta;
import ucr.ac.cr.sigiealumniapi.repository.CategoriaConsultaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoriaConsultaService {
    @Autowired
    private CategoriaConsultaRepository categoriaConsultaRepository;

    public List<CategoriaConsulta> listAll() {return categoriaConsultaRepository.findAll();}

    public void save(CategoriaConsulta categoriaConsulta) {
        categoriaConsultaRepository.save(categoriaConsulta);
    }

    public CategoriaConsulta get(int id) {
        return categoriaConsultaRepository.findById(id).get();
    }

    public void delete(int id) {
        categoriaConsultaRepository.deleteById(id);
    }
}
