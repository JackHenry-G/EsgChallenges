package com.esg.customers.Repository;

import org.springframework.stereotype.Repository;

import com.esg.customers.Model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    /*
     * This gives all the functionality of:
     * <S extends T> S save(S entity);
     * 
     * <S extends T> Iterable<S> saveAll(Iterable<S> entities);
     * 
     * Optional<T> findById(ID id);
     * 
     * boolean existsById(ID id);
     * 
     * Iterable<T> findAll();
     * 
     * Iterable<T> findAllById(Iterable<ID> ids);
     * 
     * long count();
     * 
     * void deleteById(ID id);
     * 
     * void delete(T entity);
     * 
     * void deleteAllById(Iterable<? extends ID> ids);
     * 
     * void deleteAll(Iterable<? extends T> entities);
     * 
     * void deleteAll();
     */
}
