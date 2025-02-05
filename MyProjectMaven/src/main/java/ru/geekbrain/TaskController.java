package ru.geekbrain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;
    private final TaskManager taskManager;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return new ResponseEntity<>(taskService.createTask(task), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id)
                .map(task -> ResponseEntity.ok(task))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        Task task = taskService.updateTask(id, updatedTask);
        return task != null ? ResponseEntity.ok(task) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
    private final TaskManager taskManager;

    @Autowired
    public TaskController(TaskManager taskManager) {
        this.taskManager = taskManager;
        taskManager.addObserver(new TaskLogger()); // Добавляем наблюдателя
    }

    @PostMapping("/regular")
    public void addRegularTask(@RequestParam String description) {
        TaskFactory factory = new RegularTaskFactory();
        Task task = factory.createTask(description);
        taskManager.addTask(task);
    }

    @PostMapping("/urgent")
    public void addUrgentTask(@RequestParam String description) {
        TaskFactory factory = new UrgentTaskFactory();
        Task task = factory.createTask(description);
        taskManager.addTask(task);
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskManager.getTasks();
    }


}
