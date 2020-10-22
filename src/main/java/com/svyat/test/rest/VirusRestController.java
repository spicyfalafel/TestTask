package com.svyat.test.rest;

import com.svyat.test.model.Virus;
import com.svyat.test.service.VirusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/viruses/")
public class VirusRestController {

    @Autowired
    private VirusService virusService;

    @GetMapping("{id}")
    public ResponseEntity<Virus> getVirus(@PathVariable("id") Integer id){
        if( id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Virus virus = this.virusService.getById(id);
        if(virus == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(virus, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Virus> saveVirus(@RequestBody @Valid Virus virus){
        HttpHeaders headers = new HttpHeaders();
        if(virus == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.virusService.save(virus);
        return new ResponseEntity<>(virus, headers, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<List<Virus>> saveAll(@RequestBody @Valid List<Virus> viruses){
        HttpHeaders headers = new HttpHeaders();
        if(viruses == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.virusService.saveAll(viruses);
        return new ResponseEntity<>(viruses, headers, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Virus> updateVirus(@RequestBody @Valid Virus virus, UriComponentsBuilder builder){
        HttpHeaders headers = new HttpHeaders();
        if(virus==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.virusService.save(virus);
        return new ResponseEntity<>(virus, headers, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Virus> deleteVirus(@PathVariable("id") Integer id){
        Virus virus = this.virusService.getById(id);
        if(virus == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.virusService.delete(id);
        return new ResponseEntity<>(virus, HttpStatus.FOUND);
    }
    @GetMapping()
    public ResponseEntity<List<Virus>> getAllViruses(){
        List<Virus> all = this.virusService.getAll();
        if(all.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
}

