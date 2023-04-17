package org.j2os.classFinal.api;

import org.j2os.classFinal.domain.Person;
import org.j2os.classFinal.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/person")
public class PersonAPI {
    @Autowired
    private PersonService personService;

    @GetMapping("/save")
    public Person save(HttpServletRequest request) {
        Person person = new Person();
        person.setName(request.getParameter("name"));
        person.setFamily(request.getParameter("family"));
        person.setCarId(Long.valueOf(request.getParameter("carid")));
        return personService.save(person);
    }

    @GetMapping("/findByName")
    public Object find(HttpServletRequest request) {
        Person person = new Person();
        person.setName(request.getParameter("name"));
        return personService.findByName(person);
    }

//    @GetMapping("/findById")
//    public Object find2(HttpServletRequest request) {
//        Person person = new Person();
//        person.setId(Long.valueOf(request.getParameter("id")));
//        return personService.findById(person);
//    }
}
