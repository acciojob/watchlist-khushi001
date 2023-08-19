/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Repository;


@Repository
public class MovieRepository {

    HashMap<String, Movie> movieDb = new HashMap<>();
    HashMap<String, Director> directorDb = new HashMap<>();
    HashMap<String, List<String>> movieDirectorDb = new HashMap<>();

    public String addMovie(Movie movie) {
        movieDb.put(movie.getName(), movie);
        return "sucess";
    }

    public String addDirector(Director director) {
        directorDb.put(director.getName(), director);
        return "success";
    }

    public String addMovieDirectorPair(String movieName, String directorName) {
        if (!movieDirectorDb.containsKey(directorName)) {
            movieDirectorDb.put(directorName, new ArrayList<String>());
        }
        movieDirectorDb.get(directorName).add(movieName);
        return "sucess";
    }

    public Movie getMovieByName(String name) {
        return movieDb.get(name);
    }

    public Director getDirectorByName(String name) {
        return directorDb.get(name);
    }

    public List<String> getMoviesByDirector(String name) {
        return movieDirectorDb.get(name);
    }

    public List<String> getallMovies() {
        return new ArrayList<>(movieDb.keySet());
    }

    public String deleteDirectorByName(String name) {
        directorDb.remove(name);
        for (String m : movieDirectorDb.get(name)) {
            movieDb.remove(m);
        }
        movieDirectorDb.remove(name);
        return "sucess";
    }

    public String deleteAllDirectorandMovies() {
        for (String name : directorDb.keySet()) {
            if (movieDirectorDb.containsKey(name)) {
                for (String m : movieDirectorDb.get(name)) {
                    movieDb.remove(m);
                }
                movieDirectorDb.remove(name);
            }
            directorDb.remove(name);
        }
        return "sucess";
    }
}