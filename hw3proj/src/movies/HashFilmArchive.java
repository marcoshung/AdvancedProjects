package movies;
import java.util.*;

public class HashFilmArchive extends HashSet<Movie> implements FilmArchive{
	
	//returns the sorted list of movies after putting the list into a hashset
	public ArrayList<Movie> getSorted(){
		HashSet<Movie> hashset = new HashSet<Movie>(this);
		return new ArrayList<Movie>(hashset);
	}
	
	//returns list of movies and prints it again after putting it through a hash set
	public static void main(String[] args) {
		HashFilmArchive archive = new HashFilmArchive(); 
		for (Movie m: Movie.getTestMovies())
		archive.add(m); 
		for (Movie m: archive)
		System.out.println(m); 
		System.out.println("**************"); 
		for (Movie m: archive.getSorted())
		System.out.println(m); 
	}

}
