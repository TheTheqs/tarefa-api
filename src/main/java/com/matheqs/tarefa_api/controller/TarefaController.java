package com.matheqs.tarefa_api.controller;

import com.matheqs.tarefa_api.dto.CriarTarefaDTO;
import com.matheqs.tarefa_api.dto.TarefaResponseDTO;
import com.matheqs.tarefa_api.model.Tarefa;
import com.matheqs.tarefa_api.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {
    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    //C - Criar Tarefa
    @PostMapping
    public ResponseEntity<TarefaResponseDTO> criarTarefa(@RequestBody @Valid CriarTarefaDTO dto) {
        TarefaResponseDTO resposta = new TarefaResponseDTO(
                "Tarefa criada com sucesso!",
                tarefaService.criarTarefa(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    //R - Ler tarefas (individual e todas)
    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> encontrarTarefaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(tarefaService.encontrarTarefaPorId(id));
    }

    @GetMapping("/todas")
    public ResponseEntity<List<Tarefa>> encontrarTodasAsTarefas() {
        return ResponseEntity.ok(tarefaService.encontrarTodasAsTarefas());
    }

    //U - Atualizar tarefa
    @PutMapping("/{id}")
    public ResponseEntity<TarefaResponseDTO> atualizarTarefa(@RequestBody @Valid CriarTarefaDTO dto, @PathVariable Long id) {
        TarefaResponseDTO resposta = new TarefaResponseDTO(
                "Tarefa atualizada com sucesso!",
                tarefaService.atualizarTarefa(id, dto));
        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }

    //D - DESTRUIR!!!
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarTarefa(@PathVariable Long id) {
        tarefaService.deletarTarefa(id);
        return ResponseEntity.noContent().build();
    }
}
