/*
* File: Movie.java
* Author: Vámosi László Ádám
* Copyright: 2025, Vámosi László Ádám
* Group: II-N
* Date: 2025-11-25
* GitHub: https://github.com/vamosilaszloadam/
* Licenc: MIT
*/

package com.example.models;

public class Movie {
    private int id;
    private String title;
    private String director;
    private int release_year;
    private String genre;
    public Movie() {}
    public Movie(String title, String director, int release_year, String genre) {
        this.title = title;
        this.director = director;
        this.release_year = release_year;
        this.genre = genre;
    }
    public Movie(int id, String title, String director, int release_year, String genre) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.release_year = release_year;
        this.genre = genre;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public int getRelease_year() {
        return release_year;
    }
    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
}
