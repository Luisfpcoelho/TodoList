package com.todo.api.demo.Controller;

import com.todo.api.demo.DTO.TodoRequestDTO;
import com.todo.api.demo.DTO.TodoResponseDTO;
import com.todo.api.demo.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    TodoService todoService;

    @PostMapping("/create")
    public void create(@RequestBody TodoRequestDTO dto){
     todoService.create(dto);
    }

    @GetMapping("/{id}")
    public TodoResponseDTO buscarPorId(@PathVariable("id") UUID id){
        return todoService.buscarPorId(id);
    }

    @GetMapping("/buscarTodoso")
    public List<TodoResponseDTO> buscarTodos(){
        return todoService.buscarTodos();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id){
        todoService.deleteTodo(id);
    }
    }
