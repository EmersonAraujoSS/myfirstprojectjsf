package br.com.avancard.repository;

import br.com.avancard.entidades.Lancamento;
import br.com.avancard.jpautil.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class IDaoLancamentoImpl implements IDaoLancamento {

    @Override
    public List<Lancamento> consultar(Long codUser) {
        List<Lancamento> lista = null;

        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        lista = entityManager.createQuery("from Lancamento where usuario.id = " + codUser).getResultList();

        transaction.commit();
        transaction.begin();

        return lista;
    }
}