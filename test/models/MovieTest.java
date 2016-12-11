package models;

import static org.junit.Assert.*;

import org.junit.Test;

public class MovieTest {

	Movie test = new Movie("Rambo: First Blood", "1982", "www.rambo.com");

	@Test
	public void testCreateMovie() {
		assertEquals("Rambo: First Blood", test.title);
		assertEquals("1982", test.releaseDate);
		assertEquals("www.rambo.com", test.url);
	}

	@Test
	public void testGetTitle() {
		assertEquals("Rambo: First Blood", test.getTitle());
	}

	@Test
	public void testGetReleaseDate() {
		assertEquals("1982", test.getReleaseDate());
	}

	@Test
	public void testGetUrl() {
		assertEquals("www.rambo.com", test.getUrl());
	}

	@Test
	public void testCalculateAverageRating() {
		
		test.addRating(new Rating(-1, -1, 5, -1));
		assertEquals(5.0, test.calculateAverageRating(), 0.001);
		
	}
}