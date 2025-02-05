package ru.geekbrain;

public interface TaskObserver {
    void update(Task task);
}

// Пример реализации наблюдателя
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskLogger implements TaskObserver {
    private static final Logger logger = LoggerFactory.getLogger(TaskLogger.class);

    @Override
    public void update(Task task) {
        logger.info("Task updated: " + task.getDescription());
    }
}