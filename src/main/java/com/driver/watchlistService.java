package com.driver;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class watchlistService {

    @Autowired
    private MovieRepository movieRepo;

    public String addMovie(Movie movie) {
        return movieRepo.addMovie(movie);
    }

    public String addDirector(Director director) {
        return movieRepo.addDirector(director);
    }

    public String addMovieDirector(String movieName, String directorName) {
        return movieRepo.addMovieDirectorPair(movieName, directorName);
    }

    public Movie getMovieByName(String name) {
        return movieRepo.getMovieByName(name);
    }

    public Director directorByName(String name) {
        return movieRepo.getDirectorByName(name);
    }

    public List<String> getMoviesByDirector(String name) {
        return movieRepo.getMoviesByDirector(name);
    }

    public List<String> getAllMovies() {
        return movieRepo.getallMovies();
    }

    public String deleteDirectorByName(String name) {
        return movieRepo.deleteDirectorByName(name);
    }

    public String deleteAllDirectors() {
        return movieRepo.deleteAllDirectorandMovies();
    }
}