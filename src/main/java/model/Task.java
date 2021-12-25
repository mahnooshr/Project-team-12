package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Task {
    private static HashMap<Long, Task> tasks = new HashMap<>();
    private String leader;
    private long id;
    private String title;
    private String description;
    private Date dateAndTimeOfCreation;
    private Date dateAndTimeOfDeadLine;
    private String comments;
    private Priority priority;
    private final ArrayList<String> assignedUsers = new ArrayList<>();

    public Task(Priority priority, String comments, String dateAndTimeOfCreation, String dateAndTimeOfDeadLine, String title,String leader) throws ParseException {
        setPriority(priority);
        setComments(comments);
        setDateAndTimeOfCreation(new SimpleDateFormat("yyyy-MM-dd|HH:mm").parse(dateAndTimeOfCreation));
        setDateAndTimeOfDeadLine(new SimpleDateFormat("yyyy-MM-dd|HH:mm").parse(dateAndTimeOfDeadLine));
        setTitle(title);
        setLeader(leader);
        setId(IDGenerator.nextId());
        tasks.put(id, this);
    }

    public Task() {

    }

    public void setId(long id) {
        this.id = id;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setDateAndTimeOfCreation(Date dateAndTimeOfCreation) {
        this.dateAndTimeOfCreation = dateAndTimeOfCreation;
    }

    public void setDateAndTimeOfDeadLine(Date dateAndTimeOfDeadLine) {
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

    public Date getDateAndTimeOfCreation() {
        return dateAndTimeOfCreation;
    }

    public Date getDateAndTimeOfDeadLine() {
        return dateAndTimeOfDeadLine;
    }

    public String getTitle() {
        return title;
    }

    public String getComments() {
        return comments;
    }

    public ArrayList<String> getAssignedUsers() {
        return assignedUsers;
    }

    public static Task getTaskById(long id) {
        return tasks.get(id);
    }

    public void addUsersToTask(ArrayList<String> names) {
        assignedUsers.addAll(names);
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getLeader() {
        return leader;
    }

    public static void setTasks(HashMap<Long, Task> tasks) {
        Task.tasks = tasks;
    }

    public static HashMap<Long, Task> getTasks() {
        return tasks;
    }

    @Override
    public String toString() {
        return "Task{ " + "\n" +
                "Id= " + id + "\n" +
                "Title= " + title + "\n" +
                "Description= " + description + "\n" +
                "DateAndTimeOfCreation= " + dateAndTimeOfCreation + "\n" +
                "DateAndTimeOfDeadLine= " + dateAndTimeOfDeadLine + "\n" +
                "Comments= " + comments + "\n" +
                "Priority= " + priority + "\n" +
                "AssignedUsers= " + assignedUsers + "\n" +
                '}';
    }

    public void removeUsersFromTask(ArrayList<String> users) {
        assignedUsers.removeAll(users);
    }

    public boolean isDeadlineValid(String deadLine) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd|HH:mm").parse(deadLine);
        return dateAndTimeOfCreation.compareTo(date) < 0;
    }
}
