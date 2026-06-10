package com.todo.api.demo.Service;

import com.todo.api.demo.DTO.TodoRequestDTO;
import com.todo.api.demo.DTO.TodoResponseDTO;
import com.todo.api.demo.Model.Status;
import com.todo.api.demo.Model.Todo;
import com.todo.api.demo.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    public TodoResponseDTO create(TodoRequestDTO dto) {
        Todo todo = new Todo();
        todo.setTitulo(dto.titulo());
        todo.setDescricao(dto.descricao());
        todo.setConcluido(Status.PENDENTE);
        Todo todoNovo = todoRepository.save(todo);

        return converterParaDTO(todo);
    }

    public TodoResponseDTO buscarPorId(UUID ID){

        Todo todonovo = todoRepository.findById(ID).orElseThrow();

        return converterParaDTO(todonovo);
    }
    public List<TodoResponseDTO> retornarLista(){
        return  todoRepository.findAll().
                stream().map(this::converterParaDTO).toList();
    }

    private TodoResponseDTO converterParaDTO(Todo todo) {

        return new TodoResponseDTO(
                todo.getId(),
                todo.getTitulo(),
                todo.getDescricao(),
                todo.getConcluido(),
                todo.getDataCriacao(),
                todo.getDataConclusao()
        );
    }
}