package movies;
import java.util.*;

public interface FilmArchive {
	public ArrayList<Movie> getSorted();
	public boolean add(Movie m);
}
