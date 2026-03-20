package pl.coderslab.controller.pracadomowa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.TaskManager.Task;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TaskController {

    private List<Task> tasks = new ArrayList<>();

    @RequestMapping("/addTask")
    @ResponseBody
    public String addTask(@RequestParam("id") long id, @RequestParam("title") String title) {
        Task task = new Task();
        task.setId(id);
        task.setTitle(title);
        tasks.add(task);
        return tasks.toString();

    }

    @RequestMapping("removeTask")
    @ResponseBody
    public String removeTask(@RequestParam("id") long id) {
        tasks.removeIf(task -> task.getId() == id);
        return tasks.toString();
    }

}
