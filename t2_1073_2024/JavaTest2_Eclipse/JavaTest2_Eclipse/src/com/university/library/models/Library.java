package com.university.library.models;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Library {
	Set<Book> books = new TreeSet<>(Comparator.comparing(Book::getTitle).thenComparing(Book::getAuthor));

	public void addBook(Book book) {
		books.add(book);
	}

	public Collection<Book> getBooks() {
		return books;
	}
}
