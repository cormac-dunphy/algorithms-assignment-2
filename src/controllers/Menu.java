package controllers;

import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellFactory;
import models.Movie;
import models.Rating;
import utils.Importer;

public class Menu {
	public MovieRecommendAPI movieRecommend = new MovieRecommendAPI();

	//these are the menu options for the user
	@Command(description = "Add A New User")
	public void addUser(@Param(name = "first name") String firstName, @Param(name = "last name") String lastName,
			@Param(name = "age") long age, @Param(name = "gender") String gender,
			@Param(name = "occupation") String occupation, @Param(name = "zipCode") long zipCode) {
		movieRecommend.addUser(firstName, lastName, age, gender, occupation, zipCode);
		//inform user when user has been added to database
		System.out.println("User: " + firstName + lastName + " has been added to the Database.");
	}

	@Command(description = "Delete A User")
	public void removeUser(@Param(name = "id") Long id) {
		movieRecommend.removeUser(id);
		//inform user when user has been removed from database
		System.out.println("User: " + id + " has been removed from the Database.");
	}

	@Command(description = "Add A Movie")
	public void addMovie(@Param(name = "title") String title, @Param(name = "year") String year,
			@Param(name = "url") String url) {
		movieRecommend.addMovie(title, year, url);
		//inform user when movie has been added to database
		System.out.println("Your Movie Title: " + title + " has been added to the Database.");
	}

	@Command(description = "Add a Rating")
	public void addRating(@Param(name = "user ID") Long userID, @Param(name = "movie ID") Long movieID,
			@Param(name = "movie rating") Long movieRating, @Param(name = "user timestamp") Long userTimestamp) {
		movieRecommend.addRating(userID, movieID, movieRating, userTimestamp);
		//inform user when user rating has been added to database
		System.out.println("Your Movie Rating: " + movieRating + " MovieID: " + movieID + " has been added to the Database.");
	}
	
	@Command(description = "Get A Movie")
	public void getMovie(@Param(name = "movie ID") Long id) {
        // Declare gm as a Movie to receive movie details back from getmovie method.
		Movie gm = movieRecommend.getMovie(id);	
		// Print details of movie to console.
		System.out.println("Movie Details - ID: " + gm.id + "  Title: " + gm.title + "  Released: " + gm.releaseDate + "  URL: " + gm.url);
	}
	
	@Command(description = "Get A Users Ratings")
	public void getUserRatings(@Param(name = "user ID") Long userID) {
		Rating gur = movieRecommend.getUserRatings(userID);
		System.out.println("Rating Details - ID: " + gur.userID + "  Title: " + gur.movieID + "  Rating: " + gur.movieRating + "  Timestamp: " + gur.userTimestamp);	
	}
	
	@Command(description = "Top 10 Movies")
	public void getTop10Movies() {
		movieRecommend.getTop10Movies();
	}
	
	@Command(description = "Get User Recommendations")
	public void getUserRecommendations(@Param(name = "user ID") Long userID) {
		movieRecommend.getUserRecommendations(userID);
	}

	public void menu() throws Exception {
		Menu menu = new Menu();
		//welcome to movie recommender menu
		Shell shell = ShellFactory.createConsoleShell("MR", "Welcome to Movie Recommender - ?help for instructions", menu);
		shell.commandLoop();
		menu.movieRecommend.storeInput();
	}
}
