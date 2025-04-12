package com.example.demo_gfg_database.books.repository;

import com.example.demo_gfg_database.books.models.Book;
import com.example.demo_gfg_database.books.models.Genre;
import com.example.demo_gfg_database.commons.DatabaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    Logger logger = LoggerFactory.getLogger(BookRepository.class);

//    @Autowired
    private final DatabaseRepository databaseRepository;

    public BookRepository(DatabaseRepository databaseRepository) throws SQLException {
        this.databaseRepository = databaseRepository;
        createTable();
    }

    public Connection getConnection(){
        return databaseRepository.getConnection();
    }

//    private int id;
//    private String title;
//    private String author;
//    private String authorEmail;
//    private Genre genre;
//    private Date createdON;
//    private Date updatedON;

    public void createTable() throws SQLException {
        logger.info("Inside Create table");

        String sql = "Create table if not exists book(id int primary key auto_increment,title varchar(50) not null,author varchar(50)," +
                "authorEmail varchar(50),genre varchar(50) not null,createdOn date,updatedOn date)";



        Statement statement = getConnection().createStatement();
        logger.info("Inside Create table  2222");
        boolean result = statement.execute(sql);
        logger.info("Inside Create table... result-{}",result);
    }

    public void addBook(Book book) throws SQLException {
        String sql = "Insert into book (title, author, authorEmail,genre,createdOn,updatedOn) " +
                "values (?,?,?,?,?,?)";

        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);

        preparedStatement.setString(1, book.getTitle());
        preparedStatement.setString(2, book.getAuthor());
        preparedStatement.setString(3, book.getAuthorEmail());
        preparedStatement.setString(4,book.getGenre().name());
        preparedStatement.setDate(5,new Date(book.getCreatedON().getTime()));
        preparedStatement.setDate(6,new Date(book.getUpdatedON().getTime()));


        boolean result = preparedStatement.execute();

    }

    public List<Book> getAllBooks() throws SQLException {
        String sql = "select * from book";
        List<Book> books = new ArrayList<>();
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            String authorEmail = resultSet.getString("authorEmail");
            Genre genre = Genre.valueOf(resultSet.getString("genre"));
            Date createdOn = resultSet.getDate("createdOn");
            Date updatedOn = resultSet.getDate("updatedOn");
            int id = resultSet.getInt("id");

            Book book = Book.builder()
                    .id(id)
                    .title(title)
                    .author(author)
                    .authorEmail(authorEmail)
                    .genre(genre)
                    .createdON(createdOn)
                    .updatedON(updatedOn)
                    .build();
            books.add(book);
        }
        return books;
    }
}
