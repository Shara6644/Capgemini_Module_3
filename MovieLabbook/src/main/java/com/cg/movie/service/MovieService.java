package com.cg.movie.service;

import java.util.List;

import com.cg.movie.entity.Movies;
import com.cg.movie.exception.MovieException;

public interface MovieService {
	public Movies findMovieById(int movieId) throws MovieException;
	public Movies addMovie(Movies movie) throws MovieException;
	public Movies deleteMovie(int movieId)throws MovieException;
	public Movies updateMovie(Movies movie)throws MovieException;
	public List<Movies> searchMovieByCategory(String genre) throws MovieException;
	public List<Movies> listAllMovies() throws MovieException;

}
