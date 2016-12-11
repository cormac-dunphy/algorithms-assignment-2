package models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UserTest {
	
	User test = new User("Cormac", "Dunphy", "Male", 19, "Student", 1997);
	
	@Test
	public void testCreateMovie() {
		assertEquals("Cormac", test.firstName);
		assertEquals("Dunphy", test.lastName);
		assertEquals("Male", test.gender);
		assertEquals(19, test.age);
		assertEquals("Student", test.occupation);
		assertEquals(1997, test.zipCode);
	}
	
	@Test
	public void testGetFirstName() {
		assertEquals("Cormac", test.getFirstName());
	}

	@Test
	public void testGetLastName() {
		assertEquals("Dunphy", test.getLastName());
	}

	@Test
	public void testGetGender() {
		assertEquals("Male", test.getGender());
	}
	
	@Test
	public void testGetAge() {
		assertEquals(19, test.getAge());
	}
	
	@Test
	public void testGetOccupation() {
		assertEquals("Student", test.getOccupation());
	}
	
	@Test
	public void testGetZipCode() {
		assertEquals(1997, test.getZipCode());
	}

}