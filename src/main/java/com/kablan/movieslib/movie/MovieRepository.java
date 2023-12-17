package com.kablan.movieslib.movie;

import com.kablan.movieslib.additionalMovie.AdditionalMovie;
import com.kablan.movieslib.movie.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    Optional<Movie> findMovieByImdbId(String imdbId);

    Optional<Movie> findMovieByTitleIgnoreCase(String title);

    Optional<Movie> findMovieByTitleContainsIgnoreCase(String title);
}
