package ssf.day13_workshop.controllers;

import java.util.List;
import java.util.logging.Logger;

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

    // For debugging purposes, get the logger. Logger's name = class name
    private final Logger logger = Logger.getLogger(SaveController.class.getName());

    @PostMapping
    public String postSave(HttpSession sess, Model model) {
        
       //Process POST request
       // Clear session
       List<Task> taskList = (List<Task>)sess.getAttribute(ATTR_TASKLIST);

       //System.out.printf(">>> tasklist: %s\n", taskList);
       logger.info("Task list: %s".formatted(taskList));
       logger.info("Session closed.");

       // Destroy the3 session
       sess.invalidate();

       // Create new task obj for form in index
       model.addAttribute(ATTR_TASK, new Task());
       
       return "index";
   }
}
