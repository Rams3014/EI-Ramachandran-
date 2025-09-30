public class ConsoleObserver implements ConflictObserver {
    @Override
    public void notifyConflict(Task newTask, Task existingTask) {
        System.out.println("⚠ Conflict detected: " + newTask.getDescription() +
                           " overlaps with " + existingTask.getDescription());
    }
}
