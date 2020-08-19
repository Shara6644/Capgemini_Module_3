package com.cg.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.movie.dao.MovieDao;
import com.cg.movie.entity.Movies;
import com.cg.movie.exception.MovieException;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	MovieDao movieDao;
	 
	@Override
	public Movies addMovie(Movies movie) throws MovieException {
		
		return movieDao.addMovie(movie);
	}

	@Override
	public Movies deleteMovie(int movieId) throws MovieException {
	Movies movie = movieDao.findMovieById(movieId);
		   if(movie==null)
		   {
			   throw new MovieException(movieId +" does not exists"); 
		   }
				return movieDao.deleteMovie(movieId); 
	}

	@Override
	public Movies updateMovie(Movies movie) throws MovieException {
		if( movieDao.findMovieById(movie.getMoviesId())!=null)
		 {
       movieDao.updateMovie(movie); 
		 }
		 else
		 {
			 throw new MovieException(movie.getMoviesName()+"ID does not exist");
		 }
		 return movie ;
	}

	@Override
	public List<Movies> searchMovieByCategory(String genre) throws MovieException {
		List<Movies> list =movieDao.searchMovieByCategory(genre);
		if(list.isEmpty())
		{
			throw new MovieException("No records found");
		}
		return list;
	}

	@Override
	public List<Movies> listAllMovies() throws MovieException {
		List<Movies> list =movieDao.listAllMovies();
		if(list.isEmpty())
		{
			throw new MovieException("No records found");
		}
		return list;
	}

	@Override
	public Movies findMovieById(int movieId) throws MovieException {
 Movies movie = movieDao.findMovieById(movieId);
		
		if(movie==null)
		{
			throw new MovieException(movieId +" Product Id does not exists");
		}
		
		return movie;
		 
	}

}
