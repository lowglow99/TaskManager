import java.time.LocalDate;

public class Task {
    private String description;
    private LocalDate dueDate;
    private boolean isCompleted;

    public Task(String description, LocalDate dueDate){
        this.description = description;
        this.dueDate = dueDate;
        this.isCompleted = false;
    }

    public Task(String description, LocalDate dueDate, boolean isCompleted){
        this.description = description;
        this.dueDate = dueDate;
        this.isCompleted = isCompleted;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate(){
        return dueDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public void markCompleted(){
        this.isCompleted = true;
    }

    @Override
    public String toString(){
        return "Task{" +
                "description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
