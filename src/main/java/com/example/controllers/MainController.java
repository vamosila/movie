/*
* File: MainController.java
* Author: Vámosi László Ádám
* Copyright: 2025, Vámosi László Ádám
* Group: II-N
* Date: 2025-11-25
* GitHub: https://github.com/vamosilaszloadam/
* Licenc: MIT
*/

package com.example.controllers;

import java.util.List;

import com.example.models.Movie;
import com.example.models.MovieSource;
import com.example.models.Sqlite;
import com.example.views.MainView;

public class MainController {
    private static MovieSource movieSource = new MovieSource(new Sqlite());
    public static void start() {
        List<Movie> movieList = movieSource.index();
        MainView mainView = new MainView();
        mainView.showMovies(movieList);
    }
}
