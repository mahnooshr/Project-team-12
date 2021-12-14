package model;

import java.util.HashMap;

public class Task {
    private static HashMap<Long,Task>tasks = new HashMap<>();
    private long id;
    private String title;
    private String description;
    private String dateAndTimeOfCreation;
    private String dateAndTimeOfDeadLine;
    private String comments;
    private Priority priority;

    public Task(Priority priority, String comments, String dateAndTimeOfCreation, String dateAndTimeOfDeadLine, String title) {
        this.priority = priority;
        this.comments = comments;
        this.dateAndTimeOfCreation = dateAndTimeOfCreation;
        this.dateAndTimeOfDeadLine = dateAndTimeOfDeadLine;
        this.title = title;
        this.id = IDGenerator.nextId();
        tasks.put(id,this);
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setDateAndTimeOfCreation(String dateAndTimeOfCreation) {
        this.dateAndTimeOfCreation = dateAndTimeOfCreation;
    }

    public void setDateAndTimeOfDeadLine(String dateAndTimeOfDeadLine) {
        this.dateAndTimeOfDeadLine = dateAndTimeOfDeadLine;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    public String getDateAndTimeOfCreation() {
        return dateAndTimeOfCreation;
    }

    public String getDateAndTimeOfDeadLine() {
        return dateAndTimeOfDeadLine;
    }

    public String getTitle() {
        return title;
    }

    public String getComments() {
        return comments;
    }

    enum Priority {
        Highest,
        High,
        Low,
        Lowest
    }

}
