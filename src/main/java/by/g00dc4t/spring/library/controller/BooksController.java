package by.g00dc4t.spring.library.controller;

import by.g00dc4t.spring.library.entity.Book;
import by.g00dc4t.spring.library.entity.Person;
import by.g00dc4t.spring.library.service.BooksService;
import by.g00dc4t.spring.library.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BooksService booksService;
    @Autowired
    private PersonService peopleService;

    @RequestMapping("")
    public String showAllBooks(Model model) {
        model.addAttribute("books", booksService.getAllBooks());
        return "book/all-books";
    }

    @RequestMapping("/new")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "book/book-info";
    }

    @RequestMapping("/{id}/edit")
    public String updateBook(@PathVariable("id") int id, Model model) {
        Book book = booksService.getBook(id);
        model.addAttribute("book", book);
        return "book/book-info";
    }

    @RequestMapping("/save")
    public String saveBook(@ModelAttribute("book") Book book) {
        booksService.saveBook(book);
        return "redirect:/books";
    }

    @RequestMapping("/{id}")
    public String showBook(@PathVariable("id") int id, Model model) {
        Book book = booksService.getBook(id);
        model.addAttribute("book", book);
        model.addAttribute("person", new Person());
        model.addAttribute("peoples", peopleService.getAllPersons());
        return "book/book-view";
    }

    @RequestMapping("/{id}/delete")
    public String deleteBook(@PathVariable("id") int id) {
        booksService.deleteBook(id);
        return "redirect:/books";
    }

    @RequestMapping("/{id}/assign")
    public String assignBook(@ModelAttribute("person") Person person, @PathVariable("id") int bookId,
                             Model model, BindingResult bindingResult) {
        Book book = booksService.getBook(bookId);
        book.setPerson(peopleService.getPerson(person.getId()));
        booksService.saveBook(book);
        model.addAttribute("book", book);
        model.addAttribute("peoples", peopleService.getAllPersons());
        return "book/book-view";
    }

    @RequestMapping("/{id}/release")
    public String releaseBook(@PathVariable("id") int id, Model model) {
        Book book = booksService.getBook(id);
        book.setPerson(null);
        booksService.saveBook(book);
        model.addAttribute("book", book);
        model.addAttribute("person", new Person());
        model.addAttribute("peoples", peopleService.getAllPersons());
        return "book/book-view";
    }

}
