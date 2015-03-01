import java.net.*;
import java.util.*;
public class Theater {
	private ArrayList<Movie> movies;
	private TreeMap<String, ArrayList<Movie>> sorting;
	public Theater() {
		movies = new ArrayList<Movie>();
		sorting = new TreeMap<String, ArrayList<Movie>>();
		Scanner input;
		try {
			URL url = new URL(
					"http://files.grouplens.org/datasets/movielens/ml-100k/u.item");
			input = new Scanner(url.openStream());
			while (input.hasNextLine()) {
				String line = input.nextLine();
				Movie m_movie = new Movie(line);
				movies.add(m_movie);
				setGenres(m_movie);
			}
		} catch (Exception e) {
		}
	}
	public void setGenres(Movie m_movie) {
		ArrayList<String> g_s = m_movie.getGenre();
		for (String genre : g_s) {
			if (sorting.containsKey(genre)) {
				ArrayList<Movie> m = sorting.get(genre);
				m.add(m_movie);
				sorting.remove(genre);
				sorting.put(genre, m);
			} else {
				ArrayList<Movie> m = new ArrayList<Movie>();
				m.add(m_movie);
				sorting.put(genre, m);
			}
		}
	}
	public ArrayList<Movie> getGenre(String g_mine) {
		return sorting.get(g_mine);
	}
	public ArrayList<Movie> getRanGenMov(Movie m) {
		ArrayList<Movie> randomMovies = new ArrayList<Movie>();
		double rand = Math.random() * m.getGenre().size()
				;
		ArrayList<Movie> movies = sorting.get(m.getGenre().get((int) rand));
		for (int i = 0; i < 4; i++) {
			double rand2 = Math.random() * movies.size();
			randomMovies.add(movies.get((int) rand2));
		}
		return randomMovies;
	}
	public static void main(String[] args) {
		Theater t = new Theater();
		Movie m = new Movie(
				"1|Toy Story (1995)|01-Jan-1995||http://us.imdb.com/M/title-exact?Toy%20Story%20(1995)|0|0|0|1|1|1|0|0|0|0|0|0|0|0|0|0|0|0|0");
		System.out.println(t.getRanGenMov(m));
	}
	@Override
	public String toString() {
		return "Theater [sorting=" + sorting + "]";
	}
	
	public ArrayList<Movie> getMovies() {
		return movies;
	}
}