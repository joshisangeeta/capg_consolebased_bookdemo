package com.sj.db;

import java.util.*;

import com.sj.model.Book;

public class Database {
	TreeSet<Book> bookSet = new TreeSet<Book>();

	public Database() {

		Book b1 = new Book(1, "Not without my daughter", "Betty Mehmoody", 2000);
		Book b2 = new Book(2, "Accidental PrimeMinister", "Sanjay Baru", 3500);
		Book b3 = new Book(3, "Abstract Algebra", "JNash", 4000);
		Book b4 = new Book(4, "Papillon", "Henry C", 5000);

		bookSet.add(b1);
		bookSet.add(b2);
		bookSet.add(b3);
		bookSet.add(b4);
	}

	public TreeSet<Book> getBookSet() {
		return bookSet;
	}

	public void setBookSet(TreeSet<Book> bookSet) {
		this.bookSet = bookSet;
	}

	
}
