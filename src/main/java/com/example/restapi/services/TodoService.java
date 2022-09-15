package com.example.restapi.services;

import com.example.restapi.entities.TodoEntity;
import com.example.restapi.entities.UserEntity;
import com.example.restapi.models.Todo;
import com.example.restapi.repository.TodoRepo;
import com.example.restapi.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    TodoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;

    public Todo createTodo(TodoEntity todo, Long userId){
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(todoRepo.save(todo));
    }

    public Todo completeTodo(Long Id){
        TodoEntity todo = todoRepo.findById(Id).get();
        todo.setCompleted(!todo.getCompleted());
        return Todo.toModel(todoRepo.save(todo));
    }
}
