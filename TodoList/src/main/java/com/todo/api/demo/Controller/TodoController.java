package com.todo.api.demo.Controller;

import com.todo.api.demo.DTO.TodoRequestDTO;
import com.todo.api.demo.DTO.TodoRequestUpdateDTO;
import com.todo.api.demo.DTO.TodoResponseDTO;
import com.todo.api.demo.Model.Todo;
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
    public ResponseEntity<Todo> create(@RequestBody TodoRequestDTO dto){
        Todo salvo = todoService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);

    }

    @GetMapping("{id}")
    public ResponseEntity<TodoResponseDTO> buscarPorId(@PathVariable UUID id){
        TodoResponseDTO todo = todoService.listarPorId(id);
        return ResponseEntity.ok(todo);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        todoService.deletePorId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<TodoResponseDTO> listarTodos(){
        return todoService.retornarLista();
    }
    @GetMapping("{nome}")
    public ResponseEntity<TodoResponseDTO> buscarPorid(@PathVariable String nome){
        TodoResponseDTO todo = todoService.listarPorNomeUnidade(nome);
        return ResponseEntity.ok(todo);

    }
    @PutMapping({"id"})
    public ResponseEntity<TodoResponseDTO> atualizar(@PathVariable UUID id, @RequestBody TodoRequestUpdateDTO dto){
        TodoResponseDTO todo = todoService.update(dto, id);
        return ResponseEntity.ok(todo);
    }

}
