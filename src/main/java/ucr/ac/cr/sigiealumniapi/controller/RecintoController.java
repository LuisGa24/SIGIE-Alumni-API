package ucr.ac.cr.sigiealumniapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucr.ac.cr.sigiealumniapi.domain.Recinto;
import ucr.ac.cr.sigiealumniapi.service.RecintoService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/api/recinto")
public class RecintoController {
    @Autowired
    private RecintoService recintoService;

    @GetMapping("/getAll")
    public List<Recinto> list() {
        return recintoService.listAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Recinto> get(@PathVariable Integer id) {
        try {
            Recinto recinto = recintoService.get(id);
            return new ResponseEntity<Recinto>(recinto, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Recinto>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public void add(@RequestBody Recinto recinto) {
        recintoService.save(recinto);
    }


    @PutMapping(value = "/update")
    public void update(@RequestBody Recinto recinto) {
        recintoService.save(recinto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        recintoService.delete(id);
    }
}
