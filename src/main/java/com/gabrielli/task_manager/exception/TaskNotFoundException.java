package com.gabrielli.task_manager.exception;

import lombok.extern.java.Log;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(Long id) {
        super("Task com id "+ id +" não encontrada");

    }
}
