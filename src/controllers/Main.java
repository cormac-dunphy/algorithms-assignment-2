package controllers;

import utils.Importer;

public class Main {
	public static void main(String[] args) throws Exception {
		//Read in all the data files firstly.
		Importer importer = new Importer();
		//inform user when files are loaded
		System.out.println("Importing Movies");
		importer.ImportMovies();
		System.out.println("Importing Rating");
		importer.ImportRatings();
		System.out.println("Importing Users");
		importer.ImportUsers();
		
		//Runs menu class
		Menu menu = new Menu();
		menu.menu();
	}
}
