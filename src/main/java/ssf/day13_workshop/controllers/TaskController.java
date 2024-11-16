package ssf.day13_workshop.controllers;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import ssf.day13_workshop.models.Task;
import static ssf.day13_workshop.models.Constants.*;

@Controller
@RequestMapping("/task")
public class TaskController {
    
    // For debugging purposes, get the logger. Logger's name = class name
	private final Logger logger = Logger.getLogger(TaskController.class.getName());

    // POST /task
    @PostMapping
    public String postTaskAdd(@Valid @ModelAttribute Task task, BindingResult bindings,
                                Model model, HttpSession sess) {        
        // Get taskList from current session (if avail)
        List<Task> taskList = getTaskListSess(sess);

        // Fake business logic
		if(taskList.size() >= 3) {
			logger.warning("Free tier user is trying to create more than 3 tasks");
			ObjectError err = new ObjectError(  "globalError", 
                                                "You are on free tier. You cannot have more than 2 tasks");
			bindings.addError(err);
		}
        else
        {
            // Add task to session
            // Check if POST form is free from errors
            if(!bindings.hasErrors())
            {
                taskList.add(task);
            
                logger.info("Added task: %s".formatted(task));
                // System.out.printf("Added task: %s\n", task);
            }
        }

        // Add task, taskList (sess) to model
        model.addAttribute(ATTR_TASK, task);
        model.addAttribute(ATTR_TASKLIST, taskList);

        return "index";
    }
}
