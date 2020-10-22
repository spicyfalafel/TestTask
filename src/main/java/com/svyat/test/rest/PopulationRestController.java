package com.svyat.test.rest;

import com.svyat.test.model.Population;
import com.svyat.test.service.PopulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/population/")
public class PopulationRestController {
    @Autowired
    private PopulationService populationService;

    @GetMapping("{id}")
    public ResponseEntity<Population> getVirus(@PathVariable("id") Integer id){
        if( id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Population population = this.populationService.getById(id);
        if(population == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(population, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Population> saveVirus(@RequestBody @Valid Population population){
        HttpHeaders headers = new HttpHeaders();
        if(population == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.populationService.save(population);
        return new ResponseEntity<>(population, headers, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<List<Population>> saveAll(@RequestBody @Valid List<Population> population){
        HttpHeaders headers = new HttpHeaders();
        if(population == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.populationService.saveAll(population);
        return new ResponseEntity<>(population, headers, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Population> updateVirus(@RequestBody @Valid Population population, UriComponentsBuilder builder){
        HttpHeaders headers = new HttpHeaders();
        if(population==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.populationService.save(population);
        return new ResponseEntity<>(population, headers, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Population> deleteVirus(@PathVariable("id") Integer id){
        Population population = this.populationService.getById(id);
        if(population == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.populationService.delete(id);
        return new ResponseEntity<>(population, HttpStatus.FOUND);
    }
    @GetMapping()
    public ResponseEntity<List<Population>> getAllViruses(){
        List<Population> all = this.populationService.getAll();
        if(all.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
}
