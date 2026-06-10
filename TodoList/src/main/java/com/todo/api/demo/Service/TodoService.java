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

        return new  TodoResponseDTO(todoNovo.getTitulo(), todoNovo.getDescricao(), todoNovo.getConcluido());
    }

    
}