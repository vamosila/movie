/*
* File: MainView.java
* Author: Vámosi László Ádám
* Copyright: 2025, Vámosi László Ádám
* Group: II-N
* Date: 2025-11-25
* GitHub: https://github.com/vamosilaszloadam/
* Licenc: MIT
*/

package com.example.views;

import java.util.List;

import com.example.models.Movie;

public class MainView {
    public void showMovies(List<Movie> movieList) {
        System.out.printf("%-5s %-17s %-19s %s\n", "Id", "Cím", "Rendező", "Év");
        movieList.forEach((movie)->{
            System.out.printf("%-4d %-17s %-19s %d\n", 
                movie.getId(),
                movie.getTitle(),
                movie.getDirector(),
                movie.getRelease_year()
            );
        });
    }
}
