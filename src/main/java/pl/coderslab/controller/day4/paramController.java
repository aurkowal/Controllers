package pl.coderslab.controller.day4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/first")
public class paramController {

    private static final DateTimeFormatter DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @PostMapping(path = "/form", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String showInfo(@RequestParam("paramName") String paramName, @RequestParam("paramDate") String paramDate) {
        LocalDate date = LocalDate.parse(paramDate, DATE);
        return paramName + " - " + date;
    }
}