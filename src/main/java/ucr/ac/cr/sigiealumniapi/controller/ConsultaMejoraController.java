package ucr.ac.cr.sigiealumniapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucr.ac.cr.sigiealumniapi.domain.ConsultaMejora;
import ucr.ac.cr.sigiealumniapi.service.ConsultaMejoraService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/api/consultaMejora")
public class ConsultaMejoraController {
    @Autowired
    private ConsultaMejoraService consultaMejoraService;

    @GetMapping("/getAll")
    public List<ConsultaMejora> list() {
        return consultaMejoraService.listAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ConsultaMejora> get(@PathVariable Integer id) {
        try {
            ConsultaMejora consultaMejora = consultaMejoraService.get(id);
            return new ResponseEntity<ConsultaMejora>(consultaMejora, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<ConsultaMejora>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public void add(@RequestBody ConsultaMejora consultaMejora) {
        consultaMejoraService.save(consultaMejora);
    }


    @PutMapping(value = "/update")
    public void update(@RequestBody ConsultaMejora consultaMejora) {
        consultaMejoraService.save(consultaMejora);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        consultaMejoraService.delete(id);
    }
}
