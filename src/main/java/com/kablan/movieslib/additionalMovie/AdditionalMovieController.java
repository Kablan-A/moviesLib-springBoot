package com.kablan.movieslib.additionalMovie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin(origins = "https://movies-lib-project.netlify.app")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/additionalMovies")
public class AdditionalMovieController {

    @Autowired
    private AdditionalMovieService additionalMovieService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping
    public ResponseEntity<List<AdditionalMovieProjection>> getAllAdditionalMovies() {
        return new ResponseEntity<List<AdditionalMovieProjection>>(additionalMovieService.allAdditionalMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<AdditionalMovie>> getSingleAdditionalMovie(@PathVariable String imdbId) {
        return new ResponseEntity<Optional<AdditionalMovie>>(additionalMovieService.singleAdditionalMovie(imdbId), HttpStatus.OK);
    }

    @PostMapping("/add")
    public String addAdditionalMovieToMovies(@RequestBody AdditionalMovie additionalMovie) {
        // Use the template to add data
        mongoTemplate.save(additionalMovie, "movies");
        return "Added successfully";
    }

    @DeleteMapping("/delete/{imdbId}")
    public String deleteAdditionalMovie(@PathVariable String imdbId) {
        mongoTemplate.remove(Query.query(Criteria.where("_imdbId").is(imdbId)), AdditionalMovie.class);
        return "Deleted successfully";
    }
}
