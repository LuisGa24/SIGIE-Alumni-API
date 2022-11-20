package ucr.ac.cr.sigiealumniapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucr.ac.cr.sigiealumniapi.domain.CategoriaConsulta;
import ucr.ac.cr.sigiealumniapi.service.CategoriaConsultaService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/api/categoriaConsulta")
public class CategoriaConsultaController {
    @Autowired
    private CategoriaConsultaService categoriaConsultaService;

    @GetMapping("/getAll")
    public List<CategoriaConsulta> list() {
        return categoriaConsultaService.listAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CategoriaConsulta> get(@PathVariable Integer id) {
        try {
            CategoriaConsulta categoriaConsulta = categoriaConsultaService.get(id);
            return new ResponseEntity<CategoriaConsulta>(categoriaConsulta, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<CategoriaConsulta>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public void add(@RequestBody CategoriaConsulta categoriaConsulta) {
        categoriaConsultaService.save(categoriaConsulta);
    }


    @PutMapping(value = "/update")
    public void update(@RequestBody CategoriaConsulta categoriaConsulta) {
        categoriaConsultaService.save(categoriaConsulta);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        categoriaConsultaService.delete(id);
    }
}
