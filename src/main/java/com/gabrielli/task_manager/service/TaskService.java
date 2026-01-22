package com.gabrielli.task_manager.service;

import com.gabrielli.task_manager.exception.EmptyTaskListException;
import com.gabrielli.task_manager.exception.TaskNotFoundException;
import com.gabrielli.task_manager.model.Task;
import com.gabrielli.task_manager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    //listar tarefas
    public List<Task> getAllTasks(){
        List<Task> list = taskRepository.findAll();
        if(list.isEmpty()){
            throw new EmptyTaskListException();
        }
        return list;
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
        return taskRepository.findById(id).orElseThrow(()->new TaskNotFoundException(id));
    }
    //atualizar tarefa
    public Task updateTask(Long id,Boolean newStatus){
        Task task = taskRepository.findById(id).orElseThrow(()->new TaskNotFoundException(id));
        task.setCompleted(newStatus);
        return taskRepository.save(task);
    }
    //listar tarefas por status
    public List<Task> searchTasksStatus(Boolean status){
        return taskRepository.findByCompleted(status);
    }
}
