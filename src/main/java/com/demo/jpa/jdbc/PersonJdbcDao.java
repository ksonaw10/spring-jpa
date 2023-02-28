package com.demo.jpa.jdbc;

import com.demo.jpa.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> findAll(){
        return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person findById(int id){
        return jdbcTemplate.queryForObject("select * from person where id = ?", new BeanPropertyRowMapper<>(Person.class), new Object[]{id});
    }

    public Person findByName(String name){
        return jdbcTemplate.queryForObject("select * from person where name = ?", new BeanPropertyRowMapper<>(Person.class), new Object[]{name});
    }

    public int deleteById(int id){
        return jdbcTemplate.update("delete from person where id = ?",new Object[]{id});
    }

    public int insert(Person p){
        return jdbcTemplate.update("insert into person (id, name, location, birth_date) values (?,?,?,?) ",
                new Object[]{p.getId(), p.getName(), p.getLocation(), p.getBirthDate()});
    }

    public int update(Person p){
        return jdbcTemplate.update("update person set " +
                        "name =?, location=? where id =? ",
                new Object[]{p.getName(), p.getLocation(), p.getId()});
    }
}
