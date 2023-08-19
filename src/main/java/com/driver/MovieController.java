/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.driver;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/movies")
public class MovieController{

    @Autowired
    private watchlistService watchlistService;

    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
        String message = watchlistService.addMovie(movie);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director) {
        String message = watchlistService.addDirector(director);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movieName, @RequestParam String directorName) {
        String message = watchlistService.addMovieDirector(movieName, directorName);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping(" /movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name) {
        Movie movie = watchlistService.getMovieByName(name);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name) {
        Director director = watchlistService.directorByName(name);
        return new ResponseEntity<>(director, HttpStatus.OK);
    }

    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String name) {
        List<String> list = watchlistService.getMoviesByDirector(name);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies() {
        List<String> list = watchlistService.getAllMovies();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String name) {
        String message = watchlistService.deleteDirectorByName(name);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors() {
        String message = watchlistService.deleteAllDirectors();
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}