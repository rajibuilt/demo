package com.Rajibuilt.demo.api;

import com.Rajibuilt.demo.model.Person;
import com.Rajibuilt.demo.model.PersonService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    private void addPerson( @Valid @NotNull @RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }
    @GetMapping(path="/{id}")
    public Person getPersonByID(@PathVariable("id") UUID id){
        return personService.getPersonById(id).orElse(null);

    }

    @DeleteMapping(path="{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
        personService.deletePerson(id);
    }

    @PutMapping(path="{id}")
    public void updatePerson(@PathVariable("id") UUID id, @Valid @NotNull  @RequestBody Person personToUpdate){
        personService.updatePerson(id, personToUpdate);
    }
}
