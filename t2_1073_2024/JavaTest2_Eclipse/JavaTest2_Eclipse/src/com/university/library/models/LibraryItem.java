package com.university.library.models;

import com.university.library.contracts.Borrowable;

public abstract class LibraryItem implements Borrowable,Cloneable {
		protected String title;
		protected String author;
		protected int yearPublished;
		public LibraryItem(String title, String author, int yearPublished) {
			super();
			this.title = title;
			this.author = author;
			this.yearPublished = yearPublished;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public int getYearPublished() {
			return yearPublished;
		}
		public void setYearPublished(int yearPublished) {
			this.yearPublished = yearPublished;
		}
		@Override
		public boolean isAvailable() {
			return true;
		}
		public abstract int getLoanPeriod();
		@Override
		protected Object clone() throws CloneNotSupportedException {
			LibraryItem copy=(LibraryItem)super.clone();
			copy.title=this.title;
			copy.author=this.author;
			copy.yearPublished=this.yearPublished;
			return copy;
			
		}
		
		
}
