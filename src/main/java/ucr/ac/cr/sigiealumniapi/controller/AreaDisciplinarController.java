package ucr.ac.cr.sigiealumniapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucr.ac.cr.sigiealumniapi.domain.AreaDisciplinar;
import ucr.ac.cr.sigiealumniapi.service.AreaDisciplinarService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/api/areaDisciplinar")
public class AreaDisciplinarController {
    @Autowired
    private AreaDisciplinarService areaDisciplinarService;

    @GetMapping("/getAll")
    public List<AreaDisciplinar> list() {
        return areaDisciplinarService.listAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AreaDisciplinar> get(@PathVariable Integer id) {
        try {
            AreaDisciplinar areaDisciplinar = areaDisciplinarService.get(id);
            return new ResponseEntity<AreaDisciplinar>(areaDisciplinar, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<AreaDisciplinar>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public void add(@RequestBody AreaDisciplinar areaDisciplinar) {
        areaDisciplinarService.save(areaDisciplinar);
    }


    @PutMapping(value = "/update")
    public void update(@RequestBody AreaDisciplinar areaDisciplinar) {
        areaDisciplinarService.save(areaDisciplinar);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        areaDisciplinarService.delete(id);
    }
}
