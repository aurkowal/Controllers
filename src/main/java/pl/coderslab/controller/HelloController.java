package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class HelloController {

    @RequestMapping("/workers")
    @ResponseBody
    public String showWorkers() {

        try {
            int draw = ThreadLocalRandom.current().nextInt(1, 31);

            File file = ResourceUtils.getFile("classpath:workers.txt");
            List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);

            String drawnName = findNameByNumber(lines, draw)
                    .orElse("Brak pracownika o numerze: " + draw);
            return drawnName;

        } catch (Exception e) {
            return "Wystąpił błąd podczas odczytu pracownika: " + e.getMessage();
        }
    }

    private Optional<String> findNameByNumber(List<String> lines, int number) {
        String target = String.valueOf(number);

        for (String raw : lines) {
            if (raw == null) continue;
            String line = raw.trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split(",", 2);
            if (parts.length < 2) continue;

            String left = parts[0].trim();
            String right = parts[1].trim();

            try {
                int id = Integer.parseInt(left);
                if (id == number) {
                    return Optional.of(right);
                }
            } catch (NumberFormatException ignored) {

            }
        }
        return Optional.empty();
    }
}
