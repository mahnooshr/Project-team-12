package model;

import org.junit.Test;

public class Task {
    private long id;
    private String title;
    private String description;
    private String dateAndTimeOfCreation;
    private String dateAndTimeOfDeadLine;
    private StringBuilder comments;
    private Priority priority;

    public Task() {
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setComments(StringBuilder comments) {
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

    public StringBuilder getComments() {
        return comments;
    }

    enum Priority {
        Highest,
        High,
        Low,
        Lowest
    }

}
