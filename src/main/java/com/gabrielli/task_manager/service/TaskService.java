package com.gabrielli.task_manager.service;

import com.gabrielli.task_manager.model.Task;
import com.gabrielli.task_manager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    //listar tarefas
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }
    //criar
    public Task createTask(Task task){
        return taskRepository.save(task);
    }
    //deletar
    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
    //buscar pelo id
    public Task searchTask(Long id){
        return taskRepository.findById(id).orElse(null);
    }
}
