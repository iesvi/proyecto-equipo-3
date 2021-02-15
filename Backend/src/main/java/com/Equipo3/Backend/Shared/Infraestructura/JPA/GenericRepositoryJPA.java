package com.Equipo3.Backend.Shared.Infraestructura.JPA;

import com.Equipo3.Backend.Shared.Dominio.Repository.GenericRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
@Repository
public abstract class GenericRepositoryJPA<T,K> implements GenericRepository<T,K> {
    @PersistenceContext
    private EntityManager em;

    private Class<T> type;

    public GenericRepositoryJPA(Class<T> type) {
        this.type = type;
    }

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    public T findOne(K pk) {
        return em.find(type,pk);
    }

    public Iterable<T> findAll() {

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<T> query = cb.createQuery(type);

        Root<T> root = query.from(type);
        TypedQuery<T> queryExecute = em.createQuery(query);

        return queryExecute.getResultList();
    }

    @Transactional
    public T save(T tipo) {
        em.persist(tipo);
        return tipo;
    }

    @Transactional
    public void delete(T tipo)
    {
        em.remove(tipo);
    }


}
