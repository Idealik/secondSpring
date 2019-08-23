package com.example.personal;

import com.example.personal.domain.Department;
import com.example.personal.domain.Person;
import com.example.personal.domain.Position;
import com.example.personal.repository.DepartmentRepository;
import com.example.personal.repository.PersonRepository;
import com.example.personal.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private PositionRepository positionRepository;

    @GetMapping("/main")
    public String loadMainPage(Map<String, Object> model) {
        Iterable<Department> departmentEntities = departmentRepository.findAll();
        model.put("departments", departmentEntities);
        return "main";
    }

    @GetMapping("/creationDepartment")
    public String loadCreationDepartmentPage() {
        return "creationDepartment";
    }

    @GetMapping("/departmentWorkers/{id}")
    public String loadDepartmentWorkersPage(@PathVariable("id") int id,  Map<String, Object> model) {
        model.put("name", departmentRepository.findById(id).getName());
        model.put("id", id);
        Iterable<Person> personIterable =  personRepository.findByDepartmentId(id);
        model.put("persons", personIterable);
        return "departmentWorkers";
    }

    @GetMapping("/creationPosition")
    public String loadCreationPositionPage(Map<String, Object> model) {
        Iterable<Position> positionIterable = positionRepository.findAll();
        model.put("positions", positionIterable);
        return "creationPosition";
    }

    @GetMapping("/creationWorker/{id}")
    public String loadCreationWorkerPage(@PathVariable("id") int id, Map<String, Object> model) {
        Iterable<Position> positionIterable = positionRepository.findAll();
        model.put("id", id);
        model.put("positions", positionIterable);
        return "creationWorker";
    }

    @PostMapping("/addWorker")
    public String addWorker(@ModelAttribute Person person) {
        personRepository.save(person);
        return "redirect:/main";
    }

    @PostMapping("/addPosition")
    public String addPosition(@ModelAttribute Position position) {
        positionRepository.save(position);
        return "redirect:/creationPosition";
    }

    @PostMapping("/addDepartment")
    public String saveItem(@ModelAttribute Department department) {
        departmentRepository.save(department);
        return "redirect:/main";
    }

    @GetMapping("/moreInfoAboutPerson/{id}")
    public String loadMoreInfoAboutPersonPage(@PathVariable("id") int id, Map<String, Object> model) {
        Person person = personRepository.getById(id);
        model.put("person", person);
        model.put("position",positionRepository.findById(person.getPosition().getId()));
        model.put("department", departmentRepository.findById(person.getDepartment().getId()));

        return "moreInfoAboutPerson";
    }

    @PostMapping("/deletePerson")
    public String deletePerson(@RequestParam int id) {
        personRepository.deleteById(id);
        return "redirect:/main";
    }


}