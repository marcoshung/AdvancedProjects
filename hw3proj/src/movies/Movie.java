package movies;

public class Movie implements Comparable<Movie>{
	private String title;
	private int year;
	
	public Movie(String title, int year) {
		this.title = title;
		this.year = year;
	}

	@Override
	public int compareTo(Movie o) {
		if(this.title.compareTo(o.getTitle()) == 0){
			return Integer.compare(this.year,o.getYear());
		}
		return this.title.compareTo(o.getTitle());
	}
	
	public int getYear() {
		return this.year;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String toString() {
		return "Movie " + title + " (" + year + ")";
	}
	
	public static Movie[] getTestMovies() {
		Movie[] movies = new Movie[10];
		movies[0] = new Movie("True Grit",1969); 
		movies[1] = new Movie("True Grit",2010);
		movies[2] = new Movie("The Martian", 2015);
		movies[3] = new Movie("Bridge of Spies",2015);
		movies[4] = new Movie("The Avengers", 2012);
		movies[5] = new Movie("The Avengers", 2012);
		movies[5] = new Movie("Avengers:Infinity War",2018);
		movies[6] = new Movie("Iron Man",2008);
		movies[7] = new Movie("Lone Survivor",2012);
		movies[8] = new Movie("Tangled",2012);
		movies[9] = new Movie("The Greatest Showman",2017);
		return movies;
		
	}
	
	public int hashCode() {
		return title.hashCode() + year;
	}
	
	public boolean equals(Movie m) {
		if(this.title.equals(m.getTitle()) && this.year == m.getYear()) {
			return true;
		}
		return false;
	}
	
}
