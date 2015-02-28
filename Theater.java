import java.util.ArrayList;

public class Theater {
	private ArrayList<Movie> theater;

	public Theater() throws Exception {
		// fix to try/catch
		theater = new ArrayList<Movie>();
		for (int i = 1; i < 1683; i++) {
			Movie m = new Movie(i);
			theater.add(m);
		}
	}

	public ArrayList<Movie> getTheater() {
		return theater;
	}
	// public Movie getMovie(String title){ //method to search theater by name
	// for(int i = 0; i< 1682; i++){
	// if
	// }
	// return null;
	// }

}
