package com.matheqs.tarefa_api.service;

import com.matheqs.tarefa_api.dto.CriarTarefaDTO;
import com.matheqs.tarefa_api.model.Tarefa;
import com.matheqs.tarefa_api.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    //C - Criar (Create)
    public Tarefa criarTarefa(CriarTarefaDTO dto) {
        Tarefa tarefa = new Tarefa(dto.getNome(), dto.getDataEntrega(), dto.getResponsavel());
        return tarefaRepository.save(tarefa);
    }

    //R - Ler (Read)
    public Tarefa encontrarTarefaPorId(Long id) {
        return tarefaRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Não há tarefa no banco de dados com o id fornecido: id = " + id )
        );
    }

    public List<Tarefa> encontrarTodasAsTarefas() {
        return tarefaRepository.findAll();
    }

    //U - Atualizar (Update)
    public Tarefa atualizarTarefa(Long id, CriarTarefaDTO dto) {
        Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Erro ao atualizar, não há tarefa no banco de dados com o id fornecido: id = " + id )
        );
        tarefa.setNome(dto.getNome());
        tarefa.setDataEntrega(dto.getDataEntrega());
        tarefa.setResponsavel(dto.getResponsavel());
        return tarefaRepository.save(tarefa);
    }
}
