package com.example.demo2;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class MovieServiceUnitTests {

    @InjectMocks
    private MovieService movieService;

    @Mock
    private MovieRepository movieRepository;

    @Before("test1")
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void givenMovieServiceWhenQueriedWithAnIdThenGetExpectedMovie() {
        Movie movie = new Movie(100L, "Hello World!");
        Mockito.when(movieRepository.findById(100L))
                .thenReturn(Optional.ofNullable(movie));

        Movie result = movieService.retrieveMovies(100L);

        Assertions.assertEquals(movie.getTitle().toLowerCase(), result.getTitle());
    }
}
