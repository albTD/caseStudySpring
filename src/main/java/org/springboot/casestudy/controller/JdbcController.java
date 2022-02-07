package org.springboot.casestudy.controller;

import java.util.List;

import org.springboot.casestudy.model.Book;
import org.springboot.casestudy.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JdbcController {

	@Autowired
	BookService bookservice;
	
	@GetMapping("/book")
	private List<Book> getAllBook()
	
	{
		return bookservice.getAllBooks();
		
	}
	//getting specific user
	@GetMapping("/book/{id}")
	private Book getBook(@PathVariable("id") int id)
	{
		
		try {
			 bookservice.getBookById(id);
				
		}
		catch(Exception e){
			
			 System.out.println("Book not foundd!!!!!!!");
			 return null;
			
		}
   	
		return  bookservice.getBookById(id);
		
		
	}
	
	//getting specific user
	@GetMapping("/book/search/{bookName}")
	private Book getBookByName(@PathVariable("bookName") String bookName)
	{
		
		try {
			return bookservice.getBookByName(bookName);
		}
		catch(Exception e){
			
			 System.out.println("Book not foundd!!!!!!!");
			 return null;
			
		}
		
	
	}
	
	
	
	//deleting specific user
	
	@DeleteMapping("/book/{id}")
	
	private void deleteBook(@PathVariable ("id") int id)
	{
		
		bookservice.delete(id);
	}
	
	
	@GetMapping("/book/del/{bookName}")
	
	private void deleteBookByName(@PathVariable ("bookName") String bookName)
	{
		
		bookservice.deleteByName(bookName);
	}
	
	
   @PostMapping("/book")
	private int saveBook(@RequestBody Book book)
	{
		
		bookservice.saveOrUpdate(book);
		
		return book.getId();
	}
	
	
	
	

	/*
	 * @RequestMapping("/insert") public String index() {
	 * 
	 * jdbc.execute("insert into user(name,email) values('Manisha','m@gmail.com')");
	 * 
	 * return "Row inserted successfully"; }
	 */
	
}