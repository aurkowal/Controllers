package pl.coderslab.controller.day4;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.time.LocalDateTime;

@Controller

public class SessionController {
    @GetMapping("/checkTime")
    @ResponseBody
    public String checkTimeInSession(@SessionAttribute(name = "currentTime", required = false)LocalDateTime currentTime, HttpSession session) {
        if (currentTime == null) {
            session.setAttribute("currentTime", LocalDateTime.now());
            return "Current time was set";
        }
        return currentTime.toString();
    }

}
