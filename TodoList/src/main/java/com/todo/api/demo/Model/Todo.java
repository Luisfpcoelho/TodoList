package com.todo.api.demo.Model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Todo")
public class Todo {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @Column(name = "titulo", nullable = false, length = 50)
    private String titulo;

    @Column(name = "descrição", )
    private String descrição;
    private String titulo;
    private String titulo;

}
