package br.com.avancard.repository;

import br.com.avancard.entidades.Pessoa;

public interface IDaoPessoa {

    Pessoa consultarUsuario(String login, String senha);

}
