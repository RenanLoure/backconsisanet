package com.erudio.consisanet.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
 
/**
 * Tarefas
 */
@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String nomeTarefa;
    private String situacao;

    @ManyToOne
    @JoinColumn(name = "usuario_responsavel_id")
    private Usuario usuarioResponsavel;

    @ManyToOne
    @JoinColumn(name = "tarefa_principal_id")
    private Tarefa tarefaPrincipal;

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public LocalDate getDataInicio() {
      return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
      this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
      return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
      this.dataFim = dataFim;
    }

    public String getNomeTarefa() {
      return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
      this.nomeTarefa = nomeTarefa;
    }

    public String getSituacao() {
      return situacao;
    }

    public void setSituacao(String situacao) {
      this.situacao = situacao;
    }

    public Usuario getUsuarioResponsavel() {
      return usuarioResponsavel;
    }

    public void setUsuarioResponsavel(Usuario usuarioResponsavel) {
      this.usuarioResponsavel = usuarioResponsavel;
    }

    public Tarefa getTarefaPrincipal() {
      return tarefaPrincipal;
    }

    public void setTarefaPrincipal(Tarefa tarefaPrincipal) {
      this.tarefaPrincipal = tarefaPrincipal;
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      result = prime * result + ((dataInicio == null) ? 0 : dataInicio.hashCode());
      result = prime * result + ((dataFim == null) ? 0 : dataFim.hashCode());
      result = prime * result + ((nomeTarefa == null) ? 0 : nomeTarefa.hashCode());
      result = prime * result + ((situacao == null) ? 0 : situacao.hashCode());
      result = prime * result + ((usuarioResponsavel == null) ? 0 : usuarioResponsavel.hashCode());
      result = prime * result + ((tarefaPrincipal == null) ? 0 : tarefaPrincipal.hashCode());
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Tarefa other = (Tarefa) obj;
      if (id == null) {
        if (other.id != null)
          return false;
      } else if (!id.equals(other.id))
        return false;
      if (dataInicio == null) {
        if (other.dataInicio != null)
          return false;
      } else if (!dataInicio.equals(other.dataInicio))
        return false;
      if (dataFim == null) {
        if (other.dataFim != null)
          return false;
      } else if (!dataFim.equals(other.dataFim))
        return false;
      if (nomeTarefa == null) {
        if (other.nomeTarefa != null)
          return false;
      } else if (!nomeTarefa.equals(other.nomeTarefa))
        return false;
      if (situacao == null) {
        if (other.situacao != null)
          return false;
      } else if (!situacao.equals(other.situacao))
        return false;
      if (usuarioResponsavel == null) {
        if (other.usuarioResponsavel != null)
          return false;
      } else if (!usuarioResponsavel.equals(other.usuarioResponsavel))
        return false;
      if (tarefaPrincipal == null) {
        if (other.tarefaPrincipal != null)
          return false;
      } else if (!tarefaPrincipal.equals(other.tarefaPrincipal))
        return false;
      return true;
    }

}