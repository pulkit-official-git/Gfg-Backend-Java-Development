package com.example.demo_gfg_database;

import com.example.demo_gfg_database.books.models.Book;
import com.example.demo_gfg_database.books.models.Genre;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DemoGfgDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoGfgDatabaseApplication.class, args);
//
//		Book book1 = new Book();
//		book1.setId(1);
//		book1.setAuthor("John Doe");
//		System.out.println(book1.getAuthor());
//
//		Book book2 = new Book(1,"Harry Potter","J K Rowling",null, Genre.THRILLER,new Date(),new Date());
//		System.out.println(book2);
//
//		Book.BookBuilder bookBuilder3 = Book.builder()
//				.id(3)
//				.author("Anna bel")
//				.genre(Genre.THRILLER);
////				.build();
//
//		Book book3 = bookBuilder3.authorEmail("anna@gmail.com")
//				.build();
//
//		System.out.println(book3);
	}

}
