package by.g00dc4t.spring.library.controller;

import by.g00dc4t.spring.library.entity.Person;
import by.g00dc4t.spring.library.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/people")
public class PeopleController {
    @Autowired
    private PersonService peopleService;

    @RequestMapping("")
    public String showAllPeople(Model model) {
        model.addAttribute("people", peopleService.getAllPersons());
        return "people/all-people";
    }

    @RequestMapping("/new")
    public String addNewPeople(Model model) {
        model.addAttribute("person", new Person());
        return "people/people-info";
    }

    @RequestMapping("/save")
    public String savePeople(@ModelAttribute("person") Person person) {
        peopleService.savePerson(person);
        return "redirect:/people";
    }

    @RequestMapping("/{id}")
    public String showPeople(@PathVariable("id") int id, Model model) {
        Person people = peopleService.getPerson(id);
        model.addAttribute("people", people);
        return "people/people-view";
    }

    @RequestMapping("/{id}/edit")
    public String updatePeople(@PathVariable("id") int id, Model model) {
        Person person = peopleService.getPerson(id);
        model.addAttribute("person", person);
        return "people/people-info";
    }

    @RequestMapping("/{id}/delete")
    public String deletePeople(@PathVariable("id") int id) {
        peopleService.deletePerson(id);
        return "redirect:/people";
    }
}
