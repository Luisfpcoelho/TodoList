package com.todo.api.demo.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "Todo")
public class Todo {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "titulo", nullable = false, length = 50)
    private String titulo;

    @Column(name = "descrição", length = 500)
    private String descricao;

    @Column(name = "concluido")
    private Status concluido ;

    @Column(name = "dataCriacao")
    private LocalTime dataCriacao;

    @Column(name = "dataConclusão")
    private LocalTime dataConclusao;
}
