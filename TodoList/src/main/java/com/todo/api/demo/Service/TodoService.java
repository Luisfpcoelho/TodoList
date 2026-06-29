package com.todo.api.demo.Service;

import com.todo.api.demo.DTO.TodoRequestDTO;
import com.todo.api.demo.DTO.TodoRequestUpdateDTO;
import com.todo.api.demo.DTO.TodoResponseDTO;
import com.todo.api.demo.Model.Status;
import com.todo.api.demo.Model.Todo;
import com.todo.api.demo.Repository.TodoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    public Todo create(TodoRequestDTO dto) {
        Todo newTodo = new Todo();
        newTodo.setTitulo(dto.titulo());
        newTodo.setDescricao(dto.descricao());
        return todoRepository.save(newTodo);
    }

   public List<TodoResponseDTO> retornarLista(){
        return todoRepository.findAll().stream().map(TodoResponseDTO::new).toList();
    }

    public TodoResponseDTO listarPorId(UUID id){

       Todo todo = todoRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "tarefa não encontrada"));
       return new TodoResponseDTO(todo);
    }
    public List<TodoResponseDTO> listarPorNome(String nome){
        return  todoRepository.findByTituloContainingIgnoreCase(nome).stream().map(TodoResponseDTO::new).toList();

    }
    public TodoResponseDTO listarPorNomeUnidade(String nome){
        Todo todo = todoRepository.findByTituloContainingIgnoreCase(nome).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "tarefa não encontrada"));
        return new TodoResponseDTO(todo);

    }
    @Transactional
    public TodoResponseDTO update(TodoRequestUpdateDTO dto, UUID id){
        Todo todo = todoRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa não encontrada"));
        todo.setTitulo(dto.titulo());
        todo.setDescricao(dto.descricao());
        todo.setConcluido(Status.CONCLUIDO);

        Todo newTodo = todoRepository.save(todo);
        return new TodoResponseDTO(newTodo);
    }
    public void deletePorId(UUID id){
        if (!todoRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Tarefa não encontrada");
        }
        todoRepository.deleteById(id);

    }
}