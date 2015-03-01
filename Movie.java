import java.util.*;
public class Movie {
	private int id;
	private String title;
	private String releasedate;
	private String vidreleasedate;
	private String url;
	private ArrayList<String> genre=new ArrayList<String>();
	private ArrayList<String> possible;
	public Movie(String m_movie) {
		String[] fields = m_movie.split("\\|");
		id = Integer.parseInt(fields[0]);
		title = fields[1];
		releasedate = fields[2];
		vidreleasedate = fields[3];
		url = fields[4];
		String[] list = { "unknown", "Action", "Adventure", "Animation",
				"Children's", "Comedy", "Crime", "Documentary", "Drama",
				"Fantasy", "Film-Noir", "Horror", "Musical", "Mystery",
				"Romance", "Sci-Fi", "Thriller", "War", "Western" };
		possible = new ArrayList<String>(); // list of possible genres
		possible.addAll(Arrays.asList(list));
		for (int i = 5; i < fields.length; i++) {
			if (Integer.parseInt(fields[i]) == 1) {
				genre.add(possible.get(i - 5));
			}
		}
	}
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getReleasedate() {
		return releasedate;
	}
	public String getVidreleasedate() {
		return vidreleasedate;
	}
	public String getUrl() {
		return url;
	}
	public ArrayList<String> getGenre() {
		return genre;
	}
	public static void main(String [] args){
		Movie m = new Movie("1|Toy Story (1995)|01-Jan-1995||http://us.imdb.com/M/title-exact?Toy%20Story%20(1995)|0|0|0|1|1|1|0|0|0|0|0|0|0|0|0|0|0|0|0");
		System.out.print(m.toString());
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", releasedate="
				+ releasedate + ", vidreleasedate=" + vidreleasedate + ", url="
				+ url + ", genre=" + genre + "]";
	}
}