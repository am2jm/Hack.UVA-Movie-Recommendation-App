import java.net.*;
import java.util.*;

public class Theatre {

	private ArrayList<Movie> movies;
	private TreeMap<String, ArrayList<Movie>> sorting;

	public Theatre() {
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
	
	public void setGenres(Movie m_movie){
		ArrayList<String> g_s = m_movie.getGenre();
		for(String genre: g_s){
			if(sorting.containsKey(genre)){
				ArrayList<Movie> m = sorting.get(genre);
				m.add(m_movie);
				sorting.remove(genre);
				sorting.put(genre, m);
				
			}
			else{
				ArrayList<Movie> m = new ArrayList<Movie>();
				m.add(m_movie);
				sorting.put(genre, m);
			}
		}
		
	}
	public ArrayList<Movie> getGenre(String g_mine){
		return sorting.get(g_mine);
	}
	
	static void main(String [] args){
		Theatre m_theatre = new Theatre();
	}
}
