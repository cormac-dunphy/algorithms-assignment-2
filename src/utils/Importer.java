package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import models.Movie;
import models.Rating;
import models.User;

public class Importer {

	public static HashMap<Long, User> userMap = new HashMap<Long, User>();
	public static HashMap<Long, Movie> movieMap = new HashMap<Long, Movie>();
	public static HashMap<Long, Rating> ratingMap = new HashMap<Long, Rating>();
	//public static ArrayList<Rating> ratingArray = new ArrayList<Rating>();


	public static void ImportUsers() throws FileNotFoundException {
		// Scanner
		File usersFile = new File("data/users5.dat");
		String delims = "[|]";	
		Scanner inUsers = new Scanner(usersFile);

			while (inUsers.hasNextLine()) {

				String userDetails = inUsers.nextLine();
				String[] userTokens = userDetails.split(delims);

				long userID = Long.parseLong(userTokens[0]);
				String firstName = userTokens[1];
				String lastName = userTokens[2];				
				long age = Long.parseLong(userTokens[3]);
				String gender = userTokens[4];
				String occupation = userTokens[5];
				long zipCode = Long.parseLong(userTokens[6]);
				//System.out.println("usertokens.length: " + userTokens.length);

				// output user data to console.
				if (userTokens.length == 7) {
					User u = new User(firstName, lastName, gender, age, occupation, zipCode);
					userMap.put(new Long(userID), u);
				} else {
					inUsers.close();
				}

			}

	}

	public static void ImportMovies() throws FileNotFoundException {

		
		File itemsFile = new File("data/items5.dat");
		// Must have | surrounded by [] in order for the split to work properly.
		String delims = "[|]";	
		Scanner inItems = new Scanner(itemsFile);
	       
		while (inItems.hasNextLine())   {
            // get movie details from movie date source file
            String itemDetails = inItems.nextLine();
            // parse movie details string - split by |
            String[] itemTokens = itemDetails.split(delims);

            long movieID = Long.parseLong(itemTokens[0]);
            String title = itemTokens[1];
            String releaseDate = itemTokens[2];
            String url = itemTokens[3];
            //System.out.println("MovieID: " + movieID);
            //System.out.println("Title: " + title);
            //System.out.println("Release Date: " + releaseDate);
            //System.out.println("URL: " + url);
            //System.out.println("itemtokens.length: " + itemTokens.length);
            
            if (itemTokens.length == 23) {
            		Movie m = new Movie(title, releaseDate, url);
            		movieMap.put(new Long(movieID), m);
            //		System.out.println("moviemap :" + movieMap);
	} else {
				inItems.close();
           }
        								}
		
	}

	
	public static void ImportRatings() throws FileNotFoundException {
        
		File ratingsFile = new File("data/ratings5.dat");
		Scanner inRatings = new Scanner(ratingsFile);
		String delims = "[|]";
		// each field in the file is separated (delimited) by a "|".

		while (inRatings.hasNextLine())   {

			String ratingDetails = inRatings.nextLine();
			String[] ratingTokens = ratingDetails.split(delims);

				long userID = Long.parseLong(ratingTokens[0]);
				long movieID = Long.parseLong(ratingTokens[1]);
				long movieRating = Long.parseLong(ratingTokens[2]);
				long userTimestamp = Long.parseLong(ratingTokens[3]);
	     		//System.out.println("UserID: " + userID);
	            //System.out.println("MovieID: " + movieID);
	            //System.out.println("movieRating: " + movieRating);
	            //System.out.println("Time: " + userTimestamp);
//				System.out.println("ratingTokens.length: " + ratingTokens.length);
		           
				// output rating data to console.
				if (ratingTokens.length == 4) {
					Rating r = new Rating(userID, movieID, movieRating, userTimestamp);
					ratingMap.put(new Long(userID), r);
			//		ratingArray.add(r);
					movieMap.get(r.getMovieID()).addRating(r);
				} else {
					inRatings.close();
				}

			}
	}
}
