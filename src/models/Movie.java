package models;

import java.util.ArrayList;
import java.util.List;

public class Movie implements Comparable<Movie> {

	static Long counter = 0l;
	public Long id;
	public String title;
	public String releaseDate;
	public String url;

	
	List<Rating> ratings = new ArrayList<Rating>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public Movie(String title, String releaseDate, String url) {
		this.id = counter++;
		this.title = title;
		this.releaseDate = releaseDate;
		this.url = url;
	}

	public void addRating(Rating newRating) {
		ratings.add(newRating);
	}

	public double calculateAverageRating() {
		int sum = 0;
		if (!ratings.isEmpty()) {
			for (Rating rating : ratings) {
				sum += rating.getmovieRating();
			}
			return (double) sum / ratings.size();
		}

		return sum;
	}

	@Override
	public int compareTo(Movie o) {
		return Double.compare(calculateAverageRating(), o.calculateAverageRating());
	}

}