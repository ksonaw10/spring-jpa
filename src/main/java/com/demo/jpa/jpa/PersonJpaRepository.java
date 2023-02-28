package com.demo.jpa.jpa;

import com.demo.jpa.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Person> findAll(){
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
        return namedQuery.getResultList();
    }
    public Person findById(int id){
        return entityManager.find(Person.class, id);
    }
    public Person insert(Person p){
        return entityManager.merge(p);
    }

    public Person update(Person p){
        return entityManager.merge(p);
    }

    public void deleteById(int id){
        Person p = findById(id);
        entityManager.remove(p);
    }
}
