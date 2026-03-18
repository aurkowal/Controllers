package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class RandomController {
    Random random = new Random();
    
    @RequestMapping("/show-random")
    @ResponseBody
    public String showRandom() {

        int randomNumber = random.nextInt(100) + 1;
        return "Wylosowano liczbe " + randomNumber;
    }

}
