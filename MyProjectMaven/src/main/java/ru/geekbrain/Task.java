package ru.geekbrain;

import javax.persistence.*;
import java.time.LocalDateTime;

//@Entity
//@Table(name = "tasks")
//public class Task {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false)
//    private String description;
//
//    @Enumerated(EnumType.STRING)
//    private TaskStatus status;
//
//    private LocalDateTime createdDate;
//
//    public Task() {
//        this.createdDate = LocalDateTime.now(); // Устанавливаем дату создания по умолчанию
//    }
//
//    // Геттеры и сеттеры
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public TaskStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(TaskStatus status) {
//        this.status = status;
//    }
//
//    public LocalDateTime getCreatedDate() {
//        return createdDate;
//    }
//}
//
//enum TaskStatus {
//    NOT_STARTED,
//    IN_PROGRESS,
//    COMPLETED
//}
public interface Task {
    String getDescription();
}

public class RegularTask implements Task {
    private final String description;

    public RegularTask(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return "Regular Task: " + description;
    }
}

public class UrgentTask implements Task {
    private final String description;

    public UrgentTask(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return "Urgent Task: " + description;
    }
}

public interface TaskFactory {
    Task createTask(String description);
}

public class RegularTaskFactory implements TaskFactory {
    @Override
    public Task createTask(String description) {
        return new RegularTask(description);
    }
}

public class UrgentTaskFactory implements TaskFactory {
    @Override
    public Task createTask(String description) {
        return new UrgentTask(description);
    }
}
