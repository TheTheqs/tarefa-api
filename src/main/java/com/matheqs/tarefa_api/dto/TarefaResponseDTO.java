package com.matheqs.tarefa_api.dto;

import com.matheqs.tarefa_api.model.Tarefa;

public class TarefaResponseDTO {
    private String mensagem;
    private Tarefa tarefa;

    public TarefaResponseDTO(String mensagem, Tarefa tarefa) {
        this.mensagem = mensagem;
        this.tarefa = tarefa;
    }

    // Getters e Setters

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }
}

