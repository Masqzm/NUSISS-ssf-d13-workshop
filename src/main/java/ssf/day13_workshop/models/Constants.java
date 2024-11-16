package ssf.day13_workshop.models;

import java.util.LinkedList;
import java.util.List;

import jakarta.servlet.http.HttpSession;

public class Constants {
    public static final String ATTR_TASK = "task";
    public static final String ATTR_TASKLIST = "taskList";

    // Fn. to get taskList from current session
    public static List<Task> getTaskListSess(HttpSession sess) {

        List<Task> taskList = (List<Task>) sess.getAttribute(ATTR_TASKLIST);

        // Check if session is avail
        if (taskList == null) {
            // Initialize session by creating a list
            taskList = new LinkedList<>();
            // Add to the session
            sess.setAttribute(ATTR_TASKLIST, taskList);
        }

        return taskList;
    }
}
