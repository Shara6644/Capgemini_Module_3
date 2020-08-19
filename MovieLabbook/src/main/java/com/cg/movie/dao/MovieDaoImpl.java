package com.cg.movie.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.movie.entity.Movies;
import com.cg.movie.exception.MovieException;

@Repository
@Transactional
public class MovieDaoImpl implements MovieDao {

	 @PersistenceContext
	 EntityManager em;
	@Override
	public Movies addMovie(Movies movie) throws MovieException{
		em.persist(movie);
		return movie;
	}

	@Override
	public Movies deleteMovie(int movieId)throws MovieException {
		Movies movie =em.find(Movies.class, movieId);
		
		if(movie!=null)
		{
			em.remove(movie);
		}
		return movie;
	}

	@Override
	public Movies updateMovie(Movies movie)throws MovieException{
		Movies m=em.merge(movie);
		return m;
	}

	@Override
	public List<Movies> searchMovieByCategory(String genre)throws MovieException {
		String qry ="select m from Movies m where m.moviesGenre =:genre";
		TypedQuery<Movies> query = em.createQuery(qry,Movies.class );
		query.setParameter("genre", genre);
		List<Movies> list = query.getResultList();
		
		return list;
		
	}

	@Override
	public List<Movies> listAllMovies()throws MovieException {
		String qry ="select m from Movies m";
		TypedQuery<Movies> query = em.createQuery(qry,Movies.class );
		List<Movies> list = query.getResultList();
		
		return list;
	}

	@Override
	public Movies findMovieById(int movieId) throws MovieException {
		Movies movie =em.find(Movies.class, movieId);
		return movie;
	}

}
