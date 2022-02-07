package org.springboot.casestudy.service;

import java.util.ArrayList;
import java.util.List;

import org.springboot.casestudy.model.Book;
import org.springboot.casestudy.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	@Autowired
	BookRepository bookrepo;
	
	//listing all users
	public List <Book> getAllBooks()
	{
		List <Book> books=new ArrayList<Book>();
		
		bookrepo.findAll().forEach(book -> books.add(book));
		return books;
	}
	
	//listing sprcific user record
	
	public Book getBookById(int id)
	{
		
		return bookrepo.findById(id).get();
		
	}
	
	
	public Book getBookByName(String bookName) throws Exception
	{
        List <Book> books=new ArrayList<Book>();
		bookrepo.findAll().forEach(book -> books.add(book));
        int c=0;
		for(int i=0;i<books.size();i++) {
			if(books.get(i).getBookName().contentEquals(bookName)) {
				c++;
				return books.get(i);
				
			}
			if(i==books.size()-1 && c==0) {
				 throw new Exception("not found");
                			
			}
		}
		
		return null;
		
		
	}
	
	
	//save or update
	public void saveOrUpdate(Book  book)
	{
		
		bookrepo.save(book);
	}
	//delete a specific record
	
	public void delete(int id)
	{
		
		bookrepo.deleteById(id);
	}
	
	public void deleteByName(String bookName)
	{
        List <Book> books=new ArrayList<Book>();		
		bookrepo.findAll().forEach(book -> books.add(book));
		
		for(int i=0;i<books.size();i++) {
			if(books.get(i).getBookName().contentEquals(bookName)) {
				bookrepo.deleteById(books.get(i).getId());
			}
		}
		

	}
	
}