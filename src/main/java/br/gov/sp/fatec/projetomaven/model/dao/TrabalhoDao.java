package br.gov.sp.fatec.projetomaven.model.dao;

import br.gov.sp.fatec.projetomaven.model.entity.Trabalho;

public interface TrabalhoDao {

    //public Trabalho cadastrarTrabalho(String titulo, Date dataHoraEntrega, String localArquivo, Professor professorAvaliadorId);

    //public Trabalho cadastrarTrabalho(String titulo, Date dataHoraEntrega, String localArquivo);

    public Trabalho salvarTrabalho(Trabalho trabalho);

    public Trabalho buscarTrabalhoPorId(Long id);

    public void removerTrabalhoPorId(Long id);

}