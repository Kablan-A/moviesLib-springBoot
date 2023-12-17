package com.kablan.movieslib.additionalMovie;

import com.kablan.movieslib.additionalMovie.AdditionalMovie;
import com.kablan.movieslib.additionalMovie.AdditionalMovieProjection;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdditionalMoviesRepository extends MongoRepository<AdditionalMovie, ObjectId> {
//    @Query(value = "{}", fields = "{ 'imdbId': 1 }")

    @Query(value = "{}", fields = "{ 'imdbId': 1, 'title' : 1, 'poster' : 1}")
    List<AdditionalMovieProjection> findAllProjectedBy();

    Optional<AdditionalMovie> findAdditionalMovieByImdbId(String imdbId);

}
