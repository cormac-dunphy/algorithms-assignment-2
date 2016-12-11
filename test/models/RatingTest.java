package models;

import static org.junit.Assert.*;

import org.junit.Test;

public class RatingTest {
	
	Rating test = new Rating(1, 8, 5, 888888);
	
	@Test
	public void testCreateMovie() {
		assertEquals(1, test.userID);
		assertEquals(8, test.movieID);
		assertEquals(5, test.movieRating);
		assertEquals(888888, test.userTimestamp);
	}
	
	@Test
	public void testGetUserID() {
		assertEquals(1, test.getUserID());
	}

	@Test
	public void testGetMovieID() {
		assertEquals(8, test.getMovieID());
	}

	@Test
	public void testMovieRating() {
		assertEquals(5, test.getmovieRating());
	}
	
	@Test
	public void testGetUserTimestamp() {
		assertEquals(888888, test.getUserTimestamp());
	}

}