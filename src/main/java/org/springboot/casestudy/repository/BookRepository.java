package org.springboot.casestudy.repository;


import org.springboot.casestudy.model.Book;
import org.springframework.data.repository.CrudRepository;


public interface BookRepository extends CrudRepository<Book,Integer>{

	
	
}