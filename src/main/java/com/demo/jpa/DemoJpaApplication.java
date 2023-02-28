package com.demo.jpa;

import com.demo.jpa.entity.Person;
import com.demo.jpa.jdbc.PersonJdbcDao;
import com.demo.jpa.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


@SpringBootApplication
public class DemoJpaApplication implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	public static void main(String[] args) {
		SpringApplication.run(DemoJpaApplication.class, args);
	}
	@Autowired
	PersonJpaRepository dao;

	@Override
	public void run(String... args) throws Exception {
		logger.info("user 11 {}", dao.findById(11));

		logger.info("inserting new person {}", dao.insert(new Person(14, "tara", "berlin", new Date())));
		logger.info("update person 13{}", dao.update(new Person(13, "peter", "uterect", new Date())));
	//	dao.deleteById(13);
		logger.info("all users {}",dao.findAll());
	/*	logger.info("user 11 {}", dao.findById(11));
		logger.info("userName 11 {}", dao.findByName("test11"));
		logger.info("{} users deleted", dao.deleteById(12));
		//logger.info("inserting new person {}", dao.insert(new Person(14, "tara", "berlin", new Date())));
		logger.info("inserting new person {}", dao.update(new Person(13, "peter", "uterect", new Date())));*/

	}
}
