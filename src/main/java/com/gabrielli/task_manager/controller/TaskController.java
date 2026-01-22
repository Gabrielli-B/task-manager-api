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

    @GetMapping
    public Task searchTask(Long id){return taskService.searchTask(id);}

    @PostMapping
    public Task createTask(@RequestBody Task task){return taskService.createTask(task);}

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Boolean newStatus){return taskService.updateTask(id,newStatus);}

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){taskService.deleteTask(id);}

}
