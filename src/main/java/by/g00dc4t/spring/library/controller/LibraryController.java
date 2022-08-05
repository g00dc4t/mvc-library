package by.g00dc4t.spring.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LibraryController {
    @RequestMapping("/")
    public String getFirstView() {
        return "first-library-view";
    }
}
