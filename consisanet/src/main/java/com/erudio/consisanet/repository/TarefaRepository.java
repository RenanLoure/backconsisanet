package com.erudio.consisanet.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erudio.consisanet.model.Tarefa;
import com.erudio.consisanet.model.Usuario;

/**
 * TarefaRepository
 */
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    // Consulta tarefas por data de início e fim
    List<Tarefa> findByDataInicioBetweenAndDataFimBetween(LocalDate dataInicio1, LocalDate dataFim1, LocalDate dataInicio2, LocalDate dataFim2);

    // Consulta tarefas atrasadas (data fim superior ao dia atual e não encerradas)
    List<Tarefa> findByDataFimGreaterThanAndSituacaoNot(LocalDate dataFim, String situacao);

    // Consulta tarefas por usuário e situação
    List<Tarefa> findByUsuarioResponsavelIdAndSituacao(Long usuarioId, String situacao);

    // Consulta tarefas por usuário
    List<Tarefa> findByUsuarioResponsavelId(Long usuarioId);
}