/**
 * 
 */
package com.sj.dao;

import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

import com.sj.db.Database;
import com.sj.exception.NoBookException;
import com.sj.model.Book;

/**
 * @author HP
 *
 */
public class BookDAO {
	
	Database booksDB;	
	
	/**
	 * 
	 */
	public BookDAO() {
		super();
		
		booksDB= new Database();
		// TODO Auto-generated constructor stub
	}
	
	public Set <Book> viewAllBooks() {
		return booksDB.getBookSet();
		
	}
	
	public Optional<Book> viewByname(String name)throws NoBookException {
        Book   bookFound = null;
		for (Book b : booksDB.getBookSet()) {
			if (b.getTitle().equals(name)) {
				bookFound=b;
				System.out.println(b);
				break;
			}
		}
		if(bookFound!=null)
        return Optional.of(bookFound);
		else
		throw new NoBookException();
	}

	public void insert(Book b) {

		// TODO Auto-generated method stub
	     booksDB.getBookSet().add(b);
	
	}

	public void deleteBook(int id) {

		// TODO Auto-generated method stub
		boolean notFound = true;
		Iterator<Book> itr = booksDB.getBookSet().iterator();

		while (itr.hasNext()) {

			Book book = itr.next();
			if (book.getBookId() == id) {
				notFound = false;

				itr.remove();
				System.out.println("book deleted");
			}

		}
		if (notFound) {
			System.out.println("no book found");
		}

	}

	public void updatePrice(int id, double price) {
		
		 Book   bookFound = null;
			for (Book b : booksDB.getBookSet()) {
				if (b.getBookId()==id) {
					bookFound=b;
					//System.out.println(b);
					break;
				}
		}
	       
		Iterator<Book> itr = booksDB.getBookSet().iterator();
		while (itr.hasNext()) {

			if (itr.next().getBookId() == id) {
				itr.remove();
			}
			
		  }
				
		        Book b = new Book(id, price);
		        b.setTitle(bookFound.getTitle());
		        b.setAuthor(bookFound.getAuthor());
				booksDB.getBookSet().add(b);		
	}

        
}
