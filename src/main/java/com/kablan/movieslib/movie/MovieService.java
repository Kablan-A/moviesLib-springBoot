package com.kablan.movieslib.movie;

import com.kablan.movieslib.review.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> singleMovieByImdbId(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }

    public List<Review> allMovieReviews(String imdbId) {
        Optional<Movie> movieOptional = this.singleMovieByImdbId(imdbId);

        if (movieOptional.isEmpty()) {
            return Collections.emptyList();
        }

        Movie movie = movieOptional.get();
        return movie.getReviewIds();
    }

    public Optional<Movie> singleMovieByTitle(String title) {
        return movieRepository.findMovieByTitleContainsIgnoreCase(title);
    }

}
