package com.omerkacar.tasktracer;

import com.omerkacar.tasktracer.dto.TaskDTO;
import com.omerkacar.tasktracer.model.Task;
import com.omerkacar.tasktracer.repository.TaskRepository;
import com.omerkacar.tasktracer.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private ModelMapper modelMapper; // ModelMapper'ı da taklit (mock) ediyoruz

    @InjectMocks
    private TaskService taskService;

    private Task sampleTask;
    private TaskDTO sampleTaskDTO;

    @BeforeEach
    void setUp() {
        // Test için hem Entity hem DTO örneği hazırlıyoruz
        sampleTask = new Task();
        sampleTask.setId(1L);
        sampleTask.setTitle("Test Başlığı");

        sampleTaskDTO = new TaskDTO();
        sampleTaskDTO.setId(1L);
        sampleTaskDTO.setTitle("Test Başlığı");
    }

    @Test
    void getAllTasks_ShouldReturnTaskDTOList() {
        // GIVEN
        when(taskRepository.findAll()).thenReturn(Arrays.asList(sampleTask));
        // ModelMapper'a diyoruz ki: "Herhangi bir Task nesnesini TaskDTO'ya çevirmen istenirse, bizim hazırladığımız DTO'yu dön."
        when(modelMapper.map(any(Task.class), eq(TaskDTO.class))).thenReturn(sampleTaskDTO);

        // WHEN
        List<TaskDTO> result = taskService.getAllTasks();

        // THEN
        assertEquals(1, result.size());
        assertEquals("Test Başlığı", result.get(0).getTitle());
        // Dönüş tipinin TaskDTO olduğunu teyit ediyoruz
        assertTrue(result.get(0) instanceof TaskDTO);
    }

    @Test
    void createTask_ShouldSaveAndReturnTaskDTO() {
        // GIVEN
        when(modelMapper.map(any(TaskDTO.class), eq(Task.class))).thenReturn(sampleTask);
        when(taskRepository.save(any(Task.class))).thenReturn(sampleTask);
        when(modelMapper.map(any(Task.class), eq(TaskDTO.class))).thenReturn(sampleTaskDTO);

        // WHEN
        TaskDTO createdTaskDTO = taskService.createTask(sampleTaskDTO);

        // THEN
        assertNotNull(createdTaskDTO);
        assertEquals("Test Başlığı", createdTaskDTO.getTitle());
        verify(taskRepository, times(1)).save(any(Task.class));
    }
}