/*
* File: MovieSource.java
* Author: Vámosi László Ádám
* Copyright: 2025, Vámosi László Ádám
* Group: II-N
* Date: 2025-11-25
* GitHub: https://github.com/vamosilaszloadam/
* Licenc: MIT
*/

package com.example.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MovieSource implements DataAccessible<Movie> {
    private Database database;
    public MovieSource(Database database) {
        this.database = database;
    }

    @Override
    public List<Movie> index() {
        try {
            return tryIndex();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return new ArrayList<>();
        }
    }
    private List<Movie> tryIndex() throws SQLException {
        String sql = "select * from movies";
        try(
            Connection conn = database.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ){
            ArrayList<Movie> movies = new ArrayList<>();
            while(rs.next()) {
                Movie movie = new Movie();
                movie.setId(rs.getInt("id"));
                movie.setTitle(rs.getString("title"));
                movie.setDirector(rs.getString("director"));
                movie.setRelease_year(rs.getInt("release_year"));
                movie.setGenre(rs.getString("genre"));
                movies.add(movie);
            }
            return movies;
        }
    }

    @Override
    public void store(Movie movie) {
        try {
            tryStore(movie);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    private void tryStore(Movie movie) throws SQLException {
        String sql = "insert into movies (title, director, release_year, genre) values (?, ?, ?, ?)";

        try(
            Connection conn = database.connect();
            PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setString(1, movie.getTitle());
            stmt.setString(2, movie.getDirector());
            stmt.setInt(3, movie.getRelease_year());
            stmt.setString(4, movie.getGenre());
            stmt.executeUpdate();
        }
    }

    @Override
    public void update(Movie movie, int id) {
        try {
            tryUpdate(movie, id);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    private void tryUpdate(Movie movie, int id) throws SQLException {
        String sql = "update movies set title = ?, director = ?, release_year = ?, genre = ? where id = ?";

        try(
            Connection conn = database.connect();
            PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setString(1, movie.getTitle());
            stmt.setString(2, movie.getDirector());
            stmt.setInt(3, movie.getRelease_year());
            stmt.setString(4, movie.getGenre());
            stmt.setInt(5, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public void destroy(int id) {
        try {
            tryDestroy(id);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    private void tryDestroy(int id) throws SQLException {
        String sql = "delete from movies where id = ?";

        try(
            Connection conn = database.connect();
            PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

}
