package movies;
import java.util.*;

public class ListFilmArchive extends ArrayList<Movie> implements FilmArchive{
	
	//adds a movie to the list if it is not there and returns true; false otherwise
	public boolean add(Movie m) {
		if(this.contains(m)) {
			return false;
		}
		super.add(m);
		return true;
	}
	
	//returns the sorted  list of movies after putting it in a tree set
	public ArrayList<Movie> getSorted() {
		TreeSet<Movie> set = new TreeSet<Movie>(this);
		return new ArrayList<Movie>(set);
	}
	
	//prints the list of movies and prints it again after putting it through a tree set.
	public static void main(String[] args) {
		ListFilmArchive archive = new ListFilmArchive(); 
		for (Movie m: Movie.getTestMovies())
		archive.add(m); 
		for (Movie m: archive)
		System.out.println(m); 
		System.out.println("**************"); 
		for (Movie m: archive.getSorted())
		System.out.println(m); 
	}

}
