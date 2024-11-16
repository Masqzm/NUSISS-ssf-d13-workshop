package ssf.day13_workshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import ssf.day13_workshop.models.Task;
import static ssf.day13_workshop.models.Constants.*;

import java.util.List;

@Controller
@RequestMapping(path={"/", "index.html"})
public class IndexController {
    
    @GetMapping
    public String getIndex(HttpSession sess, Model model) {
        
        // Get taskList from current session (if avail)
        List<Task> taskList = getTaskListSess(sess);

        model.addAttribute(ATTR_TASK, new Task());
        model.addAttribute(ATTR_TASKLIST, taskList);

        return "index";
    }
}
