package utils;

import java.util.Map;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import models.Movie;
import models.Rating;
import models.User;

public class FileSerializer {

	static XStream xstream = new XStream(new DomDriver());

	public static void serializeFiles(Map<Long, Movie> movies, Map<Long, Rating> ratings, Map<Long, User> users) {

		XMLSerializer.push(movies);
		XMLSerializer.push(users);
		XMLSerializer.push(ratings);

	}

	@SuppressWarnings("unchecked")
	public static String deserializeFiles(Map<Long, Movie> movies, Map<Long, Rating> ratings, Map<Long, User> users) {

		ratings = (Map<Long, Rating>) XMLSerializer.popRatings(ratings);
		users = (Map<Long, User>) XMLSerializer.popUsers(users);
		movies = (Map<Long, Movie>) XMLSerializer.popMovies(movies);

		String xml = (String) xstream.fromXML("serialisedData.xml");
		return xml;
	}

}