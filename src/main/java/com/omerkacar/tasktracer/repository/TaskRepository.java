package com.omerkacar.tasktracer.repository;

import com.omerkacar.tasktracer.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Şaka gibi ama bitti!
    // JpaRepository<Task, Long> sayesinde;
    // save(), findAll(), findById(), deleteById() gibi tüm metodlar hazır geldi.
}