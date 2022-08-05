package by.g00dc4t.spring.library.controller;

import by.g00dc4t.spring.library.entity.People;
import by.g00dc4t.spring.library.service.PeopleService;
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
    private PeopleService peopleService;

    @RequestMapping("")
    public String showAllPeople(Model model) {
        model.addAttribute("people", peopleService.getAllPeople());
        return "people/all-people";
    }

    @RequestMapping("/new")
    public String addNewPeople(Model model) {
        model.addAttribute("people", new People());
        return "people/people-info";
    }

    @RequestMapping("/save")
    public String savePeople(@ModelAttribute("people") People people) {
        peopleService.savePeople(people);
        return "redirect:/people";
    }

    @RequestMapping("/{id}")
    public String showPeople(@PathVariable("id") int id, Model model) {
        People people = peopleService.getPeople(id);
        model.addAttribute("people", people);
        return "people/people-view";
    }

    @RequestMapping("/{id}/edit")
    public String updatePeople(@PathVariable("id") int id, Model model) {
        People people = peopleService.getPeople(id);
        model.addAttribute("people", people);
        return "people/people-info";
    }

    @RequestMapping("/{id}/delete")
    public String deletePeople(@PathVariable("id") int id) {
        peopleService.deletePeople(id);
        return "redirect:/people";
    }
}
