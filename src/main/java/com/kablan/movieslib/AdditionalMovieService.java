package com.kablan.movieslib;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdditionalMovieService {
    @Autowired
    private AdditionalMoviesRepository additionalMoviesRepository;

    public List<AdditionalMovieProjection> allAdditionalMovies() {
        return additionalMoviesRepository.findAllProjectedBy();
    }

    public Optional<AdditionalMovie> singleAdditionalMovie(String imdbId) {
        return additionalMoviesRepository.findAdditionalMovieByImdbId(imdbId);
    }

}
