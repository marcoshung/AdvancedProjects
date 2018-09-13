package movies;

public class HashAnalyzer {
	
	//adds 1000 movies each time and prints between each interval
	public static void main(String[] args) {
		HashFilmArchive archive = new HashFilmArchive(); 
		for (int i=0; i<100000; i++) {
			archive.add(new Movie("Movie" + i, 2017)); 
			if (i%1000 == 0)
			System.out.println(i);
		} 
		System.out.println("DONE");
	}

}
