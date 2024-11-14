package ssf.day13_workshop.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import ssf.day13_workshop.models.Task;
import static ssf.day13_workshop.models.Constants.*;

@Controller
@RequestMapping("/save")
public class SaveController {
    @PostMapping
    public String postSave(HttpSession sess, Model model) {
       //Process POST request
       // Clear session
       List<Task> taskList = (List<Task>)sess.getAttribute(TASK_LIST);

       System.out.printf(">>> tasklist: %s\n", taskList);

       // Destroy the3 session
       sess.invalidate();

       model.addAttribute("task", new Task());
       
       return "save";
   }
}
