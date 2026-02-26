package com.omerkacar.tasktracer.controller;

import com.omerkacar.tasktracer.dto.TaskDTO;
import com.omerkacar.tasktracer.model.Task;
import com.omerkacar.tasktracer.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Bu sınıfın bir REST API olduğunu belirtir



@RequestMapping("/api/tasks") // Bu controller'daki tüm isteklere "/api/tasks" ile başla der
public class TaskController {

    private final TaskService taskService;

    // Yine Constructor Injection! Spring bize otomatik olarak servisi verecek.
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Tüm görevleri getir: GET http://localhost:8080/api/tasks
    @GetMapping
    public List<TaskDTO> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping
    public TaskDTO createTask(@Valid @RequestBody TaskDTO taskDTO) {
        return taskService.createTask(taskDTO);
    }

    // Görev sil: DELETE http://localhost:8080/api/tasks/{id}
    @Operation(summary = "ID'ye göre görevi siler")
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}