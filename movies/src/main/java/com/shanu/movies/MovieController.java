package com.shanu.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieServ;
    @GetMapping
    @CrossOrigin
    public ResponseEntity<List<Movie>> getallMovies(){
        return new ResponseEntity<List<Movie>>(movieServ.allMovies(), HttpStatus.OK);

    }
    @GetMapping("/{imdbId}")
    @CrossOrigin
    public ResponseEntity <Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
        return new ResponseEntity <Optional<Movie>>(movieServ.singleMovie(imdbId),HttpStatus.OK);
    }

}
