package com.todo.api.demo.Controller;

import com.todo.api.demo.DTO.TodoRequestDTO;
import com.todo.api.demo.DTO.TodoResponseDTO;
import com.todo.api.demo.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    TodoService todoService;

    @PostMapping
    public void create(@RequestBody TodoRequestDTO dto){
     todoService.create(dto);
    }

}
