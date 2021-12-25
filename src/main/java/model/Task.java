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
    private String category;
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


    public void setCategory(String category) {
        this.category = category;
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

    public String getCategory() {
        return category;
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
        return "Title: " + title +":Id " + id +
                ",DateAndTimeOfCreation: " + dateAndTimeOfCreation +
                ",DateAndTimeOfDeadLine: " + dateAndTimeOfDeadLine +
                ",AssignedUsers: " + assignedUsers +
                ",Priority: " + priority;
    }



    public static String sortAndShow(ArrayList<Task> tasks) {
        StringBuilder stringBuilder = new StringBuilder();
        if (tasks.size()==0)
            return "no task yet";
        else {
            for (int i = 0; i < tasks.size(); i++) {
                stringBuilder.append(i).append(1).append(":").append(tasks.get(i).toString()).append("\n");
            }
            return String.valueOf(stringBuilder);
        }

    }


    public void removeUsersFromTask(ArrayList<String> users) {
        assignedUsers.removeAll(users);
    }

    public boolean isDeadlineValid(String deadLine) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd|HH:mm").parse(deadLine);
        return dateAndTimeOfCreation.compareTo(date) < 0;
    }
}
