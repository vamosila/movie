/*
* File: Sqlite.java
* Author: Vámosi László Ádám
* Copyright: 2025, Vámosi László Ádám
* Group: II-N
* Date: 2025-11-25
* GitHub: https://github.com/vamosilaszloadam/
* Licenc: MIT
*/

package com.example.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Sqlite implements Database {

    @Override
    public Connection connect() {
        try {
            return tryConnect();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    private Connection tryConnect() throws SQLException {
        String url = "jdbc:sqlite:database.sqlite";
        return DriverManager.getConnection(url);
    }
    
}
