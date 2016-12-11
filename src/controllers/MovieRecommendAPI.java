package controllers;

import java.util.List;
import utils.Importer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import models.Movie;
import models.Rating;
import models.User;
import utils.FileSerializer;

public class MovieRecommendAPI {

	public Map<Long, User> userIndex = new HashMap<>();
	public Map<Long, Movie> movieIndex = new HashMap<>();
	public Map<Long, Rating> ratingIndex = new HashMap<>();
	
	public User addUser(String firstName, String lastName, long age, String gender, String occupation, long zipCode) {
		User user = new User(firstName, lastName, gender, age, occupation, zipCode);
		// Put the new user into the Importer.usermap hashmap.
		Importer.userMap.put(user.id, user);
//		userIndex.put(user.id, user);
		return user;
	}

	public Movie addMovie(String title, String year, String url) {
		Movie movie = new Movie(title, year, url);
//		movieIndex.put(movie.id, movie);
		// Put new Movie into Importer movieMap hashmap.
		Importer.movieMap.put(movie.id, movie);
		return movie;
	}

	public Rating addRating(long userID, long movieID, long movieRating, long userTimestamp) {
		Rating rating = new Rating(userID, movieID, movieRating, userTimestamp);
		// Put new rating into Importer ratingMap hashmap.
		Importer.ratingMap.put(rating.getUserID(), rating);
		//ratingIndex.put(rating.getUserID(), rating);
		return rating;
	}

	public User removeUser(long id) {
		return Importer.userMap.remove(id);
		//return userIndex.remove(id);
		
	}

	public Movie getMovie(long id) {
		// Need to add 1 to ID to retrieve correct movie from MAP. 
		id = id + 1;
		// Declare p as a movie and get movie details from movieMap. All stored movies have already
		// been read into movieMap Map.
	    Movie p = Importer.movieMap.get(id);
	    // Return P movie - so that calling procedure can retrieve details.
		return p;
	}

	public Rating getUserRatings(long userID) {
		//Collection<Rating> gur = Importer.ratingMap.values();
		for (Entry<Long, Rating> key : Importer.ratingMap.entrySet()) {
			System.out.println("Key: " + key + ", Value " + Importer.ratingMap.values());
		}
		return Importer.ratingMap.get(userID);
	}

	public List<Movie> getTop10Movies() {
		//System.out.println("in top ten movies");
		//System.out.println(Arrays.asList(Importer.movieMap));
		//System.out.println(Collections.singletonList(Importer.movieMap));
		//List<Movie> tenMovies = (List<Movie>) movieIndex.values();
		List<Movie> tenMovies = (List<Movie>) Importer.movieMap.values();
		
		//System.out.println("after list movies statement");
		Collections.sort(tenMovies);
		//System.out.println("after collections.sort statement");
		//for (int i=1; i<tenMovies.size(); i++){
			//System.out.println("Top 10 Movies: " + i + tenMovies.get(i));
		//}
		return tenMovies.subList(1, 10);
	}
	
	public List<Movie> getUserRecommendations(long userID) {
		List<Movie> recMovies = (List<Movie>) Importer.movieMap.values();
		//List<Movie> recMovies = (List<Movie>) movieIndex.values();
		Collections.sort(recMovies);
		//Go through the list and if the user hasn't rated it add it to the sublist
		return recMovies.subList(1, 5);
	}

	public void storeInput() {
		FileSerializer.serializeFiles(movieIndex, ratingIndex, userIndex);
	}

}