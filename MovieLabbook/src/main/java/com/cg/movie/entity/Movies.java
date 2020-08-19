package com.cg.movie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="movie_tbl")
public class Movies {
	@Id
	@GeneratedValue(generator="seq",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="seq",sequenceName="movie_seq",allocationSize=1)
	@Column(name="movie_id")
    private int moviesId;
    
	@Column(name="movie_name",length=10)
	private String moviesName;
	
	@Column(name="movie_rating")
	private double moviesRating;
	
	@Column(name="movie_genre",length=10)
	private String moviesGenre;

	public Movies(int movieId, String moviesName, double moviesRating, String moviesGenre) {
		super();
		this.moviesId = movieId;
		this.moviesName = moviesName;
		this.moviesRating = moviesRating;
		this.moviesGenre = moviesGenre;
	}

	public Movies() {
		super();
	}

	public int getMoviesId() {
		return moviesId;
	}

	public void setMoviesId(int moviesId) {
		this.moviesId = moviesId;
	}

	public String getMoviesName() {
		return moviesName;
	}

	public void setMoviesName(String moviesName) {
		this.moviesName = moviesName;
	}

	public double getMoviesRating() {
		return moviesRating;
	}

	public void setMoviesRating(double moviesRating) {
		this.moviesRating = moviesRating;
	}

	public String getMoviesGenre() {
		return moviesGenre;
	}

	public void setMoviesGenre(String moviesGenre) {
		this.moviesGenre = moviesGenre;
	}

	
	

}
