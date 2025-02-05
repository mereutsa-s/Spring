package ru.geekbrain;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskManager {
    private static TaskManager instance;
    private final List<Task> tasks = new ArrayList<>();
    private final List<TaskObserver> observers = new ArrayList<>();

    private TaskManager() { }

    public static synchronized TaskManager getInstance() {
        if (instance == null) {
            instance = new TaskManager();
        }
        return instance;
    }

    public void addTask(Task task) {
        tasks.add(task);
        notifyObservers(task);
    }

    public void addObserver(TaskObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(Task task) {
        for (TaskObserver observer : observers) {
            observer.update(task);
        }
    }

    public List<Task> getTasks() {
        return tasks;
    }
}