package com.todo.api.demo.Controller;

import com.todo.api.demo.DTO.TodoRequestDTO;
import com.todo.api.demo.DTO.TodoResponseDTO;
import com.todo.api.demo.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoResponseDTO> create(@RequestBody TodoRequestDTO dto){
     TodoResponseDTO todo =todoService.create(dto);
     return ResponseEntity.ok(todo);

    }

    @GetMapping("{id}")
    public ResponseEntity<TodoResponseDTO> buscarPorId(@PathVariable UUID id){
        TodoResponseDTO todo = todoService.buscarPorId(id);
        return ResponseEntity.ok(todo);

    }

    @GetMapping
    public List<TodoResponseDTO> listarTodos(){
        return todoService.retornarLista();
    }

}
