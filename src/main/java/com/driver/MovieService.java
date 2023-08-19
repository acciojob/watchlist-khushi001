package com.driver;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class MovieService {
    private Map<String, Movie> movies = new HashMap<>();
    private Map<String, Director> directors = new HashMap<>();
    private Map<String, List<String>> directorToMovies = new HashMap<>();

    public void addMovie(Movie movie) {
        movies.put(movie.getName(), movie);
    }

    public void addDirector(Director director) {
        directors.put(director.getName(), director);
    }

    public void addMovieDirectorPair(String movieName, String directorName) {
        if (movies.containsKey(movieName) && directors.containsKey(directorName)) {
            directorToMovies.computeIfAbsent(directorName, k -> new ArrayList<>()).add(movieName);
        }
    }

    public Movie getMovieByName(String name) {
        return movies.get(name);
    }

    public Director getDirectorByName(String name) {
        return directors.get(name);
    }

    public List<String> getMoviesByDirectorName(String directorName) {
        return directorToMovies.getOrDefault(directorName, new ArrayList<>());
    }

    public List<String> findAllMovies() {
        return new ArrayList<>(movies.keySet());
    }

    public void deleteAllDirectors() {
        directors.keySet().forEach(this::deleteDirectorByName);
    }
    public void deleteDirectorByName(String name) {
        if (directors.containsKey(name)) {
            Director director = directors.get(name);
            List<String> moviesToDelete = new ArrayList<>(directorToMovies.getOrDefault(name, new ArrayList<>()));

            // Remove the movies first from the directorToMovies map
            directorToMovies.remove(name);

            // Then remove the movies from the movies map
            for (String movieName : moviesToDelete) {
                movies.remove(movieName);
            }

            directors.remove(name);
        }
    }


}
