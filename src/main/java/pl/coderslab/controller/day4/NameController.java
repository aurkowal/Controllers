package pl.coderslab.controller.day4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NameController {
    @GetMapping(path = "/hello/{firstName}/{lastName}", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String getName(@PathVariable("firstName") String firstname, @PathVariable("lastName") String lastname) {
        return "Witaj " + firstname + " " + lastname;
    }
}
