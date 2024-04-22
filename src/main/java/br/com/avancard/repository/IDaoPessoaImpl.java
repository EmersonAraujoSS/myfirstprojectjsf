package br.com.avancard.repository;

import br.com.avancard.entidades.Pessoa;
import br.com.avancard.jpautil.JPAUtil;
import jakarta.persistence.EntityManager;

import javax.persistence.EntityTransaction;

public class IDaoPessoaImpl  implements IDaoPessoa {

    @Override
    public Pessoa consultarUsuario(String login, String senha) {

        Pessoa pessoa = null;

        EntityManager entityManager = (EntityManager) JPAUtil.getEntityManager();
        EntityTransaction entityTransaction = (EntityTransaction) entityManager.getTransaction();
        entityTransaction.begin();

        pessoa = (Pessoa) entityManager.createQuery("select p from Pessoa p where p.login = '" + login + "' and p.senha = '" + senha + "'").getSingleResult();

        entityTransaction.commit();
        entityManager.close();

        return pessoa;
    }
}
