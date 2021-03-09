package com.Equipo3.Backend.Shared.Dominio.Repository;

/**
 * Clase de Repositorio Generico
 * @param <T>
 * @param <K>
 */
public interface GenericRepository<T, K> {

    public T findOne(K numero);

    public Iterable<T> findAll();

    public T save(T entidad);

    public boolean delete(T entidad);

}