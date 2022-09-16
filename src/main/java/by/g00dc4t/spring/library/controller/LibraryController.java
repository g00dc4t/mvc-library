package by.g00dc4t.spring.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LibraryController {
    private static final String FIRST_VIEW_NAME = "first-library-view";

    @RequestMapping("/")
    public String getFirstView() {
        return FIRST_VIEW_NAME;
    }
}
