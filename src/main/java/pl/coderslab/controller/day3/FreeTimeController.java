package pl.coderslab.controller.day3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

@Controller
public class FreeTimeController {

    @RequestMapping("/freetime")
    @ResponseBody
    public String showRandom() {
        LocalDate date = LocalDate.now();
        DayOfWeek day = date.getDayOfWeek();
        String dayName = day.toString();
        LocalTime time = LocalTime.now();

        LocalTime start = LocalTime.of(9, 0);
        LocalTime end = LocalTime.of(17, 0);

        boolean atWork = time.isAfter(start) && time.isBefore(end);

        if (dayName.equals("SUNDAY") || dayName.equals("SATURDAY")){
            return "WOLNE";
        } else {
            if (atWork) {
                return "Pracuje, nie dzwon!!!";
            }
            return "Po pracy";
        }

    }
}
