package ssf.day13_workshop.models;

public class Task {
    private String name;
    private String priority;
    private String date;
    
    @Override
    public String toString() {
        return "Task [name=" + name + ", priority=" + priority + ", date=" + date + "]";
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPriority() {
        return priority;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
}
