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
    private static final String ALL_PEOPLE_URL = "people/all-people";
    private static final String PERSON_INFO_URL = "people/person-info";
    private static final String PERSON_VIEW_URL = "people/person-view";
    private static final String REDIRECT_TO_PEOPLE_URL = "redirect:/people";
    private static final String PEOPLE_NAME = "people";
    private static final String PERSON_NAME = "person";
    private static final String ID_NAME = "id";

    @Autowired
    private PersonService peopleService;

    @RequestMapping("")
    public String showAllPeople(Model model) {
        model.addAttribute(PEOPLE_NAME, peopleService.getAllPersons());
        return ALL_PEOPLE_URL;
    }

    @RequestMapping("/new")
    public String addNewPeople(Model model) {
        model.addAttribute(PERSON_NAME, new Person());
        return PERSON_INFO_URL;
    }

    @RequestMapping("/save")
    public String savePeople(@Valid @ModelAttribute(PERSON_NAME) Person person,
                             BindingResult bindingResult) {
        String result;
        if (bindingResult.hasErrors()) {
            result = PERSON_INFO_URL;
        } else {
            peopleService.savePerson(person);
            result = REDIRECT_TO_PEOPLE_URL;
        }
        return result;
    }

    @RequestMapping("/{id}")
    public String showPeople(@PathVariable(ID_NAME) int id, Model model) {
        Person people = peopleService.getPerson(id);
        model.addAttribute(PEOPLE_NAME, people);
        return PERSON_VIEW_URL;
    }

    @RequestMapping("/{id}/edit")
    public String updatePeople(@PathVariable(ID_NAME) int id, Model model) {
        Person person = peopleService.getPerson(id);
        model.addAttribute(PERSON_NAME, person);
        return PERSON_INFO_URL;
    }

    @RequestMapping("/{id}/delete")
    public String deletePeople(@PathVariable(ID_NAME) int id) {
        peopleService.deletePerson(id);
        return REDIRECT_TO_PEOPLE_URL;
    }
}
