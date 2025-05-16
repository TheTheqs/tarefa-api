package com.matheqs.tarefa_api.service;

import com.matheqs.tarefa_api.dto.CriarTarefaDTO;
import com.matheqs.tarefa_api.model.Tarefa;
import com.matheqs.tarefa_api.repository.TarefaRepository;
import org.springframework.stereotype.Service;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    //C - Criar
    public Tarefa criarTarefa(CriarTarefaDTO dto) {
        Tarefa tarefa = new Tarefa(dto.getNome(), dto.getDataEntrega(), dto.getResponsavel());
        return tarefaRepository.save(tarefa);
    }
}
