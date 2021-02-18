package com.Equipo3.Backend.Shared.Dominio.Repository;

public interface GenericRepository<T,K> {

    public T findOne(K numero);
    public Iterable<T> findAll();
    public T save(T entidad);
    public boolean delete(T entidad);

}