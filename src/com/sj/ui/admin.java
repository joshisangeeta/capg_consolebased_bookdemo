package com.sj.ui;

import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import com.sj.dao.BookDAO;
import com.sj.exception.NoBookException;
import com.sj.model.Book;

public class admin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice;
		Scanner s = new Scanner(System.in);
		BookDAO bookDao = new BookDAO();
		char c;

		do {

			System.out.println("press 1 to view all books");
			System.out.println("press 2 to search book by title");
			System.out.println("press 3 to insert a book");
			System.out.println("press 4 to delete book");
			System.out.println("press 5 to update the book");
			System.out.println("press 6 to exit");

			choice = s.nextInt();
			switch (choice) {
			case 1:
			 Set <Book>books=	bookDao.viewAllBooks();
			 System.out.println(books);
				break;
			case 2:
				System.out.println("enter the title of book");
				String name = s.next();
			    Optional<Book> book;
				try {
					book = bookDao.viewByname(name);
					 System.out.println(book.get());
				} catch (NoBookException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
			   
				break;

			case 3:
				System.out.println("enter the book id");
				int id1 = s.nextInt();
				System.out.println("enter the book name");
				String name1 = s.next();
				System.out.println("enter the author name");
				String author = s.next();
				System.out.println("enter the book price");
				double price = s.nextDouble();
				Book ib = new Book(id1, name1, author, price);
				bookDao.insert(ib);

				break;

			case 4:
				System.out.println("enter the id of the book you want to delete");
				int id9 = s.nextInt();
				bookDao.deleteBook(id9);
				break;

			case 5:
				System.out.println("enter the id of the book you want to update");
				int id5 = s.nextInt();
				System.out.println("enter the new price");
				double price1 = s.nextDouble();

				bookDao.updatePrice(id5, price1);
				System.out.println("updated successfully");
				break;
			case 6:

			default:
				System.exit(0);

			}
			System.out.println("press y for menu:");
			c = s.next().charAt(0);

		} while (c == 'Y' || c == 'y');

		System.exit(0);
	}
}
