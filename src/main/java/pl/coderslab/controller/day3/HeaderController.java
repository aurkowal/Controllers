package pl.coderslab.controller.day3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HeaderController {
    @GetMapping("/showUserAgent")
    @ResponseBody
    public String showUserAgent(@RequestHeader(name = "User-Agent", required = false) String userAgent) {

        if (userAgent == null || userAgent.isBlank()) {
            return "Nagłówek User-Agent nie został dostarczony.";
        }
        return "User-Agent: " + userAgent;

    }
}
