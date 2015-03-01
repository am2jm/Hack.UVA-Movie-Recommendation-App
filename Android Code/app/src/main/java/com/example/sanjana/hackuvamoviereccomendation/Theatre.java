package com.example.sanjana.hackuvamoviereccomendation;

import java.util.*;

public class Theatre {

	private ArrayList<Movie> movies;
	private TreeMap<String, ArrayList<Movie>> sorting;

	public Theatre() {
		movies = new ArrayList<Movie>();
		sorting = new TreeMap<String, ArrayList<Movie>>();

		Movie m_movie;
		for(int i=1; i<=1682; i++) {
			try {
				m_movie = new Movie(i);
				movies.add(m_movie);
				setGenres(m_movie);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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

    public ArrayList<Movie> getMovies(){
        return movies;
    }

    public ArrayList<Movie> getGenre(String g_mine){
		return sorting.get(g_mine);
	}
	
	static void main(String [] args){
		Theatre m_theatre = new Theatre();
		for (Movie element: m_theatre.movies) {
			System.out.println(element);
		}
	}
}