package com.example.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> retrieveAllMovies() {
        return movieRepository.findAll();
    }

    public Movie retrieveMovies(@PathVariable Long id) {
        Movie movie = movieRepository.findById(id).get();
        Movie response = new Movie();
        response.setTitle(movie.getTitle().toLowerCase());
        return response;
    }

    public Long createMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie).getId();
    }
}
