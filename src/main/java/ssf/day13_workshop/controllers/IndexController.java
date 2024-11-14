package ssf.day13_workshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import ssf.day13_workshop.models.Task;
import static ssf.day13_workshop.models.Constants.*;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping(path={"/", "index.html"})
public class IndexController {
    
    @GetMapping
    public String getIndex(HttpSession sess, Model model) {
        
        // Check if session is avail
        List<Task> taskList = (List<Task>)sess.getAttribute(TASK_LIST);
        if (taskList == null) {
            // Initialize session by creating a list
            taskList = new LinkedList<>();
            // Add to the session
            sess.setAttribute(TASK_LIST, taskList);
        }

        model.addAttribute("task", new Task());
        model.addAttribute(TASK_LIST, taskList);

        return "index";
    }
}
