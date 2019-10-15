import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class ShufflerTest {

	@Test
	public void test() throws IOException {
		Shuffler s = new Shuffler();
		BufferedReader actual = new BufferedReader (new FileReader ("HungMarcosShuffled.txt")); 
		BufferedReader expected = new BufferedReader (new FileReader ("Target2.txt"));
		String expectedLine;
		while ((expectedLine = expected.readLine ()) != null) {
			String actualLine = actual.readLine ();
			assertEquals (expectedLine, actualLine);
		}
	}
	

}
