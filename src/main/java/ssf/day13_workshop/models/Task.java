package ssf.day13_workshop.models;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.constraints.*;

public class Task {
    @NotNull(message="Task name cannot be empty")
	@NotEmpty(message="Task name cannot be empty")
	@Size(min=5, message="Task name must be at least 5 characters long")
    private String name;

    private String priority;

    @DateTimeFormat(pattern="yyyy-MM-dd")
	@FutureOrPresent(message="Must be current or a future date")
	private Date dueDate;
    
    @Override
    public String toString() {
        return "Task [name=" + name + ", priority=" + priority + ", dueDate=" + dueDate + "]";
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
    public Date getDueDate() {
        return dueDate;
    }
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
