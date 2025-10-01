import java.util.*;

public class ScheduleManager {
    private static ScheduleManager instance;
    private List<Task> tasks;
    private List<ConflictObserver> observers;

    private ScheduleManager() {
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

 
    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addObserver(ConflictObserver observer) {
        observers.add(observer);
    }

    public void addTask(Task task) {
        for (Task t : tasks) {
            if (overlaps(t, task)) {
                for (ConflictObserver o : observers) {
                    o.notifyConflict(task, t);
                }
                return;
            }
        }
        tasks.add(task);
        System.out.println("✅ Task added successfully: " + task);
    }

    public void removeTask(String description) {
        tasks.removeIf(t -> t.getDescription().equalsIgnoreCase(description));
        System.out.println("🗑 Task removed (if it existed): " + description);
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
            return;
        }
        tasks.sort(Comparator.comparing(Task::getStartTime));
        for (Task t : tasks) {
            System.out.println(t);
        }
    }

    private boolean overlaps(Task t1, Task t2) {
        return t1.getStartTime().compareTo(t2.getEndTime()) < 0 &&
               t2.getStartTime().compareTo(t1.getEndTime()) < 0;
    }
}

