package com.cg.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.movie.entity.Movies;
import com.cg.movie.exception.MovieException;
import com.cg.movie.service.MovieService;



@RestController
@CrossOrigin("*")
public class MovieController {
	
	@Autowired
	 MovieService service;
	
	@GetMapping("movies/{id}")
    public ResponseEntity<Movies> findMovie(@PathVariable("id") int id) throws MovieException
    {
       Movies movie = null;
    	
    	 movie = service.findMovieById(id);
    	ResponseEntity<Movies> re = new ResponseEntity<Movies>(movie,HttpStatus.OK);
    	
    	return re;
    }
	@GetMapping("movies")
	public ResponseEntity<List<Movies>> findAllMovies() throws MovieException {

		List<Movies> list = service.listAllMovies();
		ResponseEntity<List<Movies>> rt = new ResponseEntity<List<Movies>>(list, HttpStatus.OK);
		return rt;

	}
	@GetMapping("movies/category/{genre}")
	public ResponseEntity<List<Movies>> findAllMoviesByCategory(@PathVariable("genre") String genre) throws MovieException {

		List<Movies> list = service.searchMovieByCategory(genre);
		ResponseEntity<List<Movies>> rt = new ResponseEntity<List<Movies>>(list, HttpStatus.OK);
		return rt;

	}
	@PostMapping("movies")
    public ResponseEntity<Movies> addproduct(@RequestBody Movies movie) throws MovieException
    {
    	Movies movie1 = service.addMovie(movie);
    	ResponseEntity<Movies> re = new ResponseEntity<Movies>(movie1,HttpStatus.OK);
    	return re;
    }
    
    @PutMapping("movies")
	public ResponseEntity<Movies> updateProduct(@RequestBody Movies movie  ) throws MovieException
    {
    	Movies movie1 = service.updateMovie(movie);
    	ResponseEntity<Movies> re = new ResponseEntity<Movies>(movie1,HttpStatus.OK);
    	return re;
    }
    
    @DeleteMapping("movies/{id}")
	public ResponseEntity<Movies> deleteProductById(@PathVariable("id") int id) throws MovieException {

		ResponseEntity<Movies> rt = null;

		Movies movie =service.deleteMovie(id);
		rt = new ResponseEntity<Movies>(movie, HttpStatus.OK);

		return rt;
	}
	

}
