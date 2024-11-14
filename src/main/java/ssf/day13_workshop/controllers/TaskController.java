package ssf.day13_workshop.controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import ssf.day13_workshop.models.Task;
import static ssf.day13_workshop.models.Constants.*;

@Controller
@RequestMapping("/task")
public class TaskController {

    // POST /task
    @PostMapping
    public String postTaskAdd(
        @ModelAttribute Task task,
        Model model, HttpSession sess) {
        
        // Check if session is avail
        List<Task> taskList = (List<Task>)sess.getAttribute(TASK_LIST);
        if (taskList == null) {
            // Initialize session by creating a list
            taskList = new LinkedList<>();
            // Add to the session
            sess.setAttribute(TASK_LIST, taskList);
        }
        // Add task to session
        taskList.add(task);

        System.out.printf("task: %s\n", task);


        // Add task, taskList (sess) to model
        model.addAttribute("task", task);
        model.addAttribute(TASK_LIST, taskList);

        return "index";
    }
}
