package com.erudio.consisanet.services;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erudio.consisanet.model.Tarefa;
import com.erudio.consisanet.repository.TarefaRepository;

@Service
public class TarefaService {
    @Autowired
    private TarefaRepository tarefaRepository;

    public Tarefa criarTarefa(Tarefa tarefa) {
        // Implemente a lógica para criar uma nova tarefa
        return tarefaRepository.save(tarefa);
    }

    public Tarefa atualizarTarefa(Long id, Tarefa tarefa) {
        // Verifique se a tarefa com o ID fornecido existe
        Tarefa tarefaExistente = tarefaRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Tarefa não encontrada com o ID: " + id));

        // Atualize os campos da tarefa existente com os valores da tarefa fornecida
        tarefaExistente.setDataInicio(tarefa.getDataInicio());
        tarefaExistente.setDataFim(tarefa.getDataFim());
        tarefaExistente.setNomeTarefa(tarefa.getNomeTarefa());
        tarefaExistente.setSituacao(tarefa.getSituacao());
        tarefaExistente.setUsuarioResponsavel(tarefa.getUsuarioResponsavel());
        tarefaExistente.setTarefaPrincipal(tarefa.getTarefaPrincipal());

        return tarefaRepository.save(tarefaExistente);
    }

    public void deletarTarefa(Long id) {
        // Verifique se a tarefa com o ID fornecido existe
        Tarefa tarefaExistente = tarefaRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Tarefa não encontrada com o ID: " + id));

        // Exclua a tarefa
        tarefaRepository.delete(tarefaExistente);
    }

    public List<Tarefa> filtrarTarefasPorData(LocalDate dataInicio, LocalDate dataFim) {
        // Implemente a lógica para filtrar tarefas por data de início e fim
        return tarefaRepository.findByDataInicioBetweenAndDataFimBetween(dataInicio, dataFim, dataInicio, dataFim);
    }

    public List<Tarefa> filtrarTarefasAtrasadas() {
        // Implemente a lógica para filtrar tarefas atrasadas (data fim superior ao dia atual e não encerradas)
        LocalDate hoje = LocalDate.now();
        return tarefaRepository.findByDataFimGreaterThanAndSituacaoNot(hoje, "ENCERRADA");
    }

    public List<Tarefa> filtrarTarefasPorUsuario(Long usuarioId, String situacao) {
        // Implemente a lógica para filtrar tarefas por usuário e situação
        if (situacao != null && !situacao.isEmpty()) {
            return tarefaRepository.findByUsuarioResponsavelIdAndSituacao(usuarioId, situacao);
        } else {
            return tarefaRepository.findByUsuarioResponsavelId(usuarioId);
        }
    }
}
