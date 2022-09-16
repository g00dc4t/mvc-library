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

import javax.validation.Valid;

@Controller
@RequestMapping("/books")
public class BooksController {
    private static final String ALL_BOOKS_URL = "books/all-books";
    private static final String BOOK_INFO_URL = "books/book-info";
    private static final String BOOK_VIEW_URL = "books/book-view";
    private static final String REDIRECT_TO_BOOKS_URL = "redirect:/books";
    private static final String BOOKS_NAME = "books";
    private static final String BOOK_NAME = "book";
    private static final String PEOPLE_NAME = "people";
    private static final String PERSON_NAME = "person";
    private static final String ID_NAME = "id";

    @Autowired
    private BooksService booksService;
    @Autowired
    private PersonService peopleService;

    @RequestMapping("")
    public String showAllBooks(Model model) {
        model.addAttribute(BOOKS_NAME, booksService.getAllBooks());
        return ALL_BOOKS_URL;
    }

    @RequestMapping("/new")
    public String addBook(Model model) {
        model.addAttribute(BOOK_NAME, new Book());
        return BOOK_INFO_URL;
    }

    @RequestMapping("/{id}/edit")
    public String updateBook(@PathVariable(ID_NAME) int id, Model model) {
        Book book = booksService.getBook(id);
        model.addAttribute(BOOK_NAME, book);
        return BOOK_INFO_URL;
    }

    @RequestMapping("/save")
    public String saveBook(@Valid @ModelAttribute(BOOK_NAME) Book book,
                           BindingResult bindingResult) {
        String result;
        if (bindingResult.hasErrors()) {
            result = BOOK_INFO_URL;
        } else {
            booksService.saveBook(book);
            result = REDIRECT_TO_BOOKS_URL;
        }
        return result;
    }

    @RequestMapping("/{id}")
    public String showBook(@PathVariable(ID_NAME) int id, Model model) {
        Book book = booksService.getBook(id);
        model.addAttribute(BOOK_NAME, book);
        model.addAttribute(PERSON_NAME, new Person());
        model.addAttribute(PEOPLE_NAME, peopleService.getAllPersons());
        return BOOK_VIEW_URL;
    }

    @RequestMapping("/{id}/delete")
    public String deleteBook(@PathVariable(ID_NAME) int id) {
        booksService.deleteBook(id);
        return REDIRECT_TO_BOOKS_URL;
    }

    @RequestMapping("/{id}/assign")
    public String assignBook(@ModelAttribute(PERSON_NAME) Person person,
                             @PathVariable(ID_NAME) int bookId, Model model) {
        Book book = booksService.getBook(bookId);
        book.setPerson(peopleService.getPerson(person.getId()));
        booksService.saveBook(book);
        model.addAttribute(BOOK_NAME, book);
        model.addAttribute(PEOPLE_NAME, peopleService.getAllPersons());
        return BOOK_VIEW_URL;
    }

    @RequestMapping("/{id}/release")
    public String releaseBook(@PathVariable(ID_NAME) int id, Model model) {
        Book book = booksService.getBook(id);
        book.setPerson(null);
        booksService.saveBook(book);
        model.addAttribute(BOOK_NAME, book);
        model.addAttribute(PERSON_NAME, new Person());
        model.addAttribute(PEOPLE_NAME, peopleService.getAllPersons());
        return BOOK_VIEW_URL;
    }

}
