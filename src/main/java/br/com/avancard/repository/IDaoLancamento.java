package br.com.avancard.repository;

import br.com.avancard.entidades.Lancamento;

import java.util.List;

public interface IDaoLancamento {

    List<Lancamento> consultar(Long codUser);
}
