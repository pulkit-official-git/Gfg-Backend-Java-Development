package com.example.demo_gfg_database.commons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Repository
public class DatabaseRepository {

    Logger logger = LoggerFactory.getLogger(DatabaseRepository.class);
    private Connection connection=null;

    private String url;
    private String username;
    private String password;


    public DatabaseRepository(@Value("${db.url}") String url, @Value("${db.username}") String username, @Value("${db.password}") String password){
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection(){
        try {
            if(connection==null){
                logger.info("Connecting to database...");
                this.connection = DriverManager.getConnection(this.url,this.username,this.password);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
