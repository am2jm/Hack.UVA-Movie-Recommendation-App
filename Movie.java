import java.awt.List;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Movie {
	private String id;
	private String title;
	private String releasedate;
	private String videodate;
	private String URL;
	private String unknown;
	private ArrayList<String> genre;
	private static ArrayList<String> possible = (ArrayList<String>) Arrays
			.asList("unknown", "Action", "Adventure", "Animation",
					"Children's", "Comedy", "Crime", "Documentary", "Drama",
					"Fantasy", "Film-Noir", "Horror", "Musical", "Mystery",
					"Romance", "Sci-Fi", "Thriller", "War", "Western");

	public Movie(String id) throws Exception {
		URL database = new URL(
				"http://files.grouplens.org/datasets/movielens/ml-100k/u.item");
		Scanner input = new Scanner(database.openStream());
		genre = new ArrayList<String>();

		while (input.hasNextLine()) {
			String[] line = input.nextLine().split("|");
			this.id = line[0];
			this.title = line[1];
			this.releasedate = line[2];
			this.videodate = line[3];
			this.URL = line[4];

			for (int i = 5; i < 20; i++) {
				ArrayList has = new ArrayList<Integer>();
				has.add(line[i]);
				if (has.get(i).equals("1")) {
					genre.add(possible.get(i - 5));
				}
			}
			if (this.id.equals(id)) {
				break;
			}
		}

	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getReleasedate() {
		return releasedate;
	}

	public String getVideodate() {
		return videodate;
	}

	public String getURL() {
		return URL;
	}

	public String getUnknown() {
		return unknown;
	}

	public ArrayList<String> getGenre() {
		return genre;
	}

}
