package com.omerkacar.tasktracer.service;

import com.omerkacar.tasktracer.dto.TaskDTO;
import com.omerkacar.tasktracer.model.Task;
import com.omerkacar.tasktracer.repository.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper; // Yeni bağımlılık

    // Constructor Injection (Spring'e diyoruz ki: Bana bir repository ver)
    public TaskService(TaskRepository taskRepository, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
    }

    public List<TaskDTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        // Entity listesini DTO listesine çeviriyoruz
        return tasks.stream()
                .map(task -> modelMapper.map(task, TaskDTO.class))
                .collect(Collectors.toList());
    }

    public TaskDTO createTask(TaskDTO taskDTO) {
        // Gelen DTO'yu veritabanına kaydetmek için Entity'ye çeviriyoruz
        Task task = modelMapper.map(taskDTO, Task.class);
        Task savedTask = taskRepository.save(task);
        // Kaydedilen veriyi tekrar DTO olarak dönüyoruz
        return modelMapper.map(savedTask, TaskDTO.class);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}