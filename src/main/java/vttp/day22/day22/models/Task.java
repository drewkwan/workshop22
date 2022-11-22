package vttp.day22.day22.models;

public class Task {

    public String taskId;
    public String taskName;
    public String assignTo;
    public String priority;
    public String completionDate;

    //assignTo should be a User class instead of a String to create a relationship

    public String getTaskId() {
        return taskId;
    }
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
    public String getTaskName() {
        return taskName;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public String getAssignTo() {
        return assignTo;
    }
    public void setAssignTo(String assignTo) {
        this.assignTo = assignTo;
    }
    public String getPriority() {
        return priority;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
    public String getCompletionDate() {
        return completionDate;
    }
    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }
}
