package com.university.library.models;

import java.util.Arrays;

public class Book extends LibraryItem implements Cloneable, Comparable<Book>{

	private Genre genre;
	boolean []borrowingStatusPerDay;
	public Book(String title, String author, int yearPublished, Genre genre) {
		super(title, author, yearPublished);
		this.genre=genre;
	}
	@Override
	public int getLoanPeriod() {
		switch(genre) {
		case FICTION:return 14;
		case NONFICTION:return 30;
		case SCIENCE: return 21;
		case HISTORY: return 21;
		default: return 0;
		}
	}
	public boolean[] getBorrowingStatusPerDay() {
		if(borrowingStatusPerDay!=null) {
			return Arrays.copyOf(borrowingStatusPerDay,borrowingStatusPerDay.length);
		}else {
			return null;
		}
	}
	public void setBorrowingStatusPerDay(boolean[] borrowingStatusPerDay) {
		if(borrowingStatusPerDay!=null) {
			this.borrowingStatusPerDay=Arrays.copyOf(borrowingStatusPerDay,borrowingStatusPerDay.length);
		}
		else {
			this.borrowingStatusPerDay=null;
		}
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		
		Book copy=(Book)super.clone();
		copy.genre=this.genre;
		copy.setBorrowingStatusPerDay(this.borrowingStatusPerDay);
		return copy;
	}
	@Override
	public boolean isAvailable() {
		if(borrowingStatusPerDay[borrowingStatusPerDay.length-1]==true) {
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public String toString() {
		return title+" by "+author+" - "+genre;
	}

	
}
