package ucr.ac.cr.sigiealumniapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucr.ac.cr.sigiealumniapi.domain.PlanEstudio;
import ucr.ac.cr.sigiealumniapi.service.PlanEstudioService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/api/planEstudio")
public class PlanEstudioController {
    @Autowired
    private PlanEstudioService planEstudioService;

    @GetMapping("/getAll")
    public List<PlanEstudio> list() {
        return planEstudioService.listAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PlanEstudio> get(@PathVariable Integer id) {
        try {
            PlanEstudio planEstudio = planEstudioService.get(id);
            return new ResponseEntity<PlanEstudio>(planEstudio, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<PlanEstudio>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public void add(@RequestBody PlanEstudio planEstudio) {
        planEstudioService.save(planEstudio);
    }


    @PutMapping(value = "/update")
    public void update(@RequestBody PlanEstudio planEstudio) {
        planEstudioService.save(planEstudio);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        planEstudioService.delete(id);
    }
}
