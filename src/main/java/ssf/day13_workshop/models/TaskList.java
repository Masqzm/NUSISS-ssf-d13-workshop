package ssf.day13_workshop.models;

import java.util.LinkedList;
import java.util.List;

public class TaskList {
    private List<Task> tasks = new LinkedList<>();

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTasks(Task task) {
        this.tasks.add(task);
    }

    @Override
    public String toString() {
        return "TaskList [tasks=" + tasks + "]";
    }
}
