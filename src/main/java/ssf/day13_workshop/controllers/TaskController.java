package ssf.day13_workshop.controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import ssf.day13_workshop.models.Task;
import ssf.day13_workshop.models.TaskList;

import static ssf.day13_workshop.models.Constants.*;

@Controller
public class TaskController {
    
    // For debugging purposes, get the logger. Logger's name = class name
	private final Logger logger = Logger.getLogger(TaskController.class.getName());

    private TaskList taskList = new TaskList();

    @GetMapping({"/", "/index"})
    public String getIndex(Model model) {
        
        logger.info("Session started");

        // Create new task list ("session") on first visit to landing page
        model.addAttribute(ATTR_TASK, new Task());      // reset task form
        model.addAttribute(ATTR_TASKLIST, taskList);    

        return "index";
    }

    // POST /task
    @PostMapping("/task")
    public String postTaskAdd(@Valid @ModelAttribute Task task, BindingResult bindings,
                                // @ModelAttribute TaskList taskList,
                                Model model) {  

        // Fake business logic
		if(taskList.getTasks().size() >= 3) {
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
                taskList.addTasks(task);
            
                logger.info("Added task: %s".formatted(task));
                logger.info("Tasklist after: %s".formatted(taskList));

                model.addAttribute(ATTR_TASK, new Task());      // reset task form
            }
            else
                model.addAttribute(ATTR_TASK, task);            // update task form (shows errors if any)
        }

        model.addAttribute(ATTR_TASKLIST, taskList);    // update taskList (sess)

        return "index";
    }

    @PostMapping("/save")
    public String postTaskAdd(Model model) {  

       //Process POST request
       //System.out.printf(">>> tasklist: %s\n", taskList);
       logger.info("Task list: %s".formatted(taskList.getTasks()));
       logger.info("Session closed.");
       taskList = new TaskList();
      
        // Create new task list ("session") 
        model.addAttribute(ATTR_TASK, new Task());      // reset task form
        model.addAttribute(ATTR_TASKLIST, taskList);    // reset taskList "sess"

        return "index";
    }
}
