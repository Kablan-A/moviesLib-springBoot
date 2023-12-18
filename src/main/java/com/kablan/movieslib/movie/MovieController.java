package com.kablan.movieslib.movie;

import com.kablan.movieslib.additionalMovie.AdditionalMovie;
import com.kablan.movieslib.review.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin(origins = "https://movies-lib-project.netlify.app")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovieByImdbId(@PathVariable String imdbId) {
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovieByImdbId(imdbId), HttpStatus.OK);
    }

    @GetMapping("/reviews/{imdbId}")
    public ResponseEntity<List<Review>> getAllReviewsForMovie(@PathVariable String imdbId) {
        return new ResponseEntity<List<Review>>(movieService.allMovieReviews(imdbId), HttpStatus.OK);
    }

    @GetMapping("/byTitle/{title}")
    public ResponseEntity<Optional<Movie>> getSingleMovieByTitle(@PathVariable String title) {
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovieByTitle(title), HttpStatus.OK);
    }

}
