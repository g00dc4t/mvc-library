package by.g00dc4t.spring.library.controller;

import by.g00dc4t.spring.library.entity.Person;
import by.g00dc4t.spring.library.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


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
        return "people/person-info";
    }

    @RequestMapping("/save")
    public String savePeople(@Valid @ModelAttribute("person") Person person,
                             BindingResult bindingResult) {
        String result;
        if (bindingResult.hasErrors()) {
            result = "people/person-info";
        } else {
            peopleService.savePerson(person);
            result = "redirect:/people";
        }
        return result;
    }

    @RequestMapping("/{id}")
    public String showPeople(@PathVariable("id") int id, Model model) {
        Person people = peopleService.getPerson(id);
        model.addAttribute("people", people);
        return "people/person-view";
    }

    @RequestMapping("/{id}/edit")
    public String updatePeople(@PathVariable("id") int id, Model model) {
        Person person = peopleService.getPerson(id);
        model.addAttribute("person", person);
        return "people/person-info";
    }

    @RequestMapping("/{id}/delete")
    public String deletePeople(@PathVariable("id") int id) {
        peopleService.deletePerson(id);
        return "redirect:/people";
    }
}
