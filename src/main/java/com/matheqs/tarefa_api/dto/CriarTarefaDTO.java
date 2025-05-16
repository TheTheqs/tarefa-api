package com.matheqs.tarefa_api.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

//DTO usado para recebimento de dados
public class CriarTarefaDTO {

    @NotBlank(message = "O nome da tarefa é obrigatório.")
    private String nome;

    @NotNull(message = "A data de entrega é obrigatória.")
    @FutureOrPresent(message = "A data de entrega não pode ser no passado.")
    private LocalDate dataEntrega;

    @NotBlank(message = "O responsável pela tarefa é obrigatório.")
    private String responsavel;

    // CONSTRUTORES
    public CriarTarefaDTO() {
    }

    public CriarTarefaDTO(String nome, LocalDate dataEntrega, String responsavel) {
        this.nome = nome;
        this.dataEntrega = dataEntrega;
        this.responsavel = responsavel;
    }

    //GETTERS E SETTERS

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
}

