package pl.coderslab.controller.day4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class RandomController2 {

    private final Random RANDOM_GENERATOR = new Random();

    @GetMapping(path = "/random/{max:\\d+}", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String getRandom(@PathVariable("max") int max) {
        int randomNumber = RANDOM_GENERATOR.nextInt(max) + 1;
        return "Użytkownik podał wartość " + max + ". Wylosowano liczbę: " + randomNumber;
    }

    @GetMapping(path = "/random/{min}/{max}", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String getRandomMinMax(@PathVariable("min") int min, @PathVariable("max") int max) {
        int randomNumber = RANDOM_GENERATOR.nextInt(max - min + 1) + min;
        return "Użytkownik podał wartość " + min + " i " + max + ". Wylosowano liczbę: " + randomNumber;
    }

//    @GetMapping("/**")
//    public String catchAll() {
//	return "redirect:/";
//    }

    @GetMapping("/")
    @ResponseBody
    public String homePage() {
        return "Welcome to home page";
    }
}