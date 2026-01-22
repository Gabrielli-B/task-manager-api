package com.gabrielli.task_manager.controller;

import com.gabrielli.task_manager.model.Task;
import com.gabrielli.task_manager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taskManagerApi")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks(){return taskService.getAllTasks();}

    @PostMapping
    public Task createTask(@RequestBody Task task){return taskService.createTask(task);}

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){taskService.deleteTask(id);}
}
