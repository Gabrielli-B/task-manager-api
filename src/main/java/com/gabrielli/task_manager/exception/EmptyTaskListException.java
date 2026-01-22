package com.gabrielli.task_manager.exception;

public class EmptyTaskListException extends RuntimeException {
    public EmptyTaskListException() {
        super("Lista de tarefas vazia");
    }
}
