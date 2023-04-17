package com.quality.demo.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quality.demo.model.Person;
import com.quality.demo.service.PersonService;

@RestController
@RequestMapping ("/persona/")
public class PersonREST {

    @Autowired
    private PersonService personService;

    @GetMapping
    private ResponseEntity<List<Person>> getAllPersonas (){
        return ResponseEntity.ok(personService.findAll());
    }

    @PostMapping
    private ResponseEntity<Person> savePersona (@RequestBody Person person){
        
        try {
            Person personaGuardada = personService.save(person);
            return ResponseEntity.created(new URI("/persona/"+personaGuardada.getId())).body(personaGuardada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    @DeleteMapping (value = "delete/{id}")
    private ResponseEntity<Boolean> deletePersona (@PathVariable ("id") Long id){
        personService.deleteById(id);
        return ResponseEntity.ok(!(personService.findById(id)!=null));

    }
}
