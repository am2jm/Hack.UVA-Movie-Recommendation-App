import java.util.*;


public class Movie {
	private int id;
	private String title;
	private String releasedate;
	private String vidreleasedate;
	private String url;
	private ArrayList<String> genre;
	private ArrayList<String> possible;
	
	public Movie(String m_movie){
		String [] fields = m_movie.split("\\|");
		id = Integer.parseInt(fields[0]);
		title = fields[1];
		releasedate = fields[2];
		vidreleasedate = fields[3];
		url = fields[4];
		
		possible = new ArrayList();
		possible.add("unknown");
		possible.add("Action");
		possible.add("Adventure");
		possible.add("Animation");
		possible.add("Children's");
		possible.add("Comedy");
		possible.add("Crime");
		possible.add("Documentary");
		possible.add("Drama");
		possible.add("Fantasy");
		possible.add("Film-Noir");
		possible.add("Horror");
		possible.add("Musical");
		possible.add("Mystery");
		possible.add("Romance");
		possible.add("Sci-Fi");
		possible.add("Thriller");
		possible.add("War");
		possible.add("Western");
		
		for(int i = 5; i < fields.length; i++){
			
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

}
