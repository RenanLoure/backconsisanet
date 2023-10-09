package com.erudio.consisanet.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.erudio.consisanet.model.Tarefa;
import com.erudio.consisanet.services.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa) {
        return tarefaService.criarTarefa(tarefa);
    }

    @PutMapping("/{id}")
    public Tarefa atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        return tarefaService.atualizarTarefa(id, tarefa);
    }

    @DeleteMapping("/{id}")
    public void deletarTarefa(@PathVariable Long id) {
        tarefaService.deletarTarefa(id);
    }

    @GetMapping("/filtro-data")
    public List<Tarefa> filtrarTarefasPorData(
      @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataInicio,
      @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataFim) {
    return tarefaService.filtrarTarefasPorData(dataInicio, dataFim);
}

    @GetMapping("/filtro-atrasadas")
    public List<Tarefa> filtrarTarefasAtrasadas() {
        return tarefaService.filtrarTarefasAtrasadas();
    }

    @GetMapping("/filtro-usuario")
    public List<Tarefa> filtrarTarefasPorUsuario(@RequestParam Long usuarioId, @RequestParam String situacao) {
        return tarefaService.filtrarTarefasPorUsuario(usuarioId, situacao);
    }
}
